### HTML
#### 폼양식&lt;form&gt;~&lt;/form&gt;
  * 정해진 값이 전송되는 것이 아닌 사용자가 선택을하거나 입력한 값을 서버로 전송
  * 전송시 form이 필요하다
  * 중요한 속성
    * **method**="전송방식"
      * 데이터의 전송방식 : get, post (How 어떻게 전송하는지)
    * **action**="전송된 데이터를 받는 곳" (wher 어디로 전송하는지)
  * client가 server에 보내는 요청
  * 정보 단위 form로 결정(&lt;form&gt; ←전송단위→ &lt;/form&gt;)
  * 목적이 다르면 다른 form tag로 감싼다(ex 검색, 로그인)
  * 입력값 의미-> 사용자의 의도(파라미터), 프로그램을 사용하는 목적
  * input tag 
    * type 속성 결정
    * name 폼내부에 존재하는 입력이나 선택한 값들을 구분할때 사용
      * 체크 박스는 항목의 이름은 같고 값만 다르다(id는 한페이지에 중복된 id를 가질수 없기때문에 항목을 구분할때 사용이 불가/동일한카테고리)
```HTML
<html>
	<head>
		<meta http-equiv="refresh" content="10";>
	</head>
	<body>
		<form namd="forml" method="post" action="nothingcgi">
			ID : <input type="text" name="id" value="abc" readonly = "readonly" disabled="disabled"/>
			<br>
			Password : <input type="password" name="pw"/>
			<br>
			남기고 싶은 글<br>
			<textarea cols="30" rows="3" name="content"></textarea>
			<br>
			당신의 성별은?<br/>
			<input type="radio" name="gender" value="male" checked="checked"/>남자
			<input type="radio" name="gender" value="female"/>여자
			<br>
			당신의 취미는?<br/>
			<input type="checkbox" name="hoddy" value="read">독서
			<input type="checkbox" name="hoddy" value="trip">여행
			<input type="checkbox" name="hoddy" value="listen-music">음악감상
			<input type="checkbox" name="hoddy" value="movie">영화
			<br>
			<select name="car" size="3" multiple="multiple">
				<option>당신이 구매하고 싶은 차종은?</option>
				<option value="sonata">소나타</option>
				<option value="equus">에쿠스</option>
				<option value="avante">아반떼</option>
			</select>
			<br>
			<input type="hidden" name="start" value="1">
			<br>
			<input type="file" name="unload">
			<br>
			<input type="submit" >
			<br>
			<input type="reset" value="취소">
			<br>
			<input type="button" value="function1" onclick="sayHello()"/><input type="button" value="function2"/>
		</form>
		<script>
          function sayHello(){
            //이벤트 리스너 : 무슨일을 할지 결정
            alert("hello~");
          }
    	</script>
	</body>
</html>
```
* textarea는 열고 닫아야 한다 붙어서 사용<textarea></textarea>
* value 속성 디폴트 값을 준다
* readonly = "readonly" 수정 불가
* disabled="disabled" 못쓰게 막음
```HTML
<select name="car" size="3" multiple="multiple">
```
* name이 같으면 그룹핑이 된다
* vlaue에 있는 값이 전송된다(vlaue 속성 값은 영어로 설정)
* checked="checked" 선택 강제
* select 테그에 size 속성을 주면  JList로 사용 가능
* 일반적으로 값 결정의 주체는 사용자이지만 hidden은 제작자가 결정 (많이 사용된다)
* type="submit"기능이 정해져 있는 버튼
* 전송을 담당하는 버튼을 누르면 method이 지정한 방식과 action이 지정한 위치로 전송
* type="reset" 브라우저 로드시 가지는 기본값을 가진다
* 모든 브라우저에서 지원을 안할 수 있다 (input:type="text",type="password",type="radio",type="checkbox",type="hidden",type="button")(select)(textarea)
* &lt;meta http-equiv="refresh" content="3 url=https://www.naver.com/";&gt;
  * meta 부가적인
  * url이 없으면 제자리에서 3초후 세로 고침 url이 지정되면 지정된 곳으로 이동
  * 페지의 문자세트, 페이지 캐쉬 관련 지정 JSP에서 지정
  * meta의 name 속성
    * keywords : 검색봇이 읽어들이는 값, 검색엔진의 키워드에 문서를 등록하고자 할 때
    * description : 사이트 간략 설명, 검색엔진에 문서의 요약설명에 들어갈 내용을 알려주고자 할 때
    * 쇼핑몰 사이트에서 사용
