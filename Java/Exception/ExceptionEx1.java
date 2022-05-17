class ExceptionEx1 {
	public static void divide(int num1, int num2) {
		if(num2 != 0) {//try catch -> if else
			int result = num1 / num2;
			System.out.println(result);
		} else {
			System.out.println("0넣지마라~");
		}
		
	}

	public static void main(String[] args) {
		divide(8, 2);
		divide(8, 0);
		System.out.println("end of main");
	}
}
