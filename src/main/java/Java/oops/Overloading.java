package Java.oops;

public class Overloading {
	public void m1(String a, String b) {
		System.out.println("from arg 2 - "+a+" - "+b);
	}
	public void m1() {
		System.out.println("blank arg");
	}
	public void m1(String a) {
		System.out.println("from arg 1 - "+a);
	}
	
	public void m1(String a, String b, String c) {
		System.out.println("from arg -3 "+a+" - "+b+" - "+c);
	}
	public void m2(String a, String b, String c) {
		System.out.println("from arg -3 "+a+" - "+b+" - "+c);
	}
	public void m1(String... str) {
		System.out.println("from var arg");
	}
	
	public static void main(String[] args) {
		
		Overloading over = new Overloading();
		over.m1("azhar", "Uddin", "ali", "Gaya");
		System.out.println("From main method");
		
	}


}
