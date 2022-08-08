/**
 * @param
 * - arguments[0] : current form
 * - arguments[1] : command what to do
 * - arguments[2] : need check or not
 */
function doWhat(){
	var formObj = arguments[0];
	formObj.action = argument[1] + ".do";
	var pass = true;
	if(arguments[2]){
		formObj.method="post";
		pass = hasBlank(formObj);
	}
	if(pass && formObj.retry){
		var pw1 = formObj.retry.value;
		var pw2 = formObj.upw.value;
		if(pw1 != pw2){
			pass = false;
			alert("비밀번호가 동일하지 않습니다.같은값을 두번 입력하세요.");
			formObj.upw.focus();
		}
	}
	if(pass){
		formObj.submit();
	}
}
function hasBlank(){
	var formObj = arguments[0];
	var checkList = ["text","password","textarea"];
	//var checkList = new Array("text", "password", "textarea");
	var pass = true;
	for(var i=0; pass && i<formObj.length; i++){
		var field = formObj[i];
		if(checkList.indexOf(field.type) != -1){
			if(field.value.trim().length == 0){
				pass=false;
				alert("누락항목(" + field.title+")");
				field.focus();
			}
		}
	}
	return pass;
}
