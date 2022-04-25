/*
	override
	=>부모클래스에서 정의된 메서드를 재정의한다.
	=>무엇을 하는가?(what) 동일, 어떻게 하는가?(how) 변경
	=>메서드 헤더(리턴타임,이름,파라미터 정보)는 변경할 수 없다. 단, 접근제한자는 변경가능하지만 더 좁아질 수 없다.
		private < 생략 < protected < public
	=>물리적으로 동일하게 인식할 수있는 메서드를 만든다
*/

class Father{
	private int age = 70;	//멤버변수
	//아부지가 식사를 한다.
	public void eat(){
		//아부지는 오른손잡이다.
		System.out.println("오른손으로 냠냠");
	}
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
class Son extends Father{
	public Son(int age){
		setAge(age);
	}
	//아들도 식사를 한다.
	public void eat(){
		//아들은 왼손잡이 였다....
		System.out.println("왼손으로 냠냠");
	}
	
}
public class  OverrideEx {
	public static void main(String[] args) {
		Son s = new Son(20);
		s.eat();
		System.out.println(s.getAge());


	}
}