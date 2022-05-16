class StringEx5 {
	public static void main(String[] args) {
		String str1 = "abcdefghijk";

		System.out.println(str1.substring(4));//4부터 끝까지 가져온다(부분 집합)
		// 4이상, 9미만 => indexOf랑 함께 사용
		System.out.println(str1.substring(4, 9));

		//String -> char[]
		char[] arr = str1.toCharArray();
		System.out.println(java.util.Arrays.toString(arr));

		char[] temp = {'t','e','s','l','a'};
		// char[] -> String 2가지
		String name1 = String.valueOf(temp);
		//String.valueOf(int) int -> String
		//Integer.parseInt(String) String -> int
		String name2 = new String(temp);

		System.out.println(name1);
		System.out.println(name2);
	}
}
