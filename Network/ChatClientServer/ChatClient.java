public class ChatClient {
	private Socket sock;
	private BufferedReader br;
	private PrintWriter pw;
	public ChatClient(){
		String ip = JOptionPane.showInputDialog("접속할 IP를 입력하세요");
		String id = JOptionPane.showInputDialog("사용할 ID를 입력하세요");
		if(ip.length() ==0 || id.length() == 0){
			System.out.println(
				"IP와 ID를 제대로 입력하지 않아 프로그램을 종료합니다.");
			System.exit(-1);
		}
		try {
			sock = new Socket(ip, 10001);
			pw = new PrintWriter(
				new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(
				new InputStreamReader(sock.getInputStream()));
			BufferedReader keyboard = new BufferedReader(
				new InputStreamReader(System.in)	
			);
			
			//사용자의 id를 전송한다
			pw.println(id);
			pw.flush();
			new Thread(){
				public void run(){
					try{
						//사용자 메세지 읽기
						String line = null;
						while((line = br.readLine())!=null){
							if((line.equals("/quit"))){
								//*중요한 파트
								//Client는 Server에게 종료하겠다는 통보하고 sever에서 허가해야 종료할 수 있다
								//Client는 임의로 프로그램 종료가 불가능하다
								//Client 상태 변경이 서버에 접속한 모든 Client가 알고 있어야 한다
								//hm(공유자원) 정보가 올바르게 유지되어야 한다
								//상태 변경을 sever 스레드가 관리(공유중)??
								throw new Exception();
							}
							System.out.println(line);
						}
					}catch(Exception e){
						System.out.println(e);
					}finally{
					}
				}
			}.start();
			String line = null;
			//키보드 입력 읽기
			// /quit
			while((line = keyboard.readLine())!=null){
				pw.println(line);
				pw.flush();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			exit();
		}//finally
	}
	private void exit(){
		try {
			if(pw != null){
				pw.close();
			}
		} catch (Exception e){}
		try {
			if(br != null)
				br.close();
		} catch (Exception e){}
		try{
			if(sock != null)
				sock.close();
		}catch(Exception e){}
		System.out.println("클라이언트의 접속을 종료합니다.");
		System.exit(0);
	}
	public static void main(String[] args) {
		new ChatClient();
	}//main
}//class
