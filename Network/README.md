## Network
### TCP/UDP
* 데이터를 보내기 위해 사용하는 프로토콜
* 웹 TCP로 동작
* TCP 연결형 통신방식/인터넷/ 신뢰성 보장 순서대로 전달하는 것을 보장 수신 확인
* UDP 비 연결형 통방식/송ㅅ수신 신호 확인 절차 없음/안정성이 낮음 /신뢰성이 보장되지 않지만 속도가 빠르다 (수신 확인이 어렵다 유실 가능성, 순서 보장x 등 발생)  
 (방송국 송출시 수신을 생각하고 보내지 않는다)
### Shocket
* 서버와 클라이언트 양방향 연결이 이루어지는 통신
* Client와 Server가 서로를 추상화하여 Socket으로 정보를 가지고 있어 테이터를 송수신
* 소켓은 읽고 쓸수 있다(역활)
### EchoClientServer
<img src="https://i.ibb.co/M2TrBz1/2022-06-27-204312.png" width="70%" height="60%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
[TCP 통신을 하는 프로그램 기본 틀]->웹 어떻게 읽고 어떻게 전송하는지만 바뀐다
#### 도메인
* 도메인은 인터넷에 연결된 컴퓨터를 사람이 쉽게 기억하고 입력할 수 있도록 문자(영문, 한글 등)로 만든 인터넷주소
* 도메인 Ip가 변경되는 경우 DNS에서 변경(도메인은 변경x)
* 사용자가 IP가 변경되어도 그 사실을 몰라도 도메인을 통해 계속 이용가능.
* DNS : 사람이 이해하기 쉬운 도메인 이름을 숫자로 된 식별 번호(IP 주소)로 변환
* 사이트 접속 방법  
  (1) DNS(도메인 네임 시스템) 도메인 이름을 보고 Ip변경  
  (2) Ip접속  
* 윈도우 도메인의 Ip주소 가져오는 명령어 nslookup
```java
public class NSLookup {
	public static void main(String[] args) {
		String domain = JOptionPane.showInputDialog(
			"도메인을 입력하시요"
		);
		//IP나타내는 객체
		InetAddress[] inetaddr=null;
		try {
			inetaddr = InetAddress.getAllByName(domain);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		for(int i=0;i<inetaddr.length;i++){
			System.out.println(inetaddr[i].getHostName());//도메인
			System.out.println(inetaddr[i].getHostAddress());//IP
			System.out.println(inetaddr[i].toString());
			System.out.println("----------------------");
		}
	}
}
```
#### OSI 7 Layers
* 통식 방식을 표현하는 표준 네트워킹이 가능한 장비 혹은 장비위에 올라가는 소프트웨어는 OSI 7 Layers 규칙대로 통신
* 통신할때 일반적으로 7단계 과정을 거친다
* (S/W(Shocket)이 하는 일 7:Application Layer 6: Presentation Layr 5: Session Layer 4: Transport Layr)
* (H/W가 하는 일 3:Network Layer 2: Datalink Layr 1: Plysical Layer)
> * Application Layer - 응용서비스 (Data 프로토콜 설정)
> * Presentation Layer - MIME 인코딩, 암호화
> * Session Layer - 접소 설정, 유지, 종료 관리
> * Transport Layer - TCP/UDP
> * (H/W)Network, Datalink, Plysical Layer - IP, 통신경로 선택, 전기적 신호 변경  

<img src="https://postfiles.pstatic.net/MjAyMjA2MjhfMTk4/MDAxNjU2Mzg4NzA3MDc3.5oACWzJiZI6yquX3PlJ_J9kJJnBXTfFpnqIKQiXwUrwg.KVtZdIg352ddcsxjb64yQziVqmIMlXTQaqgVQeNzOs0g.PNG.forget980/image.png?type=w580" width="70%" height="60%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

[HTTP] HyperText(HTML)TransferProtocol(HTML 전송하는 방법)
