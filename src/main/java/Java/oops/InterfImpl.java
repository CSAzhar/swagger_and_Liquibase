package Java.oops;

public class InterfImpl implements AnInterface{

	@Override
	public void print() {
		System.out.println("Printing implemetation");
		
	}
	
	public static void main(String[] args) {
		InterfImpl a = new InterfImpl();
		a.print();
		a.write();
		AnInterface.staticMethod();
	}

}
