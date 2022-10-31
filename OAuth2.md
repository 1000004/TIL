## OAuth
* **OAuth**는 인터넷 사용자들이 비밀번호를 제공하지 않고 다른 웹사이트 상의 자신들의 정보에 대한 웹 사이트나 애플리케이션의 접근 권한을 부여할 수 있는 공통적인 수단으로서 사용되는, 접근 위임을 위한 개방형 표준
### OAuth의 배경
> 간한하게 인증과 권한을 회득
* third party Application에 아이디와 비밀번호를 제공하고 싶지 않은 요구
* 개인정보를 여러곳에 입력하면 피싱에 둔감해지고 Application이 안전하다는 보장이 없기 때문에 보안에 취약
### Oauth 1.0 참여자
![image](https://user-images.githubusercontent.com/102463200/198908308-c62e06d5-22e4-49a0-bc98-d68c798c10b8.png)
* **Service provider** : OAuth를 사용하는 Open API를 제공하는 서비스
* **User** : Service Provider에 계정을 가지고 있으면서, Consumer를 이용하려는 사용자
* **Consumer** : OAuth 인증을 사용해 Service Provider의 기능을 사용하려는 애플리케이션이나 웹 서비스
### OAuth 인증 과정
> Request Token의 요청과 발급 → 사용자 인증 페이지 호출 → 사용자 로그인 완료 → 사용자의 권한 요청 및 수락 → Access Token 발급 → Access Token을 이용해 서비스 정보 요청
* **Access Token을 가지고 있는 Consumer는 사전에 호출이 허락된 Service Provider의 오픈 API를 호출**
### oauth_signature 만들기
> Request Token 발급 요청시 발급 되는 oauth_signature 매개변수
* HMAC 암호화 방법을 이용하여 oauth_signature를 생성되는데 OAuth 1.0에서는 oauth_signature를 생성하는 것이 가장 까다롭다
## OAuth 2.0
> OAuth 1.0 단점  
> 웹 애플리케이션이 아닌 애플리케이션에서는 사용이 곤란하다  
> 절차가 복잡하여 OAuth 구현 라이브러리 제작이 어려워 복잡한 절차 때문에 Service Provider에게도 연산 부다밍 발생  
### OAuth 2.0 특징
* 웹어플리케이션이 아닌 애플리케이션 지원 강화
* 암호하가 필요 없음 (HTTPS를 사용하고 HMAC을 사용하지 않는다)
* Siganature 단순하 (정렬과 URL 인코딩이 필요 없다)
* Access Token 갱신
