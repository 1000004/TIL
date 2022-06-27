## Network
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
