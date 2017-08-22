package com.dreamworks.restworks.interview.LruCache;

public class NodeStr {
    String key;
    int value;
    
    NodeStr prev;
    NodeStr next;
 
    public NodeStr(String key, int value){
        this.key = key;
        this.value = value;
    }
}