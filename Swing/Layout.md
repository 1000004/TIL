 #### BorderLayout
 ```java
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame1 extends JFrame{
	public MyFrame1(){
		borderLayout();
		setTitle("MyFrame1");
		setSize(400,300);//픽셀 해상도에 따라 달라짐
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/*
	 * JFrame의 기본 배치관리자는 BorderLayout(border 경계 테두리)
	 * Component 5가지 영역으로 나누어 배치
	 * north와 south는 횡으로 길이 변화에 영향을 받는다
	 * west와 east는 종으로 길이 변화에 영향을 받는다.
	 * center는 가로세로 둘다 길이 영향을 받는다.
	 * center를 중심 4방향 배치
	 * 한가지 영역이 사라지면 center가 차지한다.
	 * center가 없으면 비어진다.
	 * 영역 설정없이 만들면 center에 생성
	 * north와 south는 높이가 선호크기로 결정
	 * west와 east는 넓이가 선호크기로 결정
	 */
	private void borderLayout(){
		JButton btnNorth = new JButton("north");
		JButton btnCenter = new JButton("center");
		JButton btnWest = new JButton("west");
		JButton btnEast = new JButton("east");
		JButton btnSouth = new JButton("south");
		
		add(btnNorth, BorderLayout.NORTH);//선호크기 높이
		add(btnCenter, BorderLayout.CENTER);//높이 넓이 모두 영향
		add(btnWest, BorderLayout.WEST);//north, south 빼고 넓기 결정
		add(btnEast, BorderLayout.EAST);
		add(btnSouth, BorderLayout.SOUTH);
		add(new JButton("hi~"));
		//중심영역에 이미 center버튼이 있는 상태로 "hi~"의 버튼을 덮게 된다.
		//영역별 한개 밖에 못 넣는다.
	}
}
public class Ex1 {
	public static void main(String[] args) {
		new MyFrame1();
	}
}
```

<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfMTQy/MDAxNjUyOTU2NDkwNDY0.oxxD_t1RGnOVsd3EY4I2ktqEC4M-6crz7gSNklfGbNAg.dwQ2p50WJ9VqzRoXiQYBCmDNGl4jVbZ0VIrAkGNk4ikg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
 
  #### FlowLayout
 ```java
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame1 extends JFrame{
	public MyFrame1(){
		flowLayout();
		setTitle("MyFrame1");
		setSize(400,300);//픽셀 해상도에 따라 달라짐
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/*
	 * 차례대로 추가 왼->오 자리가 없으면 위->아래
	 * 기본 중앙 정렬->생성자를 이용해 정렬방법 정할 수 있다
	 * 표시하는 내용에 따라 크기 결정(정해진 여백)
	 * 기본적으로 Component 선호크기로 결정(표시 내용을 보고 적당한크기를 알아서)
	 * 창크기가 변경되어도 component 크기 변경 없다
	 */
	private void flowLayout(){
		FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
		// BorderLayout -> FlowLayout
		setLayout(flow);
		for(int i=1; i<30; i++){
			JButton btn = new JButton(String.valueOf(i));
			//선호크기 강제 지정
			//btn.setPreferredSize(new Dimension(40,20));//너무작으면 글자 표현이 찌그러져보인다
			add(btn);
		}
	}
}
public class Ex2 {
	public static void main(String[] args) {
		new MyFrame1();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfOTEg/MDAxNjUyOTU3MjI2MzU5.aeOx5rdfD_Krn_l9Yq1zfRELaS9XY3a-1qWwJTChRv4g.b2BmFeZDTGkENt-oWayTaRDv_ALopyGDCLkIyZ5KfLsg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
#### GridLayout
 ```java
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame1 extends JFrame{
	public MyFrame1(){
		gridLayout();
		setTitle("MyFrame1");
		setSize(400,300);//픽셀 해상도에 따라 달라짐
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/*
	 * 배치 크기는 동일
	 * 길이 넗이 변화가 모든 Component에 영향(flowLayout은 Component 크기 고정)
	 * 칸을 나누고 차례대로 들어간다
	 * 합병 불가능
	 * 영역 하나에 하나의 Component 넣을 수 있다.
	 * 가로간격 세로간격 지정가능
	 * Component를 칸 갯수보다 많이 배치하면 임의로 다르게 변경
	 * 줄갯수를 0이 아닌 수로 지정하고 캔갯수를 0으로 하면 줄갯수는 보장 
	 * 줄수를 0으로 칸갯수를 0이아닌 수로 지정하면 칸갯수는 보장
	 * 몇개 들어가는지 모르겠을때 둘다 0이면 안되며 무조건 0으로 지정된 칸수, 줄수만 변경
	 */
	private void gridLayout(){
		GridLayout grid = new GridLayout(4,5,10,5);
		// BorderLayout -> GridLayout
		setLayout(grid);
		for(int i=1; i<=19;i++){
			JButton btn = new JButton(String.valueOf(i));
			add(btn);
		}
	}
}
public class Ex3 {
	public static void main(String[] args) {
		new MyFrame1();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfMjAz/MDAxNjUyOTU3NzgwMjUy.6KUp8Q8Tq3YVu16eXYz9jjREjtKrWSIe8QHZKX3zJEAg.3dPmgJi3qYp-iXkbEFF9z-LaKiSnk63Pvm486dweVmcg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
#### NONE
 ```java
package kr.ac.green;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame1 extends JFrame{
	public MyFrame1(){
		none();
		setTitle("MyFrame1");
		setSize(400,300);//픽셀 해상도에 따라 달라짐
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/*
	 * 배치 크기는 동일
	 * 길이 넗이 변화가 모든 Component에 영향(flowLayout은 Component 크기 고정)
	 * 칸을 나누고 차례대로 들어간다
	 * 합병 불가능
	 * 영역 하나에 하나의 Component 넣을 수 있다.
	 * 가로간격 세로간격 지정가능
	 * Component를 칸 갯수보다 많이 배치하면 임의로 다르게 변경
	 * 줄갯수를 0이 아닌 수로 지정하고 캔갯수를 0으로 하면 줄갯수는 보장 
	 * 줄수를 0으로 칸갯수를 0이아닌 수로 지정하면 칸갯수는 보장
	 * 몇개 들어가는지 모르겠을때 둘다 0이면 안되며 무조건 0으로 지정된 칸수, 줄수만 변경
	 */
	private void none(){
		
			//각 각 Component 수작업으로 관리
			//무언가가 바뀌었을때 자동적으로 배치가 되지 않고 수작업 필요
			//절대 좌표 쓰지 않는 것이 좋다
			setLayout(null);
			JButton btn = new JButton("!");
			btn.setSize(200,200);
			JButton btn2 = new JButton("?");
			btn2.setSize(50,50);
			btn2.setLocation(200,200);//JFrame 왼쪽 위 0,0
			add(btn);
			add(btn2);
			System.out.println(btn.getSize());
		
	}
}
public class Ex4 {
	public static void main(String[] args) {
		new MyFrame1();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfMTMg/MDAxNjUyOTU4MTMyNzE0.1hUQ09H7pcGCL8rzR54QrnCBR3NNjpEWIHOrUupoR-wg.awBcchJonIlLTgB6uyl8Kad9kgjNizzfEI3LtrOUyvMg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
