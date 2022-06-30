public class CardLayoutEx extends JFrame implements ItemListener{
	//layout 매니저
	//씬을 모두 만들어놓고 선택한 씬을 보여준다
	private static char code = 'A';
	private JPanel pnlMain;
	private CardLayout card;
	
	//각 카드의 이름
	private String[] scenes = {"first", "second", " third"};
	private JComboBox cbScenes;
	
	public CardLayoutEx(){
		card = new CardLayout();
		//CardLayout으로 설정
		pnlMain = new JPanel(card);
		for(int i=0; i<scenes.length; i++){
			//add(카드, 카드식별자)
			pnlMain.add(getPanel(), scenes[i]);//CardLayout 추가 할때 이름을 넣는다
		}
		cbScenes = new JComboBox(scenes);
		cbScenes.addItemListener(this);
		
		add(pnlMain, BorderLayout.CENTER);
		add(cbScenes, BorderLayout.SOUTH);
		
		setTitle("CardLayout Ex");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private static JPanel getPanel(){
		JPanel pnl = new JPanel(new BorderLayout());
		JLabel lbl = new JLabel(String.valueOf(code), JLabel.CENTER);
		lbl.setFont(new Font(Font.SERIF, Font.BOLD, 60));
		pnl.add(lbl, BorderLayout.CENTER);
		code++;
		return pnl;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String name = cbScenes.getSelectedItem().toString();
		//name을 식별자로 가지는 카드를 보여준다.
		card.show(pnlMain, name);	//	name을 가진 pnl을 보여준다
	}
	public static void main(String[] args) {
		new CardLayoutEx();
	}
	
	
}
