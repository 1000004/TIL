
## 1. 추상 클래스
> > ### abstract class
> * 추상 메서드가 존재할 수 있는 클래스
> > 추상 메서드
> > > 헤더만 존재,
> > > 기능을 강제하고 통일
> * 상위개념을 표현할 때 추상클래스 사용
> * 객체를 못 만든다.
> * 추상 메서드가 없어도 상위 객체를 강제로 만들지 못하도록 추상클래스 만드는게 가능
> * 추상클래스를 상속받는 일반클래스는 반드시 추상 메서드를 override를 통해 동작을 구현
>   *  추상클래스가 상속받을 시 메소드 구현 의무 아님
>```java
>  abstract class Shape {
>	    public abstract int getArea(); // 추상  메서드
>  }
>  class Circle extends Shape {
>	    private int r;
>	    public static final double PI = 3.14;
>	    @Override
>	    public int getArea(){ //Shape을 상속받는 Circle은 추상 메서드 구현
>		   return (int)(r*r*PI);
>	   }
>  }
>```
## 2. 인터페이스
> > ### interface
> * 추상메서드와 상수만 들어갈 수 있다.
>   * 멤버변수, 일반메서드, 생성자 포함 할 수 없다.
> * 객체생성이 불가능하다
> * 접근제한자는 묵시적으로 public (생략 가능)
> * ‘구현 한다’라고 표현 (implements 표시)
> * 관례상 네이밍에서 첫글자를 I로 시작한다.
> * is-a 관계 다중구현 → 다형성 극대화
> * 표준 규격 구현 가능
>   * 클래스들간의 통합을 걱정할 필요 없다.
>   * 기능을 사용하는 외부 사용자는 복잡하게 어떻게 구현하는가는 전혀 필요 없이
>   메소드 호출만 가능하면 되기 때문에 추상 메서드로 구성된 인터페이스만 알면 된다.
>```java
>interface IA{
>  	int NUM = 3;
>  	void todo();
>  	void methodA();
>}
>interface IB{
>  	void todo();
>}
>//다중 구현
>class MyObj implements IA, IB{
> 	@Override
> 	public void todo(){
> 	}
> 	@Override
> 	public void methodB(){
> 	}
>}
>```
