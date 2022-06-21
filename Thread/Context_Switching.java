//순차적으로 진행할때보다 여러 스레드로 실행시 시간이 일반적으로 만든이 든다
//Context_Switching 문맥교환 비용 스레드가 많아질 수록 증가
//Thread별로 각각 callstack관리 모든 Thread의 callstack가 비어지면 프로그램 종료
//callstack에는 run메서드의 할일이 있다
//스윙으로 GUI를 만들때 하나의 스레드만 존재하는게 아니기 때문에 예외가 발행해도 프로그램은 종료되지 않는다
//스윙에서 이벤터를 처리하는 Thread - Event Dispatcher Thread
class UsingTreadProcess {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx th1 = new ThreadEx();
		
		startTime = System.currentTimeMillis();
		th1.start();
		for(int i=0;i<300;i++){
			System.out.print("-");
		}
		System.out.println(
			"소요시간1:"+
			(System.currentTimeMillis()-UsingTreadProcess.startTime)
		);
	}
}
public class ThreadEx2 extends Thread {
	public void run(){
		for(int i=0; i<300;i++){
			System.out.print("|");
		}
		System.out.println(
			"소요시간2:"+
			(System.currentTimeMillis()-UsingTreadProcess.startTime)
		);
	}
}
