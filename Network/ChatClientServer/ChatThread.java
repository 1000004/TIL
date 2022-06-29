public class ChatThread extends Thread{
	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap<String, PrintWriter> hm;
	
	public ChatThread(Socket sock, HashMap<String, PrintWriter> hm){
		this.sock = sock;
		this.hm = hm;
		try {
			PrintWriter pw = 
				new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			br = new BufferedReader(
				new InputStreamReader(sock.getInputStream())	
			);
			id = br.readLine();
			broadcast(id + "님이 접속하였습니다.");
			System.out.println("접속한 사용자의 아이디는 "+id+"입니다.");
			synchronized(hm){
				hm.put(id, pw);//Socket을 넣으면 매번 stream을 만들어야 한다.
				//모든 Thread가 공유
			}
		}catch (Exception ex){
			System.out.println("server thread constructor : " + ex);//
		}
	}//생성자
	public void run(){
		try {
			String line = null;
			while((line = br.readLine())!=null){
				if(line.equals("/quit"))
					break;
				if(line.indexOf("/to ")==0){
					sendmsg(line);
				}else{
					broadcast(id+":"+line);
				}
				
			}
		} catch (Exception ex) {
			System.out.println("server thread run : "+ex);
		}finally{
			synchronized (hm) {
				PrintWriter pw = hm.remove(id);
				pw.println("/quit");
				pw.flush();
			}
			broadcast(id+" 님이 접속 종료하였습니다.");
			try{
				if(sock != null){
					sock.close();
					//API 소켓을 닫으면 소켓에서 관련 stream 닫친다
					//의도한 대로 동작을 안할 수 있다 -> 각각 close
				}
			}catch(Exception ex){}
		}
	}//run
	
	//01234567890123
	// /to id message
	// /to doo hello
	public void sendmsg(String msg){
		int start = msg.indexOf(" ")+1;	//4
		int end = msg.indexOf(" ",start); //6
		if(end != -1){
			String to = msg.substring(start,end); //id
			String msg2 = msg.substring(end+1);	//message
			synchronized (hm) {
				PrintWriter pw = hm.get(to);
				if(pw != null){
					pw.println(id+" 님이 다음의 귓속말을 보내셨습니다. : "+msg2);
					pw.flush();
					
					pw = hm.get(id);
					pw.println(to + " 님께 다음의 귓속말을 보냈습니다 :"+msg2);
					pw.flush();
				}//if
			}
		}
	}//sendmsg
	public void broadcast(String msg){
		synchronized (hm) {
			Collection<PrintWriter>collection = hm.values();
			Iterator<PrintWriter> iter = collection.iterator();
			while(iter.hasNext()){
				PrintWriter pw = iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	}//broadcast
}
