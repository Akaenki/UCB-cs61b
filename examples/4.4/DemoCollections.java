import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class DemoCollections {
	/** Rturns a lower case version of string with all
	  * charactors except letter removed. */
	public static String cleanString(String s){
		return s.toLowerCase().replaceAll("[^a-z]", "");
	}

	/** Gets a list of all words in the file */
	public static List<String> getWords(String inputFilename){
		List<String> words = new ArrayList<String>();
		In in = new In(inputFilename);
		while(!in.isEmpty()){
			String nextWord = cleanString(in.readString);
			words.add(nextWord);
		}
		return null;
	}

	/** Returns the count of the number of unique words */
	public static int countUniqueWords(List<String> words){
		/* Use Set to collect repeate words */
		Set<String> wordSet = new HashSet<String>();
		for(String ithWord : words){
			wordSet.add(ithWord);
		}
		return wordSet.size();
	}

	/** Returns a map (dictionary) that tracks the count of all taget
	  * words in the list words */
	public static Map<String, Integer> collectWordCount(List<String> words, List<String> targets){
		Map<String,Integer> counts  = new HashMap<String, Integer>();
		for(String t : targets) {
			counts.put(t,0);
		}
		for(String s : words){
			if(coutns.containsKey(s)){
				int oldCount = counts.get(s);
				counts.put(s,oldCount + 1);
			}
		}
	}

	public static void main(String[] args){
		List<String> w = getWords("inputfile");
		/** The set constructor can take an array list */
		Set<String> wordSet = new HashSet<>(w);
		System.out.println(wordSet.size()); //Words same as countUniqueWords

	}
}