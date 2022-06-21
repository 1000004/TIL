class ThreadEx13_1 extends Thread{
	public void run(){
		for(int i=0; i<300;i++){
			System.out.println("-");
		}
	}//run()
}
class ThreadEx13_2 extends Thread {
	public void run(){
		for(int i=0; i<300; i++){
			System.out.print("|");
		}
	}//run
}
public class ThreadEx13 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		ThreadEx13_2 th2 = new ThreadEx13_2();
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		try{
			th2.join();//1끝날때까지 기다린다
		}catch(InterruptedException e){}//실행될수 없는 상태로 빠진 경우
		try{
			th2.join();//1번끌날때까지 기다리면서 2가 끝나지 않으면 2를 기다린다
		}catch(InterruptedException e){}
		System.out.print("소용시간:"+
			(System.currentTimeMillis() - ThreadEx13.startTime)//시간 재기 마지막까지 기다림
		);
	}//main
}
