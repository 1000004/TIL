## OS
> 운영체제
* 멀티태스킹 지원 : 여러 프로그램 이용 가능
* 하드웨어와 소프트웨어 중간에 있으면서 자원관리
#### JVAV가 외부 자원에 접근하는 경우
> * 외부 자원 : file, DBConnection, Port
> * OS위에서 실행되는 인반적인 프로그램과 달리 java 프로그램을 실행하기 위서는 JVM이 필요하다.
> <img src="https://postfiles.pstatic.net/MjAyMjA1MTdfMzgg/MDAxNjUyNzk1OTAyMjE5.Kh70iNzgJka8Np8Ex-Ma2bA70cE9-_JaI0SCWn2_LaUg.xa6-EEkdfeqwnhs-PGShZoAkeGPB09mRN-FOW2p9VSAg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
> * JAVA는 OS에게 특정자원에 접근할 권한을 요구하게 된다.
> * OS에서는 JAVA에게 권한 부여하고 JVM에서 자원을 쓰고 있다고 기록한다.
> * [예외처리](https://github.com/1000004/TIL/tree/main/Java/Exception#readme) 등와 같이 JAVA 프로그램이 도중에 중단되어 자원을 더 이상 사용하지 않음을 알리지 않고 종료되는 경우
> * OS에서는 JVM에서 자원을 쓰고 있다고 기록되어 있는 상태므로 계속해서 다른 프로그램이 자원에 접근이 불가능한 상태가 된다.
> * 이를 방지하기 위해 [예외처리](https://github.com/1000004/TIL/tree/main/Java/Exception#readme)에서는 try catch문에 finally을 써서 예외 상황이든 아니든 실행하도록 한다.
> * 데이터 프로그램 session에 경우에서도 max.session과 같이 최대 접속자 수가 정해져 있고 강제 종료로 사용이 끝났음을 알리지 않으면 문제가 발생하게 된다.
