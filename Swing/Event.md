# event - driven
### 1. event 처리
* event : UI상에서 사용자가 하는 행위
* event-sourse(근원) : event를 발생시킨 component ex button TextField TextArea
* event-listener : event 발생시 한일을 정의하는 객체, interface로 만들어짐, 이벤트를 감시

event가 결정되면 listener 결정 - 서로의 이름을 알수 있다/규칙을 가진다.
> Action Event - event listener /
> WindowEvent - WindowListener /
> MouseEvent - MouseListener

### 2. event를 기준으로 동작 과정
#### 01. UI 구현 
    * 처리할 event 결정 - event -sourse이 결정된다. (모든 이벤트에 반응 안함) 여러 이벤트 중 무슨 이벤트에 반응할지 결정
#### 02. event-listener 구현
#### 03. event-source, event-listener 연결 
    * 하나의 event-listener를 가지고 event-source로 구분 가능

* API 문서 method에 Invoked가 있는 경우 : 알아서 시스템상에서 호출되어진다.
* 이벤트소스.addxxxListener(리스너)
* 이벤트 소스 결정 API문서에 확인 addxxxListener Methods를 확인 맞는 Listener 찾기
* button이 Action Event 발생하는지 안하는지 Action listener가 감시 → 발생시 감지해서 동작

Invoked : 자동 호출되는 메서드 callback메서드
call : 우리가 호출해야하는 메서드

void actionPerformed(ActionEvent e)
-->callback메서드
