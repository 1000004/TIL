public class IOEx2 {
	public static void main(String[] args) {
		File f = new File("test.txt");//경로가 없으면 현재위치(실제 위치는 프로잭트 이름)
		
		//System.out.println(f.canWrite());//쓰기 권한이 있는지 확인
		
		FileOutputStream fos = null;
		//파일을 관리하는 운영체제
		//코드 안에서 어떻게 읽고 쓸지 결정
		//실제 일은 운영체제
		//외부 자원 사용
		try{
			//해당 파일이 없는 경우 만들어짐
			//오버라이드하여 기존 파일을 없어진다
			//있는지 없는지 검사하고 사용
			//의도한게 아니면 검사
			fos = new FileOutputStream("test.txt", true);//파일 path를 바로 써도 된다.
			//fos = new FileOutputStream(f, true);//true 덮어쓰지 않고 연속으로 써진다.
			fos.write('a');
			fos.write('b');
			fos.write('c');//1byte 넘기 때문에 한글로 처리가 안된다
		}catch(FileNotFoundException e){//c드라이브에 쓰기 권한을 못 받음
			e.printStackTrace();
		}catch(IOException e){//FileNotFoundException 상위 예외 바꾸면 에러
			e.printStackTrace();
		}finally{//외부자원 사용 다썼음을 알려줘야 한다
			//자원 해제
			if(fos != null){//자원이 null이면 닫을 필요가 없다 못빌려왔기 때문
				try{	
					fos.close();//예외 발생
					//널포인트 익셉션
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
