### HTML(HyperText Markup Language)
* 웹페이지 구현시 사용되는 표준 언어
* 웹 표준 문서 양식
* HTML 문서(즉, 웹 페이지)는 HTTP라는 방식의 상자를 이용해서 전송
* HTTP(HyperText Transfer Protocol) : 웹 비라우저와 웹 서버가 HTML을 비롯해 이미지, 동영상, XML 문서 등 다양한 데이터를 주고받을 때 사용하는 일종의 규칙
* 웹 서버는 웹 브라우저가 요청하느 URL에 해당하는 HTML문서를 전송하고 전송받은 웹 비라우저는 정해진 큐칙에 따라 HTML 문서를 분석해서 알맞은 화면을 생성
* **렌더링(rendering)** : HTML 표준에 따라 HTML 문서로부터 알맞은 화면을 생성하는 과정
* **HTTP**는 두 가지 관점에서 규칙
	* 요청 규칙 : 요청 데이터 통일
	* 응답 규칙 : 응답 데이터 통일
* **HTTP**에서 요청 데이터와 응답데이터는 line/header/body 3가지 영역을 가진다
	* 요청데이터
		* line : 요청 방식, 자원의 경로(URL), 프로토콜 종류/버전(최소한 정보(도멘인 입력)만으로 요청 데이터를 만들어 요청)
		* header : 참조할 수 있는 정보(클라이언드 정보), 브라우저의 종류나 언어
		* body : 정보를 전송해야 할 때 사용 ex 파일 업로드
	* 응답데이터
		* line : 프로토콜 종류/버전,응답코드
		* header : 보내는 데이터 정보(인코딩 정보 유형)
		* body : HTML 문서 내용(JS,CSS 포함) 또는 이미지 파일 데이터 등이 전달(웹 비라우저가 요청한 자원 내용)
		* **자원** : 동작할 떄 필요 사항
> 클라이언트 에서 실행하는 언어 : HTML, JS, CSS → 브라우저에서 실행  
> 서버에서 실행하는 언어 : JSP(Java Server Page)/Serblet + java 
* Markup 검증 서비스 사이트를 통해 맞는 문법인지 확인할 수 있지만 HTML은 문법이 느슨해 엄격하게 지키지 않아도 수용 가능하다
* HTML 문서의 버전을 알려준다<!DOCTYPE html> (XML 문법) 문서 제일 위에 표기, 대문자로 표기
* Hyper Text
  * 비선형 문서(하이퍼 링크)(디지털) <-> 선형 문서(책)(아날로그)
* Markup Language
  * Tag로 이루어진 문서 <테그 이름> ex <a> a 테그
* HTML 문서의 특징
  * 태그(TAG)로 구성
  * 태그(TAG)는 복수개의 속성을 가질 수 있다
  * HTML문서는 텍스트 파일(메모장에서 볼 수 있다)
  * 확장자는 .htm 또는 .html(예전 확장자가 3자리까지 밖에 인지를 못했다)
  * 결과 확인은 웹브라우저를 통해서 할 수 있다(브라우저로 불리기 위해서는 HTML Parsor, JSParsor, CSS Parsor 구문 분석기 HTML문서를 읽을 수 있고 해석할 수 있는 엔진 : Parsor를 가지고 있어야 한다)
* HTML History
  * HTML 4.01 기준으로 XHTML/HTML5 갈라진다
  * 2000 W3C XHTML 추천 테그를 만들수 있는(형식은 동일) XML로 가기 위한 과도기
  * 2009 아이폰 플래시가 지원을 안함 (게임 배너 동영상 프레이어 전부 플래시로 만들어짐 어도비(애플에서 떨어져나온 회사)에서 플래시를 만듬)
  * 2014 W3C HTML5 추천
  * (HTML5 느슨하지만 XTML 문법은 엄격)
* HTML : 문서 구조 
  * 여는 테그 &lt;html&gt;/ 닫는 테그 &lt;/html&gt;
  * &lt;head&gt; 설정이나 부가 정보가 위치&lt;/head&gt;
  * &lt;body&gt;사용자 화면에 보여질 내용들이 들어감&lt;/body&gt;
* CSS : 디자인 부분 (표현한할 수 있는 방법이 풍부)
* #### empty tag(중간에 들어가지 않는다) - &lt;x>&lt;/x&gt; = &lt;/x&gt;
* #### &lt;테그이름 속성 이름 = "속성값"&gt; XHTML은 속성 , 이름 소문자 (속성값을 ""로 감싼다)
* #### &lt;!--여기는 주석--&gt; 연산, 로직 관련 주석을 남기면 안된다(페이지를 디자인 할때 사용)(SQ ml 파생된 html, xml 주석 사용가능)
* 엔터와 스페이스 표시가 안된다 공백 한칸으로
* #### &lt;title&gt;&lt;/title&gt; : setTitle()-> head 사이
* #### &lt;b/&gt; 줄바꿈 (html5 &lt;br&gt; 닫는 테그 생략 ok)
* #### &lt;p&gt;,&lt;/p&gt; 문단 바꾸기
* 어떻게 보여주는가? CSS로 표현(ex 정렬)(<font>,<center> HTML5 지원하지 않는다)
* HTML은 문서 구조를 나타내는 것이지 어떻게 보여지는지는 나타내지 않는다
* 문서의 외관 어떻게 보여지는지는 **CSS**에 맡긴다
* #### &lt;hn&gt;&lt;hn/&gt; (n은 숫자가 들어간다)
  * 줄바꿈이 일어난다(개행)
    * 자동으로 개행이 되는 테그 : 블럭 타입(정해진 크기가 있다)
    * 자동으로 개행이 안된는 테그 : 인라인(정해진 규격이나 사이즈가 없다)
  * 눈으로 보기에는 글자 크기를 조절하고 있는것으로 보이지만 주제라는 의미를 가지고 있다
    * 이중적인 의미를 지니고 있는 테그 눈으로 보이는거 말고 다른 의미를 가지고 있다: **semantic tag**
    * 눈으로 보이는 것은 css로 조절이 가능하기 때문에 중요하지 않다
  * 검색사이트는 검색 봇<h>테그로 들어있는 내용으로 주제를 파악
  * 불특정 다수에 보이기 위해서는 &lt;h&gt;를 활용
```HTML5
<!DOCTYPE html>
<html>
<head>
<title>ok</title>
</head>
<body>
	<h1>h1</h1>
	<h6>h6</h6>
</body>
</html>
```
* #### 글자모양과 관련된 테그
  * &lt;b&gt; 볼드체 가능하면 css로 써라(b는 보일때만 볼드 중요하다는 의미는 담지 않는다)
  * &lt;strong&gt; semantic tag 굷게,강조
* #### &lt;hr&gt; 수평선 후, 줄바꿈
* #### &lt;ul&gt;&lt;/ul&gt; (unordered list) 순서값이 없는 목록 표현
  * dic 기본값
  * &lt;li&gt; 리스트 아이템
* #### &lt;ol&gt;&lt;/ol&gt;(unordered list) start = "50" (목록 시작번호 속성)
  * type을 css로 제어 ex) none; type 공백
* #### &lt;img&gt; 웹문서에 이미지를 표현할 때 사용
  * <img> 이미지 속성
   * src(이미지 url, .hml 파일 경로)(상대좌표/절대좌표 디스크 사의 root가 아닌 다른 기준이 바뀌기 때문에 절대 좌표는 쓰지 않는다 같은 위치있는 파일이면 상대 좌표를 쓴다)
   * alt : 이미지 넣기 외부에서 들고온(웹상에 존재하는 이미지) 이미지 주소가 변경되거나 없어진면 엑박 발생
     * 엑박 이미지를 소유하고 있지 않고 alt는 그림이 제대로 표현되면 안나온다 이미지가 깨지거나 액박시 나온다 배너에도 사용
   * title : 자바의 tooltip과 유사, 모든 테그에 다 지원(**HTML Global Attribute** ex id, title, class)
* #### &lt;a&gt;~&lt;/a&gt;Anchor
  * 하이퍼 링크 가능
  * 비선형 문서 연결
  * href 속성 (Hyper Link Reference) 연결할 문서의 url(파일 경로 .html) 값을 가진다
  * target 속성
     * 새로운 탭 어디서 열건지 결정 기본값은 _self /새로운 탭으로 열기_blank
     * 창분할 frameset _parent _top 쓰지 않는다
  * a 태그 사이에 그림이 올 수 있다
```HTML5
<html>
	<head>
		<title>first</title>
	</head>
	<body>
		<h1>first.html</h1>
		<hr>
		<a href="http://naver.com">네이버</a>
		<br>
		<a href="second.htiml">go second</a>
		<br>
		<a href = "a.html#choonsik6">춘식이6번 보기</a>
	</body>
</html>

<html>
	<head>
		<title>second.html</title>
	</head>
	<body>
		<h1>second.html</h1>
		<hr>
		<a href="fist.html">go fist</a>
	</body>
</html>
```
* #### id
  * a 테그의 같은 페이지 각주 해당하는 위치로 점프 **책갈피 기능**
  * a 테그에 id를 줘서 하이퍼 링크를 통해 페이지로 이동할때 특정 id로 이동 가능
  * id는 동일한 페이지에 유일한 값으로 제한한다 동일한 값이 존재하면 안된다 아이디를 표현할때 #을 붙인다
```HTML5
<html>
	<head>
		<title>책갈피기능</title>
	</head>
	<body>
		<a id="choonsikList"><h1>*춘식이 리스트*</h1></a>
		<ol>
			<li><a href="#choonsik1">춘식1</a></li>
			<li><a href="#choonsik2">춘식2</a></li>
			<li><a href="#choonsik3">춘식3</a></li>
			<li><a href="#choonsik4">춘식4</a></li>
			<li><a href="#choonsik5">춘식5</a></li>
			<li><a href="#choonsik6">춘식6</a></li>
		</ol>
		<hr>
		<a id="choonsik1">춘식1</a> <a href="#choonsikList">[목록으로]</a>
		<br>
		<img src="https://item.kakaocdn.net/do/c5c470298d527ef65eb52883f0f186c48f324a0b9c48f77dbce3a43bd11ce785" />
		<br>
		<a id="choonsik2">춘식2</a> <a href="#choonsikList">[목록으로]</a>
		<br>
		<img src="https://img1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/cnoC/image/PMf1Svki5j407IcpPXbV6LMi4XY" />
		<br>
		<a id="choonsik3">춘식3</a> <a href="#choonsikList">[목록으로]</a>
		<br>
		<img src="https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/593/fb61eb5b1fbd9707852d5caad7a5788f_res.jpeg" />
		<br>
		<a id="choonsik4">춘식4</a> <a href="#choonsikList">[목록으로]</a>
		<br>
		<img src="https://cdn.sports.hankooki.com/news/photo/202009/img_6539191_0.jpg" />
		<br>
		<a id="choonsik5">춘식5</a> <a href="#choonsikList">[목록으로]</a>
		<br>
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRXcmE6xhNn5kXH3-3hOjeAavoMWIyuMuvoiumA_lTJop1Uz-ieEn5xse0bDIDQ3R3Gs4&usqp=CAU" />
		<br>
		<a id="choonsik6">춘식6</a> <a href="#choonsikList">[목록으로]</a>
		<br>
		<img src="https://www.jungle.co.kr/image/ea06cd0346fa8777cb624e3f" />
	</body>
</html>
```
* #### **entity** 중요 (상수와 같은 개념)
  * html, xml에서 사용 가능
  * 테그가 아닌 글자로 표시
```HTML5
> <: &lt; 작다
>: &gt; 크다
& : &amp;
" : &quot;
space(공백) &nbsp;
```
* &lt;BODY&gt;&lt;/BODY&gt; 테그 (사용 안함)
  * (link 방문안함/vlink 방문함/alink 누를때)
  * 그림보다 배경이 우선
* &lt;link&gt; : href 속성 외부 css파일을 불러온다
