package com.dreamworks.restworks.interview.java8;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

	private String name;
	
	public String getPriceInfoStr(String product){
		double price = calculatePrice(product);
		Random random = new Random();
		Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
		return String.format("%s:%.2f:%s", name,price,code);
	}
	
	public double getPrice(String product){
		return calculatePrice(product);
	}
	
	
	public Future<Double> getPriceAsync(String product){
		return CompletableFuture.supplyAsync(()-> calculatePrice(product));
	}
	
	
	private double calculatePrice(String product) {
		delay();		
		return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
	}
	
	public static void delay() {
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	public Shop(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


}
