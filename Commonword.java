package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class Commonword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] banned = new String[] { "hit" };
		Commonword cm = new Commonword();
		System.out.println(cm.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banned));
	}

	public String mostCommonWord(String paragraph, String[] banned) {

		HashSet hs = new HashSet<>();
		HashMap<String, Integer> hm = new HashMap();
		for (int i = 0; i < banned.length; i++) {
			hs.add(banned[i]);
		}
		String[] words = paragraph.replaceAll("[\\W+]" , " ").toLowerCase().split("\\s+");

		for (int i = 0; i < words.length; i++) {
			if (!hs.contains(words[i])) {
				if (hm.containsKey(words[i])) {
					hm.put(words[i], hm.get(words[i]) + 1);
				} else {
					hm.put(words[i], 1);
				}
			}
		}
		HashMap.Entry<String, Integer> maxEntry = null;

		for (HashMap.Entry<String, Integer> entry : hm.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
		String p = maxEntry.toString();
		return p.replaceAll("[^A-Za-z]", " ").trim();
	}

}
