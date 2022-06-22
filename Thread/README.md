
#### 프로세스 : OS에서 실행중인 프로그램
##### 멀티태스킹 : 시분할 시스템 프로세스  A,B,C에 시간 할당을 빠르게 진행 동시에 실행된느 것으로 보인다
    * 자원 할당 사람예측이 불가  
    * 순차적으로 실행되는 것인 더 경제적이지만 응답성이 낮다, 사용자 입장에서 답답함을 느낄 수 있다  
    * 실행 중인 스레드에 자원을 해제하고 다시 할당하는 과정에서 문맥 교환 비용이 든다
#### 병렬 parallel (H/W) : 물리적인 코어수는 연산속도와 연관 없다 동시 처리량이 많아진다
#### 병행 concurrency (S/W) : 프로세스 스케줄링 의거 자원할당 프로세스는 할당받은 자원을 다시 내부적으로 **Thread**에 스케줄링
#### (Process는 thread의 집합) 프로그램의 흐름 Thread(context)
> ##### 스케줄링하는 JVM 경우 여러 Thread가 작업 순서 예측이 어렵기 때문에 같은 코드지만 다른 결과가 나오게 된니다.

* 스레드의 만드는 방법 알기
* 스레드의 움직임 통제하기
* 원하는 순서대로 작업이 되도록 한다
* 여러 스레드의 동작으로 문제점을 알고 극복

여러 스레드로 이루어진 프로세스를 여러개만들어 네트워크로 통신이 가능해진다
#### API Thread.State
> ##### New 스레드가 만들어진 상태  
> ##### RUNNABLE 대기열, 실행 상태  
> ##### BLOCKED 입출력 대기  
> ##### WAITING 무작정 기다리는 상태  
> ##### TIMED_WAITING sleep()  
> ##### TERMINATED run 종료 소멸된 상태
> ##### 모든 스레드가 Not Runnable인 상태 -> DeadLock
<img src="https://postfiles.pstatic.net/MjAyMjA2MjJfMzAw/MDAxNjU1ODc2NTM2NjE3.xMqVOHllS6tQptCp-XHK-9Yh-3rdptWqNs0dgFiR81Yg.mIC18CDqmcSDplu8spF54f6V1ttKyxlLxftBQI-rqZkg.PNG.forget980/image.png?type=w580" width="50%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
> #### Not Runable 상태로 넘어가는 method sleep join은 InteruptedException이 발생
> 우선순위 설정은 대기열에서 가상머신에게 뽑힐 확률 높인다 (Max,Min,Normal) (우선순위가 2인 스레드가 만든 스레드는 2다)

> ##### **일반 스레드** - 주기능 ex 한글 문서작성  
> ##### **데몬 스레드** - 백그라운 보조작업 (일반쓰레드 전부 죽으면 자동 소멸) ex 한글 자동저장 자바 g.c
