package keyword.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class KeywordTester {
	
	private Map<Integer, String> tweetsStorage;
	private Map<String, List<Integer>> wordIndexDB;
	
	private final TweetReader tweetReader = new TweetReader();
	private final TweetWordIndex wordIndex = new TweetWordIndex();
	
	public static void main(String[] args) {
		
		KeywordTester tester = new KeywordTester();
		
		try{
			
			tester.readTweetFile();
			tester.createWordIndex();
			tester.searchIndex();
			
		} catch (IOException e) {
			System.out.println("Unable to read in file.");
			return;
		}
		
	}
	
	private void readTweetFile() throws IOException{
		
			System.out.println("Reading in Tweets...");
			tweetsStorage = tweetReader.readTweets("res/tweets.txt");
			System.out.println("File contains " + tweetsStorage.size() + " tweets.\n");	
			
	}
	
	private void createWordIndex(){
		
		System.out.println("Indexing Words...");
		wordIndexDB = wordIndex.createIndex(tweetsStorage);
		System.out.println("Tweets contain " + wordIndexDB.size() + " unique words.\n");
	
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
