package Java.multithreading;

public class M1 extends Thread{
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r1 = () -> {
			for(int i = 10; i< 500; i++) {
				System.out.println("thread 2 - "+i);
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		for(int i = 1; i< 4000; i++) {
			System.out.println("thread main - "+i);
			
		}
		
		
		
	}

}
