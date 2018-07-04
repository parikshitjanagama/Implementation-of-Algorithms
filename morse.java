package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class morse {
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		morse m = new morse();
		System.out.println(m.uniqueMorseRepresentations(words));
	}
	public int uniqueMorseRepresentations(String[] words) {

		String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		Set<String> hs = new HashSet<String>();

		for (int i = 0; i< words.length; i++) {

			StringBuilder sb = new StringBuilder();
			for (int j = 0 ; j < words[i].length() ; j++) {
				sb.append(MORSE[words[i].charAt(j) - 'a']);
			}
				hs.add(sb.toString());
			
		}
		return hs.size();
	}
}
