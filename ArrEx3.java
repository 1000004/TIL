class ArrEx3 {
	public static void todo(int[] param) {
		for(int n : param) {
			System.out.println(n);
		}
	}
	// Variable Length Arguments : 가변길이 인자 => VARLARG : JDK1.5~
	/*
		규칙
		1. 메서드당 1개만 존재할 수 있다.
		2. 일반 파라미터와 혼재하는 경우
			2-1. 일반 파라미터는 생략이 불가능하다.
			2-2. 가변길이 인자는 항상 마지막 파라미터여야 한다.
	*/
	public static void doit(int... param) {
		// param : 배열
		todo(param);
	}
	public static void testMethod(String str, int... nums) {
	}
	public static void main(String... args) {
		// 일반 파라미터는 생력할 수 없다.
		// testMethod(); 
		testMethod("a");
		

		doit(1);
		doit(1, 2);
		doit(1, 2, 3);
		doit();
		doit(new int[]{1,2,3,4,5,6});
		doit(null);
		/*
		todo(new int[]{1,2,3});
		todo(new int[]{1,2,3,4});
		todo(new int[]{1,2});
		todo(new int[]{1,2,3,4,5});
		*/
	}
}