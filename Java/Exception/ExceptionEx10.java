class ResultMiuseException extends Exception { //예외처리가 의무
	public ResultMiuseException() {
		super("결과가 마이너스");//msg 설정
	}

	public ResultMiuseException(String msg) {
		super(msg);
	}
}
class ExceptionEx10 {
	/*
		num2가 num1보다 크면 이거슨 예외다.
	*/
	public static void minus(int num1, int num2) throws Exception {
		int result = num1 - num2;
		if(result >= 0) {
			System.out.println(result);
		} else {
			try {
				// 예외상황이라 정의
				ResultMiuseException e = new ResultMiuseException("차감하는 수가 더 클수 없습니다.");
				// 예외발생시키기
				throw e;
			} finally {
				System.out.println("이거슨 누가 호출했든 강제로 해야하는 일입니다.");
			}
		}
	}

	public static void main(String[] args) {
		try {
			minus(100, 20);
		} catch(Exception e) {
			System.out.println("예외발생");
		}

		try {
			minus(10, 20);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			minus(10, 100);
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			minus(20, 20);
		} catch(Exception e) {
			System.out.println("아 몰라~");
		}
		//사용하는 사람마다 원하는대로 예외 상황을 다르게 처리
	}
}