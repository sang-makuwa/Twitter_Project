package keyword.search;

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
	WordsTrie createIndex(Map<Integer, String> tweetsMap) {
		WordsTrie tweetWordsTrie = new WordsTrie();

		for (Map.Entry<Integer, String> tweetEntry : tweetsMap.entrySet()) {
			
			String[] words = tweetEntry.getValue().split("\\s+");
			
			for (String word: words){
				word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
				
				tweetWordsTrie.addWord(word, tweetEntry.getKey());
			}
		}
		
		return tweetWordsTrie;
	}
}
