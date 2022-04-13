class Bar {
	public int num1 = 10; //public
	private int num2 = 5; //private
	int num3 = 2; //생략
	
	public void printNum2(){
		System.out.println(num2);
		printNum1();
	}

	private void printNum1(){
		System.out.println(num1);
	}
}

public class  UseBar {
	public static void main(String[] args) {
		Bar b = new Bar();

		System.out.println(b.num1);
		//System.out.println(b.num2); 오류 main이 접근
		System.out.println(b.num3);
		b.printNum2(); // b에서 접근 오류 발생x
		//b.printNum2(); 오류 ptivate method

	}
}
