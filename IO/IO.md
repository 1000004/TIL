# I/O
### stream
01 방향(단방향) 02 순차
#### stream(I/O)
  * byte - 읽기 : InputStream - 쓰기 : OutputStream
  * char - 읽기 : Reader - 쓰기 : Writer
> 입출력 클래스는 대상이 나오거나 어떻게(특징) 읽는지/쓰는지가 나오고 byte단위로 일기/쓰기 char 단위로 읽기/쓰기 인지 나온다.
> * #### 클래스 이름으로 유추가능 FileInputStrean - byte 단위로 읽기 / BufferedReader - Buffer를 사용해서 char 단위 읽기
* char는 나중에 만들어졌다
* A~Z a~z는 모두 1byte로 표기가 된다
* (ANSI 33이전 눈에 안보이는 글자 줄바꿈 tap ANSI 33이전 33~255 눈에 보이는 알파벳, 특수문자)
* 한글 일본어 중국어의 경우 한글자가 1byte로 표기가 안된다 최소 2byte
* 0~255가 ANSI에서 정해진 글자들로 약속이 되어있기 때문에 새로운 글자를 못넣는다
* 새로  256부터 추가되는 순간 한 글자에 2byte가 된다
* 가는 2byte이기 때문에 읽을때 1byte씩 끊어서 읽어 합면 문자가 깨진다.
* char는 1글자 단위로 읽기 때문에 영어권이 아닌 1byte가 넘는 글자를 깨지지 않게 가져 올 수 있다.
* byte 연산이 char보다 압도적으로 많이 사용된다. jpg avi zip mp3 
* (한글 파워포인트의 경우 글자만 있는게 아닌 표와 그림이 있기 때문에 byte)
* char는 글자(영어가 아닌 글자가 표함)로만 이루어진 경우 txt, java
* InputStream/OutputStream, Reader/Writer 추상클래스 : 읽거나 쓰는 대상이 정해지지 않았다
* Reader/Writer는 InputStream/OutputStream 이용해서 만들어짐
* API : InputStream 읽는 대상을 모르기 때문에 read가 추상메서드 실질적으로 호출되는 메서드
* byte를 정수 읽고 쓴다
* 3을 넣을때 기본 데이터형을 int로 인식 read 파라미터를 byte로 만들면 매번 형변환 필요 int로 받는다(조심)
* char단위로 읽는 Reader의 경우도 int 파라미터로 같다
* byte < char < int < double

* 인코딩 가능한 스트림 InputStreamReader OutputStreamWriter
* string 인코딩 가능 String(byte[] bytes,...,String charsetName) 바이트 연산만 가능(chr 연산의 경우 인코딩하는 메서드가 없다)
* Reader InputStream OutputStream과 연관이 없어 보이지만 실질적으로 호출되는 추상 메서드 read(char[] cbuf, int off,int len) 안에서 InputStream을 쓰고 있다

* 파일을 읽을때 byte로만 읽을 수 있는 경우 string으로 만들수 있어야 한다.(fis isr br String vs fr br String)
* char 연산을 해야 하지만 바이트 스트림으로만 제공되는 경우가 있다(메서드를 getInputStream, getOutputStream만 제공 ) ex Socket
* 영어로만 되어 있는 경우 문제 없지만 byte연산시 글자가 깨진다는 사실을 알고 있지만 여전히 바이트 연산만으로 읽는 경우가 많다.
* 파일로 저장 시 인코딩하는 경우와 같이 바이트 연산만 가능

#### ByteArrayOutputStream 
* 생성자 파라미터 없다 파일은 외부에서 가져오고 메서드로 바이트 배열을 만들 수 있다.
* 바이트 베열을 만드는 메서드 toByteArray()
* 네트워크 파일 전송시 사용
* (파일 객체는 파일 데이터를 가지고 있지 않다 경로 이름을 가지고 있다)
* Fileinputstream으로 내용을 읽고 byte배열로 써서 전송

#### 파일 끝을 알려주는 E.O.F (end of file) 읽으면  -1를 반환
> 쓰기 읽기를 이용해 파일 복사 가능
```java
public class Copy {
	public static void copy(String fileName){
		// cheoonsik_copy.jpeg(복사본 이름)
		int idx = fileName.lastIndexOf(".");
		String ext = fileName.substring(idx);//.txt
		String preName = fileName.substring(0, idx +1);
		String copyName = preName + "_copy" + ext;
		//try - resource : JDK1.7~(AutoCloseable 구현체에 한함)
		//닫을때 해야하는 일이 있으면 쓸수 없다.
		try(//finally로 안닫아도 된다.
			FileInputStream fis = new FileInputStream(fileName);
			FileOutputStream fos = new FileOutputStream(copyName);	
		){
			File f = new File(copyName);
			int data = -1;
			if(f.exists()){
				while((data = fis.read()) != -1){
						fos.write(data);
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}//finally{
//			if(fis != null){
//				try{
//					fis.close();
//				}catch(IOException e){}
//				try{
//					fos.close();
//				}catch(IOException e){}
//			}
//		}
	}
	public static void main(String[] args) {
		copy("test.txt");
	}
}
```
