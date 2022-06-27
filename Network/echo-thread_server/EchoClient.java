public class EchoClient {
	public static void main(String[] args) {		
		Socket sock = null;
		
		OutputStream out = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null;
		
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		BufferedReader keyboard = null;
		InputStreamReader keyIsr = null;
		try{
			//소켓이 생성 : 접속했음.
			//server 정보(추상화)
			sock = new Socket("127.0.0.1",10001);
			//"127.0.0.1" 자기 자신을 나타내는 아이피 local this 자신의 IP 접속 (실제 아이피 다르다)
			//내부 아이피 vs 외부 아이피
			//동일한 이터넷 선을 통해 연결되는 디바이스는 내부 아이피로 접근가능
			//외부에서 접근x 내부망
			//같은 내부망에서 연결 가능
			keyIsr = new InputStreamReader(System.in);
			keyboard = new BufferedReader(keyIsr);
			
			out = sock.getOutputStream();
			in = sock.getInputStream();
			osw = new OutputStreamWriter(out);
			pw = new PrintWriter(osw);
			
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String line = null;
			//1. 키보드입력이 있을때까지 대기
			while((line = keyboard.readLine())!=null){
				if(line.equals("quit"))break;
				pw.println(line);
				pw.flush();
				//2. 서버로 부터 전송 대기
				String echo = br.readLine();
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			MyUtils.closeAll(
				keyboard, keyIsr, br, isr, in, pw, osw, out, sock
			);
		}
	}//main
}

