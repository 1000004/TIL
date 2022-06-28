public class EchoThreadServer {
	public static void main(String[] args) {
		try{
			//서버에서만 쓰인다 : ServerSocket
			//Client(request 요청) Server(response 응답)
			//ServerSocket 접속을 받아주는 역활 -> 서버에서만 일어난다.
			ServerSocket server = new ServerSocket(10001);
			//10001 port 번호 (프로세스 식별자 port)
			//10001 port로 받겠다
			System.out.println("접속을 기달립니다.");
			while (true) {//*접속 대기 하나여서 하나만 접속 가능(bindException 주소를 이미 사용중 (port)) -> 반복문 여러 client 접속
				//client 정보를 담긴 소켓
				Socket sock = server.accept();//*통신하고 있는 대상의 정보는 소켓이가지고 있다
				//1)접속을 대기 클라이언트에 접속을 받을 준비 쓰레드가 정지 (실행 불가상태) 접속 할때 까지 대기
				//2)접속시도 성공하면 소켓 만들어짐
				//3)접속대기는 풀린다
				//4)서버측 소켓이 만들어진다
				//(client 추상화 server.accept() 결과 얻는다)
				//접속 성공조건이 해당 Ip, port가 대기중이어야 가능
				//(client는 new로 소켓 생성)
				//실제 통신는 소켓(알아서 한다 전기 기호를 어떻게 변경하고 전송 수신하는지 알아서)
				//어떻게 통신하는지는 몰라도 된다
				EchoThread echoThread = new EchoThread(sock);
				echoThread.start();
			}//while
		}catch(Exception e){
			System.out.println("catch : "+e);
		}
	}//main
}
