//Thread 순서 제어 하기
//wait() notifyAll() Objcet에 있는 메서드 (스레드 상태 변경 시키는 메서드)
//Object 자바를 만들때 스레드에 구상할 수 있게 구상
//wait()를 수행한 메서드가 lock을 풀고 not runable 상태 변경
//wait() 해당 자원에 lock을 취득했을때만 호출가능(lock을 취득 안한 경우 InterruptedException) 
//-> synchronized 메서드 synchronized 블록 내부에 있다(lock을 가졌다)
//notifyAll()나 notify() 호출이 없으면 지정된 ms ns 이후에 호출하는 메서드로 파라미터를 가지기도 하지만 주로 파라미터 없는 wait() 사용
//notify() : wait() 중인 무작이 하나의 스레드를 깨운다(깨운다 = runable 상태로 변경)
//notifyAll() : wait() 중인 스레드를 다 깨운다
class MyBox{
	private int contents;
	private boolean isEmpty = true;
	public synchronized int get(){
		while(isEmpty){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		isEmpty = !isEmpty;
		notifyAll();
		System.out.println(
			Thread.currentThread().getName() + " : 소비 "+contents
		);
		return contents;
	}
	public synchronized void put(int value){
		while(!isEmpty){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		contents = value;
		System.out.println(
			Thread.currentThread().getName() + " : 생산 "+ value
		);
		isEmpty = !isEmpty;
		notifyAll();
	}
}
class Producer extends Thread{
	private MyBox box;
	public Producer(MyBox box){
		this.box = box;
	}
	public void run(){
		for(int i =0;i<20;i++){
			box.put(i);
			try {
				sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
class Consumer extends Thread{
	private MyBox box;
	public Consumer(MyBox c){
		box = c;
	}
	public void run(){
		int value = 0;
		for(int i=0; i<10;i++){
			box.get();
			try {
				sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
public class ProducerConsumer {
	public static void main(String[] args) {
		MyBox c = new MyBox();
		Producer p1 = new Producer(c);
		Consumer c1 = new Consumer(c);
		Consumer c2 = new Consumer(c);
		p1.start();
		c1.start();
		c2.start();
    //상호배제 synchronized : 동시에 진입 막는다
		//wait : isEmpty 조건에 의해 생산을 못하거나 소비를 못하고 턴을 넘기는 경우를 
	}
}
