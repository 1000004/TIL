public class IOEx1 {
	private static String fileName = "test.dat";//확장자 dat
	//복잡한 연산을 하는 stream은 byte 이용
	public static void write(){
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try{
			fos = new FileOutputStream(fileName);
			//편집기로 확인 불가능하고 따로 구분할 필요없다
			//읽기 위해 만들어진 파일이 아닌다
			dos = new DataOutputStream(fos);
			
			dos.writeInt(100);
			dos.writeInt(99);
			dos.writeBoolean(false);
			dos.writeUTF("abc");//문자열
			dos.writeUTF("mbc\nsbs");
			dos.writeUTF("이거슨 한글");
			
			dos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(dos, fos);
		}
	}
	public static void read(){
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try{
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			
			int num1 = dis.readInt();
			int num2 = dis.readInt();
			boolean flag = dis.readBoolean();
			String str1 = dis.readUTF();
			String str2 = dis.readUTF();
			String str3 = dis.readUTF();
			
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(flag);
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(str3);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(dis, fis);
		}
	}
	public static void main(String[] args) {
		write();
		read();
	}
}
