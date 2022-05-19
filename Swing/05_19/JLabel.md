 ```java
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;//awt에서 쓰던 layout

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame3 extends JFrame{
	//remae : alt + shift + t -> n
	//메소드 선언한 곳으로 이동 : 메소드포인트 + ctrl->open declaration
	
	//눈에 보이는 수만큼 새로 객체 만들어야 한다
	//색깔객체의 경우 여러번사용 가능 색을 한꺼번에 변경 가능
	private JLabel lbl; 
	private JLabel lblCenterAlign;
	private JLabel lblRightAlign;
	private JLabel lblColor;
	private JLabel lblFont;
	private JLabel lblFont2;
	public MyFrame3(){
		init();
		setDisplay();
		showFrame();
	}
	//private 메소드를 만드는 이유 : 생성자가 길어지는걸 방지하기위해 같은 목적의 일 분할
	//Component 초기화,Component 배치,JFrame 설정로 나눈다.
	//Component 초기화
	private void init(){
		lbl = new JLabel("이거슨 레이블 입니다");
		lblCenterAlign = new JLabel("이거슨 중앙정렬입니다",JLabel.CENTER);//Align 맞추다
		lblRightAlign = new JLabel("이거슨 오른쪽정렬입니다");
		lblRightAlign.setHorizontalAlignment(JLabel.RIGHT);
		lblColor = new JLabel("RED",JLabel.CENTER);
		lblColor.setOpaque(true);//배경을 불투명하게
		Color red = Color.RED;
		//lblColor.setBackground(red);//배경색
		lblColor.setBackground(new Color(0x86E57F));//원하는 색상 십진수 0x를 붙인다
		lblColor.setForeground(Color.WHITE);//문자색
		
		lblFont = new JLabel("Font바꾸기");
		//글꼴,글자크기,스타일 Font 바꾸기
		//physical, logical 글꼴
		//logical font 자바에서 제공 글꼴 영어만 지원 가상머신에서 지원
		//physical font 운영체제에서 제공
		Font font = new Font("궁서", Font.BOLD, 20);//physical font쓰면 로딩이 느려진다
		lblFont.setFont(font);
		
		lblFont2 = new JLabel("hi~TESLA", JLabel.CENTER);
		lblFont2.setFont(new Font(Font.SERIF,Font.BOLD | Font.ITALIC,15));
	}
	//Component 배치
	private void setDisplay(){
		//add(lbl, BorderLayout.NORTH);
		setLayout(new GridLayout(0,1));
		add(lbl);
		add(lblCenterAlign);
		add(lblRightAlign);
		add(lblColor);
		add(lblFont);
		add(lblFont2);
		
	}
	//JFrame 설정
	private void showFrame(){
		setTitle("JLable Ex");
		setSize(400,300);
		setLocation(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Ex1 {
	public static void main(String[] args) {
		new MyFrame3();
	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfMjY0/MDAxNjUyOTU5ODEzMDgw.aAGG_Tn8u3hIt6b8Kz7hPY8itzlymk_7umOYNsV-c0og.3W5PDD10MwcHbQ-Z_s4hzxzDk9VfSAir-PMPoEUkQAkg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

 ```java
 package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame4 extends JFrame{
	private JLabel lblImg1;
	public MyFrame4(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
		//ImageIcon icon = new ImageIcon("choonsik.jpeg");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("choonsik.jpeg");
		Image newImg = img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
		//이미지 변환시 사용하는 알고리즘 종류(Image API 문서에서 확인)를 파라미터로 넣는다
		//SCALE_SMOOTH는 새롭게 생성된 이미지의 품질이 떨어지지 않게한다.
		lblImg1 = new JLabel(new ImageIcon(newImg));
		//lblImg1 = new JLabel(icon);
	}
	private void setDisplay(){
		add(lblImg1, BorderLayout.CENTER);
	}
	private void showFrame(){
		setTitle("Image + JLable");
		//이미지 자체를 수정이 가장 좋다
		//코드로 수정하고자 하면 창의 크기를 정하고 맞추서 배치 or 창에 배치를 다하고 맞춰서 크기 설정
		setSize(300,300);
		//코드로 이미지를 조정하면 손상됨
		//pack(); // 사진에 맞춰 자동 창 크기
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Ex2 {
	public static void main(String[] args) {
		new MyFrame4();
	}

}
 ```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfMjAy/MDAxNjUyOTU5OTk1NjM3.Y-q-bXDIaHhIjU1I2KKZYlhqypP45hRCKGFI_jLYmrkg.SYuuvtPdB2tRS8zQZ_IUnkfV79C_6jpY3XJwiNxC5u8g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
