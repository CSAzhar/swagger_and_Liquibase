package Java.oops;
class A{
	public void m1() {
		System.out.println("A.m1() called from top");
	}
}
public class IsARelationsShip extends A{
	public void m2() {
		System.out.println("A=This.m2() called");
	}
	public void m1() {
		System.out.println("A.m1() called from bottom");
	}
	
	public static void main(String[] args) {
		A a1 = new A();
		a1.m1();
//		a1.m2();    < - not defined
		
		IsARelationsShip isA = new IsARelationsShip();
		isA.m1();
		isA.m2();
		
		A a2 = new IsARelationsShip();
		a2.m1();
		((IsARelationsShip)a2).m2();	//<- cant called
		
//		IsARelationsShip isA2 = new A();
		
		
		
		
	}
}
