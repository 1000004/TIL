# ItemListener
> ItemEvent - ItemListener
* RadioButton 상태 변화는 2가지다
* 선택된 상태 → 선택이 해제된 상태/선택 안된 상태 → 선택된 상태
* RadioButton은 여러개 중 하나만 선택 가능하기 떄문에 첫번째로 선택하는 경우를 재외하고 a가 선택된 상태로 b가 선택될시 a의 첫번째 상태변화가 발생하고 b가 두번째 상태변화 발생
* 두번째 선택부터는 상태변화가 두번씩 발생한다.
* 이를 구별하기 위해 SELECTED, DESELECTED로 상태를 상수로 받는다
```java
ItemListener listener = new ItemListener(){
    @Override
    public void itemStateChanged(ItemEvent e){
      int state = e.getStateChange(); //SELECTED, DESELECTED
    }
};
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfODEg/MDAxNjUzNDg4Mjc3ODQy.niPqtF9n_8LrqSN7fJ_vfFd3WU1wte2zRE9hPIcLiyYg.C4dteeMOn_wdjKintkglraqDJumYy9BshaZL5RLadQEg.PNG.forget980/image.png?type=w580"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTA3/MDAxNjUzNDg4MzAxNzcw.Nb-3_p7bqDEd6trEy9u44WPSoi7b75cy18S5wEyAOI8g.Q18LTUMGzQTOvywgFIuiR0_VBfpANy3KiCEhciILOhEg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

```java
public class Ex extends JFrame {
	private String[] colors = {"red", "green", "blue", "white"};
	private JRadioButton[] rbtns;
	private JLabel lblColor;
	
	public Ex1() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init(){
		rbtns = new JRadioButton[colors.length];
		ButtonGroup group = new ButtonGroup();
		for(int idx=0; idx<rbtns.length;idx++){
			rbtns[idx] = new JRadioButton(colors[idx]);
			group.add(rbtns[idx]);
		}
		
		lblColor = new JLabel();
		lblColor.setOpaque(true);
		lblColor.setBorder(new LineBorder(Color.GRAY,1));
		lblColor.setBackground(Color.WHITE);
	}
	private void setDisplay(){
		JPanel pnlWest = new JPanel(new GridLayout(0,1));
		for(JRadioButton btn : rbtns){
			pnlWest.add(btn);
		}
		TitledBorder tBorder = new TitledBorder(new LineBorder(Color.GRAY,1),"color");
		tBorder.setTitlePosition(TitledBorder.BELOW_TOP);
		pnlWest.setBorder(tBorder);
		
		add(pnlWest, BorderLayout.WEST);
		add(lblColor, BorderLayout.CENTER);
	}
	private void addListeners(){
		/*
		final ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				JRadioButton btn = (JRadioButton)ae.getSource();
				System.out.println(btn.getText());
			}
		}
		*/
		ItemListener listener = new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				int state = e.getStateChange(); //SELECTED, DESELECTED
				if(state == ItemEvent.SELECTED){
					String color = ((JRadioButton)e.getSource()).getText();
					Color backgroud = Color.WHITE;
					if(color.equals("red")){
						backgroud = Color.RED;
					}else if(color.equals("green")){
						backgroud = Color.GREEN;
					}else if(color.equals("blue")){
						backgroud = Color.BLUE;
					}
					lblColor.setText(color);
					lblColor.setFont(new Font(Font.SERIF, Font.BOLD, 20));
					lblColor.setForeground(backgroud);
				/*	
					//System.out.println(((JRadioButton)e.getSource()).getText() + "<< SELECTED");
				}else{
					//System.out.println(((JRadioButton)e.getSource()).getText() + "<< DESELECTED");
				}
				*/
				}
			}
		};
		for(JRadioButton btn : rbtns){
			btn.addItemListener(listener);
		}
		
	}
	private void showFrame(){
		setTitle("change color");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex1();

	}

}
```
