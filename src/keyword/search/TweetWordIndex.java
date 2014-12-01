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
	public Map<String, List<Integer>> createIndex(Map<Integer, String> tweetsMap) {
		
		List<String> ignoreWords = Arrays.asList("", "a", "able", "about",
				"across", "after", "all", "almost", "also", "am", "among", "an",
				"and", "any", "are", "as", "at", "be", "because", "been", "but",
				"by", "can", "cant", "cannot", "could", "dear", "did", "do", "does",
				"either", "else", "ever", "every", "for", "from", "get", "got",
				"had", "has", "have", "he", "her", "hers", "him", "his", "how",
				"however", "i", "if", "in", "into", "is", "it", "its", "just",
				"least", "let", "like", "likely", "may", "me", "might", "most",
				"must", "my", "neither", "no", "nor", "not", "of", "off", "often",
				"on", "only", "or", "other", "our", "own", "rather", "said", "say",
				"says", "she", "should", "since", "so", "some", "than", "that",
				"the", "their", "them", "then", "there", "these", "they", "this",
				"tis", "to", "too", "twas", "us", "wants", "was", "we", "were",
				"what", "when", "where", "which", "while", "who", "whom", "why",
				"will", "with", "would", "yet", "you", "your");
		
		Map<String, List<Integer>> tweetWordMap = new HashMap<String, List<Integer>>();

		for (Map.Entry<Integer, String> tweetEntry : tweetsMap.entrySet()) {
			
			String[] words = tweetEntry.getValue().split("\\s+");
			
			for (String word: words){
				word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				
				if (!ignoreWords.contains(word)){
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
		}
		
		return tweetWordMap;
	}
}
