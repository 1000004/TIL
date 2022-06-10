public class SettingProperties extends JFrame{
	public SettingProperties(){
		Properties prop = new Properties();
		FileInputStream fis = null;//reader를 사용 해도 되지만 권장x
		try {
			fis  = new FileInputStream("myFrame_setting.properties");
			prop.load(fis);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
				this,
				"설정을 불러오던 도중 문제가 발생했습니다. 프로그램을 종료합니다.",
				"심각",
				JOptionPane.ERROR_MESSAGE
			);
			System.exit(-1);
		}finally{
			IOUtil.closeAll(fis);
		}
		//Container c = getContentPane();
		//c.setBackground(new Color(Integer.parseInt(prop.getProperty("bgColor"))));
		setTitle(prop.getProperty("title"));
		setSize(
			Integer.parseInt(prop.getProperty("width")),
			Integer.parseInt(prop.getProperty("height"))
		);
		setLocation(
			Integer.parseInt(prop.getProperty("x")),
			Integer.parseInt(prop.getProperty("y"))
		);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
