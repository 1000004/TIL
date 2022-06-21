public class ThreadEx1_1 extends Thread {
	public void run(){
		for(int i=0; i<5;i++){
			System.out.println(getName());//스레드 이름을 가져올수 있다
		}
	}
}
public class ThreadEx1_2 implements Runnable{
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(Thread.currentThread().getName());//이구문을 수행하는 스레드의 이름을 가져온다
		}
	}
}
public class CreateThread {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
    //Thread 생성자에 RunableThread 인스턴스를 파라미터로 전달.
		Thread t2 = new Thread(r);
    //단일 상속 Thread을 상속받으면 더이상 상속 받기 어렵다
		//상속 받을 클래스가 따로 있는 경우 유용하다
		
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName());
		//t1 t2 순서는 예측이 어렵다
		
		//main은 다하고 죽음
	}
}
