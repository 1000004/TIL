---
title:  "HTML,CSS,JS"
search: false
categories: 
  - 프론트엔드
toc: true  
tags:
  - 프론트엔드
author: 정예림
---
# Intro

안녕하세요. 정예림 사원입니다.  
HTML,CSS,JS에 대한 구조, 구성 그리고 기본적인 문법을 정리하였습니다.

# HTML
> - 우리가 보는 웹페이지가 어떻게 구조화되어 있는지 브라우저로 하여금 알 수 있도록 하는 마크업 언어   

* Hyper Text: (다른 텍스트에 대한) 링크가 포함된 텍스트.
* Markup Language: 문서가 화면에 표시되는 형식을 나타내거나 데이터를 정적으로 기술한 언어라는 점에서 프로그래밍 언어와 차이가 있다.

# HTML 요소(Element)
* HTML은 elements로 구성
> - 주요 부분   

1. 여는 태그(Opening tag): 요소의 이름과, 열고 닫는 껵쇠 괄호로 구성. 요소의 시작.
2. 닫는 태그(Closing tag): 이것은 요소의 이름 앞에 슬래시(/)가 있는것을 제외하면 여는 태그와 동일. 요소의 끝.
3. 내용(Content): 요소의 내용이며, 단순한 텍스트.
* 여는 태그, 닫는 태그, 내용을 통틀어서 요소.
## 블럭 레벨 요소 vs 인라인 요소
* HTML 두가지 종류의 요소(Element)
* **블록 레벨 요소(Block-level elements)**는 웹페이지 상에 블록(Block)을 만드는 요소.
* 블록 레벨 요소 이전과 이후 요소 사이에 새로운 줄(Line)을 만들고 나타남.
* 블록 레벨 요소는 일반적으로 페이지의 구조적 요소를 나타낼 때 사용.
* 블록 레벨 요소를 사용하여 단락(Paragraphs), 목록(lists), 네비게이션 메뉴(Navigation Menus), 꼬리말(Footers)등을 표현 가능.
* 블록 레벨 요소는 인라인 요소에 중첩될 수 없지만 블록 레벨요소는 다른 블록 레벨 요소에 중첩 불가능.
* **인라인 요소(Inline elements)**는 항상 블록 레벨 요소내에 포함.
* 인라인 요소는 문서의 한 단락같은 큰 범위에는 적용될 수 없고 문장, 단어 같은 작은 부분에 대해서만 적용.
* 인라인 요소를 작성하면 그것을 작성한 단락내에 나타남.
* 예를 들어, 인라인 요소에는 하이버링크를 정의하는 요소인 a tag, 텍스트를 강조하는 요소인 em tag, strong tag 등.
## Self-Closing 태그
* 단일 태그(Single tag) 닫는 태그가 생략.
* Contents가 필요 없는 경우이거나 속성을 통해 가져옴.
* ex - img tag, br tag
## 속성(Attributes)
* 속성은 태그에 추가적인 내용을 담고 싶을 때 사용.
> 속성을 사용할 때 주위할 점   

  * 요소 이름 다음에 바로 오는 속성은 요소 이름과 속성 사이에 공백이 있어야 되고, 하나 이상의 속성들이 있는 경우엔 속성 사이에 공백이 있어야 합니다.
  * 속성 이름 다음에 등호(=)가 붙습니다.
  * 속성 값은 열고 닫는 따옴표로 감싸야 합니다.
  * a tag 속성 표시 예   
  href="http://www.example.com"   
## HTML 문서의 구조   
![image](https://user-images.githubusercontent.com/102463200/204215359-60dbbf4b-4f0e-43b2-a7ed-d7bb44758a31.png)   

1. &lt;!DOCTYPE html&gt; :  HTML5 문서를 선언하는 구문. 웹브라우저에게 문서가 HTML5로 작성됨을 알림.
2. &lt;html&gt;&lt;/html&gt; :  HTML 문서의 시작과 끝.
3. &lt;head&gt;&lt;/head&gt; : &lt;head&gt; CSS, JavaScript, 메타태그 등이 위치.
4. &lt;meta charset="utf-8"&gt; : 이 요소는  HTML 문서의 인코딩 설정을 UTF-8로 지정.(문서의 정보를 설정)
5. &lt;title&gt;&lt;title&gt; : &lt;title&gt;요소입니다. 이 요소를 사용하면 페이지 제목이 설정되며 페이지가 로드되는 브라우저 탭에 표시되는 제목으로 사용.(문서의 상단 제목을 표시)
6. &lt;body&gt;&lt;/body&gt; : 문서 본문에 해당하는 부분으로 실제 화면에 나타나는 메인 부분.
## HTML 텍스트
* HTML을 사용하는 주요 목적 중의 하나는 텍스트에 의미를 부여(시맨틱)하는 것.
* 텍스트에 "내 페이지 최상위 heading"의 역할 감싸는 semantic 요소 &lt;h1&gt;텍스트&lt;/h1&gt;
# CSS(Cascading Style Sheet)
* HTML 문서에 레이아웃과 디자인을 포함한 시각적 요소를 정의하기 위한 규격.
* HTML은 콘텐츠 내용과 구조를 정의하고 CSS에서는 콘텐츠의 위치, 정렬, 글자크기, 여백 배경색상 등을 정의하는 구조.
* 디자인을 적용할 HTML 요소를 셀렉터(Selector)로 지정해 원하는 디자인 속성을 부여.
## CSS의 ruleset   
```css
p {
  color: red;
  width: 500px;
  border: 1px solid black;
}
```
* 위와 같은 Rule Set의 집합은 스타일시트(Style Sheet)라 한다.
> Rule Set 구조   

* 선택자(selector) : rule set의 맨 앞에 있는 HTML 요소 이름. 꾸밀 요소를 선택.
* 선언 : color: red와 같이 단일 규칙. 꾸미미기 원하는 요소의 속성을 명시.
* 속성(property) : 주어진 HTML 요소를 꾸밀 수 있는 방법. color는 p요소의 속성. CSS에서 rule 내에서 영향을 줄 속성을 선택.
* 속성 값 : 속성의 오른쪽에, 콜론 뒤에, 주어진 속성을 위한 많은 가능한 결과중 하나를 선택하기 위해 속성 값을 갖는다.(color의 값에는 red 외에도 많음)
* rule set(셀렉터로 구분)은 반드시 {}로 감싸져야 함.
* 선언 안에, 각 속성을 해당 값과 구분하기 위해 콜론 :을 사용해야함.
* rule set 안에, 각 선언을 그 다음 선으로부터 구분하기 위해 세미콜론 ;을 사용.
## CSS 선택자의 종류   
![image](https://user-images.githubusercontent.com/102463200/204211190-9aedff3f-468b-4ef4-8719-b9f4816234ca.png)   

## CSS 작동 방식   
![image](https://user-images.githubusercontent.com/102463200/204231263-68eff344-1b6d-484a-ab57-97a8bf681647.png)   
![image](https://user-images.githubusercontent.com/102463200/204226170-9210358b-66ab-4667-ab2f-fe31900b01e4.png)   
1. 브라우저는 HTML을 로드.
2. HTML을 DOM으로 변환.
3. 그런 다음 브라우저는 포함된 이미지 및 비디오와 같은 HTML 문서에 연결된 대부분의 리소스와 연결된 CSS를 가져옴.
4. 브라우저는 CSS 구문 분석(parsing)하고 CSSOM을 생성하고 DOM과 CSSOM을 조합.   
(예로 요소, class, ID 등 찾은 선택자를 기반으로 DOM의 어느 노드에 어떤 규칙을 적용해야 하는지 결정하고, 필요에 따라 스타일을 첨부)
5. render tree는 규칙이 적용된 후에 표시되어야하는 구조에 배치.
6. 페이지 화면에 시각으로 표시.(painting)
## DOM
> - 문서 객체 모델은 XML, HTML 문서의 각 항목을 계층으로 표현하여 생성, 변형, 삭제할 수 있도록 돕는 인터페이스.   

* 브라우저가 이해할 수 있는 자료구조, HTML문서를 파싱한 결과물.   
![image](https://user-images.githubusercontent.com/102463200/204230839-56eb5ffb-7b1b-4293-a4e8-504259122fd6.png)   
# JavaScript
* HTML 문서에 이벤트 처리나 동적으로 변화하는 콘텐츠를 표현하거나 서버와 연결을 통해 데이터를 가지고 오는 등의 프로그램적인 요소.
* HTML은 텍스트 파일로 한번 작성된 내용은 수정하기 전까지는 항상 내용이 동일.
* 웹에서 새로운 뉴스, 날씨, 검색순위, 상품정보등이 접속할때 마다 변하는 것은 일반적으로 서버에서 데이터베이스 연동등 백엔드 프로그램을 통해 구현.
* 최근에는 서버에서 정보를 갱신하기 않고(SSR 서버 사이드 렌더링) 클라이언트에서 자바스크립트를 이용해 정보를 갱신하는(CSR 클라이언트 사이드 렌더링) 기술이 많이 사용되고 있음.
## SSR vs CSR
* 렌더링 : 서버에서 요청해서 받은 내용을 브라우저 화면에 표시.
* CSR은 페이지의 내용을 브라우저에서, 그리고 SSR은 서버에서 페이지 내용을 다 그려서 브라우저로 던져준다.
* CSR은 SPA 트렌트와 JS 표준화와 함께 본격적으로 시작되었다.
* 서버 사이드 렌더링과 달리 서버에 HTML 문서를 요청하는 것이 아니라, 클라이언트 사이드 렌더링은 브라우저에서 자바스크립트로 콘텐츠를 렌더링.
## JS - 브라우저 동작 원리   
![image](https://user-images.githubusercontent.com/102463200/204231686-3a78bb31-b4e6-449f-913b-3124496a22c5.png)   
* HTML, CSS 파일은 렌더링 엔진의 HTML 파서와 CSS 파서에 의해 파싱되어 DOM, CSSOM 트리로 변환되고 렌더 트리로 결합.
* 자바스크립트는 렌더링 엔진이 아닌 자바스크립트 엔진이 처리.
* 렌더링 엔진에서 제어 권한을 넘겨 받은 자바스크립트 엔진은 script 태그 내의 자바 스크립트 코드 또는 script 태그의 src 어트리뷰트에 정의된 자바스크립트 파일을 로드라고 파싱하여 실행.
* DOM API : HTML의 요소들을 JS에서 제어하기 위한 명령들의 집합, DOM API를 통해 HTML의 구조나 내용 또는 스타일 등을 동적으로 조작 가능.
* AST(Abstract Syntax Tree) : 프로그래밍 언어의 문법에 따라 소스 코드 구조를 표시하느 계층적 프로그램 표현.
#### 참고 문서
Mmdn <https://developer.mozilla.org/ko/> <br>
HTML 프로그래밍 기초 <https://dinfree.com/lecture/frontend/121_html_1.html> <br>
CSR <https://ctdlog.tistory.com/46> <br>
브라우저 동작 원리 <https://poiemaweb.com/js-browser> <br>
브라우저 렌더링 과정 <https://iancoding.tistory.com/295>
