## Inner Class
* Outer 객체가 생성된 이후에 Inner 객체 생성이 가능
* 다른 형태의 클래스가 필요하지만 다른곳에 사용되지 않는 경우 Inner Class 사용
* 다른 곳에 사용하지 않고 하나의 객체에만 쓰인다.
* Outer class 에 완전히 종속되고 Outer class안에서만 사용하는 객체
* 모든 제한자 사용가능한 class
* 외부 클래스에 사용하지 않는다.
* Outer의 멤버변수 메소드를 마음대로 불러 쓸 수 있다.(private 제한자인 경우도 가능)
* Outer객체가 있는 상태로 Inner객체가 garbage collection에서 쓰레기 객체로 판정되도 삭제 안됨 (메모리 누수로 이어진다)
```java
class Outer{
	
	private int num = 10;
	//private Inner some = new Inner(); // 맴버변수로 Inner Class 사용
	
	public void todo(){
		Inner some = new Inner(); // 지역변수로 Inner Class 사용
	}
  //class Inner : Outer 객체가 생성된 이후에 Inner 객체 생성이 가능
	private class Inner{
		public void printNum(){
			System.out.println(num);
		}
		
	}
}
```
* static inner Class
  * Outer 객체 생성 없어도 static inner 객체 생성이 가능 하다
  * -> 따로 생성이 가능하도록 한다는 의미는 다른곳에 사용 가능하도록 한다는 의도를 가질 수 있다.
  * Inner class 쓰는 이유가 모호해진다. 여러곳에 쓰인다면 외부에서 class 생성해서 쓰는 방법이 있다.
  * static이 없는 Inner Class와 다르게 Outer 객체가 소멸되지 않아도 Inner 객체가 garbage collection이 일어날 수 있다.
```java
class OtherOuter{
	static class OtherInner{
	}
  public static void main(String[] args) {
    OtherOuter.OuterInner other1 = new OtherOuter.OuterInner();
    //OtherOuter객체가 만들어지지 않고 OtherInner객체 생성
    
    OtherOuter.OuterInner other2 = new OtherOuter.OuterInner();
    
    System.out.println(other1 == other2);
    //false
    //static 변수는 공유한다.
		//클래스에 static이 붙어있는 경우 공유 안다.
  }
}
```
