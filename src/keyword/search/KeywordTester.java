package keyword.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KeywordTester {
	
	private ArrayList<String> tweetsStorage;
	private Map<String, List<Integer>> wordIndexDB;
	
	private final TweetReader tweetReader = new TweetReader();
	private final TweetWordIndex wordIndex = new TweetWordIndex();
	private final FibHeap tweetFH = new FibHeap();
	
	public static void main(String[] args) {
		
		KeywordTester tester = new KeywordTester();
		
		try{
			
			tester.readTweetFile();
			tester.createWordIndex();
			
			tester.testFibHeap();
			//tester.searchIndex();
			
		} catch (IOException e) {
			System.out.println("Unable to read in file.");
			return;
		}
		
	}
	
	private void readTweetFile() throws IOException{
		
			System.out.println("Reading in Tweets...");
			tweetsStorage = tweetReader.readTweets("res/test_tweets.txt");
			tweetsStorage.trimToSize();
			System.out.println("File contains " + tweetsStorage.size() + " tweets.\n");	
			
	}
	
	private void createWordIndex(){
		
		System.out.println("Indexing Words...");
		wordIndexDB = wordIndex.createIndex(tweetsStorage);
		System.out.println("Tweets contain " + wordIndexDB.size() + " unique words.\n");
	
	}
	
	private void testFibHeap(){
		Tweet t1 = new Tweet(1, 5);
		Tweet t2 = new Tweet(2, 2);
		Tweet t3 = new Tweet(3, 1);
		Tweet t4 = new Tweet(4, 10);
		Tweet t5 = new Tweet(5, 6);
		Tweet t6 = new Tweet(6, 5);
		Tweet t7 = new Tweet(7, 16);
		Tweet t8 = new Tweet(8, 4);
		Tweet t9 = new Tweet(9, 3);
		Tweet t10 = new Tweet(10, 7);
		
		tweetFH.insertNode(t1);
		tweetFH.insertNode(t2);
		tweetFH.insertNode(t3);
		tweetFH.insertNode(t4);
		tweetFH.insertNode(t5);
		tweetFH.insertNode(t6);
		tweetFH.insertNode(t7);
		tweetFH.insertNode(t8);
		tweetFH.insertNode(t9);
		tweetFH.insertNode(t10);
		
		System.out.println();
		
		tweetFH.displayRoot();
		tweetFH.extractMax();
		System.out.println();
		tweetFH.displayRoot();
		tweetFH.extractMax();
		System.out.println();
		tweetFH.displayRoot();
		tweetFH.extractMax();
		System.out.println();
		tweetFH.displayRoot();
		tweetFH.extractMax();
		System.out.println();
		tweetFH.displayRoot();
		tweetFH.extractMax();
		System.out.println();
		tweetFH.displayRoot();
		tweetFH.extractMax();
		System.out.println();
		tweetFH.displayRoot();
		tweetFH.extractMax();
	}
	
	private void searchIndex(){
		
		List<Integer> tweetsList;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		
		try{ boolean done = false;
			while (!done){
				
				System.out.println("Enter keyword or enter quit to stop");
				String text = in.readLine().toLowerCase();// read a base password
				
				if (text.equals("quit")) {
					done = true;
				} else {
					
					tweetsList = wordIndexDB.get(text);
					
					if (tweetsList != null) {
						for (Integer tweet : tweetsList) {
							System.out.println(tweet);
							System.out.println(tweetsStorage.get(tweet));
						}
					} else {
						System.out.println("Word not in the tweet database.");
					}	
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("done");
		
	}

}
