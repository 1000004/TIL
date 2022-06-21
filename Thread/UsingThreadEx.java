//스레드를 이용하면 2가지 일을 독립적 처리할 수 있다
class UsingThread {
	public static void main(String[] args) {
		ThreadEx th1= new ThreadEx();
		th1.start();
		String input = JOptionPane.showInputDialog(
			"아무 값이나 입력하세요."
		);
		System.out.println("입력하신 값은 "+ input+"입니다.");
	}
}
public class UsingThreadEx extends Thread{
	public void run(){
		for(int i=10; i>0;i--){
			System.out.println(i);
			try{
				sleep(1000);
			}catch(Exception e){}
		}
	}
}
