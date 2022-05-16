class StringEx4 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "def";
		
		System.out.println(str1.concat(str2));//연결 +연산과 같다
		String str3 = "abcdefge";

		System.out.println(str3.contains("cd"));//문자열 존재유무
		System.out.println(str3.indexOf("e"));//indexOf / lastindxOf로 인덱스 찾기
		System.out.println(str3.indexOf("e",5));
		System.out.println(str3.lastIndexOf("e"));
		System.out.println(str3.lastIndexOf("e",6));

		//String objects are immutable
		System.out.println(str3.replace("e","x"));//교체
		System.out.println(str3);
	}
}
