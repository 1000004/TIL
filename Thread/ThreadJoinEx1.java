public class ThreadJoinEx1 {
	public static void main(String[] args) {
		//스레드 생성
		Thread t = new Thread(){
			public void run(){
				try{
					//2초간 멈춤
					Thread.sleep(2000);
					//스레드 종료 메새자;
					System.out.println("MyThread 종료");
					//3초간 멈춤
					Thread.sleep(3000);
				}catch(Exception e){}
			}
		};
		//스레드 시작
		t.start();
		try{
			//join()메소드 실행
			t.join();//main 스레드가 t의 종료를 기다린다.
			//t 스레드가 하는 일이 아닌다 수행하는 스레드가 영향
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//main 메소드 종료 메세지
		System.out.println("main()종료");
	}
}
