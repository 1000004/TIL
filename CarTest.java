/*
	멤버변수 / 메서드

	클래스 -> 객체생성
*/
class Car{
	//멤버변수
	String color;
	int speed;
	int gear;
	//메소드
	void print(){
		System.out.println("("+color+","+speed+","+gear+")");
	}
}
public class  CarTest {
	public static void main(String[] args) {
		//참조형
		Car myCar = new Car();//객체생성 정의
		myCar.color = "red";//값 정의
		myCar.speed = 0;
		myCar.gear = 1;
		myCar.print();//메소드 호출
		
		Car yourCar =new Car();
		yourCar.color = "blue";
		yourCar.speed = 60;
		yourCar.gear = 3;
		yourCar.print();
		


	}
}
