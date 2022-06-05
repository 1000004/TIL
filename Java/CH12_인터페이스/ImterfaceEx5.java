/*
	인터페이스의 특징

	1.상수, 추상메서드만 포함 할 수 있다.
		=>멤버변수, 일반메서드, 생성자 포함 할 수 없다.
	2.객체생성이 불가능하다.
	3.구현한다라고 표현하다.(implements)
		=> is-a관계의 일종으로 판별한다.
	4.관례상 네이밍에서 첫글자를 I로 시작한다.

				일반클래스		추상클래스		인터페이스(추상도가 가장 높)
	멤버변수		0			0			x
	메서드		    0			0			x
	생성자		    0			0			x
	추상메서드		x			0			0
	객체생성		0			x			x
	다중상속		x			x			0
*/

interface ISome{
	//상수 : public static final
	//public static final int MAX = 5;
	int MAX = 5; //*package 접근자 아님.public으로 인지
	//public static final int MAX = 5;
	//추상메서드 : public abstract
	void todo();
	//public abstract void todo();
}
//*인터페이스를 구현하는 클래스(일반)는 추상메서드를 오버라이드하는 의무를 가진다.
class SomeImpl implements ISome{
	//오버라이드 대상이되는 메서드는 접근제한자는 public으로 한정된다..
	@Override
	public void todo(){
	}
}
class  ImterfaceEx5 {
	public static void main(String[] args) {
		


	}
}
