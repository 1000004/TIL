//기존에 존재하는 스레드 
public class Clock extends JFrame{
	private JLabel lblHour;
	private JLabel lblMin;
	private JLabel lblSec;
	
	private Font timeFont;
	
	public Clock(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init(){
		timeFont = new Font(Font.SERIF, Font.BOLD, 40);
		lblHour = new JLabel("00",JLabel.CENTER);
		lblHour.setFont(timeFont);
		
		lblMin = new JLabel("00", JLabel.CENTER);
		lblMin.setFont(timeFont);
		
		lblSec = new JLabel("00", JLabel.CENTER);
		lblSec.setFont(timeFont);
	}
	private void setDisplay(){
		JPanel pnlCenter = new JPanel();
		
		pnlCenter.add(lblHour);
		pnlCenter.add(getSecparator());
		pnlCenter.add(lblMin);
		pnlCenter.add(getSecparator());
		pnlCenter.add(lblSec);
		
		add(pnlCenter, BorderLayout.CENTER);
	}
	private JLabel getSecparator(){
		JLabel lbl = new JLabel(":",JLabel.CENTER);
		lbl.setFont(timeFont);
		return lbl;
	}
	private void addListeners(){
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTime();
				
			}
		};
		new Timer(1000, listener).start();//1초에 한번씩 이미 만들어진 스레드 사용
		//시간 재는데 사용
		//정해진 시간 주기적인 일에는 Timer
    //sleep을 이용시 오작동 위험
    //오래걸리는 작업은 스레드로 구현식 작동안할 수 있다
	}
	private void showFrame(){
		setTitle("Clock");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTime();
		setVisible(true);
	}
	private void setTime(){
		Calendar c = Calendar.getInstance();
    //내부자원과 관련되어 new로 만들지 않는다
    //윈도우 운영체제에서 가져온다
		//단축키 설정 툴킷
		//운영체제 하드웨어 관련된경우 new로 만들수 없다
		int h = c.get(Calendar.HOUR);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		
		lblHour.setText(String.format("%02d", h));
		lblMin.setText(String.format("%02d", m));
		lblSec.setText(String.format("%02d", s));
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					new Clock();
				}
			}
		);
    //main에서 관리하는 것이 아닌 Event Dispatcher Thread가 관리
    //두개의 스레드가 동일한 대상을 가지고 작업시 문제 발생(공유 자원 문제점)
		//두개의 스레드가 하나의 GUI 작업하지 않고 하나의 스레드가 GUI를 컨트롤
    //Swing is nat thread safe 스위에 모든 컴포넌트는 원하는 동작 수행이 안될 가능성을 가지고 있다
		//이벤트 처리하를 하나에 스레드에 다시킨다
	}
}
