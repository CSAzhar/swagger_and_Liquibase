package Java.innerclass;

public class MainClass {
	
	public static void main(String[] args) {
		
		Calculation getString = (value, roll) -> value+"got - "+roll;
		System.out.println(getString.getString("azhar- ", 10));
		
		Calculation byInner = new Calculation() {
			public String getString(String value, int n) {
				return "ans - "+value+"- is -"+n;
			}
		};
		System.out.println(byInner.getString("byInner", 33));
		
//		Calculation helloPrint = () -> System.out.println("from here");
//		helloPrint.print();
		
//		Calculation addition = new Calculation() {
//			public int calculate(int... nums) {
//				int sum = 0;
//				for(int n: nums) {
//					sum+=n;
//				}
//				return sum;
//			}
//		};
		
//		Calculation multiply = new Calculation() {
//			
//			@Override
//			public int calculate(int... nums) {
//				int mul = 1;
//				for(int n: nums) {
//					mul*=n;
//				}
//				return mul;
//			}
//		};
		
//		System.out.println(addition.calculate(12, 8, 90));
//		System.out.println(multiply.calculate(2, 4, 6));
//		Calculation plus = nums -> {
//			int sum = 0;
//			for(int n: nums) {
//				sum+=n;
//			}
//			return sum;
//		}; 
//		System.out.println(plus.calculate(10, 34));
		
		
		
	}

}
