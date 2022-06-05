import java.util.*;
class Car{
	public static final boolean HANDICAPPED = true;
	private String number;//차량 번호
	private boolean handicapped;// 장애인차량 유무
	// 식별자(차량번호 비교를 위한 생성자)
	public Car(String number){
		setNumber(number);
	}
	public Car(String number, boolean handicapped){
		setNumber(number);
		setHandicapped(handicapped);
	}
	//get
	public String getNumber(){
		return number;
	}
	public boolean isHandicapped(){
		return handicapped;
	}
	//set
	public void setNumber(String number){
		this.number = number;
	}
	public void setHandicapped(boolean handicapped){
		this.handicapped = handicapped;
	}

	@Override
	public String toString(){
		String kind = handicapped ? "장애인차량" : "일반차량";
		return number + "(" + kind + ")";
	}
	//차량번호가 같으면 같은 차다.
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof Car)){
			return false;
		}
		Car temp = (Car)o;
		return number.equals(temp.getNumber());
	}
}

class ParkingArea{
	private static int no = 1;//최초 생성된 주차공간 번호 1로 설정
	private int areaNo;//주차공간 번호
	private Car car;//주차 차량
	private boolean kind;//장애인 주차공간 유무

	public ParkingArea(boolean kind){
		setKind(kind);
		areaNo = no;
		no++;//주차공간 객체가 새롭게 생성될때마다 공간번호 1씩 증가
	}
	//get
	public Car getCar(){
		return car;
	}
	public boolean getKind(){
		return kind;
	}
	public int getAreaNo(){
		return areaNo;
	}
	//set
	public void setCar(Car car){
		this.car = car;
	}
	public void setKind(boolean kind){
		this.kind = kind;
	}
	public void setAreaNo(int areaNo){
		this.areaNo = areaNo;
	}
	//주차된 차량있는지 유무 판단
	public boolean isEmpty(){
		return car == null;
	}
	//주차된 차량이 나간다.
	public Car out(){
		Car temp = car;
		car = null;//주차공간은 빈다(Null)
		return temp;//나가는 차량 반환한다.
	}
	//차량이 들어온다
	public boolean in(Car car){
		if(isEmpty()){//주차공간 비어 있다면
			if(!car.isHandicapped()){//차가 장애인차량이 아니라면
				if(kind == Car.HANDICAPPED){//장애인 전용 주차공간인지 확인
					System.out.println("비장애인은 장애인구역에 주차할 수 없습니다.");
					return false;//주차 불가 반환
				}else{
					this.car = car;//해당 차량을 주차 차량으로 설정
					return true;//주차됨 반환
				}
			}else{
				this.car = car;
				return true;
			}
		}else{
			return false;//이미 주차된 차량이 있다.
		}
	}
	//주차공간 번호가 같으면 동일한 주차공간이다.
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof ParkingArea)){
			return false;
		}
		ParkingArea temp = (ParkingArea)o;
		return areaNo == temp.getAreaNo();
	}
	@Override
	public String toString(){
		String info = areaNo + "번 ";
		info += "주차구역(장애인전용 : " + kind + ") - ";
		if(car == null){
			info += "비어있음.";
		}else{
			info += car + "주차 중";
		}
		return info;
	}
}
class ParkingInfo implements implements Comparable<ParkingInfo>{
	private String number;//주차된 차량 번호
	private int areaNo;//주차공간 번호
	//생성자
	public ParkingInfo(String number){
		setNumber(number);
	}
	public ParkingInfo(String number, int areaNo){
		setNumber(number);
		setAreaNo(areaNo);
	}
	//get
	public String getNumber(){
		return number;
	}
	public int getAreaNo(){
		return areaNo;
	}
	//set
	public void setNumber(String number){
		this.number = number;
	}
	public void setAreaNo(int areaNo){
		this.areaNo = areaNo;
	}
	//차향 번호 오름차순 정렬
	@Override
	public int compareTo(ParkingInfo info){
		return number.compareTo(info.getNumber());
	}
	@Override
	public String toString(){
		return areaNo + "(" + number + ")";
	}
}
class ParkingLot{
	public static final int OUT_OF_RANGE = -1;
	public static final int MAX_TRY = 5;//최대 주차 시도

	private ArrayList<ParkingInfo> info;//주차 정보 List
	private ParkingArea[] units;//주차 공간 배열
	private int currentCount;//현제 주차수
	private final int MAX_COUNT;//최대 주차수
	private Random random;
	//생성자
	public ParkingLot(int max, int countOfHandicapped){//파라미터 : 최대 주차수, 장애인 전용 주차수
		if(countOfHandicapped > max){
			System.out.println(
				"최대 주차수보다 장애인 전용 주차수가 더 많을 수 없습니다."
			);
			//범위를 벗어남 JDK 강제 종료
			System.exit(OUT_OF_RANGE);
		}
		MAX_COUNT = max;

		units = new ParkingArea[MAX_COUNT];//최대 주차수를 가지는 주차 공간 객체 배열 생성
		for(int i =0; i<MAX_COUNT; i++){
			boolean isHandicapped = false;
			if(i < countOfHandicapped){//장애인 전용 주차수만큼 주차공간 객체 생성
				isHandicapped = Car.HANDICAPPED;
			}
			units[i] = new ParkingArea(isHandicapped);
		}

		info = new ArrayList<ParkingInfo>();
		random = new Random();
	}


	public boolean in(Car car){
		System.out.println(car + "주차시도 중...");
		if(currentCount < MAX_COUNT){//현제 주차수가 최대 주차수보다 작으면
			int tryCount = 0;
			int idx;
			do{
				idx = random.nextInt(MAX_COUNT);//idx를 int타입의 0~(MAX_COUNT-1)범위로 랜덤으로 정한다.
				tryCount++;//반복한 횟수 count
			}while(!units[idx].in(car)&&tryCount < MAX_TRY);
			//최대 시도 수(5번)를 넘지 않고 주차를 못한 경우 반복

			if(car.equals(units[idx].getCar())){
				//주차정보를 생성한다.
				ParkingInfo temp = new ParkingInfo(
					car.getNumber(),idx+1
				);
				//info list에 생성된 객체를 추가한다. 
				info.add(temp);
				//주차수 1증가
				currentCount++;
				System.out.println(
					"주차완료 (" + car.getNumber() + "/" + 
					temp.getAreaNo() + "번구역) : 남은 자리(" +
					(MAX_COUNT - currentCount) + "개)"
				);

				return true;//주차됨
			}else{
				System.out.println("주차자리르 못찾고 떠나갑니다("+ car+")");
				return false;//주차 실패
			}
		}else{
			System.out.println("죄송합니다. 만차입니다.");
			return false;
		}
	}

	public Car out(String number){
		Car car = null;
		Collections.sort(info);//주차정보를 nature order로 차량번호 오름차순으로 정렬
		int idx = Collections.binarySearch(//해당 차향번호와 동일한 차량번호를 가진 차량을 찾기
			info, new ParkingInfo(number)
		);
		if(idx >= 0){//idx가 -1이 아닌 경우 = info list에 있는경우
			//idx정보를 가지고 나가는 차량의 주차정보를 찾아 주차된 공간에서 out() method 호출한다.
			ParkingInfo temp = info.get(idx);
			car = units[temp.getAreaNo() -1].out();
			info.remove(temp);//info list에서 나가는 차량의 주차정보를 삭제한다.
			currentCount--;//현제 주차수에서 -1
			System.out.println(
				"출차완료(" + number + ")"
			);
		}else{
			System.out.println(
				"해당차량이 존재하지 않습니다.("+number+")"
			);
		}
		return car;
	}

	@Override
	public String toString(){
		String info = "<< 주차 정보 >>\n";
		for(ParkingArea temp : units){
			info += temp + "\n";
		}
		info += "주차 가능 차량 수 : " + (MAX_COUNT - currentCount);
		return info;
	}
}

class TestParkingLot {
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot(9, 2);

		Car[] cars = {
			new Car("3가 7234", Car.HANDICAPPED),
			new Car("2가 1234", Car.HANDICAPPED),
			new Car("7가 9234"),
			new Car("4가 8234"),
			new Car("8가 9234"),
			new Car("6가 9234"),
			new Car("5가 9234"),
			new Car("9가 9234"),
			new Car("1가 1233", Car.HANDICAPPED),
			new Car("2가 6234", Car.HANDICAPPED)
		};
		for(Car temp: cars){
			lot.in(temp);
		}

		lot.out("5가 9234");
		System.out.println(lot);
		lot.out("9가 9234");
		System.out.println(lot);
		lot.out("7가 9234");
		System.out.println(lot);
	}
}
