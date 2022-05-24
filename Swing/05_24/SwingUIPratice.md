<img src="https://postfiles.pstatic.net/MjAyMjA1MjRfMTQ1/MDAxNjUzMzkyMTExNzEw.7rjotesdl5Sr1MMAJ5mlzodHWrHlvrayXq7eVKPfGtwg.0hIZbTjM8GOkDvoDaFhyFzYTiPSzM1p2U_urbEm6v6wg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Menu extends JFrame {

	private String[] arrKinds = {"콤보", "포테이토", "불고기"};
	private String[] arrToppings = {"피망", "치즈", "페페로니","베이컨"};
	private String[] arrSizes = {"smll", "medium", " large"};
	
	private JCheckBox[] kinds;
	private JRadioButton[] toppings;
	private JCheckBox[] sizes;
	
	private JButton btnOrder;
	private JButton btnCancel;
	
	private JLabel lblInfo;
	
	public Menu(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
		kinds = new JCheckBox[arrKinds.length];
		for(int idx=0; idx<kinds.length; idx++){
			kinds[idx] = new JCheckBox(arrKinds[idx]);
		}
		toppings = new JRadioButton[arrToppings.length];
		ButtonGroup group = new ButtonGroup();
		for(int idx=0; idx<toppings.length; idx++){
			toppings[idx] = new JRadioButton(arrToppings[idx]);
			group.add(toppings[idx]);
		}
		
		sizes = new JCheckBox[arrSizes.length];
		for(int idx=0; idx<sizes.length;idx++){
			sizes[idx] = new JCheckBox(arrSizes[idx]);
		}
		
		btnOrder = new JButton("주문");
		btnCancel = new JButton("취소");
		
		lblInfo = new JLabel("자바피자에 오신것을 환영합니다.",JLabel.CENTER);
	}
	
	private void setDisplay(){
		JPanel pnlKinds = getPanel("종류", kinds);
		JPanel pnlToppings = getPanel("토핑", toppings);
		JPanel pnlSizes = getPanel("크기", sizes);
		
		JPanel pnlCenter = new JPanel(new GridLayout(1,0));
		pnlCenter.add(pnlKinds);
		pnlCenter.add(pnlToppings);
		pnlCenter.add(pnlSizes);
		pnlCenter.setBorder(new EmptyBorder(0,10,0,10));
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnOrder);
		pnlSouth.add(btnCancel);
		
		add(lblInfo, BorderLayout.NORTH);
		add(pnlCenter,BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private JPanel getPanel(String title, JToggleButton...btns){
		JPanel pnl = new JPanel(new GridLayout(0,1));
		for(JToggleButton btn : btns){
			pnl.add(btn);
		}
		pnl.setBorder(new TitledBorder(
				new LineBorder(Color.GRAY,1),
				title
			)
		);
		return pnl;
	}
	
	private void showFrame(){
		setTitle("피자주문");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Menu();

	}

}

```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjRfNDEg/MDAxNjUzMzk0MzA3ODc4.TvJwfJybkstunYCgrRm11qhe0PqBraPvVsi-qOVBt4cg.DUkkJfNn5BnyCDyyD-J43muqNayaH1pPs0Xe_1miSLsg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class JoinForm extends JFrame {
	public static final int INPUT_SIZE = 10;
	public static final int LABEL_WIDTH = 50;
	
	private JButton btnCheck;
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	private JTextArea taIntoduce;
	private JButton btnJoin;
	private JButton btnCancel;
	
	private Dimension sizeOfLabel = new Dimension(100,15);
	
	public JoinForm(){
		init();
		setDisplay();
		showFrame();
	}
	
	private void init(){
		btnCheck = new JButton("중복검사");
		rbtnMale = new JRadioButton("남자");
		rbtnFemale = new JRadioButton("여자", true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMale);
		group.add(rbtnFemale);
		
		taIntoduce = new JTextArea(4,30);
		btnJoin = new JButton("가입");
		btnCancel = new JButton("최소");
	}
	
	private void setDisplay(){
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		
		JPanel pnlNorth = new JPanel(new GridLayout(0,1));
		JPanel pnlId = getPanel("아이디");
		pnlId.add(btnCheck);
		JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGender = new JLabel("성별", JLabel.LEFT);
		lblGender.setPreferredSize(sizeOfLabel);
		pnlGender.add(lblGender);
		pnlGender.add(rbtnMale);
		pnlGender.add(rbtnFemale);
		
		JPanel pnlIntroduce = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIntroduce = new JLabel("자기소개",JLabel.LEFT);
		
		lblIntroduce.setPreferredSize(sizeOfLabel);
		pnlIntroduce.add(lblIntroduce);
		
		pnlNorth.add(pnlId);
		pnlNorth.add(getPanel("이름"));
		pnlNorth.add(getPanel("비밀번호",true));
		pnlNorth.add(getPanel("재입력",true));
		pnlNorth.add(pnlGender);
		pnlNorth.add(lblGender);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(new JScrollPane(taIntoduce));
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnJoin);
		pnlSouth.add(btnCancel);
		
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		
		pnlMain.setBorder(new EmptyBorder(10,10,10,10));
		add(pnlMain, BorderLayout.CENTER);
		
	}
	
	private void showFrame(){
		setTitle("회원가입");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private JPanel getPanel(String text){
		return getPanel(text, false);
	}
	private JPanel getPanel(String text, boolean isPassword){
		JPanel pnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lbl = new JLabel(text, JLabel.LEFT);
		JTextComponent input;
		if(isPassword){
			input = new JPasswordField(INPUT_SIZE);
		}else{
			input = new JTextField(INPUT_SIZE);
		}
		lbl.setPreferredSize(sizeOfLabel);
		pnl.add(lbl);
		pnl.add(input);
		return pnl;
	}
	public static void main(String[] args) {
		new JoinForm();

	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjRfMjQ2/MDAxNjUzMzk3NzIxMjU5.5QeDPfALfnSDXvXHQko5crz9e8sxY1pxcti_ZydTLf4g.3CbLGiQXbMEw-0zelz3l5IU7gr4kkTUIMToYI_cLOhwg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class InformationForm extends JFrame{
	
	private JLabel lblId;
	private JLabel lblPw;
	private JLabel lblRe;
	private JLabel lblGender;
	private JLabel lblHobby;
	private JLabel lblInfo;
	
	private JTextField tfId;
	private JButton btnChkId;
	private JPasswordField pf;
	private JPasswordField re;
	
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	
	private JCheckBox chRead;
	private JCheckBox chTravel;
	private JCheckBox chNap;
	private JCheckBox chGame;
	private JCheckBox chSurf;
	private JCheckBox chLate;
	
	private JTextArea taInfo;
	
	private JButton btnOk;
	private JButton btnCancel;
	
	public InformationForm(){
		init();
		setDisplay();
		showFrame();
	}
	
	private void init(){
		lblId = new JLabel("ID");
		lblPw = new JLabel("PW");
		lblRe = new JLabel("Re");
		lblGender = new JLabel("성별");
		lblHobby = new JLabel("취미");
		lblInfo = new JLabel("자기소개");
		
		tfId = new JTextField(8);
		btnChkId = new JButton("중복체크");
		
		btnChkId.setPreferredSize(new Dimension(60,20));
		Insets insets = btnChkId.getMargin();
		insets.left = 1;
		insets.right = 1;
		btnChkId.setMargin(insets);
		
		pf = new JPasswordField(14);
		re = new JPasswordField(14);
		
		rbtnMale = new JRadioButton("남자",true);
		rbtnFemale = new JRadioButton("여자");
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMale);
		group.add(rbtnFemale);
		
		chRead = new JCheckBox("독서");
		chTravel = new JCheckBox("여행");
		chNap = new JCheckBox("낮잠");
		chGame = new JCheckBox("게임");
		chSurf = new JCheckBox("서핑");
		chLate = new JCheckBox("지각");
		
		taInfo = new JTextArea(8, 20);
		
		btnOk = new JButton("확인");
		btnCancel = new JButton("취소");
		
	}
	private void setDisplay(){
		JPanel pnlTop = new JPanel(new BorderLayout());
		JPanel pnlBottom = new JPanel();
		
		JPanel pnlTWest = new JPanel(new BorderLayout());
		JPanel pnlTCenter = new JPanel(new BorderLayout());
		
		JPanel pnlTWNorth = new JPanel(new BorderLayout());
		JPanel pnlTWSouth = new JPanel(new GridLayout(0,1));
		
		JPanel pnlTWNWest = new JPanel(new GridLayout(0,1));
		JPanel pnlTWNEast = new JPanel(new GridLayout(0,1));
		
		pnlTWNWest.add(lblId);
		pnlTWNWest.add(lblPw);
		pnlTWNWest.add(lblRe);
		
		JPanel pnlId = new JPanel();
		pnlId.add(tfId);
		pnlId.add(btnChkId);
		
		pnlTWNEast.add(pnlId);
		JPanel pnlPw = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlPw.add(pf);
		pnlTWNEast.add(pnlPw);
		JPanel pnlRe = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlRe.add(re);
		pnlTWNEast.add(pnlRe);
		pnlTWNorth.add(pnlTWNWest, BorderLayout.WEST);
		pnlTWNorth.add(pnlTWNEast, BorderLayout.EAST);
		
		JPanel pnlGender = new JPanel(new GridLayout(1,0));
		pnlGender.add(rbtnMale);
		pnlGender.add(rbtnFemale);
		JPanel pnlHobby1 = new JPanel(new GridLayout(1,0));
		pnlHobby1.add(chRead);
		pnlHobby1.add(chNap);
		pnlHobby1.add(chTravel);
		JPanel pnlHobby2 = new JPanel(new GridLayout(1,0));
		pnlHobby2.add(chSurf);
		pnlHobby2.add(chGame);
		pnlHobby2.add(chLate);
		
		pnlTWSouth.add(lblGender);
		pnlTWSouth.add(pnlGender);
		pnlTWSouth.add(lblHobby);
		pnlTWSouth.add(pnlHobby1);
		pnlTWSouth.add(pnlHobby2);
		
		pnlTWest.add(pnlTWNorth, BorderLayout.NORTH);
		pnlTWest.add(pnlTWSouth, BorderLayout.SOUTH);
		
		pnlTCenter.add(lblInfo, BorderLayout.NORTH);
		pnlTCenter.add(new JScrollPane(taInfo), BorderLayout.CENTER);
		
		pnlTop.add(pnlTWest, BorderLayout.WEST);
		pnlTop.add(pnlTCenter, BorderLayout.CENTER);
		pnlTop.setBorder(new EmptyBorder(10,10,0,10));
		
		pnlBottom.add(btnOk);
		pnlBottom.add(btnCancel);
		
		add(pnlTop, BorderLayout.CENTER);
		add(pnlBottom, BorderLayout.SOUTH);
		
		
	}
	private void showFrame(){
		setTitle("InformationForm");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new InformationForm();

	}

}
```
