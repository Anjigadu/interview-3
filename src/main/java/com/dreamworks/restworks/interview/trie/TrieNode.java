package com.dreamworks.restworks.interview.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	char c;
	Map<Character, TrieNode> children = new HashMap<>();

	boolean isLeaf;
	int value; // to store value in the leaf node
	
	public TrieNode() {}
	public TrieNode(char c){
		this.c = c;
	}

}
