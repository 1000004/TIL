```java
public class ListStep1 extends JFrame{
	private JList<String> list;//Jlist 메소드는 보여주기 위한 메서드
	private JLabel lbl;
	
	public ListStep1(){
		list = new JList<String>(
			new String[]{"apple","banana","kiwi","grape"}
		);
		lbl = new JLabel("start");
		
		list.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxx");
		//목록 넓이 결정
		//요정도 값을 보여줄 수 있는 list(샘플)를 보여주겠다. 제네릭에 맞는 타입으로 써야 한다.
		list.setVisibleRowCount(3);
		//JScrollPane과 함께써야 의미가 있다
		add(new JScrollPane(list), BorderLayout.CENTER);
		add(lbl, BorderLayout.SOUTH);
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				lbl.setText(
					"selected item : "+list.getSelectedValue()//선택된 값 가져온다
				);
			}
		});
		
		setTitle("JList step1");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ListStep1();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA2MTNfMTA0/MDAxNjU1MTIzMjc2NTU4.1csphxmVNny9XQR9itxYuGbBbS5XKd4kMuORylQSzDcg.sBNM1d5ar2hNYxFVN3dxV4W6afc-qZbaOUtRdyKluXAg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class ListStep2 extends JFrame{
	private JList<String> list;
	private JLabel lbl;
	
	public ListStep2(){
		list =new JList<String>(
			new String[]{"apple","banna","kiwi","grape"}
		);
		lbl = new JLabel("start");
		list.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		list.setVisibleRowCount(3);
		
		list.setCellRenderer(new MyListCellRenderer());
		
		add(new JScrollPane(list), BorderLayout.CENTER);
		add(lbl, BorderLayout.SOUTH);
		/*
		 * 1. 단일선택
		 * ListSelectionModel.SINGLE_SELECTION
		 * 2. 연속된 복수선택
		 * ListSelectionModel.SINGLE_INTERVAL_SELECTION
		 * 3. 연속, 비연속 복수 선택(default)
		 * ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		 * 
		 * shift 누른 상태로 연속 복수 선택
		 * ctrl 누른 상태로 비연속 복수 선택
		 */
		
		list.setSelectionMode(
				ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				lbl.setText(
					"selected item : "+list.getSelectedValue()
				);
				
			}
		});
		setTitle("JList step2");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private class MyListCellRenderer extends DefaultListCellRenderer{
		//내부 클래스
		//List 내부를 어떻게 하나하나 어떻게 표현할지 결정해주는 interface DefaultListCellRenderer
		//기본적으로 기능을 가지고 있는 DefaultListCellRenderer을 상속받아 만든다.
		@Override
		public Component getListCellRendererComponent(
				//Component return UI가 변경될때 마다 cell을 어떻게 채울지 자동 호출
				//선택됬는지 포커스됬는지에 따라 선택 색깔 변경하여 보여준다 자동 호출
				//Component 상태 : 선택되고 안되고 포커스가 가지고 있는지 아닌지
			JList list, Object value, int idx,
			//list를 가지고 list에 들어 있는 Object(item)가 idx로 차례차례 들어온다
			boolean isSelected,boolean cellHasfocus){
			
				System.out.println("rendering");
			
				JLabel lblItem = new JLabel(value.toString());
				//미러 Component 모양만 보여준다 JButton actionListener 사용 못한다.
				lblItem.setOpaque(true);
				if(isSelected){
					lblItem.setBackground(Color.YELLOW);
					lblItem.setText(
						lblItem.getText() + "<-- Selected"
					);
				}
				if(cellHasfocus){
					lblItem.setBackground(Color.GREEN);
					lblItem.setText(
						lblItem.getText() + "<-- Focused"
					);
				}
				return lblItem;
		}
	}
	public static void main(String[] args) {
		new ListStep2();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA2MTNfMjA2/MDAxNjU1MTIzOTE3ODky.cdoybDzWDwRlDDdr1_qBe4PVdR3eZMBcCO69-qJyA3Mg.bmzDbblzWYf9WjWtXCW9uR4KgfpCFkr-4uhaaQvXEm8g.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class ListStep3 extends JFrame{
	private JList<String> list;
	private JLabel lbl;
	private JTextField tfNewItem;
	private DefaultListModel<String> model;//추가와 삭제가 가능한 Model
	
	private JPopupMenu pMenu;
	private JMenuItem miRemove;
	public ListStep3(){
		pMenu = new JPopupMenu();
		miRemove = new JMenuItem("Remove");
		pMenu.add(miRemove);
		
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		lbl = new JLabel("추가항목");
		tfNewItem = new JTextField(5);
		
		list.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		list.setVisibleRowCount(3);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(lbl);
		pnlSouth.add(tfNewItem);
		
		add(new JScrollPane(list), BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		tfNewItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addElement(tfNewItem.getText());//추가
				tfNewItem.setText("");
				list.ensureIndexIsVisible(model.getSize()-1);
				//끝에 추가되므로 마지막 인덱스를 보이도록 보장 하는 메서드
			}
		});
		
		list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent me){
				showPopup(me);
			}
			@Override
			public void mouseReleased(MouseEvent me){
				showPopup(me);
			}
			private void showPopup(MouseEvent me){
				if(me.isPopupTrigger()){
					int x = me.getX();
					int y = me.getY();
					int idx = list.locationToIndex(//좌표에 해당하는 인덱스 찾기
						new Point(x, y)	
					);
					if(idx >= 0 && list.getSelectedIndex() >=0){
						//선택된 인덱스가 있고 마우스 위치에 인데스가 있고
						pMenu.show(list, x,y);
					}
				}
			}
		});
		
		miRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//아이템 삭제
				model.remove(list.getSelectedIndex());
				
			}
		});
		setTitle("JList step3");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ListStep3();
	}
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA2MTNfNzQg/MDAxNjU1MTI0Mzc3NTYw.bG8IQnFuw--ogQMic_ljW4oc9ddXTRQaHnv90lpYDA0g.kLb7UiZezDl_epizYD3YDU2RcZyofMI3zbf0XSVfaDwg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class ListStep4 extends JFrame implements ActionListener{
	
	private JList<String> list;
	private DefaultListModel<String> model;
	private JButton btnAdd;
	private JButton btnDel;
	
	public ListStep4(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init(){
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setPrototypeCellValue("abcdefghujklmnopqrstu");
		list.setVisibleRowCount(10);
		
		btnAdd = new JButton("Add");
		btnDel = new JButton("Del");
	}
	private void setDisplay(){
		JPanel pnlCenter = new JPanel();
		JScrollPane scroll = new JScrollPane(list);
		pnlCenter.add(scroll);
		
		JPanel pnlSouth = new JPanel(new GridLayout(1,0));
		pnlSouth.add(btnAdd);
		pnlSouth.add(btnDel);
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners(){
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
	}
	private void showFrame(){
		setTitle("ListEx");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnAdd){
			String data = JOptionPane.showInputDialog(
				this, "Input your Item"
			);
			model.addElement(data);
		}else{
			int idx = list.getSelectedIndex();
			if(idx >=0){//선택된게 없으면 오류가 뜰수 있다
				model.remove(idx);
			}
		}
		
	}
	public static void main(String[] args) {
		new ListStep4();
	}
	
}
```
<img src="https://postfiles.pstatic.net/MjAyMjA2MTNfOTgg/MDAxNjU1MTI1MDU4MTU1.hqfk0bCcVWGpiC4O3ZuZLjNqBZgXlDAyZH6xHDSz4qog.QgjOFGE9R9FflpIhuRNaWk_w0_hT9Kk3hJnR_VDb0LIg.PNG.forget980/image.png?type=w580" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://postfiles.pstatic.net/MjAyMjA2MTNfMTQy/MDAxNjU1MTI1MDE1MzE3.t7bDeG2URsi5w9HZur6NQn8MDbwScQmE0FRI2dl63rYg.4Cmv7wfJ6IKnuUyV6pwKJa3ffQrsgmxepEQkEGx6UUog.PNG.forget980/image.png?type=w580" width="30%" height="20%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class ListUsingMouse extends JFrame{
	private JList<String> list;
	public ListUsingMouse(){
		list = new JList<String>(new String[] {"a","b","c"});
		list.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxx");
		list.setVisibleRowCount(10);
		JScrollPane scroll = new JScrollPane(list);
		
		add(scroll, BorderLayout.CENTER);
		
		list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent me) {
				Rectangle r = list.getCellBounds(//시작 인덱스 끝 인덱스  크기와 위지를 알려준다
					//Rectangle 위치와 크기 좌표 가져온다
					list.getLastVisibleIndex(),//제일 끝 인덱스
					list.getLastVisibleIndex()
				);
				int listY = r.y + r.height;//마지막 인덱스까지 높이
				int mouseY = me.getY();
				if(mouseY > listY){
					System.out.println("out");
				}else{
					System.out.println("in");
				}
			}
		});
		
		setTitle("MouseTest");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ListUsingMouse();
	}
}

```
<img src="https://postfiles.pstatic.net/MjAyMjA2MTNfMjkw/MDAxNjU1MTMwNjU0Mjg0.YuzYj-ehTR3xhERMcR6DLB1K4wRZMutkjzbHTQn5-cwg.5UGIwR1nwzvJfv1mSPPuhKtuqxwu8sny7lupZWukoMQg.PNG.forget980/image.png?type=w580" width="30%" height="20%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```java
public class MyList extends JFrame {
	
	private JList<Human> list;
	
	public MyList(){
		list = new JList<Human>(new Human[]{
			new Human("A", 15, false),
			new Human("B", 16, true),
			new Human("C", 18, false),
			new Human("D", 17, true)
		});
		
		list.setPrototypeCellValue(new Human("aaaaaaaaaaaaaaaaaa",100,true));
		list.setVisibleRowCount(3);
		
		add(new JScrollPane(list));
		
		list.setCellRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(
				JList list,
				Object value,
				int idx,
				boolean isSelected,
				boolean cellHasFocus
			){
				JPanel pnl = new JPanel();
				
				Human h = (Human)value;
				JLabel lblIcon = new JLabel();
				ImageIcon icon;
				if(h.isGender()){
					icon = new ImageIcon("Male-icon.png");
				}else{
					icon = new ImageIcon("Female-icon.png");
				}
				lblIcon.setIcon(icon);
				JLabel lblInfo = new JLabel(h.getName() + "("+h.getAge()+")");
				pnl.add(lblIcon);
				pnl.add(lblInfo);
				
				if(isSelected){
					pnl.setBackground(Color.GREEN);
				}
				if(cellHasFocus){
					pnl.setBackground(Color.YELLOW);
				}
				
				return pnl;
			}
		});
		
		setTitle("MyList");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyList();
	}
}

public class Human{
	private String name;
	private  transient int age;//직렬화에서 소거
	private boolean gender;
	private OptionalInfo info;
	

	public Human(String name, int age, boolean gender, OptionalInfo info) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.info = info;
	}

	public Human(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public OptionalInfo getInfo() {
		return info;
	}
	
	public void setInfo(OptionalInfo info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender + ", info=" + info + "]";
	}

	
	
}

```
<img src="https://postfiles.pstatic.net/MjAyMjA2MTNfMTgg/MDAxNjU1MTMwODg3MjUz.vWTWvA-N1ILR2HNmTGq4-Gy1MDiDxnMUC2Nr4nPH424g.907RM7av1CUwd0by3ZGS3_XwwF7GUoX6fWPp3RkM41Ig.PNG.forget980/image.png?type=w580" width="30%" height="20%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
