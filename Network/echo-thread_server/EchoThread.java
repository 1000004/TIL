public class EchoThread extends Thread {
	private Socket sock;
	public EchoThread(Socket sock){
		this.sock = sock;
	}//생성자
	public void run(){
		OutputStream out = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null;
		
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			InetAddress inetaddr = sock.getInetAddress();//아이피를 나타내는 객체(클라이언트 ip)
			System.out.println(
				inetaddr.getHostAddress()+" 로 부터 접속하였습니다.");
			out = sock.getOutputStream();//소켓 읽고 쓰기
			//바이트 쓰기 chr -> byte
			in = sock.getInputStream();
			osw = new OutputStreamWriter(out);
			pw = new PrintWriter(osw);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String line = null;
			while((line = br.readLine())!=null){//읽을게 있을때 까지 대기
				System.out.println(
					"클라이언트로 부터 전송받은 문자열 : "+line);
				pw.println(line);
				pw.flush();
			}
		} catch (Exception ex) {
			System.out.println("thread : "+ ex);
		}finally{
			MyUtils.closeAll(br, isr, in, pw, osw, out, sock);
		}
	}//run
}
