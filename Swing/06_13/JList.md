```java
public class ListStep1 extends JFrame{
	private JList<String> list;
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
