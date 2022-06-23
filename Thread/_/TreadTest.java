class MyPrinter{
	private boolean isStart = false;
	public synchronized void printContents(){
		if(!isStart){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		for(char c='a'; c<'z';c++){
			System.out.print(c);
		}
		System.out.println();
		isStart = !isStart;
		notify();
	}
	public synchronized void marker(){
		System.out.println("start printing");
		isStart = !isStart;
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
		System.out.println("end printing");
	}
}
class CallPrint extends Thread{
	MyPrinter src;
	public CallPrint(MyPrinter src){
		this.src = src;
	}
	public void run(){
		while(true){
			src.printContents();
		}
	}
}
class CallMaker extends Thread{
	MyPrinter src;
	public CallMaker(MyPrinter src){
		this.src = src;
	}
	public void run(){
		while(true){
			src.marker();
		}
	}
}
public class TreadTest {
	public static void main(String[] args) {
		MyPrinter src = new MyPrinter();
		CallPrint print = new CallPrint(src);
		CallMaker maker = new CallMaker(src);
		
		print.start();
		maker.start();
	}
}
