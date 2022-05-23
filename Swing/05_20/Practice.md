 ```java
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ex3 extends JFrame{
	private JLabel lblMoney;
	private JLabel lblRate;
	private JTextField tfMoney;
	private JTextField tfRate;
	private JButton btnCalc;
	private JTextField tfResult;
	
	public Ex3(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
		Dimension sizeOfLabel = new Dimension(120, 18);//재활용 불가
		lblMoney = new JLabel("원금을 입력하시오", JLabel.LEFT);
		lblMoney.setPreferredSize(sizeOfLabel);
		lblRate = new JLabel("이자율을 입력하시오", JLabel.LEFT);
		
		tfMoney = new JTextField(5);
		tfRate = new JTextField(5);
		
		btnCalc = new JButton("변환");
		
		tfResult = new JTextField(15);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.WHITE);
		
	}
	private void setDisplay(){
		JPanel pnlNorth = new JPanel(new GridLayout(2,1));
		pnlNorth.setBorder(new EmptyBorder(0,10,0,10));
		JPanel pnlMoney = new JPanel();
		pnlMoney.add(lblMoney);
		pnlMoney.add(tfMoney);
		pnlNorth.add(pnlMoney);
		
		JPanel pnlRate = new JPanel();
		pnlRate.add(lblRate);
		pnlRate.add(tfRate);
		pnlNorth.add(pnlRate);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);
		
		JPanel pnlSouth = new JPanel();
		Insets insets = new Insets(10,0,0,0);//위 왼 아래 우 여백을 나타내는 객체
		pnlSouth.setBorder(new EmptyBorder(insets));
		pnlSouth.add(tfResult);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void showFrame(){
		setTitle("이자 계산기");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//System.out.println(lblRate);
		//System.out.println(btnCalc.getMargin()); 버튼 안의 여백 구한기
		btnCalc.setMargin(new Insets(1,1,1,1));//버튼 안의 여백 설정
	}
	
	public static void main(String[] args) {
		new Ex3();

	}

}

```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjNfOCAg/MDAxNjUzMzE0ODcwODE4.aTm8cD2KzqQh02LIQbNV0hZt55BzjvnyMxJJt0EDs34g.B_fvn-uySbYi9zG-mYrVrIGn4aYBAuZXhtXUadp1yS8g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Counter extends JFrame{
	private JLabel lblWebtoon;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnList;
	
	public Counter(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
			lblWebtoon = new JLabel("Web toon",JLabel.CENTER);
			btnPrevious = new JButton("previous episode");
			btnNext = new JButton("next episode");
			btnList = new JButton("list");
			lblWebtoon.setFont(new Font(Font.DIALOG,Font.BOLD,30));
	}
	private void setDisplay(){
		JPanel pnlSouth = new JPanel(new GridLayout(1,2));
		pnlSouth.add(btnPrevious);
		pnlSouth.add(btnNext);
		add(lblWebtoon, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		add(btnList, BorderLayout.NORTH);
		
	}
	private void showFrame(){
		setTitle("Counter");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
public class Ex1 {
	public static void main(String[] args) {
		new Counter();
		
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjBfMjIw/MDAxNjUzMDIzNzgxMDQz.WvYM9yzRRxH_yPhYBQJSOALDqGXMdyQg-HW7mqvJhWog.3f6QCbSol8GsHRpXS8ajyE6msLbcP0AWcbBVoxFdVWQg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
 ```java
 import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Pizza extends JFrame{
	private JLabel lblNum;
	private JButton btnCombo;
	private JButton btnPotato;
	private JButton btnBulgogi;
	
	public Pizza(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
		lblNum = new JLabel("자바피자에 오신것을 환영합니다.피자를 고르세요.",JLabel.CENTER);
		btnCombo = new JButton("콤보피자");
		btnPotato = new JButton("포테이토피자");
		btnBulgogi = new JButton("불고기피자");
	}
	private void setDisplay(){
		JPanel pnl = new JPanel();
		pnl.add(btnCombo);
		pnl.add(btnPotato);
		pnl.add(btnBulgogi);
		add(lblNum, BorderLayout.NORTH);
		add(pnl, BorderLayout.CENTER);
		
	}
	private void showFrame(){
		setTitle("MyFrame");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}

public class EX2 {

	public static void main(String[] args) {
		new Pizza();

	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjBfMyAg/MDAxNjUzMDMyMjY4OTMw.FVikoMSAA3DrvdrJ3N6xj-xu2GBtc47kuwAUrdGDyjkg.EkNncSiiDLHCY3l0G3T-E5t6fMT5K6Bi42vY5MUxKvEg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
