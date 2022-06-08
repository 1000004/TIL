
# I/O
>### 입력(Input)/출력(Output)
* #### java.io - 입출력이 없는 프로그램은 없으므로 가장 중요한 패키지일 수 있다. (발전된 패키지 nio)
* #### 입출력은 프로그램 성능에 영향을 미친다.
* #### 영속적 저장소( vs 휘발성 저장소)
    * 01 file
    * 02 DataBase - file에 비해 데이터 공유 가능하다는 장점
    * 일회성이 아닌 이전 데이터를 이어받는다
    * file을 활용하여 프로그램에서 할수 있는 것들이 많아진다.
* ### buffer

   * 읽은 값은 바이트 배열로 들어가 buffer의 크기만큼 들고올수 있다.
   * count는 정확한 정보를 읽고 쓰기 위해 중요
   * 마지막에 buffer의 크기보다 적은 바이트를 읽을수 있어 count 사용
   * 입출력 연산이 컴퓨터 연산중 가장 오래 걸리는 연산 여러번 할 수록 오래 걸린다
   * buffer를 이용하여 입출력 연산을 줄인다.

<img src="https://postfiles.pstatic.net/MjAyMjA2MDhfMjc4/MDAxNjU0Njc3NDM5Mzky.hIahpsKb5khuWxx0Nt1mZhJkfiQmKQUefhfNU2AlVL4g.UvC1HZ5_xmkHlKl7sT2eisUrNlamKEaYK0rAv5_AXHUg.PNG.forget980/image.png?type=w580" width="40%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
