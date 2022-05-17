class A {
}
class B extends A {
}
class ExceptionEx2 {
	public static void main(String[] args) {
		A a = new A();
		try {
			B b = (B)a;
		} catch(ClassCastException e) {
			e.printStackTrace();		// 디버깅 용
		}
		System.out.println("end of main");
	}
}
