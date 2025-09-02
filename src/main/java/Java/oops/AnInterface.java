
package Java.oops;

public interface AnInterface {
	
	public void print();
//	public void check();
	public default void write() {
		System.out.println("Write");
	}
	public static void staticMethod() {
		System.out.println("myinterface works on datsa");
	}

}
