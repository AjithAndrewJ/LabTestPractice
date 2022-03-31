package thread;

public class DeadLock {
	public static void main(String[] args) {
		String res1="resource 1";
		String res2="resource 2";
		Thread t1 = new Thread() {  
			public void run() {  
				synchronized (res1) {
					System.out.println("t1 has "+res1);
					try { 
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println(e);
					}
					synchronized (res2) {
						System.out.println("t1 wants "+res2);
					} 
				}  
			}  
		};	  
		Thread t2 = new Thread() {  
			public void run() {  
				synchronized (res2) {  
					System.out.println("t2 has "+res2);  
					try { 
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println(e);
					}  
					synchronized (res1) {  
						System.out.println("t2 wants "+res1);
			        }  
				}  
			}  
		 }; 	      
		 t1.start();  
		 t2.start();  
	}
}
