package keyword.search;

import java.util.HashMap;

public class KeywordTester {

	public static void main(String[] args) {
		
		HashMap<Integer, String> tweetDataBase = new HashMap<Integer, String>();
		TweetReader TR = new TweetReader();
		
		tweetDataBase = TR.readTweets("res/test_tweets.txt");

	}

}
