class StringEx6 {
	public static void main(String[] args) {
		String file1 = "c:\\documents\\douwnloads\\choonsik.jpg";
		
		//~로 끝나느냐?
		System.out.println(file1.endsWith(".jpg"));
		
		//~로 시작하느냐>
		System.out.println(file1.startsWith("c:\\documents\\douwnloads"));
	}
}
