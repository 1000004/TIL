class Dummy{
	public synchronized void todo(){
		try {
			System.out.println("start...");
			wait();
		} catch (InterruptedException e) {
			System.out.println("interrupted!!!");
			System.out.println("t1(run) : "+Thread.currentThread().isInterrupted());
		}
	}
}
public class InterruptEx3 {
	public static void main(String[] args) {
		final Dummy d = new Dummy();
		Thread t1 = new Thread(){
			@Override
			public void run(){
				d.todo();
				System.out.println("i'm dead");
			}
		};
		t1.start();
		t1.interrupt();
		//실행불가상태에 있는 실행 가능상태로 가져오고(예외 발생) 실행시 catch를 출력
		//->상태 초기화 Interrupted 받지 않은 상태로
		//InterruptedException 대기상태/실행상태의 스레드에 interrupt() 가능
		//미리 interrupt() 설정해놔도 기억하기 때문에 InterruptedException 발생 미리 설정이 가능한 이유 시점을 정확히 맞출 수 없기 때문이다.
		//isInterrupted ture 유지 
		//-> InterruptedException가 발생하는 메서드를 분기로 확인하는 try - catch로 예외 확인시
		//메서드는 실행되지 않고 Not Runalble에서 Runable로 바로간다 다시 실행시 예외처리로 catch 블럭으로 넘어가면서 interrupt() 받은 기억은 초기화(isInterrupted()=false)된다.
		
		//interrupt 받을때 예외가 발생시킨다는 의미보다는 InterruptedException시 할 동작을 설정으로 기억
		
		System.out.println("t1(main) : "+t1.isInterrupted());
	}
}
