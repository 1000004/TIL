import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
//import static kr.ac.green.IOUtil.*; 
//kr.ac.green.IOUtil에 포함된 static 변수 메소드를 IOUtil 없이 쓸 수 있다.
//static 메소드인지 확인 어렵다


//객체 write read
//ObjectInputStrream
//ObjectOutputStream
public class SerializationEx1 {
	
	public static void write(){
		Human h1 = new Human("춘식1", 2, false);
		Human h2 = new Human("춘식2", 4, true);
		Human h3 = new Human("춘식3", 6, false);
		Human h4 = new Human("춘식4", 3, true);
		Human h5 = new Human("춘식5", 2, false);
		
		Human[] arr = {h1, h2, h3, h4, h5};
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			//한파일에 한 객체만 넣는다.
			//한파일에 두번 읽게 만들면 안된다 
			//객제를 바이트 단위로 쪼개서 file에 저장하고 바이트 단위로 읽어온다 
			//(marshalling/ub-Marshalling : 컴퓨팅 언어)
			//자바 : 객체 직렬화(serialization)
			
			//NotSerializableException : Serializable 구현을 안하면 오류
			//복수 데이터를 다루는 경우 원소도 Serializable를 구현해야 한다.
			//객체가 가지는 모든 멤버 객체 구성에 Serializable을 구현해야 한다.
			fos = new FileOutputStream("friends.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(arr);
			oos.flush();
			oos.reset();
			//arr에 대해 cg가 작동 안함 for문으로 write하는 경우 객체가 변경 안된체로 반복 쓰여진다
			//오작동 방지 reset()
			//write했던 Object 정보를 지워야 cg가 작동 반복 쓰기 경우 object 변경
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(oos, fos);
		}
	}
	
	public static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream("friends.dat");
			ois = new ObjectInputStream(fis);
			
			Human[] arr = (Human[])ois.readObject();
			System.out.println(Arrays.toString(arr));
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			//InvalidClassException serialVersionUID가 다르다
			//객체는 멤버변수와 메서드 구성
			//mydata.dat 파일안에 정보는 멤버변수 값만 들어간다.
			//메소드는 변경되지 않는다.
			//readObject 할때 Human 클래스 파일이 필요
			//Human 클래스에서 생성자 메서드 멤버변수 종류 객수 가져온다.
			//반드시 writeObject 시점의 Human 클래스 파일이 필요
			//The serializable class Human does not declare a static final serialVersionUID field of type long
			//serializable class 이면서 a static final serialVersionUID field of type이 없다(경고)
			//저장시 클래스파일과  읽을때 클래스 파일이 동일해야 한다.(구분기준 SerialVersionUID)
			//버전이 안맞으면 오류 version이다르면 실패 같으면 살려내진다
			//SerialVersionUID 관리 (1)부여 : 라이트를 호출하여 저장 할때 멤버변수는 그대로 있어야 한다.(주위 버전관리 실수 - 저장한 data 의미 없고 살려내지 못한다.)
			//(2) 부여x : 컴파일러가 매번 바꾼다 (부여한는 것이 정석)
			//version이다르면 실패 같으면 살려내진다
			
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(ois, fis);
		}
	}
	
	public static void main(String[] args) {
		//write();
		read();
	}
}


