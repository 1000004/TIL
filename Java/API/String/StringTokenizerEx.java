import java.util.StringTokenizer;

class StringTokenizerEx {
	public static void main(String[] args) {
		// 흘러간것은 되돌릴 수 없다.
		String line = "이@또한!흘러/가리 라~";
		StringTokenizer st = new StringTokenizer(line, "@!/");
		//구분자를 기준으로 String을 나눈다.
		//구분자가 없으면 공백을 구분자로

		// Enumeration 의 구현체
		//Iterator랑 비슷함.
		// 토큰 수 구하기
		System.out.println(st.countTokens());

		// 꺼낼 토큰이 더 있냐?
		while(st.hasMoreTokens()) {
			// 다음 토큰 나와라~
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}