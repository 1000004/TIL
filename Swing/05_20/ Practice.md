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
