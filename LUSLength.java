package LeetCode;

public class LUSLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LUSLength ls = new LUSLength();
		
		System.out.println(ls.findLUSlength("abc", "abc"));

	}

	public int findLUSlength(String a, String b) {
	        
	        if(a.length() == b.length()){
	        	
	        	if(a == b){
	        		return -1;
	        	}
	        	else {
	        		return a.length();
	        	}
	        	
	        }
	        else if (a.length() != b.length()){
	        	return Math.max(a.length() , b.length());
	        }
	        else {
	        	return -1;
	        }
	            
	        }

}
