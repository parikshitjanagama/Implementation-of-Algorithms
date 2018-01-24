import java.util.HashMap;

public class StringUniqueChars {
	
	public boolean isUnique(String s){
		for(int i= 0 ; i < s.length() ; i++){
			for(int j = i-1 ; j >=0 ; j--){
				if(s.charAt(i) == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isUniqueBetter(String s){
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0 ; i < s.length() ; i++){
			if(map.containsKey(s.charAt(i))){
				return false;
			}
			else{
				map.put(s.charAt(i), 0);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "abcdef";
		StringUniqueChars ob = new StringUniqueChars();
		System.out.println(ob.isUnique(s));
		System.out.println(ob.isUniqueBetter(s));
	}

}
