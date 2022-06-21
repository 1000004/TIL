class SomeThread extends Thread{
	public SomeThread(String name){
		super(name);
	}
	@Override
	public void run(){
		String name = this.getName();
		for(int i =0;i<10;i++){
			System.out.println(name + " is working");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){}
		}
	}
}
public class PriorityEx {
	//main thread는 우선순위가 NORM_PRIORITY(5) 이다.
	public static void main(String[] args) {
		SomeThread t1 = new SomeThread("A");
		SomeThread t2 = new SomeThread("B");
		SomeThread t3 = new SomeThread("C");
		
		//쓰레드의 우선 순위 설정
// 		t1.setPriority(Thread.MIN_PRIORITY); //1
// 		t2.setPriority(Thread.NORM_PRIORITY); //5
//		t3.setPriority(Thread.MAX_PRIORITY); //10
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
 
		t1.start();
		t2.start();
		t3.start();
	}
}
