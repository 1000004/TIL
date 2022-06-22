class SyncAccount{
	private int balance;
	public synchronized int getBalnce(){
		return balance;
	}
	//synchronized 하나의 스레드가 들어왔을때 다른 스레드가 못 들어오게 막는다
	//synchronized 동기화 되었다 싱크가 안맞다 일치하지 않다
	//공유자원 account의 정보가 두 스레드에게 다르지 않도록 막는다
	//MUTEX 상호배제 Mutual Exclusion 임계영역으로 발생하는 문제를 해결하기 위해 자바가 선택한 방법 
	//-> synchronized
	//상호배제 사용중일때 외부에서 접근 불가
	//모든객체는 lock을 가진다 멀티스레드를 가정하고 만들어짐
	//하나의 Thread가 accunt lock을 취득
	//->교대 후 스레드가 accunt lock을 가졌는지 확인하고 없으면 실행을 못한다
	//->lock을 각지고 있던 Thread가 메소드가 끝났을때 accunt lock 해제
	//lock과 lock 가지고 있는지 확인하는 조건을 묶어 모니터
	//임계영역을 해결하는 알고리즘이 많다
	//공유 하고있는 자원에 있어
	//* account lock이 없으면 account의 synchronized 메서드를 못쓴다
	
	//reordering 성능을 위해 컴파일시(독립적인 연산임을 판단 후) 최적화를 위해 자바코드 순서를 변경 바이트 코드 순서가 다를 수 있다
	//(단일 스레드 상황에서 문제 x 공유자원의 임계 영역을 이용하는 경우 문제)
	//공유자원에 두 스레드 동시에 존재할 수 있는 구간(임계영역)이 존재 -> (thread - safe 하지 않다) 캐시가 가지고 있는 값과 실제 값이 다르다/연산 전에 교대 발생

	
	// lock검사 대상 객체 this로 고정
	public synchronized void deposit(int val){
		balance += val;
	}
	public synchronized void withdraw(int val){
		if(balance >=val){
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
			balance -= val;
		}
		System.out.println("name : "+ Thread.currentThread().getName()+
			", balance="+this.getBalnce());
	}
}
public class SyncAccountSample {
	public static void main(String[] args) {
		final SyncAccount account = new SyncAccount();//account의 lock 개념을 사용
		account.deposit(5000);
		Runnable withdrawRun = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10;i++){
					account.withdraw(500);
				}
				
			}
		};
		Thread t1 = new Thread(withdrawRun);
		Thread t2 = new Thread(withdrawRun);
		
		t1.start();
		t2.start();
	}
}
