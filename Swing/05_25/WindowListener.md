## WindowListener

```java
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
		//다른곳에서 사용 가능하도록 클래스 따로 생성
		//
		//set로 가져옴
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

abstract class WindowAdapter implements WindowListener{
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
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMjQw/MDAxNjUzNDU2NDg2MTY4.lngu0OuwgAEF9N7df9iVUrJIoxb9R-nvlAeaAs48usIg.BgfVNUGR78_kGL5xasU_ELXnilLi56fK5fiD67oIxH8g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
