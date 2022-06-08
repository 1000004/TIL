public class FileEx5 {
	public static void main(String[] args) {
		File f = new File("c:\\test\\a.txt");
		System.out.println("파일크기 : " + f.length() + "bytes");
		//파일 크기 리턴은 long
		//영어는 한글자 1byte
		//윈도우 올림 단위 KB
		
		System.out.println("파일크기 : "+f.length()+"bytes");
		
		long time = f.lastModified();//마지막 수정 시간 long 타입 단위 ms
		Date date = new Date();
		date.setTime(time);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.kk:mm:ss");
		System.out.println("마지막 수정 시간 : " + sdf.format(date));
		//변환 가능
		
		System.out.println("parent : "+f.getParent());//존재하는 경로
		System.out.println("name : "+f.getName());
		System.out.println("path : "+f.getPath());//parent name 합친것
	}
}
