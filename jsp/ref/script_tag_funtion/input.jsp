<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>input.jsp</title>
</head>
<body>
	<form name="addForm">
		이름 : <input type="text" name="h_name" title="이름"/>
		<br>
		나이 : <input type="text" name="h_age" title="나이"/>
		<br>
		<input type="button" value="등록하기" onclick="addHuman()"/>
		<input type="button" value="목록으로" onclick="goList()"/>
	</form>
	<script>
		function goList(){
			location.href="output.jsp";
		}
		function addHuman(){
			var formObj = document.addForm;
			var flag = isEmpty(formObj.h_name);
			if(!flag){
				isEmpty(formObj.h_age);	
			}
			if(!flag){
				formObj.action = "save.jsp";
				formObj.method = "post";
				formObj.submit();				
			}
		}
		function isEmpty(inputElement){
			var inputValue = inputElement.value;
			if(inputValue.trim().length == 0){
				alert("필수 입력 사항입니다. : " + inputElement.title);
				inputElement.focus();
				return true;
			}else{
				return false;
			}
			
		}
	</script>
</body>
</html>
