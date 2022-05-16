class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();

		buf.append("a");//뒤에 추가
		buf.append(1);
		buf.append("bc");
		System.out.println(buf.length());
		buf.append(3.14);
		buf.append("def");
		System.out.println(buf.length());
		System.out.println(buf);

		buf.insert(3, "x");//원하는 곳에 추가
		System.out.println(buf);

		buf.delete(2, 5);//원하는 범위 삭제
		System.out.println(buf);

		buf.reverse();//역순으로 정렬
		System.out.println(buf);
	}
}
