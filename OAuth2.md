## OAuth
* **OAuth**는 인터넷 사용자들이 비밀번호를 제공하지 않고 다른 웹사이트 상의 자신들의 정보에 대한 웹 사이트나 애플리케이션의 접근 권한을 부여할 수 있는 공통적인 수단으로서 사용되는, 접근 위임을 위한 개방형 표준
### OAuth의 배경
> 간단하게 인증과 권한을 획득
* 사용자가 외부 Application에 아이디와 비밀번호를 제공하고 싶지 않은 요구
* 개인정보를 여러곳에 입력하면 피싱에 둔감해지고 Application이 안전하다는 보장이 없기 때문에 보안에 취약
  * 아이디/패스워드를 가지지 않고 API를 사용할 수 있도록 인증 토큰 활용
### OAuth 1.0 용어
![image](https://user-images.githubusercontent.com/102463200/198908308-c62e06d5-22e4-49a0-bc98-d68c798c10b8.png)
> OAuth 1.0 참여자  
* **Service provider** : 	OAuth를 사용하는 Open API를 제공하는 서비스
* **User** : Service Provider에 계정을 가지고 있으면서, Consumer를 이용하려는 사용자
* **Consumer** : OAuth 인증을 사용해 Service Provider의 기능을 사용하려는 애플리케이션이나 웹 서비스
```
* Request Token : Consumer가 Service Provider에게 접근 권한을 인증받기 위해 사용하는 값.   
  (인증이 완료된 후에는 Access Token으로 교환)
* Access Token : 인증 후 Consumer가 Service Provider의 자원에 접근하기 위해 키를 포함한 값.
```
### OAuth 1.0 인증 과정
![image](https://user-images.githubusercontent.com/102463200/198912658-2e563274-2d5c-4f5d-aebd-9c9bd9cadea4.png)

> **Request Token**의 요청과 발급 → 사용자 인증 페이지 호출 → 사용자 로그인 완료 → 사용자의 권한 요청 및 수락  
> → **Access Token** 발급 → **Access Token**을 이용해 서비스 정보 요청
* **Access Token을 가지고 있는 Consumer는 사전에 호출이 허락된 Service Provider의 오픈 API를 호출**
### oauth_signature 만들기
> 권한을 준 행위가 이루어졌음을 프로그램을 통해 증명하는 방식으로 **서명(Signature)** 을 이용  
> Request Token, Access Token 발급 요청시 생성되는 매개변수 oauth_signature
* HMAC 암호화 방법을 적용하여 oauth_signature가 생성되며 OAuth 1.0 인증에서 가장 까다로운 과정이다.
## OAuth 2.0
> OAuth 1.0 단점  
> > 웹 애플리케이션이 아닌 애플리케이션에서는 사용이 곤란하다.  
> > 절차가 복잡하여 OAuth 구현 라이브러리 제작이 어렵다.  
> > 복잡한 절차로 Service Provider에게도 연산 부담이 발생한다. 

![image](https://user-images.githubusercontent.com/102463200/198911779-2fec867e-1117-40cd-9331-5209484aac1c.png)
### OAuth 2.0 특징
* 웹어플리케이션이 아닌 애플리케이션 지원 강화
* 암호화가 필요 없음 (HTTPS를 사용하고 HMAC는 사용하지 않는다)
* OAuth 2.0에서는 보안 강화를 위해 Access Token의 Life-time을 지정할 수 있다.
* 기능 단순화, 기능과 규모의 확정성 등을 지원하기 위해 만들어짐
  * 인증서버의 분리와 다중화 등에 대한 고려
* 1.0a는 인증방식이 한가지 였지만 2.0는 다양한 인증방식을 지원
  * OAuth 1.0a는 HMAC을 이용한 암호화 인증 방식만 제공
### OAuth 2.0 용어
![image](https://user-images.githubusercontent.com/102463200/198912837-168d58e5-c504-45f2-9f67-ea37a3a151a6.png)

> OAuth 2.0 참여자
* Resurce Server(자원 서버) : OAuth2.0 서비스를 제공하고, 자원을 관리하는 서버 (보통 gogle, naver 같은 사이트)
* Resurce Owner(자원 소유자) : Resource Server의 계정을 소유하고 있는 사용자
* Client : Resource Server의 API를 사용하여 데이터를 가져오려고 하는 사이트 (개발 사이트)
* Authorization Server(권한 서버) : Client가 Resource Server의 서비스를 사용할 수 있게 인증하고 토큰을 생성해주는 서버
```
* Access Token : 자원 서버에 자원을 요청할 수 있는 토큰
* Refresh Token : 권한 서버에 접근 토큰을 요청할 수 있는 토큰
```
### OAuth 2.0 인증 과정
![image](https://user-images.githubusercontent.com/102463200/198916461-0a6901a9-da4f-429b-93db-2bcc72ee1505.png)
> OAuth2의 프로토콜 흐름
* (A) (앱 → 사용자) 사용자가 데이터에 접근하기 위해 권한을 요청
* (B) (사용자 → 앱) 접근에 동의함을 증명하는 **권한 부여 동의서**를 발급
* (C) (앱 → 권한 제공기관) **권한 부여 동의서**를 제출
* (D) (권한 제공기관 → 앱) **권한 부여 동의서**를 확인하여 접근 토큰을 제공
* (E) (앱 → 데이터 제공기관) 접근 토큰을 제출하여 사용자 데이터를 요청
* (F) (데이터 제공기관 → 앱) 사용자 데이터를 제공
### 권한 부여 동의서 방식 4가지
* Autorization Code Grant(권한 부여 코드 승인) (PKCE)
  *  Client가 다른 사용자 대신 특정 리소스에 접근을 요청할 때 사용
  *  리소스 접근을 위해, Authorization Server에서 받은 권한 코드로 리소스에 대한 액세스 토큰을 받는 방식
  *  다른 인증 절차에 비해 보안성이 높기 때문에 주로 사용
* Implicit Grant(암묵적 승인)
  * Authorization Code Grant과 다르게 권한 코드 교환 단계가 있음
  * 엑세스 토큰을 즉시 반환받아 이를 인증에 사용하는 방식
* Resurce Owner Passward Credentials Grant(리소스 소유자 암호 자격 승인)
  * Client 암호를 사용하여 액세스 토큰에 대한 사용자의 자격 증명을 교환하는 방식
  * Resurce Owner에서 ID, Password를 전달 받아 Resurce Server에 인증하는 방식으로 신뢰할 수 있는 Client인 경우 가능
* Client Credentials Grant(클라이언트 자격 승인)
  * Client가 컨텍스트 외부에서 엑세스 토큰을 얻어 특정 리소스에 접근을 요청할 때 사용하는 방식 
> Autorization Code Grant  

![image](https://user-images.githubusercontent.com/102463200/198913234-cdf8f073-d2c8-4248-9549-9a6d28e4cc9a.png)
> Implicit Grant  

![image](https://user-images.githubusercontent.com/102463200/198929605-b641404c-eebc-4420-bc02-3bef9542f1b2.png)
> Resource Owner Password Credentials Grant

![image](https://user-images.githubusercontent.com/102463200/198929739-831ed17f-e6c1-4880-893c-28dceb931538.png)
> Client Credentials Grant Type

![image](https://user-images.githubusercontent.com/102463200/198929812-1ad5a6e0-dc96-4799-9dc9-95c681b55279.png)

------------
### OAuth vs JWT
> JWT는 토큰의 종류  
> OAuth는 토큰을 발급하고 인증하는 오픈 스탠다드 프로토콜  
* JWT는 토큰 자체에 유저 정보를 담고 있기 때문에 HTTP 헤더에 실어 전달함으로써 유저 세션을 유지할 필요가 없고 가볍게 데이터를 주고받을 수 있다는 장점이 있다
* OAuth에서 주로 bearer라는 토큰 사용
  * bearer 토큰은 유저 정보와 같은 명확한 정보를 가지고 있지 않은 토큰을 말한다
