public class InterruptEx2 {
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				try {
					System.out.println(
						"try - isInterrupted : "+isInterrupted()
					);
					//인터럽트 받은 기록이 초기화됨(flas)
					System.out.println(
						"try - isInterrupted : "+ Thread.interrupted()
						//static 메서드 true/false interrupt() 받은 기록 false로 변경
					);
					System.out.println("ok");
					Thread.sleep(4000);
					//interrupt()했음에도 Thread.interrupted()로 인해 4초동안 잠든다
				} catch (InterruptedException e) {
					System.out.println(
						"catch - isInterrupted : "+ isInterrupted()
					);
				}
			}
		};
		t.start();
		t.interrupt();
		
		System.out.println("isInterrupted : "+t.isInterrupted());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println("isInterrupted : "+ t.isInterrupted());
	}
}
