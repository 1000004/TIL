class SendData{
	public int code;
	public Object data;
}
class User{
	
}
public class Protocol {
	public static final int ID_CHECK = 100;
	public static final int QUIT = 200;
	public static final int JOIN = 300;
	private Vector<User> users = new Vector<User>();
	public void doit(){
		Socket sock = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(sock.getInputStream());
			SendData data = (SendData)ois.readObject();
			if(data.code == ID_CHECK){
				String id = (String)data.data;
				//id check
			}else if(data.code == QUIT){
				//종료 명령
			}else if(data.code==JOIN){
				users.add((User)data.data);
				//...
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
