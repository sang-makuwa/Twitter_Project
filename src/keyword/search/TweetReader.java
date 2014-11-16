package keyword.search;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * TweetReader reads in tweets from a text file and stores them into a 
 * hash map. 
 *  
 * @author travismiller
 */
public class TweetReader {
	
	/**
	 * The readTweets method takes the file name of a .txt file containing
	 * tweets and returns a hash map with each tweet stored as a value and
	 * a unique integer key associated with each tweet.
	 *  
	 * @param fileName This is the .txt file name with the tweets.
	 * @return This returns the hash map of the tweets.
	 */
	public Map<Integer, String> readTweets(String fileName) throws IOException {

		Map<Integer, String> tweetsMap = new HashMap<Integer, String>(); 
		Path filePath = Paths.get(fileName);
		
		try(Scanner scanner = new Scanner(filePath)) {
			int tweetCount = 0;
			
			while (scanner.hasNextLine()) {
				tweetCount++;
				tweetsMap.put(tweetCount, scanner.nextLine());
			}
		}
		
		return tweetsMap;
	}
	
}
