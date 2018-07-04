package LeetCode;

public class reverseWords {

	public static void main(String[] args) {
		
		reverseWords rw = new reverseWords();
		System.out.println(rw.reverse("Let's take Leetcode test"));
		

	}
	// TODO Auto-generated method stub

	public String reverse(String s) {

		String[] words = s.split(" ");
		StringBuilder end = new StringBuilder();
		for (String w : words) {
			StringBuilder sb = new StringBuilder(w);
		    end.append(sb.reverse() + " ");
		}
        return end.toString();

	}
}
