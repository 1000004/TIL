### JS
* 자바 스크립트는  변수을 선언할때 타입을 주지 않는다 ( var, let(구형 버전은 사용 불가)을 사용 )
  * 변수의 타입이 동적으로 바뀐다
* (length는 메서드가 아니다)
* document.addForm = name이 addForm인  form 태그
* type을 submit으로 하여 바로 보내지 않고 버튼으로 만들고 자바스크립트를 이용해 submit하는 이유 추가적인 기능을 수행하기 위함이다
(ex 이름과 나이가 공백인지 검사한다)
* formObj.h_name은 input 태그 나타냄
* formObj.h_name.value는 input 태그의 내용을 나타냄
* 자바스크립트에서 폼을 가져오면 배열처럼 취급(폼과 관련된 태그만 가져온다)
* 자바스크립트 폼이면 배열로 취급(input 태그를 배열)
* (문자를 이꼴즈가 아닌 ==, != 사용 가능)
* document는 HTML문서를 의미
* LoginForm.jsp에서 function을 이용하여 1.공백검사와 2.비밀번호 검사 후 submit한다
* 자바스크림트 클라이언트에서 코드가 보인다
* **자바스크립트 특징**
  * 자바스크립트에 flas로 판정하는 값들
    * null
    * undefined (정립되지 않은 변수를 사용하곡잘 할때 뜬다 값을 가지지 않은 상태)
    * +0, -1
    * NaN(Not a Number) 숫자가 아니다 (글로벌 NaN 넘버의 NaN)
    * (isNaN() returns true if a value is Not-a-Number)
    * (Number.isNaN() return true if a number is Not-a-Number)
    * (1 == "1" 형변환을 해서 true로 나온다)
    * false
* **자바스크립트의 단점**
  * 자바스크림트는 클라이언트에서 실행되며 코드가 보인다
* window.confirm()를 이용하여 브라우저를 종료 전 추가적인 기능 수행 가능
### CSS
* em은 부모글자크기를 기준으로 글자 크키를 퍼센테이지로 표현
### JSP
* 반복으로 사용하는 css를 파일로 분리
* 디렉티브 include을 이용하여 중복 연산을 removeMessaage.jspf로만들어 제거
* innerHTML를 이용하여 태그 사이에 들어가는 값을 지정
