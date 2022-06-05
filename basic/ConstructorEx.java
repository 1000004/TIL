/*
	컴파일 시 클래스 내부에 생성자가 존재하지 않으면 컴파일러는 기본생성자를 만드어 준다.

	생성자 갯수 -> 객체를 만들어낼 수 있는 방법의 수 -> 객체 생성 시 파라미터를 강제할 수 있다.

	생성자가 호출되었다 -> 적어도 1개의 객체는 만들어 졌다.
*/
class Ball{
	private int num;
	
	//생성자1
	public Ball(){
	}	//기본 생성자
	//생성자2 (overload)
	public Ball(int num){
		this.num = num;
	}
}
class ConstructorEx  {
	public static void main(String[] args) {
		//new + 생성자 호출 => 객체생성
		Ball b = new Ball();
		
		Ball b2 = new Ball(10);

	}
}
