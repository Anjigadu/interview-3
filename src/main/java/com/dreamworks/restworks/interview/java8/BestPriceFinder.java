package com.dreamworks.restworks.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class BestPriceFinder {
	
	private List<Shop> shops;
	
	private final Executor executor;
	
	public BestPriceFinder(List<Shop> shops){
		this.shops = shops;
		
		int numProcessors = Runtime.getRuntime().availableProcessors();
		float targetUtilization = 1f;
		float waitTimeOverComputeTime = 100; // Wait time / compute time
		
		int numThread = (int) (numProcessors * targetUtilization * (1 + waitTimeOverComputeTime));
		
		System.out.println("* Num Processors:" + numProcessors + ", ThreadPool Size:" + numThread);
		
		// Custom Executor
		this.executor = Executors.newFixedThreadPool(Math.min(shops.size(),  numThread), 
				new ThreadFactory() {
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);
						return t;
					}});
	}
	
	
	public List<String> findPrices(String product){
		 return shops.stream()
				 .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				 .collect(Collectors.toList());
	}
	
	public List<String> findPricesParallelStream(String product){
		 return shops.parallelStream()
				 .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				 .collect(Collectors.toList());
	}
	
	public List<String> findPricesCompletableFuture(String product){
		 		
		List<CompletableFuture<String>> priceFuture = 
				shops.stream()
				 .map(shop-> CompletableFuture.supplyAsync(()->shop.getName() + " price is " + shop.getPrice(product)))
				 .collect(Collectors.toList());		
		
		return priceFuture.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
	
	public List<String> findPricesCompletableFutureAndCustomExecutor(String product){
 		
		List<CompletableFuture<String>> priceFuture = 
				shops.stream()
				 .map(shop-> CompletableFuture.supplyAsync(()->shop.getName() + " price is " + shop.getPrice(product), executor))
				 .collect(Collectors.toList());
		
		return priceFuture.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}
	
	
	
	public static void main(String[] args){
		
		List<Shop> shops = Arrays.asList(new Shop("BestBuy"), new Shop("Target"), new Shop("Apple"), new Shop("Wal-mart")
				, new Shop("Frys"), new Shop("Amazon"), new Shop("New Eggs"), new Shop("B & H"), new Shop("Costco"));
		BestPriceFinder bff = new BestPriceFinder(shops);
		
		System.out.println("[1] steram()");		
		long start = System.nanoTime();
		System.out.println(bff.findPrices("ipad"));
		long duration = (System.nanoTime() - start)/ 1_000_000;
		System.out.println("Done in " + duration + " msecs\n");
		
		System.out.println("[2] parrelsteram()");		
		start = System.nanoTime();
		System.out.println(bff.findPricesParallelStream("ipad"));
		duration = (System.nanoTime() - start)/ 1_000_000;
		System.out.println("Done in " + duration + " msecs\n");
		
		System.out.println("[3] stream() with CompletableFuture w/ join");		
		start = System.nanoTime();
		System.out.println(bff.findPricesCompletableFuture("ipad"));
		duration = (System.nanoTime() - start)/ 1_000_000;
		System.out.println("Done in " + duration + " msecs\n");
		
		System.out.println("[4] stream() with CompletableFuture w/ join & custom executor");		
		start = System.nanoTime();
		System.out.println(bff.findPricesCompletableFutureAndCustomExecutor("ipad"));
		duration = (System.nanoTime() - start)/ 1_000_000;
		System.out.println("Done in " + duration + " msecs\n");
		
	}
}
