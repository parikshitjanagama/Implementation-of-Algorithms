package LeetCode;

public class Lenoflast {
	public static void main(String[] args) {
		Lenoflast ls = new Lenoflast();
		System.out.println(ls.lengthOfLastWord(" a"));
	}

	public int lengthOfLastWord(String s) {
//		int count = 0;
//		int j = s.length() - 1;
//		while(j >=0 && s.charAt(j) == ' '){
//			j--;
//		}
//		if (s.contains(" ")) {
//			while (j >=0 && s.charAt(j) != ' ') {
//				count++;
//				j--;
//			}
//			return count;
//		}
//		return s.length();
//	}
		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
}
