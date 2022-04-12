class MyObj{
	//사용자로부터 정수 하나를 입력받아 2를 더한후 결과(int)를 돌려준다.
	
	//메소드헤더{}메소드 바디
	int plus2(int num){//int 밖으로 나갈 데이터타입
		int result = num + 2;
		//return : 일의 결과를 돌려준다. 결과 -> 일의끝
		return result;
	
	}
	//사용자로 부터 정수를 하나 받앗 내용을 출력하다.
	void printInt(int num){
		System.out.println(num);
	}
	//클래스 이름을 출력하라.
	void printClassName(){
		System.out.println("I'm MyObk");
	}
	//정수 둘을 입력받아 합을 출력하라.
	void printSum(int num1, int num2){
		int sum = num1 + num2;
		System.out.println(sum);
	}
}


public class UseMyObj  {
	public static void main(String[] args) {
		//1.객체생성
		MyObj o = new MyObj();
		//2.메서드 사용
		int myNum = o.plus2(5);
		System.out.println(myNum);
		System.out.println(o.plus2(100));
		o.printInt(100);
		o.printInt(7);
		o.printClassName();
		o.printSum(3,4);
	}
}
