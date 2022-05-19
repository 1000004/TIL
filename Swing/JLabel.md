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
public class Ex {
	public static void main(String[] args) {
		new MyFrame3();
	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfMjY0/MDAxNjUyOTU5ODEzMDgw.aAGG_Tn8u3hIt6b8Kz7hPY8itzlymk_7umOYNsV-c0og.3W5PDD10MwcHbQ-Z_s4hzxzDk9VfSAir-PMPoEUkQAkg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
