package Java.oops;
class z{
	protected Object print() {
		System.out.println("z class method");
		return "";
	}
}
class y extends z{
	public   Object print() {
		return new z();
	}
}
public class OverRiding extends y{
	
	public final z print() {
		System.out.println("override-class method");
		return new z();
	}
	
	public static void main(String[] args) {
		OverRiding o = new OverRiding();
		o.print();
		System.out.println("over rideen mathods");
	}

}
