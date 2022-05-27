## JPopupMenu
* JPopupMenu 팝업 메뉴는 마우스 우클릭으로 볼 수 있다.
* 팝업 메뉴 보여주는 요청 신호 정의 o/s 결정
* 운영체제마다 팝업 메뉴 신호가 정해져 있고 다르다
* mouse Pressed/Released 둘 중 하나는 호환
* 따라서 둘 다 처리
* PopupMenu는 단축키 없다
* 단축키 설정을 보여줄 수 있지만 Menu에 있는 단축키가 작동
* Menu에는 없는 단축키거나 다르면 단축키가 작동 안하거나 Menu에 있는 다른 기능 동작
```java
public class Ex3 extends JFrame {
	/*
	 * JPopupMenu 팝업 메뉴는 마우스 우클릭으로 볼 수 있다.
	 * 팝업 메뉴 보여주는 요청 신호 정의 o/s 결정
	 * 운영체제마다 팝업 메뉴 신호가 정해져 있고 다르다
	 * mouse Pressed/Released 둘중 하나는 분명
	 * 따라서 둘다 처리
	 */
	private JMenuBar mBar;
	private JMenu mFriends;
	private JMenuItem miChoonsik;
	private JMenuItem miRyan;
	private JMenuItem miCon;
	
	private JPopupMenu pMenu;//팝업창
	private JMenuItem miChoonsik_p;
	private JMenuItem miRyan_p;
	private JMenuItem miCon_p;
	
	private ImageIcon[] icons = {
		new ImageIcon("choonsik_icon.gif"), 
		new ImageIcon("ryan_icon.gif"), 
		new ImageIcon("con_icon.gif")
	};
	
	public static final int CHOONSIK = 0;
	public static final int RYAN = 1;
	public static final int CON = 2;
	
	private JLabel lblMain;
	
	public Ex3() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init() {
		mBar = new JMenuBar();
		mFriends = new JMenu("friends");
		miChoonsik = new JMenuItem("춘식");
		miChoonsik.setActionCommand("choonsik");
		miRyan = new JMenuItem("라이언");
		miRyan.setActionCommand("ryan");
		miCon = new JMenuItem("콘");
		miCon.setActionCommand("con");
		
		miChoonsik.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		miRyan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
		miCon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.ALT_DOWN_MASK));
		
		mFriends.add(miChoonsik);
		mFriends.add(miRyan);
		mFriends.add(miCon);
		
		mBar.add(mFriends);
		
		setJMenuBar(mBar);
		
		lblMain = new JLabel();
		lblMain.setOpaque(true);
		lblMain.setBackground(Color.WHITE);
		
		pMenu = new JPopupMenu();//팝업창에 Menu와 동일한 방식으로 JMenuItem 만들어 추가
		miChoonsik_p = new JMenuItem("choonsik");
		miChoonsik_p.setActionCommand("choonsik");
		miChoonsik_p.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		//JPopupMenu 단축키 없다
		//단축키 설정을 보여주지만 Menu에 있는 단축키가 작동
		//Menu에는 없는 단축키거나 다르면 단축키가 작동 안하거나 Menu에 있는 다른 기능 동작
		miRyan_p = new JMenuItem("ryan");
		miRyan_p.setActionCommand("ryan");
		miCon_p = new JMenuItem("con");
		miCon_p.setActionCommand("con");
		
		pMenu.add(miChoonsik_p);		
		pMenu.add(miRyan_p);
		pMenu.add(miCon_p);
	}
	private void setDisplay() {
		add(lblMain, BorderLayout.CENTER);
	}
	private void addListeners() {
		ActionListener aListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String cmd = ae.getActionCommand();
				//똑같은일을 하는 버튼이 2개이상일 때 ActionCommand를 정해 놓은것이 좋다.
				//JMenu와 pMenuBar에 동일하게 동작하는 MenuItem의 버튼이 있다
				int idx = CHOONSIK;
				if(cmd.equals("ryan")) {
					idx = RYAN;
				} else if(cmd.equals("con")){
					idx = CON;
				}				
				lblMain.setIcon(icons[idx]);
			}
		};
		miChoonsik.addActionListener(aListener);
		miRyan.addActionListener(aListener);
		miCon.addActionListener(aListener);
		miChoonsik_p.addActionListener(aListener);
		miRyan_p.addActionListener(aListener);
		miCon_p.addActionListener(aListener);
		
		MouseListener mListener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				showPopup(me);
			}
			@Override
			public void mouseReleased(MouseEvent me) {
				showPopup(me);
			}
		};
		
		lblMain.addMouseListener(mListener);
		//클릭한 위치마다 뜨는 팜업창다르다
	}
	//mousePressed와 mouseReleased 동일한 기능 호출하는 메소드로 만듬
	private void showPopup(MouseEvent me) {
		//팝업신호 맞는지 확인
		//파라미터로 들어온 MouseEvent가 오른쪽 버튼 클릭인지
		//운영체제가 정의하고 있는 팝업신호가 Pressed인지 Released인지를 확인하고 걸러준다
		if(me.isPopupTrigger()) {
			//me.getLocationOnSreen();//스크린에서 좌표
			pMenu.show(lblMain, me.getX(), me.getY());
			//pMenu를 어느 compnent에서 팝업창을 보여주는지와 해당 compnent에서 보여준느 위치
			//(마우스 위치에서 보여주고 있다)(컨포넌트 내부 좌표)를 설정해 팝업창으로 보여준다.
		}
	}
	private void showFrame() {
		setTitle("kakao friends");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex3();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMTY2/MDAxNjUzNTc5MTcxOTkz.wFvdCfGY7yK1bgY1viBOMtp4MPZgNwylLiYchUp05PQg.sQ6n2CmuxDN6TrdN60J2RhzwcTQHNn4D0RlI4k70qf8g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMjI2/MDAxNjUzNTc5MDI0MDE5.MpS1xBruCKvDEpOLWH9_wxjefp1m8nZot39YDBdDHFwg.74irGY-uG2F4cNTd7eCBwhB60LfD8ocgThzgcGuBbnwg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
