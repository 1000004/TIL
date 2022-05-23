* TitledBorder의 경우 횡으로 3가지 종으로 6가지로 총 Title의 위치는 18가지다.
```java
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BorderTest extends JFrame {
	private Font font = new Font(Font.DIALOG, Font.BOLD, 25);
	
	public BorderTest(){
		JPanel pnlMain = new JPanel(new GridLayout(0,1,10,10));
		JScrollPane scroll = new JScrollPane(pnlMain);
		//추가되는 양은 많지만 창 크기는 400 300으로 정해져 있기때문에 스크롤 객체를 생성
		Insets insets = new Insets(20,20,20,20);
		pnlMain.setBorder(new EmptyBorder(insets));
		
		AbstractBorder border = new LineBorder(Color.BLACK, 5);//선 색깔, 두께
		pnlMain.add(getLabel("LineBorder", border));//기본적으로 선으로 표시
		
		border = new TitledBorder("this is a title");
		//TitledBorder 기본형 제목을 가질 수 있는 테두리
		//기본적으로 선이 하늘색
		pnlMain.add(getLabel("TitledBorder", border));
		
		LineBorder lBorder = new LineBorder(Color.GRAY, 1);
		border = new TitledBorder(lBorder, "TitledBorder + LineBorder");
		//LineBorder를 파라미터로 가지며 선 지정
		pnlMain.add(getLabel("TitledBorder", border));
		
		TitledBorder tBorder = new TitledBorder("right");
		//타이틀의 횡위치 설정
		tBorder.setTitleJustification(TitledBorder.RIGHT);
		border = tBorder;
		pnlMain.add(getLabel("TitledBorder", border));
		
		tBorder = new TitledBorder("TEXT");
		//타일틀 폰트설정
		tBorder.setTitleFont(
				new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 15)
		);
		tBorder.setTitleColor(Color.RED);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		TitledBorder innerBorder = new TitledBorder(
			new LineBorder(Color.BLUE,1),
			"inner-border"
		);
		//LineBorder를 가지는 TitledBorder 생성
		
		innerBorder.setTitlePosition(TitledBorder.BOTTOM);
		//타이틀의 위치 설정
		//6가지
		
		tBorder = new TitledBorder(
			innerBorder,
			"TOP"
		);
		//TitledBorder를 파라미터로 가지는 TitledBorder
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder = new TitledBorder("CENTER-BOTTOM");
		tBorder.setTitleJustification(TitledBorder.CENTER);
		
		tBorder.setTitlePosition(TitledBorder.BOTTOM);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder = new TitledBorder("ABOVE-BOTTOM");
		tBorder.setTitlePosition(TitledBorder.ABOVE_BOTTOM);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder = new TitledBorder("ABOVE-TOP");
		tBorder.setTitlePosition(TitledBorder.ABOVE_BOTTOM);
		pnlMain.add(getLabel("TitledBorder",tBorder));
		
		tBorder = new TitledBorder("BELOW-TOP");
		tBorder.setTitlePosition(TitledBorder.BELOW_TOP);
		pnlMain.add(getLabel("TitledBorder",tBorder));
		
		tBorder = new TitledBorder("BELOW-BOTTOM");
		tBorder.setTitlePosition(TitledBorder.BELOW_BOTTOM);
		pnlMain.add(getLabel("TitledBorder",tBorder));
		
		border = new EtchedBorder(EtchedBorder.RAISED);//테두리가 입체적으로 튀어나옴
		pnlMain.add(getLabel("TitledBorder-RAISED", border));
		
		border = new EtchedBorder(EtchedBorder.LOWERED);//테두리가 움푹 들어감
		pnlMain.add(getLabel("TitledBorder-LOWERED", border));
		
		border = new BevelBorder(BevelBorder.RAISED);//component가 입체적으로 튀어나옴
		pnlMain.add(getLabel("BevelBorder-RAISED", border));
		
		border = new BevelBorder(BevelBorder.LOWERED);//component가 움푹 들어감
		pnlMain.add(getLabel("BevelBorder-LOWERED", border));
		
		add(scroll, BorderLayout.CENTER);
		
		//세로스크롤바를 가져온다
		JScrollBar bar = scroll.getVerticalScrollBar();
		//스크롤바의 움직이느 단위를 설정한다.
		bar.setUnitIncrement(10);
		
		setTitle("Border Test");
		setSize(400, 300);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private JLabel getLabel(String text, AbstractBorder border){
		JLabel lbl = new JLabel(text);
		lbl.setFont(font);
		lbl.setBorder(border);
		return lbl;
	}
	
	public static void main(String[] args) {
		new BorderTest();

	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjNfMTk3/MDAxNjUzMzE2OTEyNTk0._N1HGg6HLRb6Ck9R_QR-35RXvFz2PAz4aK5_pGT-oRog.ga8mrop11QC8yJtdK0CZSCSX_g_q5PTVyXljwG-COcUg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA1MjNfMTIy/MDAxNjUzMzE1NTU2MTA3.lUfWA9YKWy39UHvmdSJj0sDwALlh-LXI6kPYNRPHqqgg.pSOUxYSepbGs5baghKlZI3rooVTUCWA-0HEkxVJpAxgg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
