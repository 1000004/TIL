#### CharSequence
* String과 StringBuffer의 공통된 인터페이스
#### String
* 상수(constant)다
* 변경불가(immutable) 문자열이다
* String 객체들은 공유할 수 있다. 
* String-pool를 통해 공유
> For example : String str = “abc” (String-pool에 없는 객체의 경우 새로 생성 이미 있는 경우 만들지 않는다.)
#### StringBuffer
* 변경가능(mutable) 문자열이다
