 ```java
package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class Ex1 extends JFrame {
	public Ex1(){
		//CheckBox 여러개 중 여러개 선택
		JCheckBox cb1 = new JCheckBox("first", true);
		//처음에 만들어졌을때 선택된 상태로 만들어짐
		JCheckBox cb2 = new JCheckBox("Second");
		JCheckBox cb3 = new JCheckBox("third");
		
		cb2.setSelected(true);
		//선택된 상태로 만들어짐
		
		if(cb1.isSelected()){//선택된 상태인지 확인
			//JCheckBox를 배열로 만들어 이용시 여러개 선택 상태인지 확인 용이
			System.out.println("selected");
		}
		
		JPanel pnlCheckBox = new JPanel();
		pnlCheckBox.setBackground(Color.RED);
		//페널 색 설정
		//CheckBox의 배경색은 따로 설정해야 한다.
		pnlCheckBox.add(cb1);
		pnlCheckBox.add(cb2);
		pnlCheckBox.add(cb3);
		
		//여러개가 선택되지 않게 만들기 위해 ButtonGroup
		//한번 체크시 해제가 안됨 처음에 하나가 선택사항
		//처음에 하나가 선택사된 상태인 경우 무조건 선택사항들 중 하나를 선택해야 한다.
		JRadioButton rbtn1 = new JRadioButton("first", true);
		JRadioButton rbtn2 = new JRadioButton("Second");
		JRadioButton rbtn3 = new JRadioButton("third");
		
		
		JPanel pnlRbtn = new JPanel();
		pnlRbtn.setBackground(Color.BLUE);
		Insets insets = new Insets(20,15,10,5);
		//위 왼 아래 우 여백을 나타내는 객체
		//가로 세로 나타내는 Dimension
		//x,y 나타내는 Point
		//위치와 가로 세로 나타내는 Rectangle
		pnlRbtn.setBorder(new EmptyBorder(insets));
		//빈공간으로 테두리
		//Panel같이 테두리 없는 component에 사용는 것이 좋다 
		//파라미터 순서 위 왼 아래 오른
		//테두리 있는 객체의 경우 이상하게 적용 된다.
		pnlRbtn.add(rbtn1);
		pnlRbtn.add(rbtn2);
		pnlRbtn.add(rbtn3);
		
		ButtonGroup group = new ButtonGroup();
		//JRadioButton는 여러개중 한개 선택
		//CheckBox와 차이점
		//셋중 하나만 선택 논리 그룹핑
		group.add(rbtn1);
		group.add(rbtn2);
		group.add(rbtn3);
		
		
		JPanel pnlBtn = new JPanel();
		JToggleButton tBtn = new JToggleButton("Toggle");
		//한번눌러지면 계속 눌러진 상태 유지
		//한번 더 누르면 복귀 
		JButton btn = new JButton("버튼 여백 설정");
		pnlBtn.add(tBtn);
		pnlBtn.add(btn);
		
		add(pnlCheckBox, BorderLayout.NORTH);
		add(pnlRbtn, BorderLayout.CENTER);
		add(pnlBtn, BorderLayout.SOUTH);
		
		
		setTitle("Select");
	   	pack();
	   	setLocationRelativeTo(null);
	   	setDefaultCloseOperation(EXIT_ON_CLOSE);
	   	setVisible(true);
	   	
		//System.out.println(lblRate);
		//System.out.println(btnCalc.getMargin()); 버튼 안의 여백 구한기
	   	btn.setMargin(new Insets(1,1,1,1));//버튼 안의 여백 설정
		btn.setPreferredSize(new Dimension(100,20));//선호 사이즈 강제 지정
			   	
	   	
	}
	
	public static void main(String[] args) {
		new Ex1(); 
	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjNfNjIg/MDAxNjUzMzE1MTYzNTUw.zgczE0iNymMrbZnNdF_F72uRm87phNUalteh9WzxPfAg.GmkAfyRNKh0b1JD71E_1dy9xd8kBOFUYu6M4US7hZagg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
