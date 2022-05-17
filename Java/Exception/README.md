## 예외 처리
> #### Exception
* 일반적인 상황에서는 문제가 발생하지 않지만 특정 상황에서 예외 발생
* 예외 처리는 햬결이 아니라 상황 대처다.
* RUNTIME ERROR로 실행 도중 오류 발생시 오류 이후 코드는 실행되지 않고 중단된다. 이를 방지하기 위해 예외 처리는 문제 발생시 어떻게 해야 하는지 알려줌으로써 소스코드는 끝까지 실행 된다.
### Call Stack 프로그램 동작 원리
> Stack Last In First Out → L.I.F.O
> / Queue First In First Out → F.I.F.O
* Call Stack이 비어 있다 = 더이상 호출할 일이 없다 = 프로그램 종료
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at ExceptionEx1.divide(ExceptionEx1.java:3)
        at ExceptionEx1.main(ExceptionEx1.java:9)
계속하려면 아무 키나 누르십시오 . . .
```
* at : 문제발생위치
* 예외 발생시 CallStack에 있는 정보를 모두 보여 준다.
* in (1) main (2) divide → out (1) divide (2) main
* L.I.F.O 방식으로 최근에 호출된 일 순으로 먼저 보여준다.
* 예외 처리를 위해 수정 권한을 가진 최상단의 문제 발생 위치를 찾는다.
### try catch
* try catch는 실행을 보장하지 않는다.
 ```java
class ExceptionEx {
	public static void divide(int num1, int num2) {
      try{
            System.out.println("실행") //일부는 실행 가능
            int result = num1 / num2; // 예외가 발생할 수 있는 코드 → 예외 없을때 실행/예외가 발생시 catch블록으로 넘어감
            System.out.println(result);
        } catch(ArithmeticException e){
            System.out.println("0을 넣지 마시오");
        }
	}
	public static void main(String[] args) {
      divide(8, 2);//예외 없이 실행
      divide(8, 0);//예외 처리
      System.out.println("end of main");//예외 처리 후 실행
	}
}

```
### Exception Class
* 예외 상황 클래스의 최상의 클래스
* Exception 클래스를 상속받는 RuntimeException 클래스의 하위 클래스는 예외처리 강제되지 않음.
* Exception 클래스를 직접 상속받는 클래스는 예외처리 강제(compile error) ex) FileNotFound Excption → 코드로 회피 불가능하다. (외부 문제)
* RuntimeException의 경우 사용 빈도가 높고 코드 내부에서 발생하기 때문에 코드를 이용한 제어가 가능하다 → 사전에 방지가 가능하며 예외처리 외에도 에러 방지하는 방법의 선택이 가능
* RuntimeExcetion
  * NullPointerException(null 참조 오류)
  * ClassCastExcetion(형변화 실패)
  * ArrayIndexOutOfCBoundsException(범위를 벗어나는 값 참조)
  * Negative ArraySize Exception(배열을 만들때 길이를 음수로 뒀다)
  * Arithmetic Exception(0으로 나눈 상황)
  * NumberFormatException (숫자를 바꿀 수 없는 걸 시도) ex) Integer.paseInt("abc");
