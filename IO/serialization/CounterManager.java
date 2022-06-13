/*
 * UI저장하지 말것
 * 값만 저장 
 * Component 저장x
 * 이벤터 처리가 안될 수 있다
 */
public class CounterManager extends JFrame {
	private Counter1 counter;
	public CounterManager(){

		JButton btnSave = new JButton("Save");
		JButton btnNew = new JButton("New");
		JButton btnLoad = new JButton("Load");
		
		ActionListener aListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if(src == btnSave){
					if(counter != null){
						try(
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("frame.dat"));
						){
							oos.writeObject(counter);
							oos.flush();
							oos.reset();
							
							counter.dispose();
							counter = null;
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}else if(src == btnNew){
					if(counter == null){
						counter = new Counter1();
					}
				}else{
					if(counter == null){
						try(
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream("frame.dat"));
						){
							counter = (Counter1)ois.readObject();
							counter.setVisible(true);
							//멤버변수만 저장됨
							//UI는 저장하면 안된다 오류 가능성 UI 저장된 정보만 저장
						}catch(IOException e){
							e.printStackTrace();
						}catch(ClassNotFoundException e){
							e.printStackTrace();
						}
					}
				}
				
			}
		};
		btnSave.addActionListener(aListener);
		btnNew.addActionListener(aListener);
		btnLoad.addActionListener(aListener);
		
		setLayout(new FlowLayout());
		add(btnNew);
		add(btnSave);
		add(btnLoad);
		
		setTitle("Counter Manager");
		setLocationRelativeTo(null);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CounterManager();
	}
}
