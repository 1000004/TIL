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
* &lt;td&gt; 왼쪽 정렬, 앏게
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
					<th colspan="4">3 rows</th>
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
#### CCS
selector {  
&nbsp;&nbsp;(css 문법) 속성 : 값;  
}
* ex) padding : 10px; 간격 죽기 / border-radius : 25px; 모서리 반지름 결정
* css에서는 단어 연결시 대시를 쓴다
* 일반적으로 대시 수를 보고 어떤것이 합쳐졌는지 알수 있다
