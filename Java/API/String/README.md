### CharSequence
* String과 StringBuffer의 공통된 인터페이스
### String
* 상수(constant)다
* 변경불가(immutable) 문자열이다
* String 객체들은 공유할 수 있다
* String-pool를 통해 공유
> For example : String str = “abc” (String-pool에 없는 객체의 경우 새로 생성 이미 있는 경우 만들지 않는다.)
### StringBuffer
* 변경가능(mutable) 문자열이다
 ```java
class StringBuffer {
	public static int count = 100000;

	public static void usingString() {
		String str = "";
		long time = System.currentTimeMillis();//ms
		for(int i=0; i<count; i++){
			str += "a";
		}
		time = System.currentTimeMillis()-time;

		System.out.println(time + "ms");
	}
	public static void usingStringBuffer(){
		StringBuffer buf = new StringBuffer();
		long time = System.currentTimeMillis();
		for(int i = 0 ; i<count; i++){
			buf.append("a");
		}
		time = System.currentTimeMillis()-time;

		System.out.println(time + "ms");
	}
	public static void main(String[] args){
		// 1970.01.01 00:00:00.0000 부터 1/1000초 단위로 카운팅(long 타입)
		System.out.println(System.currentTimeMillis());
		usingString(); //result : 3811ms
		usingStringBuffer(); //result : 2ms
		//String은 문자열 변경마다 새 객체를 만들어야하기 때문에 시간이 오래걸린다.
		//문자열 변경이 잦은경우 StringBuffer를 사용
	}
}
```
