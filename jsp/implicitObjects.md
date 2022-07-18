### JSP가 제공하는 기본 객체
* [**requset**](https://github.com/yeRim650/TIL/blob/main/jsp/request.md) 
  * 실제 타입 : javax.servlet.http.HttpServletRequest (클라이언트의 요청 정보를 저장한다)
* **response** 
  * 실제 타입 : javax.servlet.http.HttpServletResponse (응답 정보를 저장한다)
* [**pageContext**](https://github.com/yeRim650/TIL/blob/main/jsp/pageContext.md) 
  * 실제 타입 : javax.servlet.jsp.PageContext (JSP 페이지에 대한 정볼르 저장한다)
* **session** 
  * 실제 타입 : javax.servlet.http.Hitp.HitpSession (HTTP 세션 정보를 저장한다)
* **[application](https://github.com/yeRim650/TIL/blob/main/jsp/application.md)** 
  * 실제 타입 : javax.servlet.ServletContext (웹 어플리케이션에 대한 정보를 저장한다.)
* [out](https://github.com/yeRim650/TIL/blob/main/jsp/out.md) 실제 타입 : javax.servlet.jsp.JspWriter (JSP 페이지가 생성하는 결과를 출력할 때 사용하는 출력 스트림이다)
* config (JSP 페이지에 대한 설정 정보를 저장)
* page (JSP 페이지를 구현한 자바 클래스 인스턴스)
* exception (익셉션 객체. 에러 페이지에서만 사용 한다.)
> ##### exception 기본 객체를 제외한 나머지 8개 기본 객체는 모든 JSP페이지에서 사용 가능
