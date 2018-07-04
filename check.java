package LeetCode;

class A {
	 public void x(int i) {
		System.out.println(i + "parent");
	}
}
class B extends A{
	 public  void x(int i) {
		System.out.println(i + "child");
	}
}
public class check {
	public static void main(String args[]) {
		A a = new B();
		a.x(3);	
		//System.out.println(a.i);
	} 
}
	
