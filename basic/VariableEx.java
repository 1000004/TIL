/*
	지역변수는 동일한 범위에 같은 이름이 중복될 수 없다.

	단, 지역변수와 멤버변수는 이름이 같을 수 있다. => 구분가능하다.
*/
class Foo {
	int num = 2; //멤버변수

	void todo(){
		int num = 4; //지역변수
		//지역변수와 멤버변수가 이름이 같을 경우 -> 지역변수
		System.out.println(num);		//4
		System.out.println(this.num);	//2 this->나에
	}
	/*
		this : 자신의 주소를 나타내는 키워드
	*/
}

public class VariableEx  {
	public static void main(String[] args) {
		Foo f = new Foo();
		f.todo();


	}
}
