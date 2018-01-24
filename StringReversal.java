
public class StringReversal {

	public static void main(String[] args) {
		String s = "This is a java string";
//		for(int i = s.length() - 1 ; i >= 0 ; i--){
//			System.out.print(s.charAt(i));
//		}
		StringBuilder sb = new StringBuilder();
//		for(int i = 0 ; i<s.length(); i++){
//			sb.append(s.charAt(i));
//		}
//		System.out.println(sb.reverse().toString());
		String s1 = "abc";
		String s2 = "def";
		s1 += s2; // s1 = s1+s2
//		String str = s1 + s2;
//		System.out.println(str);
		String str1 = sb.append(s1).append(s2).toString();
		System.out.println(str1);
	}


}
