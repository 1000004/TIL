/*
	Wrapper class : 기본데이터형을 나타내는 클래스

	기본데이터형		Wrapper class
	
	byte				Byte		
	short				Short
	int					Integer
	long				Long
	float				Float
	double				Double
	char				Character
	boolean				Boolean

*/

class WrapperEx {
	public static void main(String[] args) {
		int n = 5;
		
		// int -> Integer
		Integer i = new Integer(n);

		// Integer -> int
		int other = i.intValue();


		double d = 3.14;

		// double -> Double
		Double doubleObj = new Double(d);
		// Double -> double
		double another = doubleObj.doubleValue();

		// JDK1.5~
		// auto-boxing
		Integer i2 = 3;
		// auto-unboxing
		int m = i2;



		// String -> int
		String str = "123";
		// 정수로 변경이 불가능한 문자를 변경시도하면 실행중 에러발생(NumberFormatException)
		int strNum = Integer.parseInt(str);
		// String -> double
		double pi = Double.parseDouble("3.14");

		// int -> String
		String result = String.valueOf(100);		// "100"
	}
}