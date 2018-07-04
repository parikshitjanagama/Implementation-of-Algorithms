package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solutiongoatlatin {

	public static void main(String[] args) {

		Solutiongoatlatin sg = new Solutiongoatlatin();

		System.out.println(sg.goatLatin("I Speak Goat over add"));

	}

	public String goatLatin(String S) {

		Set<Character> hs = new HashSet<Character>();
		char[] ch = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < ch.length; i++) {
			hs.add(ch[i]);
		}
		System.out.println(hs);

		StringBuilder sb = new StringBuilder();
		int count = 1;
		String[] words = S.split(" ");

		for (String w : words) {
			char first = w.charAt(0);
			if (hs.contains(first)) {
				sb.append(w);
			} else {
				sb.append(w.substring(1));
				sb.append(first);
			}
			sb.append("ma");
			int i = 0;
			while (i < count) {
				sb.append("a");
				i++;
			}
			sb.append(" ");
			count++;

		}

		return sb.toString().trim();

	}
}
