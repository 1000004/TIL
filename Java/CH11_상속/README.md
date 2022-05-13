
## 1.상속
> ### 슈퍼 클래스,서브 클래스
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
## 2. Overload와 Override
