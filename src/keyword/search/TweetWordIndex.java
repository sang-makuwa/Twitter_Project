package keyword.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TweetWordIndex indexes the words from tweets and creates a list
 * of tweets containing that word.
 * 
 * Used http://rosettacode.org/wiki/Inverted_index#Java as a reference.
 * 
 * @author travismiller
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
	public Map<String, List<Integer>> createIndex(ArrayList<String> tweetsArray) {
		
		List<String> ignoreWords = Arrays.asList("");
		
		Map<String, List<Integer>> tweetWordMap = new HashMap<String, List<Integer>>();

		for (int i = 0; i < tweetsArray.size(); i++) {
			
			String[] words = tweetsArray.get(i).split("\\s+");
			
			for (String word: words){
				word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				
				if (!ignoreWords.contains(word)){
					List<Integer> tweetsList = tweetWordMap.get(word);
						
						if (tweetsList == null) {
							tweetsList = new ArrayList<Integer>();
							tweetsList.add(i);
							tweetWordMap.put(word, tweetsList);
						} else {
							tweetsList.add(i);
						}	
					}
			}
		}
		
		return tweetWordMap;
	}
}
