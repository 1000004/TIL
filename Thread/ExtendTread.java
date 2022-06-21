class ExtendTread extends Thread {
	//쓰레드가 할일 정의
	@Override
	public void run(){
		// run()를 오버라이딩하여 재정의.
		System.out.println("Tread 클래스를 상속");
	}
}
public class ExtendThreadTest {
	public static void main(String[] args) {
		ExtendTread et = new ExtendTread();
		//start()를 이용하여 스레드를 시작 시킨다.
		//이후 ExtendThread의 run()가 실행되고 run()가 종료되면 바로
		//ExtendThread가 소멸된다.
		et.start();//스케줄링 대상 start 호출로 대기열에 들어가 준비
		//JMV이 run 실행
		//run이 할 일이 다 실행되지 않아도 상태로 다른 스레드로 교체가 될 수 있다
		//스레드가 객수 1 main thread 2 et 3 g.c(하나의 스레드)
		//main 스레드와 et 경쟁
		//run은 명시적으로 호출하는 메서드가 아니다 내부적으로 호출 JMV가 호출한다
    //run메서드가 끝나면 thread는 죽는다 똑같은 run을 실행시키긱 위해 스레드를 다시 만들어야 한다
		//만들어진 상태/ 준비된 상태 /실행 상태
		//main도 run이다 최초로 수행되는 스레드
		System.out.println("end of main");
	}
}
