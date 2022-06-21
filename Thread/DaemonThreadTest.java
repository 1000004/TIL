public class DaemonThreadTest {
	public static void main(String[] args) {
		//스레드 생성
		Thread t = new Thread(){
			public void run(){
				try{
					//5초간 멈춤
						Thread.sleep(5000);
						//스레드 종료 메세지
						System.out.println("MyThread 종료");
				}catch(Exception e){
					//무시..
				}
			}
		};
		//반드시 start()호출 전에 사용해야 한다
		//데몬 스레드로 설정..
		//데몬 스레드는 실행이 다 안끝나도 일반 스레드가 끝나면 따라 소멸
		t.setDaemon(true);
		//스레드 시작
		t.start();
		
		//main 메소드 종료 메세지
		System.out.println("main() 종료");
	}
}
