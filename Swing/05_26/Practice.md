```java
public class Menu extends JFrame{
	private FoodChecker[] chks;
	private JTextField tfTotal;
	private int totalPrice;
	
	public Menu(Food...foodList){
		init(foodList);
		setDisplay();
		addListeners();
		showFrame();
	}
	
	public void init(Food...foodList){
		chks = new FoodChecker[foodList.length];
		for(int i=0;i<chks.length;i++){
			chks[i] = new FoodChecker(foodList[i]);
		}
		
		tfTotal = new JTextField(20);
		tfTotal.setEditable(false);
	}
	public void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		for(FoodChecker btn : chks){
			pnlCenter.add(btn);
		}
		pnlCenter.setBorder(new TitledBorder(
				new LineBorder(Color.GRAY,1),
				"menu"
		));
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(new JLabel("가격"));
		pnlSouth.add(tfTotal);
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
	}
	public void addListeners(){
		ItemListener listener = new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent ie){
				FoodChecker btn = (FoodChecker)ie.getSource();
				int price = btn.getPrice();
				if(ie.getStateChange() == ItemEvent.SELECTED){
					totalPrice += price;
				}else{
					totalPrice -= price;
				}
				showPrice();
			}
		};
		for(FoodChecker ch : chks){
			ch.addItemListener(listener);
		}
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
				int result = JOptionPane.showConfirmDialog(
						Menu.this,
						"종료합니다.",
						"알림",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE
				);
				if(result == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		
	}
	public void showFrame(){
		setTitle("Menu");
		pack();
		setLocation(100,0);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		showPrice();
		setVisible(true);
	}
	private void showPrice(){
		tfTotal.setText(String.valueOf(totalPrice));
	}
	public static void main(String[] args) {
		new Menu(
			new Food("Pizza", 28000),
			new Food("Cola", 1500),
			new Food("Hamburger", 6300),
			new Food("Java",3000)
		);
	}
}
```java
public class FoodChecker extends JCheckBox{
	private Food food;
	public FoodChecker(Food food){
		super(food.toString());
		setFood(food);
	}
	public Food getFood(){
		return food;
	}
	public void setFood(Food food){
		this.food = food;
	}
	public int getPrice(){
		return food.getPrice();
	}
}
```
```java
class Food {
	private String name;
	private int price;
	
	public Food(String name, int price){
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString(){
		return name + "("+price+")";
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMzkg/MDAxNjUzNTgxMzY1MDQ3.zOyKNDLNe0G83JQ9H2fidUaHECAtkct3E8NmHK_sjQsg.-oyNX9iANBdhi7ph33GiAs7n8K2HZk4fljkoFqyOEdwg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
----------
```java
public class MJBGame extends JFrame{
	/*
	 * 묵=0
	 * 찌=1
	 * 빠=2
	 * 
	 */
	public static final int WIN_CASE1 = -1;
	public static final int WIN_CASE2 = 2;
	
	public JRadioButton[] rbtns = {
			new JRadioButton("묵"),
			new JRadioButton("찌"),
			new JRadioButton("빠")
	};
	
	private JButton btnStart;
	private JTextArea taResult;
	
	public MJBGame(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init(){
		btnStart = new JButton("시간");
		taResult = new JTextArea(4, 20);
		taResult.setEditable(false);
		ButtonGroup bg = new ButtonGroup();
		for(JRadioButton rbtn : rbtns){
			bg.add(rbtn);
		}
	}
	
	private void setDisplay(){
		JPanel pnlNorth = new JPanel(new GridLayout(1,3));
		for(JRadioButton rbtn : rbtns){
			pnlNorth.add(rbtn);
		}
		pnlNorth.setBorder(new EmptyBorder(0,25,0,0));
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnStart);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(new JScrollPane(taResult), BorderLayout.SOUTH);
	}
	
	private void addListeners(){
		btnStart.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent ae){
						int userSelect = 0;
						for(int idx =0;idx<rbtns.length;idx++){
							if(rbtns[idx].isSelected()){
								userSelect = idx;
							}
						}
						int computer = (int)(Math.random()*3);
						
						int result = userSelect - computer;
						StringBuffer buf = new StringBuffer();
						buf.append("컴퓨터 : ");
						buf.append(whatIsChoice(computer));
						buf.append("\n");
						buf.append("당신 : ");
						buf.append(whatIsChoice(userSelect));
						buf.append("\n");
						if(computer == userSelect){
							buf.append("비겼어요~");
						}else if(result == WIN_CASE1 ||result == WIN_CASE2 ){
							buf.append("당신이 이겼어요~");
						}else{
							buf.append("당신이 졌어요~");
						}
						
						taResult.setText(buf.toString());
					}
				}
			);
			
		}

		private String whatIsChoice(int choice){
			return rbtns[choice].getText();
		}
		
		private void showFrame(){
			setTitle("MJBGame");
			setSize(300,200);
			setLocation(400,0);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
		
		public static void main(String[] args){
			new MJBGame();
		}
	
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA1MjdfMjMx/MDAxNjUzNTgxNTAzNjYz.Ny3gcm9SIsYwZTu4FtYkGfGSZjmLqERNKab4f74B55wg.cOwSM5zyXA2iBuq8y9T9OkKup3ba-oQ0ZQm8Yc9KcRwg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
