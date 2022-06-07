public class IOEx1 {
	public static void main(String[] args) {
		//표준 입력장치를 바이트 단위로 읽는 스트림.
		// 엔터 : \r+\n \r 라인에 제일 앞으로 이동(13) \n 줄바꿈(10)
		
		//a\r\n -97 13 10
		//가 176 161 한글자를 넣었는데 1바이트씩 2번 나누어 읽는다 글자가 깨진다
		InputStream is = System.in;//스캐너 안써도 읽을 수 있다.
		int data = -1;
		boolean flag = true;
		while(flag){
			try{
				//System.out.print("입력 : ");
				data = is.read();//예외 발생
				if(data >=0){//읽을게 있는경우
					System.out.println(data);
					System.out.println((char)data);//가 byte로 읽고 char 형변환하는 경우 글자가 깨진다.
					// a는 정상적으로 a 빈공간 3줄(보이지 않는 \r, \n , println 3줄)
				}else{// 컨트롤 z 종료
					flag = false;
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
