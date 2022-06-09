public class Crolling {
	//소스 보기 페이지 구조 동일 데이터가 다름
	//공통된 페이지의 특징 찾고 원하는 정보를 가져올 수 있다
	//stream 가지고 조절
	//정보를 보여주는 간단한 엔진을 가지고 보여주면 브라우저
	public static void main(String[] args) {//파일로 저장했지만 브라우저로 보여줄 수 있다.
		String urlText;
		do{
			urlText = JOptionPane.showInputDialog("URL : ");
		}while(urlText == null || urlText.trim().length()==0);
		
		HttpURLConnection con = null;
		try{
			URL url = new URL(urlText);
			con = (HttpURLConnection)url.openConnection();
			String msg = "응답코드 이상 : ";
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP){
				try(
					InputStream is = con.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));//InputStreamReader 인코딩 변경 가능
					//한글이 안깨지도록 UTF-8로 불러와서 읽고 문자열로 변경
					//이클립스 인코딩과 브라우져 인코딩 다름
					//그냥 쓰는 경우 이클립스 인코딩으로 쓰여지기 때문에 다시 인코딩 필요
						
					PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("result.html"),"UTF-8") )
				){
					String line =null;
					while((line = br.readLine()) != null){
						pw.println(line);
					}
					pw.flush();
					msg = "작업완료";
				}
			}else{
				msg += responseCode;
			}
			JOptionPane.showMessageDialog(null, msg);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				con.disconnect();
			}catch(Exception e){}
		}
	}
}
