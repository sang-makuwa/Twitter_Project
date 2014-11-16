package keyword.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TweetWordIndex indexes the words from tweets and creates a list
 * of tweets containing that word.
 * 
 * @author travismiller
 *
 */
public class TweetWordIndex {

	/**
	 * Creates an index of words from the tweets. Words are seperated from the 
	 * tweet string by whitespace. All alphanumeric characters are removed and 
	 * all the letters are made lowercase. The word is then placed in a hashmap
	 * and all tweets containing the word are then added to an ArrayList.
	 * 
	 * @param tweetsMap a hashmap of all the tweets from the file
	 * @return A hashmap with keys of all the words in the tweets and values of
	 * ArrayLists of tweets which contain that word.
	 */
	Map<String, List<Integer>> createIndex(Map<Integer, String> tweetsMap) {
		Map<String, List<Integer>> tweetWordMap = new HashMap<String, List<Integer>>();

		for (Map.Entry<Integer, String> tweetEntry : tweetsMap.entrySet()) {
			
			String[] words = tweetEntry.getValue().split("\\s+");
			
			for (String word: words){
				word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				
				List<Integer> tweetsList = tweetWordMap.get(word);
				
				if (tweetsList == null) {
					tweetsList = new ArrayList<Integer>();
					tweetsList.add(tweetEntry.getKey());
					tweetWordMap.put(word, tweetsList);
				} else {
					tweetsList.add(tweetEntry.getKey());
				}	
			}
		}
		
		return tweetWordMap;
	}
}
