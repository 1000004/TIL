class YourObj{
	//1. method
	int sum3(int num1,int num2, int num3){
		int result = num1 + num2 + num3;
		result = sum2(result,num3);
		//클래스 내부 함수를 부를때 참조변수가 필요없다.
		//2 멤버변수 사용
		return result;
	}
	//2. method
	int sum2(int num1,int num2){
		//int result = num1 + num2;
		//return result;
		//바로 return 값
		return num1 + num2;
	}
	//3. method
	void printInt(int num1){
		System.out.println(num1);

	}
	//4.method
	void printName(){
		System.out.println("1000004");
	}

}

public class UseYourObj {
	public static void main(String[] args) {
		YourObj x = new YourObj();
		int yourSum3 = x.sum3(1,2,3);//1 method
		System.out.println(yourSum3);
		x.printInt(x.sum3(1,2,3));//1 method,3 method
		int yourSum2 = x.sum2(1,2);//2 method
		System.out.println(yourSum2);//2 method,3 method
		x.printInt(1);//3 method
		x.printName();//4 method


	}
}