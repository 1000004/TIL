public class PagingEx extends JFrame{
	private JList<Human> list;
	private Vector<Human> data;
	private DefaultListModel<Human> model;
	
	private VectorPaging<Human> vp;
	
	private JComboBox<String> cBox;
	private JButton btnPre;
	private JButton btnNext;
	private int currentPage = 1;
	
	public PagingEx(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	public void init(){
		/*
		 * Test data
		 */
		data = new Vector<Human>();
		data.add(new Human("에일리", 28, "여"));
		data.add(new Human("윤아", 28, "여"));
		data.add(new Human("몰라", 30, "남"));
		data.add(new Human("흥부", 41, "남"));
		data.add(new Human("놀부", 44, "남"));
		data.add(new Human("홍련", 18, "여"));
		data.add(new Human("장화", 20, "여"));
		
		model = new DefaultListModel<Human>();
		vp = new VectorPaging<Human>(data);
		list = new JList<Human>(model);
		list.setPrototypeCellValue(new Human("aaaaaaaa",100,""));
		list.setVisibleRowCount(vp.getPerPage());
		setListData();
		
		btnPre = new JButton("<");
		btnNext = new JButton(">");
		
		cBox = new JComboBox<String>();
		cBox.setPrototypeDisplayValue("xxxxxxxxxxxxxxx");
		setPages();
	}
	private void setListData() {
		List<Human> humanList = vp.getList(currentPage);
		model.removeAllElements();
		for(Human h : humanList){
			model.addElement(h);
		}
	}
	private void setPages(){
		//cBox.removeAllItems();
		int count = vp.getTotalPageCount();
		for(int i=1; i<=count; i++){
			cBox.addItem(String.valueOf(i));//콤보박스에 추가
		}
	}
	private void setDisplay(){
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnPre);
		pnlSouth.add(cBox);
		pnlSouth.add(btnNext);
		
		add(new JScrollPane(list), BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners(){
		ActionListener aListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if(src == btnPre){
					currentPage--;
					if(currentPage == 0){
						currentPage = 1;
						JOptionPane.showMessageDialog(
							PagingEx.this, "첫페이지 입니다."
						);
					}else{
						setListData();
					}
				}else{
					currentPage++;
					int last = Integer.parseInt(
						cBox.getItemAt(cBox.getItemCount()-1)	
					);
					if(currentPage > last){
						JOptionPane.showMessageDialog(
							PagingEx.this,
							"마지막페이지 입니다."
						);
						currentPage--;
					}else{
						setListData();
					}
				}
				cBox.setSelectedIndex(currentPage-1);
			}
		};
		btnNext.addActionListener(aListener);
		btnPre.addActionListener(aListener);
		
		cBox.addItemListener(new ItemListener() {//ItemListener cBox cb rbtn
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					currentPage = Integer.parseInt(
						cBox.getSelectedItem().toString()
					);
					setListData();
				}
			}
		});
	}
	private void showFrame(){
		setTitle("PagingEx");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PagingEx();
	}
}
