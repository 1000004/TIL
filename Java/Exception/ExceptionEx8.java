class ExceptionEx8 {
	public static void makeException(int num1, int num2, String str) {
		try {
			System.out.println(num1 / num2);

			System.out.println(str.length());
		// JDK1.7~
		} catch(NullPointerException | ArithmeticException e) {
			//여러 catch블록이 있을때 catch 블록 몇개만 같이 처리하고자 할때 or을 붙이고 하나의 catch블록에 상황 객체를 같이 쓸 수 있다.
			System.out.println("예외발생");
		} 
	}
	public static void main(String[] args) {
		makeException(100, 0, "abc");		// ArithmeticException 발생
		makeException(100, 10, null);		// NullPointerException 발생
	}
}
