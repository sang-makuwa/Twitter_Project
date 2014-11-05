package keyword.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


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
	 * a unique key associated with each tweet.
	 *  
	 * @param fileName This is the .txt file name with the tweets.
	 * @return This returns the hash map of the tweets.
	 */
	public HashMap<Integer, String> readTweets(String fileName){
		
		int tweetCount = 0;
		HashMap<Integer, String> tweetsMap = new HashMap<Integer, String>(); 
		Path filePath = Paths.get(fileName);
		
		try (BufferedReader fileReader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
			String line = null;
			while ((line = fileReader.readLine()) != null) {
				tweetsMap.put(tweetCount, line);
				tweetCount++;
			}
		} catch(IOException e) {
			System.out.println("IOException Error: " + e.getMessage());
		}
		
		return tweetsMap;
	}

}
