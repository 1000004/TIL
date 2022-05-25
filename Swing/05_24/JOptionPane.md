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
			JOptionPane.showMessageDialog(this, result, "알림", JOptionPane.PLAIN_MESSAGE);
			//부모 요소, message, title, messageType
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
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfOTUg/MDAxNjUzNDA2NjU0ODA5.W55LbJrs8it6qTVwYFeQI5o3u0D9GidYhqX99M4NN5og.EAVerSN3o4S7ZQJVGP7UFA0NmB5Q_zoFLFhFMIxvCn0g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class Ex extends JFrame implements ActionListener{
	private JButton btnMessage;
	private JButton btnConfirm;
	private JButton btnInput;
	private JLabel lblResult;
	
	public Ex(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init(){
		btnMessage = new JButton("MessageDialog");
		btnConfirm = new JButton("ConfirmDialog");
		btnInput = new JButton("InputDialog");
		lblResult = new JLabel();
	}
	private void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		pnlCenter.add(btnMessage);
		pnlCenter.add(btnConfirm);
		pnlCenter.add(btnInput);
		
		add(pnlCenter,BorderLayout.CENTER);
		add(lblResult, BorderLayout.SOUTH);
	}
	private void addListeners(){
		btnMessage.addActionListener(this);
		btnConfirm.addActionListener(this);
		btnInput.addActionListener(this);
	}
	private void showFrame(){
		setTitle("simple dialogs");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae){
		Object src = ae.getSource(); //event가 발생하는 버튼을 객체로 가져온다
		/*
		 * YES_NO_OPTION
		 * OK_CANCEL_OPTION
		 * YES_NO_CANCEL_OPTION
		 * 
		 * =>YES_OPTION, NO_OPTION, OK_OPTION, CANCEL_OPTION
		 */
		if(src == btnConfirm){
			//무엇을 선택했는지 int choice에 담음 =>YES_OPTION, NO_OPTION, OK_OPTION, CANCEL_OPTION
			//showConfirmDialog 간단하게 사용자의 수락을 받는 용도
			int choice = JOptionPane.showConfirmDialog( 
				this,"예매하시겠습니까?","cofirm", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
			);
			String result = "결제 중";
			if(choice == JOptionPane.NO_OPTION){
				result = "취소";
			}
			lblResult.setText(result);
		}else if(src == btnMessage){
			//showMessageDialog 메시지만 확인
			JOptionPane.showMessageDialog(
				this, "본 공연은 코로나로 인해 지연될 수 있습니다","주위",JOptionPane.WARNING_MESSAGE
			);
		}else{
			//showInputDialog 단문으로 입력
			String input = JOptionPane.showInputDialog(
					this, "공연 정보", "검색", JOptionPane.QUESTION_MESSAGE
			);
			lblResult.setText(input + " 검색 중");
		}
	}
	public static void main(String[] args) {
		new Ex();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTkg/MDAxNjUzNDA2ODE2OTY4.hq5Fo6RqV2JI764x2JoCw1dxxwNCJIVM4VoWUj_hUa4g.m5ugOsY2OhH-w88eKbU7WW1_WyWcz5I6X1iDyVhQMlEg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
> MessageDialog Button 클릭시

<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMzAg/MDAxNjUzNDA2ODM1MDA1.NndCLvurnMbI272hEDteH2uKNxfu1JHdOg6YhfXxS8gg.kT7Pbsf9HaztQz_0oVFyAFl3COE8FTfbZCPAaBj3pywg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
> ConfirmDialog Button 클릭시

<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTAy/MDAxNjUzNDA2ODU2MzIz.F23lbevv7AXeZ0DFHO_-UxMjAzcsrYIttGpzrWpHyzsg.Zh4MeyL1QnUEPCqGcoijKFqqZGu4JFwGgwOcIQYxv6Qg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTk0/MDAxNjUzNDA2ODc2MDY5.2jSlr3AYKwfAqADFF3AKQfz7ze1Itwbk2PPZCTGqsAYg.3alLzFfm-W9y--oAixx2M1xmBjjG1P4S6x_yKmWleIQg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMjMy/MDAxNjUzNDA2OTM0NzE1.gmtRJqC3p4z6K367UpBnnUTi7pWQObOWPNgErxZp_1wg.BSyn7b930es99bri2bnem-74T-OyH_aJDjaXKlViytQg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
> InputDialog Button 클릭시

<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMjMw/MDAxNjUzNDA2OTY2NzQ1.TKhV9j_6rX4MMQA9j76gAeCrt-k2pYa5jyrkElwtWP8g.yBOdvJHYSGjN78Vqw1tdZLPamMv6rtCU4Tnwh_DOpqYg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMjE1/MDAxNjUzNDA3MDM5ODA4.lFzlfnI4SGpaxs5AP0l8So5HrR6c6C0TcOiyZhTv8vIg.-i58ovi930IsTVT8O_PbAGloQnB6sOl7r_N3Ytj9BZgg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
