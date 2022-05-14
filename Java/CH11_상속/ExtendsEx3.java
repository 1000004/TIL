class Foo{
	private int n;
	public Foo(int n){
		this.n = n;
	}
	public void todo(){
		System.out.println("foo : " + n);
	}
	public void doit(){
		System.out.println("Foo : " + this);
		this.doSomething();
		//3.this의 의미는 main 메소드에서 누구의 메소드가 호출되었는지이다.
		//b는 Bar타입 객체의 주소값이고 Bar타입 객체의 doSomething method가 호출
	}
	public void doSomething(){
		System.out.println("아이유");
	}
	public int getN(){
		return n;
	}

}
class Bar extends Foo{
	public Bar(int n){
		super(n);
	}
	@Override
	public void todo(){
		doit();//2.수퍼 객체에서 상속 받은 doit 메소드 호출
	}
	@Override
	public void doSomething(){
		System.out.println("에일리");
		//4.에일리가 출력
	}
}

public class ExtendsEx3 {
	public static void main(String[] args) {
		Bar b = new Bar(2);
		b.todo();//1.서브 객체 todo method 호출 
		//에일리
		
		System.out.println("maint : " + b);


	}
}
