package com.dreamworks.restworks.interview.LruCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// http://www.programcreek.com/2013/03/leetcode-lru-cache-java/

public class LRUCache {
	
    int capacity;
    
    Node front=null;
    Node rear=null;

    //HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Map<Integer, Node> map = new ConcurrentHashMap<Integer, Node>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);

            // remove it and set it as a  head
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }

  
    
    // remove from the list (but not from the map)
    public void remove(Node n){
    	
    	// (1) update prev
        if(n.prev!=null){
            n.prev.next = n.next;
        }
        // prev null means it is front!
        else{
            front = n.next;
        }
 
        // (2) update next
        if(n.next!=null){
            n.next.prev = n.prev;
        }
        // rear is null means it is rear!
        else{
            rear = n.prev;
        }
 
    }
 
    // put node at head (i.e., ahead of head)
    // - update front pointer, and prevous front's prev 
    // - null check for front and rear
    // - if rear is null, set rear with front (n)
    public void setHead(Node n){
        n.next = front;
        n.prev = null;
 
        if(front!=null)
            front.prev = n;
 
        front = n;
 
        if(rear ==null)
            rear = front;
    }
    

    public void setHead2(Node n) {
    	if(front==null) {
    		front = n;
    		rear =n;
    	}
    	else{
    		n.next = front;
    		front.prev = n;
    		front = n;
    	}
    	
    }
    
    
    public void set(int key, int value) {

    	if(map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;
            // remove and add (to move to head)
            remove(n);
            setHead(n);
        }
    	// newly add => first check the capacity 
    	// if full, remove the rear one
    	else{	
            Node created = new Node(key, value);
            
            if(map.size()==capacity){
            	// remove from the map & list
            	map.remove(rear.key);
                remove(rear);  
            }            
            
            // add to map & list
            map.put(key, created);
            setHead(created);
         
        }
    }
}
