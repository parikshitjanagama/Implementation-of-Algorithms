package LeetCode;

public class Detectcapital {

	public static void main(String[] args) {
		Detectcapital det = new Detectcapital();

		System.out.println(det.detectCapitalUse("usa"));

	}

	public boolean detectCapitalUse(String word) {

		if (word.charAt(0) >= 65 && word.charAt(0) <= 90) {
			for (int i = 1; i < word.length(); i++) {
				if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
					continue;
				}
				return allSmall(word);
			}
			return true;
		} else if (word.charAt(0) >= 97 && word.charAt(0) <= 122) {
			for (int i = 1; i < word.length(); i++) {
				if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
					continue;
				}
				return false;
			}
			return true;
		}
		return false;

	}

	private boolean allSmall(String word) {

		
			for (int i = 1; i < word.length(); i++) {
				if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
					continue;
				}
				return false;
			}
			return true;
	}
}
