public class FileEx8 {
	public static void main(String[] args) {
		File dir = new File("c:\\Program Files");
		
		File[] fileList = dir.listFiles();//디렉토리를 내부에 있는 파일들(파일 디렉토리)을 파일배열로 모두 가져온다
		System.out.println(fileList.length);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.kk:mm:ss");
		for(File temp : fileList){
			String fileName = temp.getName();
			if(temp.isFile()){
				System.out.print(temp.getName());
				System.out.print("\t"+(temp.length()/1024) + "kb"); //용량이 나온다
				int idx = fileName.lastIndexOf(".");//확장자를 나누는 점 찾기 lastIndexOf
				String ext = "알수 없는 유형";
				if(idx >=0){//확장자가 없는 경우 if문으로 걸러냄
					ext = fileName.substring(idx +1).toUpperCase() + "파일"; //다 대문자로 표시
				}//카테고리로 묶어 탐색기처럼 표현 (long/ 택스트 문서/exe 응용프로그램 확장자로 표현)
				System.out.println("\t"+ext);
			}else{
				System.out.println("["+ temp.getName()+"]");
			}
			Date date = new Date();
			date.setTime(temp.lastModified());
			System.out.print("\t"+sdf.format(date));
			System.out.println();
		}
		
	}
}
