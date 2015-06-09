import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {
	
	static int ALL_BOOKS_TOTAL = 0;
	static int TOTAL = 0;

	public static String zipify(String text) {
		TOTAL = 0;
		TreeMap<String, Integer> sortedWordsByOccurence = sortWordCounts(countWords(cleanBlankWords(splitString(cleanString(text)))));

		StringBuilder result = new StringBuilder("word,value\n");
		

		sortedWordsByOccurence.entrySet().stream().forEach(x -> {
			TOTAL += x.getValue();
			result.append(x.getKey() + "," + x.getValue() + "\n");
		});
		System.out.println("Words total: " + TOTAL);
		
		ALL_BOOKS_TOTAL += TOTAL;
		
		return result.toString();
	}

	private static String cleanString(String text) {
		return text.toLowerCase().replaceAll("[\\.,-\\/#!$%\\^&\\*;—:—{}=\\-_`~()]", "");
	}

	private static List<String> splitString(String text) {
		return Arrays.asList(text.split(" "));
	}

	private static List<String> cleanBlankWords(List<String> textArray) {
		ArrayList<String> retVal = new ArrayList<String>();
		retVal.addAll(textArray);
		retVal.removeAll(Arrays.asList("", null));
		return retVal;
	}

	private static HashMap<String, Integer> countWords(List<String> words) {
		HashMap<String, Integer> retVal = new HashMap<String, Integer>();

		int x;
		for (String w : words) {
			if (retVal.containsKey(w)) {
				x = retVal.get(w);
				retVal.put(w, x + 1);
			} else {
				retVal.put(w, 1);
			}
		}

		return retVal;
	}

	private static TreeMap<String, Integer> sortWordCounts(Map<String, Integer> dictionary) {
		ValueComparator comparator = new ValueComparator(dictionary);
		TreeMap<String, Integer> retVal = new TreeMap<String, Integer>(comparator);
		retVal.putAll(dictionary);
		return retVal;
	}

	static class ValueComparator implements Comparator<String> {

		Map<String, Integer> base;

		public ValueComparator(Map<String, Integer> base) {
			this.base = base;
		}

		public int compare(String a, String b) {
			if (base.get(a) >= base.get(b)) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
