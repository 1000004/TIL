class Car{
	private String color;
	private int speed;
	private int gear;

	private int id;
	private static int numberOfCars = 0; //static 변수는 소유되지 않는다 -> 공유된다.

	public Car(String c,int s, int g){
		color = c;
		speed = s;
		gear = g;

		id = ++numberOfCars;
	}
	//이런 애들은 반드시 static하게 구현해야 한다.
	//static 변수인 num울 리턴
	public static int getNumberOfCars(){
		return numberOfCars;
	}
}

class  StaticEx2 {

	public static void main(String[] args) {
		Car c1 = new Car("bule", 100,1);
		Car c2 = new Car("white", 0, 1);
		int n = Car.getNumberOfCars();		//정적 메소드 호출 클래스 이름을 앞에 붙인다.
		System.out.println("지금까지 생성된 자동차 수 = " + n);
	}
}
