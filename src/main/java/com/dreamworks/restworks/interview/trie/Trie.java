package com.dreamworks.restworks.interview.trie;

import java.util.Map;

public class Trie {

	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word, int value) {
		
		Map<Character,TrieNode> mapChildren = root.children;
		
		// for each char
		for(int i=0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			TrieNode t;
			if(mapChildren.containsKey(c)){
				t = mapChildren.get(c);				
			}
			else{
				t = new TrieNode(c);
				// add new TrieNode to parent's children map
				mapChildren.put(c, t);
			}
			mapChildren = t.children;   // <========== children change!!
			
			// set leaf node
			if(i== word.length()-1) {
				t.isLeaf = true;
				t.value = value;
			}			
		}				
	}
	
	/*
	public boolean delete(String word) {
		
		Map<Character,TrieNode> children = root.children;
		
		// for each char
		for(int i=0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			TrieNode t;
			if(children.containsKey(c)){
				t = children.get(c);				

								
			}
				
	*/	
	
	// Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
	
	public boolean search(String word) {
		TrieNode t = searchNode(word);
		if(t!=null && t.isLeaf) {
			return true;
		}
		return false;		
	}
	
	public TrieNode searchNode(String word) {
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for(int i=0; i< word.length(); i++) {
			if(children.containsKey(word.charAt(i))){
				t = children.get(word.charAt(i));
				children = t.children;
			}
			else{
				return null;
			}
		}
		return t;		
	}
	
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("test", 5);
		System.out.println("result:" + trie.search("test"));
		
	}
	
	
}
