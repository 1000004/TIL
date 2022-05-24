```java
public class Answer2 extends JFrame implements ActionListener{

	private JLabel lblInput;
	private JTextField tfInput;
	
	private JButton btnCalc;
	
	private JTextField tfResult;
	
	public Answer2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblInput = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(5);
		btnCalc = new JButton("변환");
		// btnCalc.setEnabled(false);
		tfResult = new JTextField(15);
		// tfResult.setText("1마일은 1.6킬로미터입니다.");
		// JTextComponent
		// 편집 불가능
		tfResult.setEditable(false);
		// 비활성화
		// tfResult.setEnabled(false);
		tfResult.setBackground(Color.WHITE);
		tfResult.setBorder(new LineBorder(Color.GRAY, 1));
	}

	private void setDisplay() {
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
	
	private void addListeners(){
		btnCalc.addActionListener(this);
	}

	private void showFrame() {
		setTitle("마일을 킬로미터로 변환");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 창크기 고정
		//setResizable(false);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae){
		// 사용자 입력값 가져오기
		String input = tfInput.getText();
		String result;
		try{
			// String -> int
			int mile = Integer.parseInt(input);
			//km로 계산(1.6)
			double km = mile*1.6;
			// double -> String
			result = String.valueOf(km) + "km";
		}catch(NumberFormatException e){//숫자가 아닌 글자를 입력한 경우
			result = " 숫자만 입력가능합니다.";
			/*
			 * modal 형태로 창이 생기고 버튼을 누르면 창이 사라진다.
			 * 
			 * messageType에 따라 마크가 달라진다
			 * WARNING_MESSAGE !
			 * ERROR_MESSAGE x
			 * QUESTION_MESSAGE ?
			 * INFORMATION_MESSAGE i
			 * PLAIN_MESSAGE (마크가 없다)
			 */
			JOptionPane.showMessageDialog(this, result, "알림", JOptionPane.PLAIN_MESSAGE);//부모 요소, message, title, messageType
			//modal을 끄지 않으면 포커스 전의가 안됨
		}
		// 결과창에 대입
		tfResult.setText(result);
	}

	public static void main(String[] args) {
		new Answer2();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTA5/MDAxNjUzNDA1NzAxNzgy.pbFqrDiL9MZIu8CJm-z88ZSkoWKz9qY5Y6JfCak85eog.3CMXdECLZ6aNE_dj8ApjgNB1yo_agY9HoLrxbX_wndEg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTA5/MDAxNjUzNDA1NzAxNzgy.pbFqrDiL9MZIu8CJm-z88ZSkoWKz9qY5Y6JfCak85eog.3CMXdECLZ6aNE_dj8ApjgNB1yo_agY9HoLrxbX_wndEg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
