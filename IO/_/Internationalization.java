public class Internationalization extends JFrame{
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miOpen;
	private JMenuItem miExit;
	
	private JPopupMenu pMenu;
	private JRadioButtonMenuItem rmiKorean;
	private JRadioButtonMenuItem rmiEmglish;
	
	private JLabel lblMain;
	private JLabel lblStatus;
	
	public static final int KOR = 0;
	public static final int ENG = 1;
	
	private Properties[] propArr;
	
	private String[] languages = {"korean", "english"};
	
	private int currentLang = KOR;
	
	public Internationalization(){
		propArr = new Properties[languages.length];
		for(int idx=0; idx<languages.length; idx++){
			loadLangPack(idx);
		}
		init();
		setDisplay();
		addListeners();
		showFrame();
		
	}
	private void loadLangPack(int lang){
		FileReader fr = null;
		try {
			fr = new FileReader(languages[lang]+".properties");
			propArr[lang] = new Properties();
			propArr[lang].load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fr !=null){
				try{
					fr.close();
				}catch(IOException e){}
			}
		}
	}
	private void init(){
		mBar = new JMenuBar();
		mFile = new JMenu();
		miExit = new JMenuItem();
		
		mFile.add(miOpen);
		mFile.addSeparator();
		mFile.add(miExit);
		
		mBar.add(mFile);
		
		pMenu = new JPopupMenu();
		
		rmiKorean = new JRadioButtonMenuItem("한국어",true);
		rmiEmglish = new JRadioButtonMenuItem("Englis");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rmiEmglish);
		group.add(rmiKorean);
		
		pMenu.add(rmiKorean);
		pMenu.add(rmiEmglish);
		
		lblMain = new JLabel();
		lblMain.setHorizontalAlignment(JLabel.CENTER);
		lblStatus = new JLabel();
		
		setLanguage(currentLang);
		
	}
	private void setDisplay(){
		setJMenuBar(mBar);
		add(lblMain, BorderLayout.CENTER);
		add(lblStatus, BorderLayout.SOUTH);
	}
	private void addListeners(){
		lblMain.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent me){
				showPopup(me);
			}
			@Override
			public void mouseReleased(MouseEvent me){
				showPopup(me);
			}
			
		});
		ItemListener iListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent ie) {
				if(ie.getStateChange() == ItemEvent.SELECTED){
					if(ie.getSource() == rmiKorean){
						currentLang = KOR;
					}else{
						currentLang = ENG;
					}
				}
				setLanguage(currentLang);
				
			}
		};
		rmiKorean.addItemListener(iListener);
		rmiEmglish.addItemListener(iListener);
	}
	private void showPopup(MouseEvent me){
		if(me.isPopupTrigger()){
			pMenu.show(lblMain, me.getX(), me.getY());
		}
	}
	private void showFrame(){
		setTitle("International System Demo");
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void setLanguage(int lang){
		Properties prop = propArr[lang];
		
		mFile.setText(prop.getProperty("MainForm.fileMenu"));
		lblMain.setText(prop.getProperty("MainForm.label"));
		miOpen.setText(prop.getProperty("MainForm.open"));
		miExit.setText(prop.getProperty("MainForm.exit"));
		lblStatus.setText(prop.getProperty("MainForm.status"));
	}
	public static void main(String[] args) {
		new Internationalization();
	}
}
