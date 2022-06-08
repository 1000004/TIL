public class IOEx3 {
	public static void main(String[] args) {
		//console 입력
		InputStream is = null;//키보드 입력을 받는 Stream
		InputStreamReader isr = null;//읽는 대상 : InputStream byte연산을 char연산으로 변경
		BufferedReader br = null;//불필요한 엔터를 제외하고 한줄씩 읽는다.
		
		FileWriter fw = null;//한글자씩 쓴다
		PrintWriter pw = null;//한줄씩 쓴다
		//역순으로 닫는다 메모리 누수 발생x
		
		try{
			is = System.in;
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
//			int data = -1;
//			while((data = isr.read())>=0){//문제 한글자씩 읽는다 enter까지 읽는다 -> 한줄씩 읽도록 바꾼다
//				System.out.println((char)data);
//			}
			//byte > char > string
			
			fw = new FileWriter("result.txt");
			pw = new PrintWriter(fw);//bt 엔터 빼로 pw엔터를 넣고
			
			String line = null;
//			while((line = br.readLine()) != null){//한줄씩 읽는다 readLine()
//				System.out.println(line);
//			}
			while(!(line = br.readLine()).equalsIgnoreCase("quit")){//문자열로 읽기 때문에 equals사용 quit을 치면 끝난다
				pw.println(line);
			}
			pw.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			IOUtil.closeAll(br,isr,is,pw,fw);
		}
	}
}
