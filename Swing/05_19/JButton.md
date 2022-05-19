 ```java
 import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame5 extends JFrame{
	private JLabel lblComplex;
	private JButton btnClick;
	public MyFrame5(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
		lblComplex = new JLabel("알겠습니까?");
		lblComplex.setIcon(new ImageIcon("iu.png"));
		//Location 절대 위치 Position 상대 위치
		lblComplex.setHorizontalTextPosition(JLabel.CENTER);//사진을 기준으로 문자를 수평 중심 
		lblComplex.setVerticalTextPosition(JLabel.TOP);//사진을 기준으로 문자를 수직 위
		btnClick = new JButton(new ImageIcon("click.png"));
		//JButton은 Container를 상속 받으며 button을 만들때 label이 올라간 상태로 만들게 된다.
		btnClick.setText("click");
		btnClick.setHorizontalTextPosition(JLabel.CENTER);
		btnClick.setVerticalTextPosition(JLabel.TOP);
		btnClick.setRolloverIcon(new ImageIcon("over.png"));//Button기능: 커서를 버튼을 올렸을때 이미지 설정
		btnClick.setPressedIcon(new ImageIcon("pressed.png"));//Button기능: 버튼을 눌렸을때 이미지 설정 
	}
	private void setDisplay(){
		add(lblComplex, BorderLayout.CENTER);
		add(btnClick, BorderLayout.SOUTH);
		
	}
	private void showFrame(){
		setTitle("JLabel : text + image");
		pack();
		setLocationRelativeTo(null);//사이즈 정하고 위치
		setVisible(true);
		
	}
}
public class Ex {

	public static void main(String[] args) {
		new MyFrame5();

	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfMTg5/MDAxNjUyOTYwMzY3Mzc0.AF8FnhnGva0UoORzkTZP-Vg0O7yZIs-c9pH0szobqOgg.j6m7V6SDo7yrmnTOGkDp7bd_LzRCVLDLtfTaJQkFxk4g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
