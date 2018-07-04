package LeetCode;

class judgeCircle {
	char x = 0;
	char y = 0;
	
	public static void main(String[] args){
		String moves = "URL";
		judgeCircle jc = new judgeCircle();
		System.out.println(jc.judge(moves));
		
	}

	
	
	public boolean judge(String moves){
	for(char c:moves.toCharArray())
	{
		if (c == 'U') {
			y++;
		} else if (c == 'R') {
			x++;
		} else if (c == 'L') {
			x--;
		} else if (c == 'D') {
			y--;
		}
	}if(x==0&y==0)
	{
		return true;
	}else
	{
		return false;
	}
	}
}
