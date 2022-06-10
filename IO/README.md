
# I/O
>### 입력(Input)/출력(Output)
* ##### java.io - 입출력이 없는 프로그램은 없으므로 가장 중요한 패키지일 수 있다. (발전된 패키지 nio)
* ##### 입력이 생기고 결과물을 출력이 프로그램의 목적이 될 수 있다.
* ##### 입출력 연산은 느리기때문에 횟수를 최소화.(파일 사이즈와 갯수 고려 증가시 연산 횟수가 증가하고 성능 저하로 이어짐)
* ##### 입출력은 프로그램 성능에 영향을 미친다.
* ##### 영속적 저장소( vs 휘발성 저장소)
    * 01 file
    * 02 DataBase file에 비해 데이터 공유 가능하다는 장점
    * 이전 데이터를 불러올 수 있다.
    * file을 활용하여 프로그램에서 할수 있는 것들이 많아진다.
## Stream
 > * byte - 읽기 : InputStream - 쓰기 : OutputStream
 > * char - 읽기 : Reader - 쓰기 : Writer
* Decorator 패턴 - 어떤 스트림을 조립하는지에 따라 다양한 성격을 띄게 된다.
> 생성자 중요 API에서 가장 먼저 확인
* 생성자 파라미터로 **다른 Stream**를 받는 경우(필터)
	*  독립적 사용 못함 
	*  다른 스트림에 의존 무엇을 읽고 쓰는지가 아닌 어떻게 읽고 쓰는지 결정
	*  원천 소스를 가공 연산
* 생성자 파라미터로 **원천 소스**를 받는 경우
	*  독립적 사용 
	*  무엇을 읽고 쓰는지 결정하고 간단한 읽고 쓰기 연산 수행
* 여러 스트림을 다양하게 조합 가능 Ex 키보드를 한줄씩 읽는 스트림
* 입출력이 프로 그램에서 주기능 담당하는 경우가 많다
* 어떻게 구성하는지가 프로그램의 performance결정 가장 크게 성능에 영향을 미친다.
* 읽기 쓰기 방향은 반대
	* InputStreamReader InputStream(byte)을 Reader(char로 읽는다) (byte -> char)
	* OuputStreamWriter Writer(char를 쓴다) OuputStream(byte)으로 (char -> byte)

<img src="https://postfiles.pstatic.net/MjAyMjA2MDhfNSAg/MDAxNjU0Njg0Mzc1NTY0.1ohc1pSPA6z_8xxMjNhRsjpnvK9HISpO-mHim1IPa5sg.i-m5QAQAIWmWDS-zsdAsGDZoGmNlok8LoOP3Mvypi-Ag.PNG.forget980/image.png?type=w580" width="40%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

	* br에서 readLine()을 호출시 → isr read() 호출 → is read() 호출
	* byte -> char -> 줄
	* BufferedReader는 임시저장소 buffer 가진다 줄단위로 읽어주는 연산이 가능(여기서 buffer는 속도를 높여주지는 못한다)
	* buffer는 성능을 높여주는데 속도 향상과 다양한 연산 기능
	* 한줄로 판단하기 위해서는 읽은 것을 한곳에 모아두는 공간이 필요 엔터가 들어오면 여기까지가 한줄로 판별
	
<img src="https://postfiles.pstatic.net/MjAyMjA2MDhfMTcz/MDAxNjU0Njg0ODk4Mjgw.2sr2-_ZTtWZLDQD6BsryR3tqOQPZQBnEWlAF0Fsqb1cg.V8UhnD3t8F6T9a2DUteKukcAoVo-_5XUYJZcM8h5EPsg.PNG.forget980/image.png?type=w580" width="50%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

	* pw에서 println() 호출시 fw write() 호출
	* pw fw char 연산
	* 쓰기는 원천소스를 쓰는 stream이 가장 나중에 등장 (읽기와 방향이 반대)
	* flush() 쓰기 연산시 필요 쓰기 또한 buffer를 사용 buffer는 다 채워야 나오지만 체워지지 않더라도 강제로 채워 내보낸다
	* 문자열 복수 char가 여러개 모일수 있는 공간이 필요 - 필터는 연산을 위해 대부분 buffer를 가진다.
	
> ### buffer

   * 읽은 값은 바이트 배열로 들어가 buffer의 크기만큼 들고올수 있다.
   * 입출력 연산이 컴퓨터 연산중 가장 오래 걸린다 횟수가 증가하면 오래 걸린다 buffer를 이용하여 입출력 연산을 줄인다.
   * 환경에 따라 버퍼 크기에 따른 성능 그래프가 달라짐 적당한 크기가 무엇인지 test 필요
   * 초반에는 급격하게 성능이 좋아지지만 일정 크기 이상이 되면 완만해진다.(증가하는 버퍼에 비해 비효율적으로 성능 상승)

<img src="https://postfiles.pstatic.net/MjAyMjA2MDhfMjc4/MDAxNjU0Njc3NDM5Mzky.hIahpsKb5khuWxx0Nt1mZhJkfiQmKQUefhfNU2AlVL4g.UvC1HZ5_xmkHlKl7sT2eisUrNlamKEaYK0rAv5_AXHUg.PNG.forget980/image.png?type=w580" width="40%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

```java
public class IOEx1 {
	public static void fileCopy(String filePath){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int idx = filePath.lastIndexOf(".");
		String ext = filePath.substring(idx);//.txt
		String preName = filePath.substring(0, idx +1);
		String copyName = preName + "_copy" + ext;
		try{
			fis = new FileInputStream(filePath);
			fos = new FileOutputStream(copyName);
			byte[] buffer = new byte[4096];
			int count = -1;
			while((count = fis.read(buffer)) != -1){
				fos.write(buffer, 0, count);//buffer를 설정하고 시작 인덱스와 읽는 갯수
			}
			JOptionPane.showMessageDialog(
					null, "복사완료"
			);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			IOUtil.closeAll(fis, fos);
		}
	}
	public static void main(String[] args) {
		fileCopy("d:\\java\\Lotto.zip");
	}
}
```
  	 * 마지막에 buffer의 크기보다 적은 바이트를 읽을수 있도록 count 사용
	 * count는 정확한 정보를 읽고 쓰기 위해 중요
> ### DataBase
* 입출력을 만들때 file를 직접 관리하는 경우 데이터를 어떻게 구분하여 읽고 쓸지 결정이 필요하다.
* DB는 file을 어떻게 추가하고 읽고 갱신하고 삭제할지 관리를 대신해준다.
* (Create Read Update Dlete)
* 모든 데이터를 DB로 관리하는 프로그램은 없다 일부 파일을 이용해 저장
> ### Properties
* properties는 간단한 데이터를 저장 할때도 쓰이지만 설정을 properties로 저장 할때 많이 쓰인다
* 저장 파일 유형 text, [XML](https://github.com/1000004/TIL/blob/main/XML.md)
```java
* 설정 파일을 왜 만드는가?
* 사용자는 프로그램을 사용시 설정을 변경하고 싶어도 프로그램언를 모르는기 때문에 변경이 불가능
* 사용자가 알수 있게 설정 파일 제작 파일 변경시 코드를 모르는 사용자도 프로그램을 다르게 동작하도록 만들수 있다.
* 접근 혀용 범위를 설정 파일을 만드는 프로그램 제공자가 결정하 수 있다.
* 사용자의 접근성 편의성 증가
* 코드를 변경하지 않고 프로그램이 다르게 동작하므로 유연해진다
* 상수로 정의했던것을 파일로 가져와 쓰면 코드 변경 없이 상수 수정이 가능
```
