## JToolBar
* Menu와 유사한 Toolbar
* 창에서 Toolbar를 분리할 수 있다
* 단, JToolBar가 BorderLayout container에 있고 NORTH, WEST, EAST에 배치가 안되어 있는 경우 부착할 수 있다.
## JSplitPane
* 두 개 Component 를 나누는 데 사용
* 탐색기에서 볼 수 있다
 ```java
 public class Ex4 extends JFrame{
	private JToolBar tBar;
	private JButton btnOpen;
	private JButton btnSave;
	
	private JLabel lblLeft;
	private JLabel lblRight;
	private JSplitPane sPane;
	
	public Ex4(){
		tBar = new JToolBar();//Menu와 유사한 Toolbar
		//창에서 Toolbar를 분리할 수 있다.
		//단, JToolBar가 BorderLayout container에 있고 NORTH, WEST, EAST에 배치가 안되어 있는 경우 부착할 수 있다.
		btnOpen = new JButton(new ImageIcon("open.png"));
		btnSave = new JButton(new ImageIcon("save.png"));
		tBar.setFloatable(false);//Toolbar가 떨어지지 못하게 고정
		
		tBar.add(btnOpen);
		tBar.addSeparator(new Dimension(15,1));//구분자(구분선)메뉴와 다르게 선으로만 가능 두께 조절 가능(가로설정이 중요)
		tBar.add(btnSave);
		tBar.add(Box.createHorizontalGlue());
		//횡으로 잡아먹을 수 있는 여백을 최대한으로 잡아먹도록 컨테이너 생성 Help button을 횡 끝으로 보낸다
		tBar.add(new JButton("Help"));
		
		//lblLeft = new JLabel(new ImageIcon("con_icon.gif"));
		//lblRight = new JLabel(new ImageIcon("choncik_icon.gif"));
		
		lblLeft = new JLabel();
		lblRight = new JLabel();
		
		lblLeft.setOpaque(true);
		lblLeft.setBackground(Color.WHITE);
		
		lblRight.setOpaque(true);
		lblRight.setBackground(new Color(0xCEFBC9));
		
		sPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//종으로 나눈다 HORIZONTAL은 횡으로 나눈다
		sPane.setLeftComponent(lblLeft);
		sPane.setRightComponent(lblRight);
		//두 개 Component 를 나누는 데 사용
		//요소를 칸으로 나누어 배치
		//탐색기에서 볼수 있다.
		lblLeft.setMaximumSize(new Dimension(0,0));//최소 크기 설정
		sPane.setContinuousLayout(true);
		//기본적으로 false는 그림자가 발생하고 그림자를 놓으면 그림자선을 기준으로 크기 변경
		//true 화면 계속 갱신
		sPane.setOneTouchExpandable(true);//화살표 방향으로 이동 확장
		sPane.setDividerSize(10);//선 굵기 결정
		sPane.setResizeWeight(0.3);//왼쪽/오른쪽 → 외쪽이 기준 위/아래 →  탑이 기준
		//왼쪽이 30% 오른쪽 70% 차지
		
		
		add(tBar, BorderLayout.NORTH);
		add(sPane, BorderLayout.CENTER);
		
		setTitle("ToolBarEx");
		//pack();
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ex4();
	}
 }
 ```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfNTAg/MDAxNjUzNTc5Nzc0MTEw.r2-KBHMP0AgD0dwiT-rojywuQalxk7q6nQtYXtEFIYQg.ArIgT5pI63-WMimrCfozOAojyOv-4MZNLzy7auk3K4og.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class Test2 extends JFrame {
	private JLabel lblLeft;
	private JLabel lblRTop;
	private JLabel lblRBottom;
	private JSplitPane sPane;
	private JSplitPane sPaneRight;
	public Test2(){
		
		sPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		lblLeft = new JLabel();
		lblLeft.setOpaque(true);
		lblLeft.setBackground(Color.YELLOW);
		sPane.setLeftComponent(lblLeft);
		sPaneRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		sPane.setRightComponent(sPaneRight);
		lblRTop = new JLabel();
		lblRTop.setOpaque(true);
		lblRTop.setBackground(Color.RED);
		lblRBottom = new JLabel();
		lblRBottom.setOpaque(true);
		lblRBottom.setBackground(Color.GREEN);
		sPaneRight.setTopComponent(lblRTop);
		sPaneRight.setBottomComponent(lblRBottom);
		sPane.setResizeWeight(0.3);
		sPaneRight.setResizeWeight(0.5);
		add(sPane, BorderLayout.CENTER);
		
		setTitle("ToolBarEx");
		//pack();
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test2();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMTky/MDAxNjUzNjExNjExODcy.pPTenhDvY-brbHfaFV3wSOaY_yK7eakTpKqywB9mhWkg.lsE49qxX7jdIOk-9qmo-dIbybOg3dwU1N-J7mrjG8lwg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
