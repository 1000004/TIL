import java.text.SimpleDateFormat;
import java.util.Date;

public class Doc {
	private String words;
	private String writer;
	
	private int num;//식별자
	private String date;
	
	private static int count = 1;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd");
	
	public Doc(String words, String writer){
		setWords(words);
		setWriter(writer);
		num = count;
		count++;
		date = sdf.format(new Date());
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null || !(other instanceof Doc)){
			return false;
		}
		Doc temp = (Doc)other;
		return num == temp.getNum();
	}
	
}
