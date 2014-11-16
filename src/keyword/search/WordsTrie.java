package keyword.search;

import java.util.ArrayList;
import java.util.List;

public class WordsTrie {
	
	private TrieNode trieRoot;
	
	WordsTrie() {
		trieRoot = new TrieNode();
	}
	
	private class TrieNode {
		TrieNode[] children = new TrieNode[26];
		List<Integer> tweets;
	}
	
	public void addWord(String word, int tweetId){
		TrieNode node = trieRoot;
		for(int i = 0; i < word.length(); i++) {
			int index = charIndex(word.charAt(i));
			TrieNode child = node.children[index];
			if (child == null) {
				node.children[index] = new TrieNode();
				node = node.children[index];
			} else {
				node = child;
			}
		}
		
		List<Integer> tweetList = node.tweets;
		
		if (tweetList == null)
		{
			node.tweets= new ArrayList<Integer>();
			node.tweets.add(tweetId);
		} else {
			tweetList.add(tweetId);
		}
		
		return;
	}
	
	public List<Integer> getTweets(String word) {
		TrieNode node = trieRoot;
		for(int i = 0; i < word.length(); i++) {
			int index = charIndex(word.charAt(i));
			TrieNode child = node.children[index];
			if (child == null)
				return null;
			node = child;
		}
		return node.tweets;
	}
	
	private static int charIndex(char letter) {
		int index = (int) letter - 97;
		return index;
	}

}
