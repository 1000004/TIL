###JSP
* Placing scripts at the bottom of the <body> element improves the display speed, because script interpretation slows down the display  
→ 스크립트가 interpretation이 느리기 때문에 body에 배치하면 속도가 항상되는 효과를 볼수 있다
* 또한 head에 넣으면 안되는 상황이 존재한다
* 브라우저는 HTML문서를 읽을때 구조(DOM tree)를 분석한다
* DOM tree로 문서 구조 인지

* 자바 스크립트는 오류를 찾기가 어렵다 → 브라우저 화면에서 f12(브라우저의 개발자 모드) 틀린부분을 알려준다
* 디버그를 할때 자바에서는 sysout을 이용했지만 console.log()를 이용해 console에서 확인할 출력할 수 있다.
* js document 메서드
  *  document.getElementById(id) = new html content
  * document.getElementsByTagName(name)
  * element.innerHTML
  * element.attribute = new value
  * dldment.style.property = new style
```jsp
<h2>What Can JavaSript Do?</h2>
<p>JavaScript can chage HTML attribute values.</p>
<bottn id="onBtn">Turn on the light</bottn>
<img id="myImage">Turn off the light</button>
<script>
	document.getElementById("onBtn").onclick = functiton(){
		lightControl("in");
	}
	document.getElementById("onBtn").onclick = functiton(){//다시 쓰지 않는 메서드 ()
		lightControl("off");
	}
function lightControl(state){
	var imgFile = "pic_buld" + state + ".gif";
	document.getElementById("myImage").src = imgFile;
}
</scriprt>
```
