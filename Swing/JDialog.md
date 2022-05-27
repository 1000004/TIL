## JDialog
* 기본적인 창이 있고 새로운 창이 뜰때 사용자가 새로운 창을 통해 선택 또는 입력또는 바꾸면 기본창에 정보를 전달
* 정보를 전달하기 위해서는 기본적인 창의 정보를 새로 뜬 창이 알고 있어야 한다.
* JFrame 을 써도 되지만 JDialog가 최적화 - JDialog는 생성자에서 기본창을 owner 개념을 가지고 생성된다.
* JDialog가 JDialog를 가질 수 있다
* JFrame과 비슷하게 Base-container로 쓰임
* JOptionPane로 간단한 창이 아닌 복잡한 창 띄울때 JDialog
* 모달속성을 가진다
* 상단에 밑으로 내리거나 최대창 최소창 버튼이 없다.
```java
public class Ex1 extends JFrame{

	private JButton btnOpen;
	private JLabel lblName;
	
	public Ex1(){
		btnOpen = new JButton("open");
		lblName = new JLabel("Name",JLabel.CENTER);
		lblName.setFont(new Font(Font.DIALOG,Font.BOLD,30));
		
		add(lblName, BorderLayout.CENTER);
		add(btnOpen, BorderLayout.SOUTH);
		
		btnOpen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				new NameDialog(Ex1.this);
			}
		});
		
		setTitle("JDialog Ex");
		//Dialog 대화하다
		//새로운 창을 띄울때 JDialog 사용
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void setText(String text){
		lblName.setText(text);
	}
//	public String getText(){//외부에서 꺼내 정보를 볼수 있게 하면 안좋다.
//		return lblName.getText();
//	}
	public boolean exists(String name){//내부에서 처리
		return name.equals(lblName.getText());
	}
	public static void main(String[] args) {
		new Ex1();

	}

}
```
```java
public class NameDialog extends JDialog {
	private JTextField tfName;
	private JButton btnOk;
	private JButton btnCancel;
	private Ex1 owner;
	
	private String cancelMsg = "취소 되었습니다.";
	public NameDialog(Ex1 owner){
		super(owner, "이름을 입력하시오",true);//모달속성 true 
		//상단에 밑으로 내리거나 최대창 최소창 버튼이 없다
		//종료버튼만 있다.
		
		this.owner = owner;
		
		tfName = new JTextField(20);
		tfName.setActionCommand("inputName");
		btnOk = new JButton("OK");
		btnOk.setActionCommand("inputName");
		btnCancel = new JButton("Cancel");
		
		JPanel pnlName = new JPanel();
		pnlName.add(new JLabel("이름 : "));
		pnlName.add(tfName);
		
		JPanel pnlBtns = new JPanel(new GridLayout(1,2));
		pnlBtns.add(btnOk);
		pnlBtns.add(btnCancel);
		
		getContentPane().add(pnlName, BorderLayout.CENTER);
		add(pnlBtns, BorderLayout.SOUTH);
		
		ActionListener aListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				if(ae.getActionCommand().equals("inputName")){
					String name = tfName.getText();
					//tfName 입력 없이 getText() = 0
					name = name.trim();//tfName에 스페이스바만 입력하는 경우 공백제거
					if(name.length() == 0){
						JOptionPane.showMessageDialog(
								NameDialog.this, "이름을 입력하시오", "경고", JOptionPane.WARNING_MESSAGE
						);
						tfName.requestFocus();
					/*} else if(owner.getText().equals(tfName.getText())){//외부에서 값을 꺼내오지 마라
						JOptionPane.showMessageDialog(
								NameDialog.this, "이전 이름과 다른 이름을 입력하시오", "경고", JOptionPane.WARNING_MESSAGE
						);
						tfName.requestFocus();
					*/
					} else {
						if(owner.exists(name)){
							JOptionPane.showMessageDialog(
								NameDialog.this, 
								"동일한 이름은 입력할 수 없스니다.",
								"알림",
								JOptionPane.INFORMATION_MESSAGE
							);
							tfName.requestFocus();
							tfName.selectAll();
						}else{
							setText(name);
						}
					}
				}else{
					setText(cancelMsg);
				}
			}
		};
		btnOk.addActionListener(aListener);
		btnCancel.addActionListener(aListener);
		tfName.addActionListener(aListener);//입력하고 엔터를 치면 동작
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent ae){
				setText(cancelMsg);
			}
		});
		
		pack();
		setLocationRelativeTo(owner);
		//Frame owner 중앙에 위치
		//null 스크린 중앙
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//EXIT_ON_CLOSE는 프로그램 자체가 종료
		setVisible(true);
	}
	private void setText(String text){
		owner.setText(text);
		dispose();
	}
}
```
