## Menu 만들기
* JMenuBar 컨테이너
* JMenuItem는 JMaenu의 상위 계층
* JMenuItem 기능 직접 정의 / JMaenu 기능 고정
* JMenuBar의 위치는 고정, 배치의 대상이 아니다
```java
public class Ex2 extends JFrame {
	/*
	 * Menu 만들기
	 * JMenuBar 컨테이너
	 * JMenuItem는 JMaenu의 상위 계층
	 * JMenuItem 기능 직접 정의 JMaenu 기능 고정
	 * JMenuBar의 위치는 고정 위 배치의 대상이 아니다
	 * 
	 * JFrame 구조
	 * 모두 container
	 * Rot pane layer pane content pane glass pane
	 * 눈으로 보고 있는 content pane 메뉴바 위치 고정
	 * 이전 JDK GetContentPane().add()-> add()
	 */
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenu mEdit;
	
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miExit;
	private JLabel lblMain;
	
	private JMenu mOption;
	private JMenuItem miOptionA;
	private JMenuItem miOptionB;
	
	private JMenu mCheck;
	private JCheckBoxMenuItem miFirst;
	private JCheckBoxMenuItem miSecond;
	private JCheckBoxMenuItem miThird;
	
	private JMenu mRadio;
	private JRadioButtonMenuItem miTop;
	private JRadioButtonMenuItem miBottom;
	
	
	private JButton btnExit;
	
	public Ex2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init() {
		// 컴포넌트를 생성하기전에 사용해야함.
		// whindow 환경으로 변경
		// 메뉴바 버튼 형태 등이 달라짐
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		mBar = new JMenuBar();//기본 생성자
		
		mFile = new JMenu("File");
		mEdit = new JMenu("Edit");
		
		// alt + s
		miSave = new JMenuItem("Save");
		miSave.setIcon(new ImageIcon("save.png"));//MenuItem 아이콘 설정
		miSave.setActionCommand("store");
		miSave.setMnemonic('S');//Mnemonic 확장된 상태만 키 적용
		KeyStroke keys = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK);
		//KeyEvent 상수로 키보드 나타냄
		//InputEvent Modifier키 ALT SHIFT CTRL
		miSave.setAccelerator(keys);//Accelerator 확상안된 상태도 단축키

		
		// alt + shift + o
		miOpen = new JMenuItem("Open", 'O');//Mnemonic 설정
		miOpen.setEnabled(false);//상황에 따른 비활성화
		miOpen.setIcon(new ImageIcon("open.png"));
		miOpen.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK)
			//InputEvent Modifier키 or
		);
		
		
		miExit = new JMenuItem("Exit");
		
		mOption = new JMenu("Option");
		//JMenu가 JMenuItem을 상속받기 때문에
		//JMenu가 JMenu를 가질 수 있다.
		miOptionA = new JMenuItem("A");
		miOptionB = new JMenuItem("B");
			
		mCheck = new JMenu("Check");
		miFirst = new JCheckBoxMenuItem("first", true);//체크 표시
		miSecond = new JCheckBoxMenuItem("second");
		miThird = new JCheckBoxMenuItem("third");
		
		mRadio = new JMenu("Radio");
		miTop = new JRadioButtonMenuItem("top");//둘중 하나
		miBottom = new JRadioButtonMenuItem("bottom", true);
		ButtonGroup group = new ButtonGroup();//radiobutton 버튼 그룹에 넣는다
		group.add(miTop);
		group.add(miBottom);
		
		lblMain = new JLabel("Start", JLabel.CENTER);
		lblMain.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		
		btnExit = new JButton("Good bye~");
		btnExit.setActionCommand("Exit");
	}
	private void setDisplay() {
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.addSeparator();
		//줄로 표시로 구분자 경계나눠준다
		//배치 순서 확인
		mFile.add(miExit);
		
		mOption.add(miOptionA);
		mOption.add(miOptionB);
		
		mCheck.add(miFirst);
		mCheck.add(miSecond);
		mCheck.add(miThird);
		
		mRadio.add(miTop);
		mRadio.add(miBottom);
		
		mEdit.add(mOption);
		mEdit.add(mCheck);
		mEdit.add(mRadio);
		
		mBar.add(mFile);
		mBar.add(mEdit);
		
		setJMenuBar(mBar);//MenuBar 배치
		
		add(lblMain, BorderLayout.CENTER);
		add(btnExit, BorderLayout.SOUTH);
	}
	private void addListeners() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				//Object src = ae.getSource();
				String cmd = ae.getActionCommand();
				//똑같은일을 하는 버튼이 2개이상일 때 ActionCommand를 정해 놓으면 좋다.
				System.out.println(cmd);
				String what = null;
				if(cmd.equalsIgnoreCase("Open")) {
					what = "open";
				} else if(cmd.equals("store")) {
					what = "save";
				} else if(cmd.equals("Exit")) {
					what = "Exit";
				}
				
//				String what = ae.getActionCommand();
				lblMain.setText(what);
			}
		};
		miSave.addActionListener(listener);
		miOpen.addActionListener(listener);
		miExit.addActionListener(listener);
		btnExit.addActionListener(listener);
	}
	private void showFrame() {
		setTitle("MenuEx");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex2();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMjk0/MDAxNjUzNTc4MjkxMjQx.scI5EPz8_npjXzJK21xILx_s0T2QuGngXpZyjz3jC6sg.TDH_6X0zSJT4il8bQ-W0PrBrnB-j5EcFjzD1_WGGjvYg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMTI3/MDAxNjUzNTc4MzM2NjUz.Xi_XEY521GCtSSrcM11teOT46TaV2BZKQALuATZXbTUg.97_Q8Fn0q_OKDUl8ioi7XO-1FctXKiUmGz0Y3NCUPv0g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
