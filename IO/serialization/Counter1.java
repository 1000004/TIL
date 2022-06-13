public class Counter1 extends JFrame implements ActionListener,Serializable{

	private JLabel lblNum;
	private JButton btnPlus;
	
	public Counter1(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init(){
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD,60));
		btnPlus = new JButton("plus");
	}
	private void setDisplay(){
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}
	private void addListeners(){
		btnPlus.addActionListener(this);//파라미터는 ActionListener
	}
	private void showFrame(){
		setTitle("counter");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override 
	public void actionPerformed(ActionEvent ae){
		//버튼 누르면 할일
		
		//레이블에 텍스트를 가져온다
		String value = lblNum.getText();
		//String -> int
		int num = Integer.parseInt(value);
		//1증가
		num++;
		//int -> String
		value = String.valueOf(num);
		//레이블에 설정하기
		lblNum.setText(value);
	}
	public JLabel getLblNum(){//    →
		return lblNum;
	}
	public static void main(String[] args) {
		new Counter1();

	}

}
