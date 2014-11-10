package keyword.search;

import java.util.HashMap;
import java.util.Map;

public class KeywordTester {

	public static void main(String[] args) {
		
		Map<Integer, String> tweetDataBase = new HashMap<Integer, String>();
		TweetReader TR = new TweetReader();
		
		System.out.println("Reading in Tweets...");
		
		tweetDataBase = TR.readTweets("res/test_tweets.txt");

		System.out.println(tweetDataBase.get(1));
		System.out.println(tweetDataBase.get(114));
		System.out.println(tweetDataBase.get(9997));
		//System.out.println(tweetDataBase.get(1231236));
		//System.out.println(tweetDataBase.get(1600000));
	}

}
