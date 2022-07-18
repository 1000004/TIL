### JSP가 제공하는 기본 객체
* [**requset**](https://github.com/yeRim650/TIL/blob/main/jsp/request.md) 실제 타입 : javax.servlet.http.HttpServletRequest (클라이언트의 요청 정보를 저장한다)
* **response** 실제 타입 : javax.servlet.http.HttpServletResponse (응답 정보를 저장한다)
* **pageContext** 실제 타입 : javax.servlet.jsp.PageContext (JSP 페이지에 대한 정볼르 저장한다)
* **session** 실제 타입 : javax.servlet.http.Hitp.HitpSession (HTTP 세션 정보를 저장한다)
* **application** 실제 타입 : javax.servlet.ServletContext (웹 어플리케이션에 대한 정보를 저장한다.)
* out 실제 타입 : javax.servlet.jsp.JspWriter (JSP 페이지가 생성하는 결과를 출력할 때 사용하는 출력 스트림니다)(중요도가 낮다)
