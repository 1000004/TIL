class ExceptionEx6 {
	public static void main(String[] args) {
		try{
			String str = null;

			System.out.println(str.length());
		}catch(NullPointerException e){
			System.out.println("null은 참조할 수 없습니다.");
			String str = "abc";
			Integer.parseInt(str);
		}finally{
			//finally block : 외부자원 처리
			//예외발생 여부와 관계없이 실행이 보장된다.
			System.out.println("무조건 실행된다.");
			//catch 블록에서 예외가 발생해도 실행 된다.
		}
	}
}
