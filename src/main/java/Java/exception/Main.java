package Java.exception;

public class Main extends TestExceptionOverride{
	@Override
	public void printChecked() throws ClassNotFoundException {
		System.out.println("over ridden checked");
	}
	@Override
	public void printUnchecked() {
		System.out.println("inside unchecked");
	}
	public static void main(String[] args) throws Throwable{
		TestExceptionOverride t = new TestExceptionOverride();
		t.printChecked();
		t.printUnchecked();
		int age = 13;
		assert age==15 : "age must be less than15";
		assert age==16 : "age must be less than";
	}
}