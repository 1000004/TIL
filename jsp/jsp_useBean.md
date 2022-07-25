### &lt;jsp:useBean&gt; 액션 태그
* JSP 기반 웹 어플리케이션에서 정보를 표현할 때 사용하는 것 중 하나가 자바빈(JavaBean)이다
* Java Beaan, VO(value object 값을 나타내기 위한 객체), DTO(data transfer object 값을 전달할 때 쓰는 객체), POJO(상속 구현 없이 단독으로 사용하는 객체)
* 자바빈은 속성(데이터), 변경 이벤트, 객체 직렬화를 위한 표준이다
* JSP에서는 속성을 표현하기 위한 용도로 사용
* 자바 빈의 규약
  * 멤버 변수 : private
  * getter/setter
    * 엔드 유저가 변경 불가능한 파라미터가 있더라도 setter를 만들어야한다
    * 엔드 유저에게는 setter에 접근을 못한다
  * 기본 생성자(반드시 만들어야 한다 자바빈을 사용할때 전제가 된다)
  * Serializable 표현(직렬화를 위해 해야하지만 요즘은 잘 안하는 추세)
* 프로퍼티는 자바빈에 저장되는 값
* 메서드 이름을 이용해서 프로퍼티의 이름 결정
* 프로퍼티 값을 변경하는 메서드는 프로퍼티의 이름 중 첫 글자를 대문자로 변환하여 문자열 앞에 set
* 프로퍼티 값을 읽어오는 메서드는 프로퍼티의 이름 중 첫 글자를 대문자로 변환하여 문자열 앞에 get
* 프로퍼티 이름과 필드 이름은 같지 않아도 된다
#### &lt;jsp:useBean&gt; 태그를 이용한 자바 객체 사용
```jsp
<jsp:useBean id="member"scope="request"class="kr.ac.green.MemberInfo"/>
```
```jsp
MemberInfo member = (MemverInfo)request.getAttrivute("member");
if(info==null){
  info = new MemberInfo();
  request.setAttribute("member", member);
}
```
* scope 속성값에 들어갈 수 있는 기본 객체
  * page : pageContext 기본 객체
  * request : request 기본 객체
  * session : session 기본 객체
  * application : application 기본 객체
* class 속성 대신 type 속성 사용 가능
  * 지정한 scope에 이미 객체가 존개한다고 가정
  * 객체가 없으면(null이면) 객체를 새로 만드는 것이 아닌 에러 발생
```java
package kr.ac.green;

import java.util.Date;

public class MemberInfo {

	private String id;
	private String password;
	private String name;
	private Date registerDate;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
```
* makeObject.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member"scope="request"class="kr.ac.green.MemberInfo"/>
<%
	member.setId("madvirus");
	member.setName("지우");
%>
<jsp:forward page="/useObject.jsp"/>
```
* useObject.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member"scope="request"class="kr.ac.green.MemberInfo"/>
<%
	member.setId("madvirus");
	member.setName("지우");
%>
<jsp:forward page="/useObject.jsp"/>
```
#### &lt;jsp:setProperty&gt; 액션 태그와 &lt;jsp:getProperty&gt; 액션 태그
```jsp
<jsp:useBean id="member" class="kr.ac.green.MemberInfo"/>
<jsp:setProperty name="member" property="name" value="지우">
```
* scope 속성의 기본값은 page
* &lt;jsp:setProperty&gt; 액션 태그를 이용 name을 설정 (MemberInfo객체에 name 멤버변수와 nameSetter가 존재해야 한다)
  * member.setName("지우");
  * value 속성값으로 표현식(<%= 값 %>)이나 EL(${값})가능
```jsp
<jsp:setProperty name="member" property="id" param="memberId"/>
```
* param 속성은 파라미터 값을 프로퍼티 값으로 지정할 때 값으로 지정할 때 사용
* param 속성을 사용은 다음 스크립트릿과 같다
```jsp
<%
String id = request.getParamenter("memberId");
menber.setId(id);
%>
```
```jsp
<jsp:useBean id="member" class="kr.ac.green.MemberInfo">
<jsp:setProperty name = "member" property="*"
```
* property 속성의 값을 "*"로 지정하면 각 프로퍼티의 값을 같은 이름을 갖는 파라미터에 값으로 설정
* 객체의 멤버변수에 멤버변수와 이름 같은 request 파라미터 값을 가져와 저장한다
