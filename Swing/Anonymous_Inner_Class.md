# anonymous inner class
* 객체를 한번 생성 가능
* 이름이 없는 객체 
* 람다식의 기본토대
* JDK1.8~ : 지역변수를 참조할 수 있지만, 값의 변경은 불가능 한다
* ~JDK1.7 : 지역변수를 참조하는 것이 불가능함. 단, 상수(final)는 가능하다.
```java
public class Counter extends JFrame {
	
	private JLabel lblNum;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnReset;
	
	public Counter() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init() {
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		btnPlus = new JButton("plus");
		btnMinus = new JButton("minus");
		btnReset = new JButton("reset");
	}
	private void setDisplay() {
		JPanel pnlSouth = new JPanel(new GridLayout(1, 2));
		pnlSouth.add(btnPlus);
		pnlSouth.add(btnMinus);
		add(btnReset, BorderLayout.NORTH);
		add(lblNum, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners() {
		btnPlus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				lblNum.setText(String.valueOf(Integer.parseInt(lblNum.getText())+1));
			}
		});
		btnMinus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				lblNum.setText(String.valueOf(Integer.parseInt(lblNum.getText())-1));
			}
		});
		//람다
		btnReset.addActionListener((ae)->lblNum.setText("0"));
	}
	private void showFrame() {
		setTitle("counter");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Counter();
	}
}
```
