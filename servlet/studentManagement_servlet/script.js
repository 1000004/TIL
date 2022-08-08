function todo(what){
	var obj = document.forms["menuForm"];
	obj.cmd.value = what;
	obj.action = what+".do";
	obj.submit();
}
function chkForm(){
	var form = arguments[0];
	var isOk = true;
	for(var i=0; isOk && i<form.length; i++){
		var field = form[i];
		
		if(field.type=="text"){
			if(field.value.trim().length == 0){
				var msg = "필수입력 사항 누락 : ";
				alert(msg + field.title);
				field.focus();
				isOk = false;
			}
		}
	}
	return isOk;
}
