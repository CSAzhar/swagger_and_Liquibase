package Java.innerclass;

@FunctionalInterface
interface Calculations{
	public int calculate(int... nums);
}
public class Riwo {
	
	
	static {
		System.out.println(value());
		}
	public static int x;
	public static  int value() {
		return x;
	}
	
	public static void main(String[] args) {
		
		Calculations cal = nums -> {
			int sum = 0;
			for(int s: nums) {
				sum+= s;
			}
			return sum;
		};
		
		System.out.println(cal.calculate(3, 5, 6, 33));
		
	}

}
