package Java.exception;


public class ErrorExample {

	public static void main(String[] args){
		
		int i  = 10;
		if(i<10) {
			System.out.println("less thena 10");
		}else {
			System.out.println("inside else block");
			try {
				throw new AzharException("exception occired in azhar exception");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("else completed");
		}
	}
	
}
