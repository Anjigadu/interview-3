package com.dreamworks.restworks.interview.LruCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// http://www.programcreek.com/2013/03/leetcode-lru-cache-java/

public class LRUCacheStr {
	
    int capacity;
    
    NodeStr front=null;
    NodeStr rear=null;

    //HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Map<String, NodeStr> map = new ConcurrentHashMap<>();
    
    public LRUCacheStr(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(String key) {
        if(map.containsKey(key)){
            NodeStr n = map.get(key);

            // remove it and set it as a  head
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    // remove from the list (but not from the map)
    public void remove(NodeStr n){
    	
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
    public void setHead(NodeStr n){
        n.next = front;
        n.prev = null;
 
        if(front!=null)
            front.prev = n;
 
        front = n;
 
        if(rear ==null)
            rear = front;
    }
 
    public void set(String key, int value) {

    	if(map.containsKey(key)){
            NodeStr old = map.get(key);
            old.value = value;
            // remove and add (to move to head)
            remove(old);
            setHead(old);
        }
    	// newly add => first check the capacity 
    	// if full, remove the rear one
    	else{	
            NodeStr created = new NodeStr(key, value);
            if(map.size()>=capacity){

            	// (1) remove from the map
            	map.remove(rear.key);
            	// (2) remove from the linked list
                remove(rear);  
            }            
            
            // (1) add to linked list
            setHead(created);
            // (2) add to map
            map.put(key, created);
        }
    }
}
