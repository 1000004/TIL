public class InterruptEx2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			@Override
			public void run(){
				long count = 0;
				//예외가 일어나지 않아도 반복 조건으로 사용 가능
        //try-catch문을 감싸 예외를 방생시키면서 빠져나올 수 있다
        //예외 발생된다는 점을 활용할 수 있다
				while(!isInterrupted()){//interrupt 받을때까지 복잡한 연산 또는 비용 비싼 작업시 즉각적인 반응x
					//뭔가 한다.
					count++;
				}
				System.out.println(
					"interrupted -> count ="+count
				);
				System.out.println(
					"isInterrupted : "+isInterrupted()	//ture(예외가 발생하지 않았다)
				);
				//...wait,sleep,join...
			}
		};
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		t1.interrupt();
	}
}
