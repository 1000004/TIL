/**
 * common.js
 * 파라미터를 기재를 안해도 파라미터를 쓸 수 있다 arguments[n]
 * 페이지 마다 폼이름을 변경되도 가져올 수 있다 this.form를 파라미터로 가져온다
 * <script src="js/common.js"></script> 자바스크립트는 따로 열고 닫아야 한다
 * 자바스크립트 파일로 독립시키고 변경 후 갱신이 잘 안되면 브라우저의 캐시를 지운다
 * (캐시 지우는 번거로움을 피하기 위해 처음에는 중복이 되더라도 jsp에 넣고 동작이 되는지 확인후 js파일로 분리)
 * 자바스크립트에서 비밀번호 검사해서는 안된다 (자바스크립트 코드는 클라이언트에 노출된다)
 */
function moveTo(){
			var formObj = arguments[0];
			formObj.method = "post";
			formObj.cmd.value = arguments[1];
			formObj.submit();
}
