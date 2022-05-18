class ExceptionEx11 {
	public static void main(String[] args) {
		try {
			int i = 0;
			while(true) {
				System.out.println("무한루프");
				i++;
				if(i == 3) {
					throw new Exception();
				}
			}
		} catch(Exception e) {
			System.out.println("탈출"); //break를 쓰지 않고 무한루프를 빠져나올 수 있다.
		}
	}
}