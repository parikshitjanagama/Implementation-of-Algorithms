package LeetCode;

public class Digitsrotation {
	public static void main (String[] args){
		
		Digitsrotation dr = new Digitsrotation();
		System.out.println(dr.rotatedDigits(11));
	}
	public int rotatedDigits(int N) {

		int count = 0;
		for(int i = 1; i<= N; i++){
			if(isvalid(i)){
				count++;
			}
		}
		return count;
	}
	private boolean isvalid(int N) {
		// TODO Auto-generated method stub
		boolean validfound = false;
		while(N > 0){
			if(N % 10 == 2) validfound = true;
			if(N % 10 == 5) validfound = true;
			if(N % 10 == 6) validfound = true;
			if(N % 10 == 9) validfound = true;
			if(N % 10 == 3) return false;
			if(N % 10 == 7) return false;
			if(N % 10 == 4) return false;
			N = N/10;
		}
		return validfound;
	}

}
