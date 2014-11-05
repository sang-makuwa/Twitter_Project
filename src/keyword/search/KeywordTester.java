package keyword.search;

import java.net.URL;
import java.util.HashMap;

public class KeywordTester {

	public static void main(String[] args) {
		
		HashMap<Integer, String> tweetDataBase = new HashMap<Integer, String>();
		URL tweetsUrl = KeywordTester.class.getClassLoader().getResource("test_tweets.txt");
		TweetReader TR = new TweetReader();
		
		tweetDataBase = TR.readTweets(tweetsUrl.getPath());
		
		System.out.println(tweetDataBase.get(20));
		System.out.println(tweetDataBase.get(5000));
		System.out.println(tweetDataBase.get(9998));

	}

}
