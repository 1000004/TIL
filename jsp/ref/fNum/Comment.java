public class Comment {
	private String writer;
	private String value;
	public Comment(){}
	public Comment(String writer, String value){
		this.writer = writer;
		this.value = value;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
