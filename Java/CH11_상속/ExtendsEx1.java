/*
	상속 : 부모의 구성요소에 자식이 추가 정보를 추가하는 행위

	자식객체 : 부모의 구성요소(생성자는 아님) + 추가된 개념 => 자식객체를 생성하려면 먼저 부모객체부터 만들어야 한다.

	부모객체가 생성 될때 어떤 생성자를 사용할 것인지 결정해야함.

	만약에 부모생성자 선택부분이 생략되는 경우, 컴파일러는 부모의 기본생성자를 호출하도록 만든다. (super())

	따라서 부모 클래스에 기본 생성자가 존재하지 않는 경우 에러가 발생한다, 반드시 명시적으로 부모클래스 생성자를 결정해야한다.
*/

class Some{
	public Some(){
		System.out.println("Some");
	}
	public Some(int n){
		System.out.println(n);
	}
	public void todo(){
		System.out.println("todo :: Some");
	}
}
class Other extends Some{
	public Other(){
		//spuer(); 어떤 부모생성자를 호출할지 선택여부가 없는 경우 기본 생성자가 추가된다.
		super(3); //int 파라미터에 3이 들어가는 부모 생성자를 부른다.
		//무조건 생성자 첫번째 연산으로 존재해함 
		//this()와 동일하게 첫번째로 와야하지만 setter를 통한 대안책이 있지만
		//super()는 대안이 없다
		System.out.println("Other");
	}

	@Override
	public void todo(){
		System.out.println("todo :: Other");
	}
}
public class ExtendsEx1  {
	public static void main(String[] args) {
		new Other();


	}
}
