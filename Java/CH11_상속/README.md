
## 1.상속
> ### 01. 슈퍼 클래스와 서브 클래스
> #### has-a
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
> #### Override
> > 부모클래스에서 정의된 메서드를 재정의한다.
