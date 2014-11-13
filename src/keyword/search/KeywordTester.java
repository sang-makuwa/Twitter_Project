package keyword.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordTester {

	public static void main(String[] args) {
		
		Map<Integer, String> tweetDataBase = new HashMap<Integer, String>();
		TweetReader TR = new TweetReader();
		
		System.out.println("Reading in Tweets...");
		
		tweetDataBase = TR.readTweets("res/tweets.txt");

		
		Map<String, List<Integer>> wordIndexDB = new HashMap<String, List<Integer>>();
		TweetWordIndex TI = new TweetWordIndex();
		List<Integer> tweetsList = new ArrayList<Integer>();
		
		System.out.println("Indexing Words...");
		
		wordIndexDB = TI.createIndex(tweetDataBase);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		
		try{ boolean done = false;
			while (!done){
				
				System.out.println("Enter keyword or enter quit to stop");
				String text = in.readLine();// read a base password
				
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
