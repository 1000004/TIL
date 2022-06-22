/*
 * synchronized block
 * 
 * 1. 병목구간을 최소화 할 수 있다. 구간 설정가능.
 * 2. lock검사 대상을 설정 할 수 있다(서로다른 멤버변수에 대한 연산)
 * 상호 배제 필요성
 */
class Some {
	private Object key = new Object();
	public void methodA(){
		Thread temp = Thread.currentThread();
		// lock검사 대상 객체 지정
		// 동기화 대상 지정
		// 다른 객체들간 동기화 가능
		// 메서드에 동기화 범위 정해짐 전체가 동기화 대상인 경우 병목현상이 발생하는 것을 최소화
		//(비용(시간)이 많이드는 메서드의 경우) synchronize의 메서드의 경우 메서드 전체를 기다려야 한다
		// synchronized 동기화 범위 설정 가능
		// (동기화가 필요 없는 경우을 제외 시켜 동기화로 인한 다른 스래드의 대기시간을 줄인다)
		synchronized (this) {
			for(int i=0; i<100;i++){
				try {
					System.out.println(
						temp.getName() + " -> doing methodA"
					);
					Thread.sleep(10);
				} catch (Exception e) {}
			}
		}
	}
	public void methodB(){
		Thread temp = Thread.currentThread();
		synchronized (key) { //lock 검사대상 key에 영향을 주진 않는다
			for(int i=0; i<100; i++){
				try {
					System.out.println(
						temp.getName() + " -> doing methodB"
					);
				} catch (Exception e) {}
			}
		}
	}
}
class SynchBlockTest{
	public static void main(String[] args) {
		final Some s = new Some();
		
		Thread t1 = new Thread(){
			@Override
			public void run(){
				s.methodA();
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run(){
				s.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}
