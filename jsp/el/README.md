### EL(Expression language)
${ requsetScope.속성이름} 속성만 해당  
ㄴ pageContext.getRequest() -> Servletrequest  
	pageContext.getSession()  
	pageContext.getServletContext()  
${s.num} -> getNum()  
${pageContext.getReqest} -> pageContext.reqset
* el을 이용해 if for문 제거
#### Java Standard Tag Library (JSTL)
	* JSTL
		* Core - if문, for문을 태그로 변경
		* Database
		* Funtions
	* 로직을 없앤다
	* prefix="c" 코어테그를 쓸때 관례로 core태그를 쓸때 c로 표현(강제 아님)
	* 값이 만들어지면 안된다 (값 설정 또는 제거가 일어나면 안된다)
