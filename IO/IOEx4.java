public class IOEx3 extends JFrame{
	private JTextArea taOutput;
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miExit;
	
	private JFileChooser chooser;
	
	
	public IOEx3(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init(){
		taOutput = new JTextArea();
		taOutput.setLineWrap(true);
		taOutput.setWrapStyleWord(true);
		
		mBar = new JMenuBar();
		mFile = new JMenu("File");
		miOpen = new JMenuItem("Open");
		miSave = new JMenuItem("Save");
		miExit = new JMenuItem("Exit");
		
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miExit);
		
		mBar.add(mFile);
		setJMenuBar(mBar);
		
		chooser = new JFileChooser(".");
	}
	private void setDisplay(){
		add(new JScrollPane(taOutput),BorderLayout.CENTER);
	}
	private void addListeners(){
		ActionListener aListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if(src == miOpen){
					open();
				}else if(src == miSave){
					save();
				}else{
					closeWindow();
				}
				
			}
		};
		miOpen.addActionListener(aListener);
		miSave.addActionListener(aListener);
		miExit.addActionListener(aListener);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we){
				closeWindow();
			}
		});
		
		Document doc = taOutput.getDocument();//입력된 내용 관리
		doc.addDocumentListener(new DocumentListener() {//어댑터 없음 다 오버라이드
			
			@Override
			public void removeUpdate(DocumentEvent e) {//제거
				System.out.println("removeUpdate");
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {//추가
				System.out.println("insertUpdate");
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {//문서 속성 글꼴 변경?
				
			}
		});
	}
	private void showFrame(){
		setTitle("SimplePan ver0.9");
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	private void closeWindow(){
		System.exit(0);
	}
	private void open(){
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File f =chooser.getSelectedFile();
			
			FileReader fr = null;
			BufferedReader br = null;
			try{
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String line = null;
				StringBuffer sBuffer = new StringBuffer();
				while((line = br.readLine())!=null){
					sBuffer.append(line);
					sBuffer.append("\n");
				}
				taOutput.setText(sBuffer.toString());
			}catch(IOException e){
				showMessage("파일을 여는 도중 문제가 발생했습니다. 잠시후 다시 시도해주세요.");
			}finally{
				IOUtil.closeAll(br,fr);
			}
		}
	}
	private void save(){
		String data = taOutput.getText();
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File f  =chooser.getSelectedFile();
			FileWriter fw = null;
			//btye 파일크기 크면 버퍼를 써야하지만
			//
			try {
				fw = new FileWriter(f);
				fw.write(data);
				fw.flush();
			} catch (IOException e) {
				showMessage("저장중 문제가 발생했습니다. 잠시후 다시 시도해주세요.");
			}finally{
				IOUtil.closeAll(fw);
			}
		}
	}
	private void showMessage(String msg){
		JOptionPane.showMessageDialog(
				this,
				msg,
				"알림",
				JOptionPane.INFORMATION_MESSAGE
			);
	}
	public static void main(String[] args) {
		new IOEx3();
	}
}
