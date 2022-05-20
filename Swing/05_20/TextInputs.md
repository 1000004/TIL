 ```java
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TextInputs extends JFrame{
	private JTextField tfInput1;
	private JTextField tfInput2;
	private JTextField tfInput3;
	private JPasswordField pfInput;
	
	private JTextArea taInputs;
	
	public TextInputs(){
		init();
		setDisplay();
		showFrame();
	}
	
	private void init(){
		tfInput1 = new JTextField(20);
		//단문을 입력 받을 수 있다.
		// 파라미터 : column 수 (글자 수는 아니다)
		tfInput1.setText("default");
		tfInput1.setToolTipText("이거슨 무엇일까?");//Enabled과 마찬가지고 다 지원함
		tfInput2 = new JTextField(20);
		tfInput2.setText("can't edit");
		tfInput2.setEditable(false);//편집 불가 드래그 가능
		
		tfInput3 = new JTextField(20);
		tfInput3.setText("enabled(false)");
		tfInput3.setEnabled(false);//비활성화 반응또는 상호작용하고 기능적인 component에 거의 적용가능 ex) 버튼
	
		pfInput = new JPasswordField(20);
		//JTextField과 유사하지만 입력시 특정 한 문자로 바꾸어 보여준다.
		//기본 '*'
		pfInput.setEchoChar('ㄱ');//문자지정
		
		taInputs = new JTextArea(6,20);
		taInputs.setLineWrap(true);//자동 줄바꿈
		taInputs.setWrapStyleWord(true);//단어가 끊기지 않게 줄바꿈
	}
	private void setDisplay(){
		//border Layout으로 tfInput을 넣으면 JTextField의 파라미터와 무관하게
		//공간 하나를 체워 보여준다.
		JPanel pnlNorth = new JPanel(new GridLayout(0,1));
		
		JPanel pnlTf1 = new JPanel();
		pnlTf1.add(new JLabel("default: "));
		pnlTf1.add(tfInput1);
		
		JPanel pnlTf2 = new JPanel();
		pnlTf2.add(new JLabel("can't edit: "));
		pnlTf2.add(tfInput2);
		
		JPanel pnlTf3 = new JPanel();
		pnlTf3.add(new JLabel("not enabled"));
		pnlTf3.add(tfInput3);
		
		JPanel pnlTf4 = new JPanel();
		pnlTf4.add(new JLabel("password : "));
		pnlTf4.add(pfInput);
		
		pnlNorth.add(pnlTf1);
		pnlNorth.add(pnlTf2);
		pnlNorth.add(pnlTf3);
		pnlNorth.add(pnlTf4);
		/*
		 * HORIZONTAL_SCROLLBAR_ALWAYS : 행 스크롤을 항상 보인다
		 * HORIZONTAL_SCROLLBAR_AS_NEED(default) : 행 스크롤 필요할때 보인다
		 * HORIZONTAL_SCROLLBAR_NEVER : 행 스크롤 안쓴다
		 * 
		 * VERTICAL_SCROLLBAR_ALWAYS
		 * VERTICAL_SCROLLBAR_AS_NEED(default)
		 * VERTICAL_SCROLLBAR_NEVER
		 */
		JPanel pnlCenter = new JPanel();
		JScrollPane scroll = new JScrollPane(taInputs);//한정된 공간에서 작업
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		pnlCenter.add(scroll);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
	}
	private void showFrame(){
		setTitle("TextComponent Ex");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Ex1 {

	public static void main(String[] args) {
		new TextInputs();

	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjBfNDAg/MDAxNjUzMDMxODI5MzI1.kJCw6dZL4bDjiPKYzK5VwLdFcof-7CwAuD4_jgl9xhIg.cbuoIaQJSF9O3syxd3X5N_3ylthyT9ZExPFaFthF7JAg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
 ```java
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MileToKilo extends JFrame{
	private JLabel lblInput;
	private JTextField tfInput;
	private JButton btnCalc;
	private JTextField tfResult;
	
	public MileToKilo(){
		init();
		setDisplay();
		showFrame();
	}
	private void init(){
		lblInput = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(5);
		btnCalc = new JButton("변환");
		tfResult = new JTextField(18);
	}
	private void setDisplay(){
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfResult);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void showFrame(){
		setTitle("마일을 킬로미터로 변환");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Ex2 {

	public static void main(String[] args) {
		new MileToKilo();

	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjBfMjA1/MDAxNjUzMDMyNDYxMjcz.J5mIFz_5QtLsCf039KotmMU1m32c7ws5BCDnX2_btwog.O-VCGufVLboomRuUEA4vYSrXR8ohIVDYfGnk2axIfUEg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
