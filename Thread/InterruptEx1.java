public class InterruptEx1 {
	public static void main(String[] args) {	
		Thread t1 = new Thread(){
			@Override
			public void run(){
				try{
					System.out.println("sleep...");
					//1분간 잠든다...RUN -> NOT RUNNABLE
					Thread.sleep(1000*60);
				}catch(InterruptedException e){
					//InterruptedExceotion이 처리되는 순간
					//Interrupt받은 기록이 사라진다.
					System.out.println("wake up");
					System.out.println(
						"isInterrupted : "+isInterrupted()
					);
				}
				for(int i=0; i<10; i++){
					System.out.println(i);
				}
			}
		};
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		//t1.state : NORUNNABLE - > RUNNABLE
		t1.interrupt();
	}
}
