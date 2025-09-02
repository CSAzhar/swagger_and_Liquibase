package Java.objectclass;

class Shop{
	int num;
	String name;
	Shop(int num, String name){
		this.num = num;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "num - "+this.num+" name  "+this.name;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}

public class ObjectClass {
	public static void main(String[] args) {
		Shop s1 = new Shop(1, "biryani");
		System.out.println(s1);
		System.out.println(s1.getClass().getName());
		Integer i  = 10;
//		System.out.println(i.getClass().getSigners());
		s1.equals(i);
		
	}

}
