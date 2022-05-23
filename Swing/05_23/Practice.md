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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class PizzaOrder extends JFrame{
	
	private JLabel lbl;
	
	private JCheckBox cbKind1;
	private JCheckBox cbKind2;
	private JCheckBox cbKind3;
	
	private JRadioButton rbtnTopping1;
	private JRadioButton rbtnTopping2;
	private JRadioButton rbtnTopping3;
	private JRadioButton rbtnTopping4;
	
	private JCheckBox cbSize1;
	private JCheckBox cbSize2;
	private JCheckBox cbSsize3;
	
	private JButton btnOrder;
	private JButton btnCancel;
	
	public PizzaOrder(){
		init();
	   	setDisplay();
	   	showFrame();
	}
	
	private void init(){
		lbl = new JLabel("자바피자에 오신것을 환영합니다.",JLabel.CENTER);
		
		cbKind1 = new JCheckBox("콤포");
		cbKind2 = new JCheckBox("포테이토");
		cbKind3 = new JCheckBox("불고기");
		
		rbtnTopping1 = new JRadioButton("피망");
		rbtnTopping2 = new JRadioButton("치즈");
		rbtnTopping3 = new JRadioButton("페페로니");
		rbtnTopping4 = new JRadioButton("베이커");
		
		cbSize1 = new JCheckBox("smal");
		cbSize2 = new JCheckBox("medium");
		cbSsize3 = new JCheckBox("large");
		
		btnOrder = new JButton("주문");
		btnCancel = new JButton("취소");
		
	}
	
	private void setDisplay(){
		
		JPanel pnlCenter = new JPanel(new GridLayout(1,3));
		pnlCenter.setBorder(new EmptyBorder(0,10,8,10));
		
		JPanel pnlKind = new JPanel(new GridLayout(3,0));
		pnlKind.add(cbKind1);
		pnlKind.add(cbKind2);
		pnlKind.add(cbKind3);
		LineBorder lBorder = new LineBorder(Color.GRAY, 1);
		pnlKind.setBorder(new TitledBorder(lBorder, "종류"));
		
		JPanel pnlTopping = new JPanel(new GridLayout(4,0));
		pnlTopping.add(rbtnTopping1);
		pnlTopping.add(rbtnTopping2);
		pnlTopping.add(rbtnTopping3);
		pnlTopping.add(rbtnTopping4);
		pnlTopping.setBorder(new TitledBorder(lBorder, "토핑"));
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnTopping1);
		group.add(rbtnTopping2);
		group.add(rbtnTopping3);
		group.add(rbtnTopping4);
		
		JPanel pnlSize = new JPanel(new GridLayout(3,0));
		pnlSize.add(cbSize1);
		pnlSize.add(cbSize2);
		pnlSize.add(cbSsize3);
		pnlSize.setBorder(new TitledBorder(lBorder, "크기"));
		
		pnlCenter.add(pnlKind);
		pnlCenter.add(pnlTopping);
		pnlCenter.add(pnlSize);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnOrder);
		pnlSouth.add(btnCancel);
		
		add(lbl, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
	}
	
	private void showFrame(){
		setTitle("Counter");
	   	pack();
	   	setLocationRelativeTo(null);
	   	setDefaultCloseOperation(EXIT_ON_CLOSE);
	   	setVisible(true);
	   	System.out.println(cbKind2);
	}
	
	
}

public class test1 {

	public static void main(String[] args) {
		new PizzaOrder();

	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjNfMjE0/MDAxNjUzMzE3Mzk2MDE1.qOvSyotsHUO43Pn8WfyW4izWM1RhlHBReKS63_LeXLcg.6nYFX0zlOz6W0vX_q3a6eFIrKNvt6xnkut5iArMAWskg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
 ```java
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class SignUp extends JFrame{
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblPW;
	private JLabel lblPWRe;
	private JLabel lblGender;
	
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfPW;
	private JTextField tfPWRe;
	
	private JRadioButton rbtnWoman;
	private JRadioButton rbtnMan;
	
	private JButton btnDupCh;
	
	private JLabel lblAboutMe;
	
	private JTextArea taAboutMe;
	
	private JButton btnSignUp;
	private JButton btnCancel;
	
	public SignUp(){
		init();
	   	setDisplay();
	   	showFrame();
	}
	private void init(){
		Dimension sizeOfLabel = new Dimension(125, 18);
		lblID = new JLabel("아이디");
		lblID.setPreferredSize(sizeOfLabel);
		lblName = new JLabel("이름");
		lblName.setPreferredSize(sizeOfLabel);
		lblPW = new JLabel("비밀번호");
		lblPW.setPreferredSize(sizeOfLabel);
		lblPWRe = new JLabel("재입력");
		lblPWRe.setPreferredSize(sizeOfLabel);
		lblGender = new JLabel("성별");
		lblGender.setPreferredSize(sizeOfLabel);
		
		tfID = new JTextField(10);
		tfName = new JTextField(10);
		tfPW = new JTextField(10);
		tfPWRe = new JTextField(10);
		
		rbtnWoman = new JRadioButton("여자",true);
		rbtnMan = new JRadioButton("남자");
		
		btnDupCh = new JButton("중복검사");
		
		lblAboutMe = new JLabel("자기소개",JLabel.LEFT);
		
		taAboutMe = new JTextArea(4,34);
		
		btnSignUp = new JButton("가입");
		btnCancel = new JButton("취소");
	}
	private void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(5,1));
		//pnlCenter.setBackground(Color.BLACK);
		pnlCenter.setBorder(new EmptyBorder(10,5,5,0));
		JPanel pnlID = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlID.add(lblID);
		pnlID.add(tfID);
		JPanel pnlName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlName.add(lblName);
		pnlName.add(tfName);
		JPanel pnlPW = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlPW.add(lblPW);
		pnlPW.add(tfPW);
		JPanel pnlPWRe = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlPWRe.add(lblPWRe);
		pnlPWRe.add(tfPWRe);
		JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlGender.add(lblGender);
		pnlGender.add(rbtnMan);
		pnlGender.add(rbtnWoman);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMan);
		group.add(rbtnWoman);
		
		pnlCenter.add(pnlID);
		pnlCenter.add(pnlName);
		pnlCenter.add(pnlPW);
		pnlCenter.add(pnlPWRe);
		pnlCenter.add(pnlGender);
		
		JPanel pnlEast = new JPanel();
		pnlEast.setBorder(new EmptyBorder(5,0,0,55));
		//pnlEast.setBackground(Color.BLUE);
		pnlEast.add(btnDupCh);
		
		JPanel pnlSouth = new JPanel(new BorderLayout());
		pnlSouth.setBorder(new EmptyBorder(0,5,10,10));
		JPanel pnlLblAboutMe = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlLblAboutMe.add(lblAboutMe);
		pnlSouth.add(pnlLblAboutMe,BorderLayout.NORTH);
		JScrollPane scroll = new JScrollPane(taAboutMe);
		JPanel pnlTaAboutMe = new JPanel();
		pnlTaAboutMe.setBorder(new EmptyBorder(5,0,5,0));
		pnlTaAboutMe.add(scroll);
		pnlSouth.add(pnlTaAboutMe,BorderLayout.CENTER);
		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnSignUp);
		pnlBtn.add(btnCancel);
		pnlSouth.add(pnlBtn,BorderLayout.SOUTH);
		
		
		
		add(pnlEast, BorderLayout.EAST);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void showFrame(){
		setTitle("회원가입");
	   	pack();
	   	setLocationRelativeTo(null);
	   	setDefaultCloseOperation(EXIT_ON_CLOSE);
	   	setVisible(true);
	}
}

public class Test2 {

	public static void main(String[] args) {
		new SignUp();

	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjNfNCAg/MDAxNjUzMzE3NjAxNjgw.aUuBRX04jNI-Z96MOdsU-Wx38-oVSBZev1ZJ1mDyqXQg.br9OlA3EbC0SdAYE7ZacsRa9uXjpjDfFTnGbkWZKQz0g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
 ```java
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class InformationForm extends JFrame{
	private JLabel lblID;
	private JLabel lblPW;
	private JLabel lblPWRe;
	
	private JTextField tfID;
	private JTextField tfPW;
	private JTextField tfPWRe;
	
	private JButton btnDupCh;
	
	private JLabel lblGender;
	private JRadioButton rbtnWoman;
	private JRadioButton rbtnMan;
	
	private JLabel lblHobby;
	private JCheckBox cbHobby1;
	private JCheckBox cbHobby2;
	private JCheckBox cbHobby3;
	private JCheckBox cbHobby4;
	private JCheckBox cbHobby5;
	private JCheckBox cbHobby6;
	
	private JLabel lblAboutMe;
	private JTextArea taAboutMe;
	
	private JButton btnOk;
	private JButton btnCancel;
	
	JPanel pnlTa;
	
	public InformationForm(){
		init();
	   	setDisplay();
	   	showFrame();
	}
	private void init(){
		Dimension sizeOfLabel = new Dimension(30, 30);
		lblID = new JLabel("ID");
		lblID.setPreferredSize(sizeOfLabel);
		lblPW = new JLabel("PW");
		lblPW.setPreferredSize(sizeOfLabel);
		lblPWRe = new JLabel("Re");
		lblPWRe.setPreferredSize(sizeOfLabel);
		lblGender = new JLabel("성별");
		
		btnDupCh = new JButton("중복체크");
		
		tfID = new JTextField(9);
		tfPW = new JTextField(15);
		tfPWRe = new JTextField(15);
		
		rbtnWoman = new JRadioButton("여자");
		rbtnMan = new JRadioButton("남자",true);
		
		lblHobby = new JLabel("취미");
		
		cbHobby1 = new JCheckBox("독서");
		cbHobby2 = new JCheckBox("낮잠");
		cbHobby3 = new JCheckBox("여행");
		cbHobby4 = new JCheckBox("서핑");
		cbHobby5 = new JCheckBox("게임");
		cbHobby6 = new JCheckBox("지각");
		
		lblAboutMe = new JLabel("자기소개",JLabel.LEFT);
		
		taAboutMe = new JTextArea(10,23);
		
		btnOk = new JButton("확인");
		btnCancel = new JButton("취소");
	}
	private void setDisplay(){
		//south
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBorder(new EmptyBorder(10,5,0,0));
		pnlSouth.add(btnOk);
		pnlSouth.add(btnCancel);
		
		//center
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(10,8,0,0));
		JPanel pnlInputTf = new JPanel(new BorderLayout());
		JPanel pnlLbl = new JPanel(new GridLayout(3,1));
		pnlLbl.add(lblID);
		pnlLbl.add(lblPW);
		pnlLbl.add(lblPWRe);
		pnlInputTf.add(pnlLbl,BorderLayout.WEST);
		
		JPanel pnlTf = new JPanel(new GridLayout(3,1));
		JPanel pnlID = new JPanel();
		pnlID.add(tfID);
		btnDupCh.setPreferredSize(new Dimension(60,22));
		btnDupCh.setMargin(new Insets(0,0,0,0));
		pnlID.add(btnDupCh);
		JPanel pnlPW = new JPanel();
		pnlPW.add(tfPW);
		JPanel pnlPWRe = new JPanel();
		pnlPWRe.add(tfPWRe);
		pnlTf.add(pnlID);
		pnlTf.add(pnlPW);
		pnlTf.add(pnlPWRe);
		pnlInputTf.add(pnlTf,BorderLayout.CENTER);
		pnlCenter.add(pnlInputTf,BorderLayout.NORTH);
		
		JPanel pnlGender = new JPanel(new BorderLayout());
		pnlGender.add(lblGender, BorderLayout.NORTH);
		JPanel pnlCbGender = new JPanel(new GridLayout(1,2));
		JPanel pnlLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlRight = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlLeft.add(rbtnWoman);
		pnlRight.add(rbtnMan);
		pnlCbGender.add(pnlLeft);
		pnlCbGender.add(pnlRight);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnWoman);
		group.add(rbtnMan);
		
		pnlGender.add(pnlCbGender, BorderLayout.CENTER);
		pnlCenter.add(pnlGender, BorderLayout.CENTER);
		
		JPanel pnlHobby = new JPanel(new BorderLayout());
		pnlHobby.add(lblHobby, BorderLayout.NORTH);
		JPanel pnlCbHobby = new JPanel(new GridLayout(2,3));
		pnlCbHobby.add(cbHobby1);
		pnlCbHobby.add(cbHobby2);
		pnlCbHobby.add(cbHobby3);
		pnlCbHobby.add(cbHobby4);
		pnlCbHobby.add(cbHobby5);
		pnlCbHobby.add(cbHobby6);
		pnlHobby.add(pnlCbHobby, BorderLayout.CENTER);
		pnlCenter.add(pnlHobby, BorderLayout.SOUTH);
		
		//east
		JPanel pnlEast = new JPanel(new BorderLayout());
		pnlEast.setBorder(new EmptyBorder(10,0,0,10));
		pnlEast.add(lblAboutMe, BorderLayout.NORTH);
		JScrollPane scroll = new JScrollPane(taAboutMe);
		pnlEast.add(scroll, BorderLayout.CENTER);
		
		add(pnlEast, BorderLayout.EAST);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void showFrame(){
		setTitle("InformationForm");
	   	pack();
	   	setLocationRelativeTo(null);
	   	setDefaultCloseOperation(EXIT_ON_CLOSE);
	   	setVisible(true);
	   	System.out.println(pnlTa);
	}
}

public class test3 {

	public static void main(String[] args) {
		new InformationForm();

	}

}
 ```
 <img src="https://postfiles.pstatic.net/MjAyMjA1MjNfMjY4/MDAxNjUzMzE3NzM3NzAy.jlLswsjITmqnN6cKNyKxGJ4lrweTsiiMbSmOrFtWLQMg.szdRw55--yxFY_pyjFeEIp4CZMFxWy4F0mHjFaa6qdQg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
