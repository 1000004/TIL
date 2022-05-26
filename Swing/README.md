### Swing을 이용하여 [GUI](https://github.com/1000004/TIL/blob/main/GUI.md)만들기
#### JFrame 구조
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfNTQg/MDAxNjUzNTc4MTEyNzk0.WrmNWaSjpzzpgXYvT_bqEgykZDwhhmyGZZ4F9lcP4nkg.xncK4DYrdjlAjEwr6bF-feQJ0Km7iu4yRszjNLeAhEAg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
* Root Pane Layer Pane Content Pane Glass Pane
* 모든 Pane container
* Content Pane이 우리가 눈으로 보고 있는 Pane - 메뉴바 위치가 고정되어 있다
* 요소를 Content Pane에 추가할 때 예전 JDK GetContentPane().add()-> add()
