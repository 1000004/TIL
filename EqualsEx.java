class Car{
	private int price;
	private String color;
	private String model;
	public Car(int price, String  color, String model){
		setPrice(price);
		setColor(color);
		setModel(model);
	}
	public int getPrice(){
		return price;
	}
	public String getColor(){
		return color;
	}
	public String getModel(){
		return model;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public void setColor(String color){
		this.color = color;
	}
	public void setModel(String model){
		this.model = model;
	}
	//1. 가격이 같으면 같은 차다.
	//2. 색상과 가격이 같으면 같은 차다.
	//3. 색생과 모델이 같으면 같은 차다.
	@Override
	public boolean equals(Object o){
		//Object o에 null이 오거나 Car의 인스턴스가 오지 않는 경우 바로 결과값이 false
		if(o==null || !(o instanceof Car)){
			return false;
		}
		//헤더에서 c2 = Object o로 형변환 되었기 때문에
		//가격을 사용하기 위해 형변환이 필요 : Object -> car
		Car temp = (Car)o;
		//String 참조형은 equals가 문자열 내용으로 비교하도록 정의되어 있다.
		//비교 대상의 model문자열을 가져와 비교
		boolean result1 = model.equals(temp.getModel());	//모델비교
		//boolean result1 = (price == temp.getPrice());		//가격비교
		boolean result2 = color.equals(temp.getColor());	//색상비교

		return result1 && result2;
	}
}
class  EqualsEx {
	public static void main(String[] args) {
		Car c1 = new Car(2500, "white", "avante");
		Car c2 = new Car(2500, "black", "avante");
		//System.out.println(c1 == c2) 주소비교;
		//c1.equals(new Bus());
		//c1.equals(null);
		boolean result = c1.equals(c2);
		System.out.println(result);


	}
}