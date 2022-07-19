### out 기본객체
* JSP 페이지가 생성하는 모든 내용은 out 기본 객체를 통해 전송
* JSP가 servlet으로 변경되면 문자열로 처리 ex out.println("<html>");
* 브라우저에 write 해주는 객체
* (response 데이터에 body에 wite)
```jsp
  <%
     out.println("1) 안녕하세요.");
  %>
  2) 안녕하세요.
```
* 동일한 결과가 나온다
* 두번째 방법이 편하기 때문에 out 기본 책체를 직접 사용해서 응답 결과를 생하는 경우 많지 않다.
* if - else 블록에 사용하면 코드를 덜 복잡하게 만들어 줄 수 있다.
```jsp
<% if(grade>10){ %>
<%= A %>
<% }else if (grade > 5){ %>
<%= B %>
<% } %>
```
```jsp
<%
  if(grade > 10){
    out.println(A);
  }else if(grade > 5){
   out.println(B);
  }
%>
```
* print()/println()/newLine()
#### out 기본 객체와 [버퍼](https://github.com/yeRim650/TIL/blob/main/jsp/buffer.md)의 관계
  * <%@ page buffer = "16kb" %>
  * <%@ page autoFlush = "false" %>
  * out 기본 객체의 버퍼의 관련 메서드
    * getBufferSize() 버퍼의 크기
    * getRemaining() 현재 남은 버퍼 크기
    * clear() (flush전 취소 할때 사용, 직접 호출하는 경우는 거의 없다) IOException 발생
    * clearVuffer() (flush전 취소 할때 사용, 직접 호출하는 경우는 거의 없다) IOException 발생x
    * flush() 버퍼를 플러시한다. 즉 버퍼의 내용을 클라이언트에 전송
    * isAutonFlush() 버퍼가 다 찼을 때 자동으로 플러시 할 경우 true를 리턴
