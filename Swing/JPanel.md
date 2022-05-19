#### JPanel
* Container 한개당 하나의 LayoutManager를 가진다.
* JFrame에 LayoutManager를 가지고 JPanel를 배치해서 JPanel에 다른 LayoutManager만들어 배치
```java
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame2 extends JFrame {
	
	public MyFrame2(){
		//panel의 default layout-manager : FlowLayout
		JPanel pnlLeft = new JPanel();//pnl로 되어있으면 패널이다
		JPanel pnlRight = new JPanel();
		
		for(int i = 0; i<20; i++){
			JButton btn = new JButton(String.valueOf(i));
			pnlLeft.add(btn);
		}
		
		pnlRight.setLayout(new BorderLayout());
		pnlRight.add(new JButton("north"),BorderLayout.NORTH);
		pnlRight.add(new JButton("west"),BorderLayout.WEST);
		pnlRight.add(new JButton("center"),BorderLayout.CENTER);
		pnlRight.add(new JButton("east"),BorderLayout.SOUTH);
		
		setLayout(new GridLayout(1,2));
		add(pnlLeft);
		add(pnlRight);
		
		setTitle("using JPanel");
		setSize(600,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
public class Ex{
	public static void main(String[] args) {
		new MyFrame2();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MTlfNTcg/MDAxNjUyOTU4MzA4NDM2._Tl1DIym8zDliEabqILDOqwQljNF9faUjZ8q3B5VqQIg.TuOffJVVtAAc1BZTC4FmeBNnvzKucO-SUn-QBhQDRCcg.PNG.forget980/image.png?type=w580"></img>
