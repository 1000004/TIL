```java
public class Menu extends JFrame{
	
	private Food[] menus = {
			new Food("pizza", 28000),
			new Food("Cola",1500),
			new Food("Humburger",6300),
			new Food("Java",3000)
	};
	
	private JCheckBox[] cbs;
	private JLabel lblPrice;
	private JTextField tfPriceSum;
	public static final int NORMAL_EXIT = 0;
	
	public Menu(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init(){
		cbs = new JCheckBox[menus.length];
		for(int idx=0; idx<cbs.length;idx++){
			cbs[idx] = new JCheckBox(menus[idx].getMenu());
		}
		lblPrice = new JLabel("가격");
		tfPriceSum = new JTextField(20);
		tfPriceSum.setText("0");
		tfPriceSum.setEditable(false);//편집 불가 드래그 가능
	}
	
	private void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		for(JCheckBox cb :cbs){
			pnlCenter.add(cb);
		}
		TitledBorder tBorder = new TitledBorder(new LineBorder(Color.GRAY,1),"menu");
		pnlCenter.setBorder(tBorder);
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(lblPrice);
		pnlSouth.add(tfPriceSum);
		add(pnlCenter,BorderLayout.CENTER);
		add(pnlSouth,BorderLayout.SOUTH);
	}
	
	private void addListeners(){
		
		ItemListener listener = new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				int state = e.getStateChange(); //SELECTED, DESELECTED
				String menu = ((JCheckBox)e.getSource()).getText();
				boolean flag = true;
				int idx = 0;
				int result = 0;
				while(flag){
					if(menu.equals(menus[idx].getMenu())){
						if(state == ItemEvent.SELECTED){
							result = Integer.parseInt(tfPriceSum.getText()) + menus[idx].getPrice();
						}else if(state == ItemEvent.DESELECTED){
							result = Integer.parseInt(tfPriceSum.getText()) - menus[idx].getPrice();
						}
						tfPriceSum.setText(String.valueOf(result));
						flag = false;
					}else{
						idx++;
					}
				}
			}
		};
		
		for(JCheckBox cb : cbs){
			cb.addItemListener(listener);
		}
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
				int choice = JOptionPane.showConfirmDialog(
						Menu.this,
						"종료합니다.",
						"알림",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE
					);
				if(choice == JOptionPane.OK_OPTION){
					System.exit(NORMAL_EXIT);
				}
			}
		});
	}
	
	private void showFrame(){
		setTitle("Menu");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Menu();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfNjQg/MDAxNjUzNDg4NzEzMDg0.dQjxYDJp11O5ZME8s0NR4yaSCGpdtzphMrVsJ8snpvsg.PeK33yDmNJK7oBWdE0ndeKH_zfc4tiEfCXeFLbvVtMIg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class MJBGame extends JFrame{
	private String[] mjb = {"묵", "찌", "빠"};
	private JRadioButton[] rbtns;
	private JButton btnStart;
	private JTextArea taResult;
	final private String WIN = "당신이 이겼어요~";
	final private String LOSE = "컴퓨터가 이겼어요~";
	Random r = new Random();
	
	public MJBGame(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init(){
		rbtns = new JRadioButton[mjb.length];
		ButtonGroup group = new ButtonGroup();
		for(int idx=0; idx<rbtns.length;idx++){
			rbtns[idx] = new JRadioButton(mjb[idx]);
			group.add(rbtns[idx]);
		}
		
		btnStart = new JButton("시작");
		taResult = new JTextArea();
		taResult.setOpaque(true);
		taResult.setBorder(new LineBorder(Color.GRAY,1));
		taResult.setBackground(Color.WHITE);
	}
	private void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		pnlCenter.setBorder(new EmptyBorder(0,50,20,50));
		JPanel pnlMJB = new JPanel(new GridLayout(1,3));
		for(JRadioButton rbtn : rbtns){
			pnlMJB.add(rbtn);
		}
		pnlCenter.add(pnlMJB);
		JPanel pnlbtn = new JPanel();
		pnlbtn.add(btnStart);
		pnlCenter.add(pnlbtn);
		
		
		add(pnlCenter,BorderLayout.NORTH);
		add(taResult,BorderLayout.CENTER);
		
	}
	private void addListeners(){
		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				boolean flag = true;
				int idx = 0;
				String me = null;
				while(flag && idx < 3){
					if (rbtns[idx].isSelected()){
						me = rbtns[idx].getText();
						flag = false;
					}
					idx++;
				}
				int num = r.nextInt(3) + 1;
				String com = "빠";
				if(num == 1){
					com = "묵";
				}else if(num == 2){
					com = "찌";
				}
				String print = "컴퓨터 : "+com +"\n";
				print += "당신 : "+me + "\n";
				if(me.equals(com)){
					print +="비겼어요~";
				}else if(me.equals("묵")){
					if(com.equals("찌")){
						print += WIN;
					}else{
						print += LOSE;
					}
				}else if(me.equals("찌")){
					if(com.equals("빠")){
						print += WIN;
					}else{
						print += LOSE;
					}
				}else{
					if(com.equals("묵")){
						print += WIN;
					}else{
						print += LOSE;
					}
				}
				taResult.setText(print);
			}
		});
	}
	private void showFrame(){
		setTitle("MJBGame");
		setSize(300, 230);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MJBGame();
	}

}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTg5/MDAxNjUzNDg5MDExNDU0.8KimHIg1MZmASQdK56xeum7j2P31GEoi4hZ67IlR7fUg.qPoWR_ISpjxsXSbP8JKHgkoiTjylAcCz6QrDiWBz0lYg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA1MjVfMTgx/MDAxNjUzNDg5MDAwMzAw.8NHP21e4mpxrjJtG2V4Eo_k9ciz8UN1kAFkWRWYvhngg.9Rpkl8KtpsLdCSpzbU_Nro29SesqiFbS2Mw6RRdVCaUg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
