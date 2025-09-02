package Java.objectclass;

class Student implements Cloneable{
	int id;
	String name;
	
	Student(Student s){
		this.id = s.id;
		this.name = s.name;
	}
	
	Student(int id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		return super.clone();
	}
}

public class CopyContructor {

	public static void main(String[] args) throws CloneNotSupportedException {
		Student azhar = new Student(1, "azhar");
		Student ali = (Student)azhar.clone();
		azhar.name = "azharmod";
		System.out.println(azhar.name);
		System.out.println(ali.name);
		System.out.println(ali.equals(azhar));
		Student s3 = new Student(azhar);
	}
}







