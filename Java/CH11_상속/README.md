
### 1.상속
> ### 01. 슈퍼 클래스와 서브 클래스
> * 상속 계층 구조
> * 상속은 중복을 줄인다
> * 상속은 is-a관계
>```java
>class SuperClass {
>	  private int numPrivate = 2;//private 접근제한자 상속에서 배제
>	  protected int numProtected = 4;//protected 접근제한자 상속관개시 사용가능
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
