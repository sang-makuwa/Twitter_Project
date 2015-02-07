package keyword.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FibHeap {
	
	private Node max;
	private int numNodes;
	
	public FibHeap(){
		max = null;
		numNodes = 0;
	}
	
	public void displayRoot() {
		Node w = max;
		 
		do {
			System.out.println(w.tweet.freq);
			w = w.right;
		} while(w != max);
	}
	
	public void insertNode(Tweet tweet){
		
		Node inNode = new Node(tweet);
		addToRoot(inNode);
		
		if (max == null || inNode.getValue() > max.getValue()) {
			max = inNode;
		} 
			
		numNodes++;
		
//		System.out.println("Inserting tweet " + tweet.tid + " with value " + tweet.freq);
//		System.out.println("Heap max is tweet " + max.tweet.tid + " with value " + max.tweet.freq);
//		System.out.println(numNodes + " nodes in the heap");	
	}
	
	public Tweet extractMax(){
		Node maxNode = max;
		
		if (max != null) {

			for (Node child : max.children) {
				addToRoot(child);
				child.parent = null;
			}
				
			max.left.right = max.right;
			max.right.left = max.left;
			
			
			if(max == max.right) {
				max = null;
			} else {
				max = max.right;
				consolidate();
			}
			
			numNodes--;
			
//			System.out.println("Removing tweet " + maxNode.tweet.tid + " with value " + maxNode.tweet.freq);
//			if (max != null)
//				System.out.println("Heap max is tweet " + max.tweet.tid + " with value " + max.tweet.freq);
//			System.out.println(numNodes + " nodes in the heap");
//			
//			System.out.println();
			
			return maxNode.tweet;
		}
		
		return null;
		
	}
	
	private void addToRoot(Node addNode){
		
		if (max != null) {
			addNode.left = max;
			addNode.right = max.right;
			max.right.left = addNode;
			max.right = addNode;
		} else {
			addNode.left = addNode;
			addNode.right = addNode;
		}
		
	}
	
	private void consolidate() {
		Double maxDegree = Math.log(numNodes)/Math.log((1.0+Math.sqrt(5.0))/2.0);
		Node[] degreeArray = new Node[maxDegree.intValue() + 2];
		Node w = max;
		boolean endRoot = false;
		Set<Integer> rootList = new HashSet<Integer>();
		
		do {
			rootList.add(w.tweet.tid);
			
			Node x = w;
			w = x.right;
			
			int degree = x.degree;
			
			while(degreeArray[degree] != null) {
				Node y = degreeArray[degree];
				
				if(x.getValue() < y.getValue()) {
					Node temp = x;
					x = y;
					y = temp;
				}
				
				linkNodes(y , x);
				
				degreeArray[degree] = null;
				degree++;
			} 
			
			degreeArray[degree] = x;
			
		} while (!rootList.contains(w.tweet.tid));
		
		max = null;
		
		for (int i=0; i < maxDegree; i++) {
			if (degreeArray[i] != null) {
				
				if (max == null || degreeArray[i].getValue() > max.getValue()) {
					max = degreeArray[i];
				}
			}
		}

	}
	
	
	
	private void linkNodes(Node y, Node x) {
		y.left.right = y.right;
		y.right.left = y.left;
		
//		if(max == y){
//			max = y.right;
//		}
		
//		if (max == y) {
//			x.left.right = x.right;
//			x.right.left = x.left;
//			x.right = y.right;
//			x.left = y.left;
//			y.right.left = x;
//			y.left.right = x;
//			//max = x;
//			max = y.right;
//			
//		} else {
//			y.left.right = y.right;
//			y.right.left = y.left;
//		}
		
		x.children.add(y);
		x.degree++;
	}
	
	public int size(){
		return numNodes;
	}
	
	private class Node {
		private final Tweet tweet;
		private Node parent;
		private LinkedList<Node> children;
		private Node left;
		private Node right;
		private boolean mark;
		private int degree;
		
		public Node(Tweet tweet){
			this.tweet = tweet;
			parent = null;
			children = new LinkedList<Node>();
			left = null;
			right = null;
			mark = false;
			degree = 0;
		}
		
		public int getValue(){
			return tweet.freq;
		}
	}

}