class StringEx1 {
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		//String-pool에 등록 : 공유된다.
		//new String("abc")을 이용하는 경우 String-pool에 등록이 안되지만
		//intern를 이용하여 String-pool에 등록 가능하다.
		String temp = str1.intern();

		//String str3 = new String("abc").intern();
		String str3 = "abc";
		String str4 = "abc";

		//문자열 내용 비교
		System.out.println(str1.equals(str2));
		System.out.println(str3.equals(str4));
		System.out.println(str1.equals(str3));
		
		//주소비교
		System.out.println(str1 == str2);
		System.out.println(str3 == str4);
		System.out.println(str1 == str3);
		System.out.println(temp == str3);
	}
}
