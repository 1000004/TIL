class MyObj{
	int method1(){
		System.out.println("8을 리턴합니다.");
		return 8;
	}

	void method2(){
		System.out.println("이건 리턴이 없어요");
	}
	/*
		return : 연산의 결과를 돌려준다. return 밑구문 수용되 않음
	*/
	String WhatIsTis(int num){
		if(num % 2 == 0){
			return "짝수";
		}else{
			return "홀수";
		}
	}
	String otherCase(int num){
		if(num > 2){
			return "2보다 큼";//메서드 종료
		}
		System.out.println("되냐?");
			return "2보다 적다";
	}
}

public class MethodEx  {
	public static void main(String[] args) {
		MyObj o = new MyObj();
		o.method1();	//출력만
		int num = o.method1(); //o.method1()->8 return 값을 변수 num에 담음

		o.method2();

		o.otherCase(4);

		o.otherCase(1);

	}
}

