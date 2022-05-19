 ```java
public class JFrameEx1 {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.setSize(200,200);//숫자의 의미는 픽셀(해상도에 따라 나눠짐)
		f.setLocation(300,300);//자바의 경우 왼쪽 위 귀퉁이가 0,0
		
		Dimension size = f.getSize();
		System.out.println(size.width);
		System.out.println(size.height);
		
		Point location = f.getLocation();
		System.out.println(location.x);
		System.out.println(location.y);
		/*
		 * EXIT_ON_CLOSE : JVM 종료
		 * DISPOSE_ON_CLOSE : 해당 창종료
		 * HIDE_ON_CLOSE : default
		 * DO_NOTHTING_ON_CLOSE
		 */
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
```

 ```java
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameEx2 {
	public static void main(String[] args){
		JFrame f = new JFrame();
		
		f.setTitle("?");//창의 Title 설정
		
		Dimension size = new Dimension(500,400); //사이즈 설정
		Point location = new Point(300, 200); //위치 설정
		
		f.setSize(size);//Dimension로 사이즈 설정
		f.setLocation(location);//Point로 위치 설정
		
		ImageIcon icon = new ImageIcon("icon.png");//창의 자바 아이콘 이미지를 다른 이미지로 변경
		Image img = icon.getImage();
		f.setIconImage(img);
		
		f.setResizable(false);//사이즈 병경 false
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
```


 ```java
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameEx3 {
	public static void goCenter(JFrame frame){//창을 화면 중간으로 띄우도록 설정 하는 메서드
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = frame.getSize();//화면크기를 가져온다
		
		int x = (screenSize.width-size.width)/2;
		int y = (screenSize.height-size.height)/2;
		
		frame.setLocation(x,y);
	}

	public static void main(String[] args) {
		/*
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screens = ge.getScreenDevices();
		
		JFrame f = new JFrame(screens[1].getDefaultConfiguration());
		*/
		JFrame f = new JFrame();
		f.setSize(400,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// f.setLocation(200,200);
		//goCenter(f);
		f.setLocationRelativeTo(null);//화면 중간에 창을 띄워준다
		//전체화면
		//사이즈/위치 설정하고 전체화면 사용
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
	}

}
```


 ```java
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameEx2 {
	public static void main(String[] args){
		JFrame f = new JFrame();
		
		f.setTitle("?");//창의 Title 설정
		
		Dimension size = new Dimension(500,400); //사이즈 설정
		Point location = new Point(300, 200); //위치 설정
		
		f.setSize(size);//Dimension로 사이즈 설정
		f.setLocation(location);//Point로 위치 설정
		
		ImageIcon icon = new ImageIcon("icon.png");//창의 자바 아이콘 이미지를 다른 이미지로 변경
		Image img = icon.getImage();
		f.setIconImage(img);
		
		f.setResizable(false);//사이즈 병경 false
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
```

