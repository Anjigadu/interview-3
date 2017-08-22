package com.dreamworks.restworks.interview.google;

import java.util.List;

interface Tree {
	void addNode(String key, String parent, Runnable notify);

	/** Return direct children of supplied key. */
	List<String> getChildren(String key);

	/**
	 * Remove the specified node and all its children, deeply. The notify
	 * callback for each node is called in breadth-first order.
	 */
	void removeSubtree(String key);
}
