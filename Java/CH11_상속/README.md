
## 1.상속
> ### 01. 슈퍼 클래스와 서브 클래스
> * 상속은 슈퍼 클래스(부모 클래스)와 서브 클래스(자식 클래스)로 이루어진 계층 구조이다.
> * 상속은 서브클래스가 가진 중복을 줄여준다.
> * is-a관계
> 
> <img src="https://postfiles.pstatic.net/MjAyMjA1MTNfNjEg/MDAxNjUyNDUyMTc2NTk4.0yUQ_2XgQY2-UY5ISPfKEwHoTbif8cr-xlOuGHR30Cog.CZuCTfykpvIYu7Gy5yP0yvBh9K_fuLiER8eIfK6UjJ0g.PNG.forget980/%ED%99%94%EB%A9%B4_%EC%BA%A1%EC%B2%98_2022-05-13_232207.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
>```java
>class SuperClass {
>	  private int numPrivate = 2;//private 접근제한자 상속에서 배제
>	  protected int numProtected = 4;//protected 접근제한자 상속 관계시 사용가능
>	  public int getNumProvate(){
>		  return numPrivate;
>	  }
>}
>class SubClass extends SuperClass {
>	  public void print(){
>		  System.out.println(numProtected);
>	  }
>}
>```
> ### 02. Overload와 Override
> #### Overload
> > 이름이 같은 메서드 클래스 내부에 복수 개 존재하는 경우
> > * 메서드 구분기준 : 이름, 파라미터(타입,갯수,순서)
> > * 구분기준이 아닌것 : 리턴정보, 접근제한자
> ```java
> class MyObj{
>	  void todo(){
>	  }
>	  void todo(int n){
>	  }
> }
>```
> #### Override
> > 부모클래스에서 정의된 메서드를 재정의한다.
> > * 메서드 헤더(리턴타임,이름,파라미터 정보)는 변경할 수 없다. 단, 접근제한자는 변경가능하지만 더 좁아질 수 없다.
> ```java
>  //@... : Annotation : JDK1.5~
>  class Parent{
>	  public void todo(String str){
>		  // todo :: A
>	  }
>  }
> class Child extends Parent{
>	  @Override//오버라이드 검증 : 컴파일 타임
>	  public void todo(String n){
>	  	// todo :: B
> 	}
>}
>```
