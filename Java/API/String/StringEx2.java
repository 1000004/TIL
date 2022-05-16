class StringEx2 {
	public static void main(String[] args) {
		String str = "americanPie           ";
		
		char c = str.charAt(2);
		System.out.println(c);

		System.out.println(str.length());//문자열의 길이정보

		String temp = str.trim();//내용이 없는 공백을 없애준다.
		//str과 temp는 다른 객체
		//새로운 문자열을 만들어 줌
		System.out.println(temp.length());
		System.out.println(str.length());

		//앞,뒤 여백 제거
		System.out.println("a, b".trim());//문자 사이 공백 제거 대상 아님
		System.out.println("ab   ".trim() + "<<<");
		System.out.println("<<<"+("     ab".trim()));

		//아스키코드 구하기
		System.out.println(str.codePointAt(6));
	}
}
