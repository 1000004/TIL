```java
public class Answer3 extends JFrame implements ActionListener{
	
	private JLabel lblMoney;
	private JTextField tfMoney;
	private JLabel lblRate;
	private JTextField tfRate;
	
	private JButton btnCalc;
	
	private JTextField tfResult;
	
	public Answer3() {
		init();
		setDisplay();	
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblMoney = new JLabel("원금을 입력하시오", JLabel.LEFT);
		lblRate = new JLabel("이자율을 입력하시오", JLabel.LEFT);
		
		tfMoney = new JTextField(5);
		tfRate = new JTextField(5);
		
		btnCalc = new JButton("변환");
		
		tfResult = new JTextField(15);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.WHITE);
		tfResult.setBorder(new LineBorder(Color.GRAY,1));
	}

	private void setDisplay() {
		JPanel pnlLeft = new JPanel(new GridLayout(2, 1));
		JPanel pnlMoneyInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlMoneyInfo.add(lblMoney);
		JPanel pnlRateInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlRateInfo.add(lblRate);
		
		pnlLeft.add(pnlMoneyInfo);
		pnlLeft.add(pnlRateInfo);
		
		
		JPanel pnlRight = new JPanel(new GridLayout(2, 1));
		JPanel pnlMoney = new JPanel();
		pnlMoney.add(tfMoney);
		JPanel pnlRate = new JPanel();
		pnlRate.add(tfRate);
		pnlRight.add(pnlMoney);
		pnlRight.add(pnlRate);
		
		JPanel pnlSouth = new JPanel(new BorderLayout());
		
		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnCalc);
		JPanel pnlResult = new JPanel();
		pnlResult.add(tfResult);
		
		pnlSouth.add(pnlBtn, BorderLayout.NORTH);
		pnlSouth.add(pnlResult, BorderLayout.CENTER);
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		
		pnlMain.add(pnlLeft, BorderLayout.WEST);
		pnlMain.add(pnlRight, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		pnlMain.setBorder(new EmptyBorder(0,20,0,20));
		//Title이 잘리지 않도록 왼오 여백을 늘린다.
		
		add(pnlMain, BorderLayout.CENTER);
	}
	private void addListeners(){
		btnCalc.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		JTextField tf = null;
		// 사용자 입력값 가져오기
		try{
			tf = tfMoney;
			// String -> int
			int money = Integer.parseInt(tfMoney.getText());
			tf = tfRate;
			double rate = Double.parseDouble(tfRate.getText());
			//이자 계산(money * rate)
			double interest = money*rate;
			// double -> String
			String result = String.valueOf(interest);
			tfResult.setText(result);
		}catch(NumberFormatException e){//숫자가 아닌 글자를 입력한 경우
			String msg = "이자를 소수로 입력하세요.";
			if(tf == tfMoney){
				msg = "원금을 정수로 입력하세요.";
			}
			JOptionPane.showMessageDialog(this, msg, "경고", JOptionPane.WARNING_MESSAGE);//부모 요소, message, title, messageType
			//modal을 끄지 않으면 포커스 전의가 안됨
			tf.requestFocus();//포커스가 향한다.
			tf.selectAll();//다 드래그
		}
		// 결과창에 대입
	}
	
	private void showFrame() {
		setTitle("이자 계산기");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Answer3();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTI3/MDAxNjUzNDA2MTI3OTgz.ml4AnWEF_Rk8ho0gmzke8pSB5RgIfpWakq2qJkTbTmQg.HzMDSljpuW0fUpelqMElBMXtkEGVsNSL0X7_rd3aS1wg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
