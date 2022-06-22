class UnsafeAccount {
	private int balance;
	public int getBalance(){
		return balance;
	}
	public void deposit(int val){
		balance += val;
	}
	//잔액 500원 일때
	//메서드 withdraw는 임계영역
	//임계영역 1. 상태변경 2. 복수의 스레드에 열려 있다(여러 Thread가 동시에 접근 가능)
	//account 스레드가 다르게 해석(ex 멤버변수)
	//한 스레드가 임계영역을 다수행할때까지 lock할 필요가 있다
	public void withdraw(int val){
		if(balance>=val){
			//t1, t2
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			balance -= val;
		}
		System.out.println(
			"name : "+ Thread.currentThread().getName()+
			", balance="+this.getBalance()
		);
	}
}

public class UnsafeAccountSamle {
	public static void main(String[] args) {
		//공유자원
		final UnsafeAccount account = new UnsafeAccount();//1.8부터 지역변수 참조 가능 변경 불가?
		account.deposit(5000);
		Runnable withdrawRun = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					account.withdraw(500);
				}
				
			}
		};
		Thread t1 = new Thread(withdrawRun);
		Thread t2 = new Thread(withdrawRun);
		t1.start();
		t2.start();
		//경우1 출금액이 작액보다 많으면 출금하지 못해도 음수가 나온다
		//경우2 500을 출금해도 잔액이 그대로다
		//t1,t2의 공유자원- account
		//공통으로 접근 withdraw() - critical section (임계영역)
		//임계영역 = 위험 구역
		//실행 후 대기열로 넘어갈때 언제 교대되는지 모른다
		//라인별 실행x
		//if문(balance>=val) 조건을 통과하고 교대 -500 발생할 수 있다
		//balance -= val 대입전 교대 0 발생할 수 있다
		//성능 상 매번 balance를 맴버변수로 읽어오는것은 비효율적이기(느리기) 때문에 캐시에 저장 다시 balance를 캐시에서 가져온다
		//스래드는 account에 접근시 balance 500을 읽고 자신의 캐시에 balance는 500으로 가지고 있는 경우 발생
	}
}
