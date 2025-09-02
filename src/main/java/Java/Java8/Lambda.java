package Java.Java8;
interface Calculation{
	public int calculate(int... nums);
}
public class Lambda {
	public static void main(String[] args) {
		Calculation adding = nums -> {
			int sum = 0;
			for(int n: nums) {
				sum+=n;
			}
			return sum;
		};
		
		System.out.println(adding.calculate(10, 20, 20));
	}
}
