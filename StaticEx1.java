class  StaticEx1 {
	public int num = 100;
	public static int other = 200; 

	public void doit(){
		System.out.println("doit");
	}
	public static void todo(){
		System.out.println("todo");
	}
	// static : 프로그램이 시작할때 메모리에 올라간다.
	// 객체지향(x)
	// static 클래스 안에 있지만 객체의 구성요소가 아니다.
	// 객체를 안 만들어도 사용가능
	public static void main(String[] args) {
		System.out.println(other);
		StaticEx1 e = new StaticEx1();
		e.doit();
		System.out.println(e.num);
		todo();
	}
}
