### HTML
#### 테이블 테그와 속성
* 복수data가 들어가는 표만들기
* &lt;table&gt; ~ &lt;/table&gt;
> 줄 tr  
> 칸 td
* 셀병합(&lt;td&gt;, &lt;th&gt;에만 있는 속성)
  * colspan="4" 가로로 4칸차지
  * rowspan="4" 세로로 3칸차지
* 테이블 제목 &lt;caption&gt;~&lt;/caption&gt;
* 테이블 헤드 &lt;thead&gt;~&lt;/thead&gt;
* 테이블 페이징
* &lt;tf&gt; 중간정렬 굷게
* &lt;td&gt; 왼쪽 정렬, 게
* 테그 순서 caption thead tfood tbody (그룹핑 효과)
* 보여지는 순서 caption thead tbody tfood
```HTML5
<html>
	<head>
		<title>HTML연습</title>
		<style>
			table {
				border-collapse: collapse;
			}
		
			td, th {
				border: 1px solid gray;
			}
			thead tr {
				background-color: #CCCCCC;
			}
			tbody tr:hover {
				background-color: yellow;
			}
		</style>
	</head>
	<body>
		<table>
			<caption>소설게시판</caption>

			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th colspan="4" style="background-color : green">3 rows</th>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td>3</td>
					<td>죄송합니다.</td>
					<td>A</td>
					<td>2022.07.12</td>	
				</tr>
				<tr>
					<td>2</td>
					<td>미안합니다.</td>
					<td>A</td>
					<td>2022.07.10</td>	
				</tr>
				<tr>
					<td>1</td>
					<td>연재를 시작합니다.</td>
					<td>A</td>
					<td>2022.07.09</td>	
				</tr>	
			</tbody>
		</table>
	</body>
</html>
```
<img src="https://postfiles.pstatic.net/MjAyMjA3MTJfMjc5/MDAxNjU3NjE2NjcyNjI2.oEExC-268ADrRZyq0_onHCR6vBF-0DVWPpKO36-BkXkg.fHW-92Nyr-1JMnAbfHY8-8ltbe6H0B2pN4Ax_bTFWbcg.PNG.forget980/image.png?type=w580" width="70%" height="60%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```HTML5
table {
	border-collapse: collapse;
}
```
* 떨어진 테두리를 병합
```HTML5
td, th { <- selector
	border : 1px solid gray;
}
```
* border - 테두리/ 1px - 두께/ solid 실선 / gray 색
```HTML5
thead tr {
	background-color: #CCCCCC;
}
```
* thead 밑에 있는 tr만 적용 
```HTML5
tbody tr:hover{
		background-color: yellow;
}
```
* 마우스가 올라갔을때 색
```HTML5
<th colspan="4" style="background-color : green">3 rows</th>
```
* 특별히 한두개의 태그의 style을 변경할때 테그 style 속성에 바로 적용
#### CCS
> selector {  
> &nbsp;&nbsp;(css 문법) 속성이름 : 속성값;  
> }
* ex) padding : 10px; 간격 죽기 / border-radius : 25px; 모서리 반지름 결정
* css에서는 단어 연결시 대시를 쓴다
* 일반적으로 대시 수를 보고 어떤것이 합쳐졌는지 알수 있다
```HTML5
<html>
	<head>
		<title>selector ex</title>
		<style>
			/*테그 선택자*/
			p{
				border: 1px double red;
			}
			/*id 선택자*/
			#firstP{
				font-weight: bold;
			}
			/*(tag가 p인)class 선택자*/
			p.javaP{
				background-color: yellow;
			}
		</style>
	</head>
	<body>
		<p id="firstP" onclick="clickP()">first</p>
		<p class="javaP">second</p>
		<p class="javaP">third</p>
		<idv class="javaP">this is a div</div>
		<script>
			function clickP() {//listner
				alert("click");//클릭시 경고창
			}
		</script>
	</body>
<html>
```
* 일반적으로 선택자가 영어로 시작하면 tag
* id는  유일한 값 선택자는 #로 시작 (Global Attribute)
* class 중복 가능 선택자는 .로 시작 (Global Attribute)
* selector *는 전부
* js에도 쓰인다
* /* */ 주석
* 영역을 나타내는 idv
* **&lt;script&gt; ~ &lt;/script&gt;** 
	* js 스크립트 위치는 헤더사이 또는 body 끝에 쓴다 (body 끝에 쓴는 것이 유리)
	* function은 자바와 메서드와 유사 return이 있을 수 있지만 js에서는 타입이 중요하지 않기 때문에 포기하지 않는다
	* 스윙과 이벤트 처리 비교
		* function은 - listenr 역할
		* p - event source
		* onclick="clickP()" - addlistner 역할
