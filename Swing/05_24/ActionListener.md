## ActionListener
<img src="https://postfiles.pstatic.net/MjAyMjA1MjRfNTQg/MDAxNjUzNDAyMjU1NjU5.AUH7NYWX77MFUtMxCU0yQIxFMfgfK7y2y695-2oGZ1og.7H2y5uG2WsZWQi57WYBaqSaTN_Z2ufL2payio1qeVrog.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
* plus Button을 누르면 Label 숫자 + 1
* count1,count2,count3,count4 class는 해당 동일한 UI를 보여준다.
* count1은 내부클래스에 ActionListener를 구현한다.
* count2,count3,count4는 독립된 ActionListener class를 가진다.
* ActionListener2 class의 경우 ActionListener2가 count2의 멤버변수를 가져와 event를 처리하기 때문에  count2 멤버변수가 외부 클래스의 영향을 받게 되므로 결합도가 높다.
* ActionListener3 class의 경우 count2가 event 발생시 할 일을 method로 정의하고 ActionListener3가 method를 호출하기 때문에 count2 멤버변수를 내부에서 처리하여 결합도가 낮다.
* event 발생시 할 일이 변경되더라도 ActionListener3는 method 이름이 변경되지 않는 이상 영향을 받지 않는다.
* ActionListener4 class의 경우 interface IDoClick를 만들어 event 발생시 할 일을 method로 추상화시킴으로써 IDoClick을 구현한 모든 클래스가 ActionListener4가 이용이 가능해지면서 재사용성이 올라갔다.
```java
public class Counter1 extends JFrame implements ActionListener{

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
	public JLabel getLblNum(){
		return lblNum;
	}
	public static void main(String[] args) {
		new Counter1();

	}

}

```
```java
public class Counter2 extends JFrame{
	private JLabel lblNum;
	private JButton btnPlus;
	
	public JLabel getLalNum(){
		return lblNum;
	}
	
	public Counter2(){
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
		btnPlus.addActionListener(new MyActionListener2(this));
	}
	private void showFrame(){
		setTitle("counter2");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public JLabel getLblNum(){
		return lblNum;
	}
	public static void main(String[] args) {
		new Counter2();

	}

}

public class MyActionListener2 implements ActionListener{
	private Counter2 ui;
	
	public MyActionListener2(Counter2 ui){
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		//버튼 누르면 할일
		
		//레이블에 텍스트를 가져온다
		String value = ui.getLblNum().getText();
		//String -> int
		int num = Integer.parseInt(value);
		//1증가
		num++;
		//int -> String
		value = String.valueOf(num);
		//레이블에 설정하기
		ui.getLblNum().setText(value);
	}

}

```
```java
public class Counter3 extends JFrame{

	private JLabel lblNum;
	private JButton btnPlus;
	
	public Counter3(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init(){
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD,6));
		btnPlus = new JButton("plus");
	}
	private void setDisplay(){
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}
	private void addListeners(){
		MyActionListener3 listener = new MyActionListener3(this);
		btnPlus.addActionListener(listener);
	}
	public void plusNum(){//lblNum 변수가 바뀌어서
		lblNum.setText(String.valueOf(Integer.parseInt(lblNum.getText())+1));
	}
	private void showFrame(){
		setTitle("counter");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Counter3();

	}

}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener3 implements ActionListener{
	private Counter3 ui;
	
	public MyActionListener3(Counter3 ui){
		this.ui = ui;
	}
	@Override
	public void actionPerformed(ActionEvent ae){
		ui.plusNum();
	}

}
```
```java
public class Counter4 extends JFrame implements IDoClick{

	private JLabel lblNum;
	private JButton btnPlus;
	
	public Counter4(){
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
		btnPlus.addActionListener(new MyActionListener4(this));//파라미터는 ActionListener
	}
	private void showFrame(){
		setTitle("counter");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override 
	public void click(){
		lblNum.setText(String.valueOf(Integer.parseInt(lblNum.getText())+1));
	}
	public JLabel getLblNum(){
		return lblNum;
	}
	public static void main(String[] args) {
		new Counter4();

	}

}

public class MyActionListener4 implements ActionListener{
	
	private IDoClick ui;
	
	public MyActionListener4(IDoClick ui){
		this.ui = ui;
	}
	@Override
	public void actionPerformed(ActionEvent ae){
		ui.click();
	}
}

public interface IDoClick {

	void click();
}
```
