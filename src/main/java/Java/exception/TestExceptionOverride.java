package Java.exception;

public class TestExceptionOverride {

	public void printChecked() throws ClassNotFoundException{
		System.out.println("checked exception");
	}
	
	public void printUnchecked() throws ArithmeticException{
		System.out.println("unchecked exception");
	}
}
