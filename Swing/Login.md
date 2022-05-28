```java
public class Login extends JFrame{
	HashMap<String, AccountInfo> map = new HashMap<String, AccountInfo>();
	private JLabel lblId;
	private JLabel lblPw;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JButton btnLogin;
	private JButton btnJoin;
	
	public static final int NORMAL_EXIT = 0;

	public Login(){
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init(){
		lblId = new JLabel("ID");
		lblId.setPreferredSize(new Dimension(80, 18));
		lblPw = new JLabel("Password");
		lblPw.setPreferredSize(new Dimension(80, 18));
		tfId = new JTextField(10);
		tfPw = new JPasswordField(10);
		tfPw.setEchoChar('*');
		btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(85, 25));
		btnJoin = new JButton("Join");
		btnJoin.setPreferredSize(new Dimension(85, 25));
	}
	private void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		
		JPanel pnlId = new JPanel();
		pnlId.add(lblId);
		pnlId.add(tfId);
		pnlCenter.add(pnlId);
		
		JPanel pnlPw = new JPanel();
		pnlPw.add(lblPw);
		pnlPw.add(tfPw);
		pnlCenter.add(pnlPw);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnJoin);
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(5,5,5,15));
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		add(pnlMain);
		
	}
	private void addListeners(){
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
				
				int choice = JOptionPane.showConfirmDialog(
					Login.this,
					"exit?",
					"question",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE
				);
				if(choice == JOptionPane.YES_OPTION){
					System.exit(NORMAL_EXIT);
				}
			}
		});
		btnLogin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				String id = tfId.getText();
				String pw = String.valueOf(tfPw.getPassword());
				
				id = id.trim();
				pw = pw.trim();
				if(id.length() == 0){
					JOptionPane.showMessageDialog(
							Login.this, "input your ID", "information", JOptionPane.INFORMATION_MESSAGE
					);
					tfId.requestFocus();
				}else if(pw.length() == 0){
					JOptionPane.showMessageDialog(
							Login.this, "input your password", "information", JOptionPane.INFORMATION_MESSAGE
					);
					tfId.requestFocus();
				}else{
					if(map.containsKey(id)){
						boolean flag = map.get(id).equals(new AccountInfo(id, pw));
						if(flag){
							JOptionPane.showMessageDialog(
									Login.this, 
									"welcome!!",
									"information",
									JOptionPane.INFORMATION_MESSAGE
								);
							setVisible(false);
							new InformationForm(Login.this);
						}else{
							JOptionPane.showMessageDialog(
								Login.this, 
								"check your password",
								"information",
								JOptionPane.INFORMATION_MESSAGE
								);
							tfPw.requestFocus();
						}
					}else{
						JOptionPane.showMessageDialog(
							Login.this, 
							"check your ID",
							"information",
							JOptionPane.INFORMATION_MESSAGE
						);
						tfId.requestFocus();
					}
				}
			}
		});
		btnJoin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				new JoinForm(Login.this);
			}
		});
	}
	private void showFrame(){
		setTitle("Login");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	public void join(String id, AccountInfo accountInfo){
		map.put(id,accountInfo);
	}
	public void withdraw(){
		map.remove(tfId.getText());
	}
	public boolean exists(String id){
		return map.containsKey(id);
	}
	public String getInfo(){
		AccountInfo accountInfo = map.get(tfId.getText());
		return accountInfo.toString();
	}
	public boolean matchPassword(String pw){
		return pw.equals(String.valueOf(tfPw.getPassword()));
	}
	public void inputClear(){
		tfId.setText(null);
		tfPw.setText(null);
	}
}

package kr.ac.green;

public class LoginInfo {
	private String id;
	private String pw;
	public LoginInfo(String id, String pw){
		setId(id);
		setPw(pw);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString(){
		return "<<id님의 회원정보>>\n";
	}

	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof LoginInfo)){
			return false;
		}
		LoginInfo temp = (LoginInfo)o;
		return getId().equals(temp)&&getPw().equals(temp);
	}
	@Override
	public int hashCode(){
		return  Integer.parseInt(getId())% 4;
	}
}

public class JoinForm extends JDialog{
	private String[] informs = {"ID","Password","Retry","Name","NickName"};
	private JLabel[] lblInforms;
	private JTextField[] tfs;
	private JRadioButton rbtnM;
	private JRadioButton rbtnF;
	private JButton btnJoin;
	private JButton btnCancel;

	private Login owner;
	
	public JoinForm(Login owner){
		super(owner, "JoinForm",true);
		this.owner = owner;
		owner.setVisible(false);
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	public void init(){
		lblInforms = new JLabel[informs.length];
		tfs = new JTextField[informs.length];
		for(int i=0;i<lblInforms.length;i++){
			lblInforms[i] = new JLabel(informs[i]);
			lblInforms[i].setPreferredSize(new Dimension(80, 18));
			if(i==1||i==2){
				tfs[i] = new JPasswordField(10);
			}else{
				tfs[i] = new JTextField(10);
			}
		}
		rbtnM = new JRadioButton("Male",true);
		rbtnF = new JRadioButton("Female");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnM);
		group.add(rbtnF);
		
		btnJoin = new JButton("Join");
		btnJoin.setPreferredSize(new Dimension(100, 25));
		btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(100, 25));
	}
	public void setDisplay(){
		JPanel pnlCenter = new JPanel(new GridLayout(0,1));
		pnlCenter.setBorder(new EmptyBorder(0,10,5,10));
		JPanel pnlNorth = new JPanel(new GridLayout(0,1));
		pnlNorth.setBorder(new EmptyBorder(0,10,5,10));
		pnlNorth.add(new JLabel("-Input your information"));
		//pnlCenter.add(new JLabel("-Input your information"));
		JPanel[] pnls = new JPanel[informs.length];
		for(int i=0;i<pnls.length;i++){
			pnls[i] = new JPanel();
			pnls[i].add(lblInforms[i]);
			pnls[i].add(tfs[i]);
			pnlCenter.add(pnls[i]);
		}
		
		JPanel pnlSouth = new JPanel(new BorderLayout());
		JPanel pnlRbtn = new JPanel();
		TitledBorder border = new TitledBorder("Gender");
		pnlSouth.setBorder(new EmptyBorder(0,10,5,10));
		pnlRbtn.setBorder(border);
		pnlRbtn.add(rbtnM);
		pnlRbtn.add(rbtnF);
		pnlSouth.add(pnlRbtn,BorderLayout.CENTER);
		JPanel pnlbtn = new JPanel();
		pnlbtn.add(btnJoin);
		pnlbtn.add(btnCancel);
		pnlSouth.add(pnlbtn, BorderLayout.SOUTH);
		
		add(pnlSouth,BorderLayout.SOUTH);
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
	}
	public void addListeners(){
		btnJoin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				int i = 0;
				boolean flag = true;
				String[] infos = new String[informs.length];
				while(i<informs.length&&flag){
					String info = null;
					if(i==1||i==2){
						JPasswordField tf = (JPasswordField)tfs[i];
						info = String.valueOf(tf.getPassword());
					}else{
						info = tfs[i].getText();
					}
					infos[i] = info.trim();
					if(infos[i].length() == 0){
						flag = false;
					}
					i++;
				}
				if(i==informs.length){
					if(infos[1].equals(infos[2])){	
						if(owner.exists(infos[0])){
							JOptionPane.showMessageDialog(
								JoinForm.this,
								"invalid ID : already existed",
								"information",
								JOptionPane.INFORMATION_MESSAGE
							);
							tfs[0].requestFocus();
						}else{
								owner.join(infos[0], new AccountInfo(infos[0],infos[1],infos[3],infos[4],rbtnM.isSelected()));
								owner.inputClear();
								owner.setVisible(true);
								JOptionPane.showMessageDialog(
									JoinForm.this, 
									"Join OK",
									"information",
									JOptionPane.INFORMATION_MESSAGE
								);
								dispose();
						}
					}else{
						JOptionPane.showMessageDialog(
							JoinForm.this, 
							"check your password",
							"information",
							JOptionPane.INFORMATION_MESSAGE
						);
					}
				}else{
					i--;
					JOptionPane.showMessageDialog(
						JoinForm.this, 
						"missing input : "+lblInforms[i].getText(),
						"information",
						JOptionPane.INFORMATION_MESSAGE
					);
					tfs[i].requestFocus();
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				owner.inputClear();
				owner.setVisible(true);
				dispose();
			}
		});
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
				owner.inputClear();
				owner.setVisible(true);
				dispose();
			}
		});
	}
	public void showFrame(){
		setTitle("JoinForm");
		pack();
		setLocationRelativeTo(owner);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
}

public class AccountInfo {
	private String id;
	private String pw;
	private String name;
	private String nickName;
	private boolean gender;
	
	public AccountInfo(String id,String pw){
		setId(id);
		setPw(pw);
	}
	
	public AccountInfo(String id, String pw, String name, String nickName, boolean gender) {
		setPw(pw);
		setName(name);
		setNickName(nickName);
		setGender(gender);
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString(){
		String info = "<<"+id+"님의 회원정보>>\n";
		info += "-name : "+name+"\n";
		info += "-password : ????\n";
		info += "-nickname : "+nickName+"\n";
		info += "-nickname : "+(isGender()?"male":"female");
		return info;
	}

	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof AccountInfo)){
			return false;
		}
		AccountInfo temp = (AccountInfo)o;
		return getId().equals(temp.getId())&&getPw().equals(temp.getPw());
	}

}
```
