## WindowListener
* API가 제공하는 WindowAdapter
	* 가전제품 필요전기 10v 전압 필요 전기제공 220v 전압 연결시 고장 위험
	* Adapter는 요구하는 전압과 제공하는 전압에서 사이에서 맞춰 준다.
	* Frame에서 1개의 메서드를 이용하지만 WindowListener가 제공하는 메서드가 7개인 경우 WindowAdapter가 조절
* AdapterPattern : 요구와 제공 사이에서 불일치한 사항을 마춰주는 객체(Adapter)를 만든다 - GoF
```java
abstract class WindowAdapter implements WindowListener{
	//API가 제공하는 WindowAdapter
	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void windowClosing(WindowEvent e) 
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowDeactivated(WindowEvent e) {	
	}
}
```
-------------
WindowAdapter를 상속받는 외부 클래스 생성
```java
public class MyWindowListener extends WindowAdapter {
	
	private MyFrame1 ui;
	
	public void setUi(MyFrame1 ui){
		this.ui = ui;
	}
	
	@Override
	public void windowClosing(WindowEvent we){
		ui.close();
	}

}
public class MyFrame1 extends JFrame{
	public static final int NORMAL_EXIT = 0;
	public MyFrame1(){
		/*
		 * (AtionListener 추상메서드 한개)
		 * WindowEvent -> WindowListener 추상메서드 여러개 -> WindowAdapter
		 * 창에서 WindowEvent가 발생시 동작 수행
		 */
		// addWindowListener(this);
		
		MyWindowListener listener = new MyWindowListener();
		listener.setUi(this);
		/*
		*일반적으로 다른곳에서 사용 가능하기위해서는 클래스 따로 생성
		*하지만 해당 경우는 다른 곳에 객체를 사용하지 않지만
		*JFrame를 이미 상속중이 때문에 WindowAdapter를 상속받는 다중 상속이 불가능 하기 때문에 클래스 만듬
		*/
		
		//setter로 가져옴
		addWindowListener(listener);
		
		setTitle("MyFrame1");
		setLocationRelativeTo(null);
		setSize(300,400);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//이벤트 발생시 원하는 행위를 수행 시킬 수 없다 개입이 불가능
		//이벤트를 직접 정의해야 정의한 일을 수행 가능
		//setDefaultCloseOperation는 아무것도 하지 말라는 설정이 우선
		setVisible(true);
	}
	
	public void close(){
		int choice = JOptionPane.showConfirmDialog(
			this,
			"종료하시겠습니까?",
			"종료",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);
		if(choice == JOptionPane.YES_OPTION){
			//정성 종료
			//사용자의 의도
			//양수는 정상 종료일때 사용
			//음수는 비정상 종료일때 사용
			System.exit(NORMAL_EXIT);
		}
	}

	public static void main(String[] args) {
		new MyFrame1();

	}

}
```
-------------------
inner class
```java
public class MyFrame2 extends JFrame {
	private JButton btnExit;
	public static final int NORMAL_EXIT = 0;
	public MyFrame2(){
		
		
		btnExit = new JButton ("Exit");
		btnExit.addActionListener(new ExitActionListener());
		addWindowListener(new InnerWindowListener());
		add(btnExit, BorderLayout.SOUTH);
		
		setTitle("MyFrame2");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
		
	}
	private class ExitActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae){
			close();
		}
	} 
	private class InnerWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent we){
			close();
			/*
				//inner class에서 WindowAdapter 상속 받는 객체 생성
				int choice = JOptionPane.showConfirmDialog(
					//inner class에서의 this가 아닌 MyFrame2 this가 부모요소 조심 해야한다
					MyFrame2.this,
					"종료 하시겠습니까?",
					"궁금",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE
				);
				if(choice == JOptionPane.YES_OPTION){
				System.exit(NORMAL_EXIT);
				}
			*/
		}
	}
	public void close(){
		int choice = JOptionPane.showConfirmDialog(
				this,
				"종료 하시겠습니까?",
				"궁금",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
		if(choice == JOptionPane.YES_OPTION){
		System.exit(NORMAL_EXIT);
		}
	}
	
	public static void main(String[] args){
		new MyFrame2();
	}
}

```
---------------------------
anonymous inner class
```java
public class MyFrame3 extends JFrame {
	public static final int NORMAL_EXIT = 0;
	private JButton btnExit;
	
	public MyFrame3(){
		btnExit = new JButton("Exit");
		add(btnExit, BorderLayout.SOUTH);
		
		// anonymous inner class : 객체 생성을 1번만 할 수 있다.
		// 많이 사용
		// 람다식의 기본토대다...
		// 이름이 없는 클래스
		// 객체를 한번 생성 가능
		// ActionListener는 인터페이스기 때문에 (구현한)Override를 한 anonymous inner class 생성
		btnExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				close();
			}
		});
		final int num = 2;
		//JDK1.8부터도 변경이 불가능한다.
		//지역변수 호환성을 위해 final를 붙인다
		//Swing의 경우와 아두이노 버튼 클릭 이벤트와 유사
		//아두이노는 파라미터로 WindowEvent가 아닌 이벤트 소스
		WindowListener wListener = new WindowAdapter(){
			//WindowAdapter를 상속 받는 anonymous inner class 생성
			//wListener는 객체 이름이지 class이름이 아니다.
			@Override
			public void windowClosing(WindowEvent we){
				close();
				//JDK1.8~ : 지역변수를 참조할 수 있지만, 값의 변경은 불가능 한다
				//~JDK1.7 : 지역변수를 참조하는것이 불가능함. 단, 상수(final)는 가능하다.
				System.out.println(num);//지역변수 사용 가능
			}
		};
		addWindowListener(wListener);
		setTitle("MyFrame3");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	public void close(){
		int choice = JOptionPane.showConfirmDialog(
				this,
				"종료 하시겠습니까?",
				"궁금",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
		if(choice == JOptionPane.YES_OPTION){
		System.exit(NORMAL_EXIT);
		}
	}
	
	public static void main(String[] args) {
		new MyFrame3();
	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMjQw/MDAxNjUzNDU2NDg2MTY4.lngu0OuwgAEF9N7df9iVUrJIoxb9R-nvlAeaAs48usIg.BgfVNUGR78_kGL5xasU_ELXnilLi56fK5fiD67oIxH8g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
