public class InterruptEx4 {
	public static void main(String[] args) {
		Thread t = new Thread(){
			@Override
			public void run(){
				int i=0;
				while(i<100000){
					i++;
				}
				System.out.println("current state : "+isInterrupted());
				try {
					Thread.sleep(1000);//바로 Not Runnable -> Runable
				} catch (InterruptedException e){
					System.out.println("current state : "+isInterrupted());
				}
			}
		};
		t.start();
		t.interrupt();
		System.out.println("end of main");
	}
}
