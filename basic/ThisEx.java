class Dog{
	private String name;
	private int age;
	private kind;

	public Dog(String name, int age){
		setName(name);
		setAge(age);
		System.out.println("frist");
		
	}
	/*
		this
			1. 자신의 참조값
			2. 자신의 생산자 : this(...) : 생성자 내부에서만 사용가능
				=>생산자의 첫 연산으로 존재해야한다.
	*/
	public Dog(String name, int age, String kind){
		this(name, age);
		setKind(kind);
		System.out.pringln("second")
	}

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getKind(){
		return kind;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setKind(String kind){
		this.kind = kind;
	}
}

class  ThisEx {
	public static void main(String[] args) {
		/*
			객체 생성시 여러 생성자가 사용될 수도 있다.
		*/
		Dog d = new Dpg("쪽쪽이", 8,"푸들"); //생산자 2개 이용됨

	}
}
