## MouseListener
* Override 메서드만 일부만 필요한 경우 MouseAdapter
* Pressed + Released = Clicked
* 일이 일어나는 순서 Pressed →  Released → Clicked
* Clicked시 반응이 늦기 때문에 일반적으로 Pressed, Released가 쓰임.
* 하지만 getClickCount()를 이용해 더블클릭을 구현할 수 있다.(더블 클릭 속도는 os가 설정)
* Entered는 요소에 커서가 올라왔는지 Exited 요소에서 커서가 나갔는지 동작
* 같은 이름의 갖는 컴포넌트가 있을 경우 ex) btnExit, miExit-> if(src == miExit || src == btnExit) 계속 조건 추가됨
* ae.getSource()를 사용하면 if문 조건이 너무 길어짐 ↑ae.getActionCommand(); 사용 추천
```java
abstract class MouseAdapter implements MouseListener{
//5개 메서드
    @Override
    public void mouseClicked(MouseEvent e) {//Button Clicked
    }
    @Override
    public void mousePressed(MouseEvent e) {//Button Pressed
    }
    @Override
    public void mouseReleased(MouseEvent e) {//Button Released
    }
    @Override
    public void mouseEntered(MouseEvent e) {//Cursor Entered
    }
    @Override
    public void mouseExited(MouseEvent e) {//Cursor Exited
    }
}      
    
```
```java
public class Ex1 extends JFrame {
	private JLabel lbl;
	
	public Ex1() {
		lbl = new JLabel("start", JLabel.CENTER);
		lbl.setOpaque(true);
		lbl.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		lbl.setBackground(Color.WHITE);
		lbl.setBorder(new BevelBorder(BevelBorder.RAISED));
		//lbl 테두리가 입체적으로 보인다
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.add(lbl, BorderLayout.CENTER);
		pnlCenter.setBorder(new EmptyBorder(40, 40, 40, 40));
		add(pnlCenter, BorderLayout.CENTER);
		
		MouseListener mListener = new MouseListener() {
			// MouseListener API Override해야하는 메서드 5개(단축키 alt + shft + s ->v)
			// 몇개의 메서드만 필요한 경우 MouseAdapter
			@Override
			public void mouseClicked(MouseEvent e) {//Pressed + Released = Clicked
				//일이 일어나는 순서 Pressed →  Released → Clicked
				// Clicked는 일반적으로 Pressed, Released에 비해 늦게 반응하기 때문에 쓰임이 적다
				// 하지만 getClickCount()를 이용해 더블클릭을 구현할 수 있다.
				if(e.getButton() == MouseEvent.BUTTON3 && e.getClickCount() == 2) {
					lbl.setText("double click");
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {//마우스 버튼을 누르다
				lbl.setBackground(Color.YELLOW);
				int btn = e.getButton();//마우스 버튼를 int로 구분하여 제한을 둘수 있다.
				String msg = "mouse pressed : button";
				if(btn == MouseEvent.BUTTON1) {
					msg += 1;//왼쪽 클릭
				} else if(btn == MouseEvent.BUTTON2) {
					msg += 2;//휠 클릭
				} else {
					msg += 3;//오른쪽 클릭
				}
				lbl.setText(msg);
				lbl.setBorder(new BevelBorder(BevelBorder.LOWERED));
				//lbl 테두리가 움푹 들어가는 것처럼 보인다
				//RAISED,LOWERED로 버튼으로 보일 수 있다
			}
			@Override
			public void mouseReleased(MouseEvent e) {// 떼다
				lbl.setBackground(Color.WHITE);
				lbl.setText("start");
				lbl.setBorder(new BevelBorder(BevelBorder.RAISED));
			}
			@Override
			public void mouseEntered(MouseEvent e) {//커서가 들어왔는지
				lbl.setBackground(Color.GREEN);
				lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
				//버튼에 커서를 올리면 마우스 아이콘 변경
			}
			@Override
			public void mouseExited(MouseEvent e) {//커서가 나갔는지
				lbl.setBackground(Color.WHITE);
				//lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		};
		
		lbl.addMouseListener(mListener);
		
		setTitle("Ex1");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex1();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMTIg/MDAxNjUzNTgwMDk4ODM0.8dynPHvoJriILtPqBZvWLy5pR909pleu8vw9fEn5EWcg.zVty24RbKie9HX0MS-59suM4_0WO4SYD81aVTEODyMog.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
