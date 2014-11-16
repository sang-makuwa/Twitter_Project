package keyword.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class KeywordTester {

	public static void main(String[] args) {
		
		/*
		 * Reads in Tweets
		 */
		Map<Integer, String> tweetDataBase;
		TweetReader tweetReader = new TweetReader();
		
		try {
			System.out.println("Reading in Tweets...");
			tweetDataBase = tweetReader.readTweets("res/tweets.txt");
			System.out.println("File contains " + tweetDataBase.size() + " tweets.\n");
			
		} catch (IOException e) {
			System.out.println("Unable to read in file.");
			return;
		}
		
		
		/*
		 * Creates inverted index
		 */
		Map<String, List<Integer>> wordIndexDB;
		TweetWordIndex wordIndex = new TweetWordIndex();
		
		System.out.println("Indexing Words...");
		wordIndexDB = wordIndex.createIndex(tweetDataBase);
		System.out.println("Tweets contain " + wordIndexDB.size() + " unique words.\n");

		
		/*
		 * Finds tweets with keyword
		 */
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
							System.out.println(tweetDataBase.get(tweet));
						}
					} else {
						System.out.println("Word not in the tweet database.");
					}	
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");
	}

}
