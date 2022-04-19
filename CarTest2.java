class Engine{
	private int cc;
	private double weight;
	
	public Engine(int cc, double weight){
		setCc(cc);
		setWeight(weight);
	}

	public int getCc(){
		return cc;
	}
	public double getWeight(){
		return weight;
	}

	public void setCc(int cc){
		this.cc = cc;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}

	public String toString(){
		return cc + "cc(" + weight + "kg)";
	}
}


class Car{
	private String color;
	private int price;
	private String model;
	private Engine engine;

	public String getColor(){
		return color;
	}
	public int getPrice(){
		return price;
	}
	public String getModel(){
		return model;
	}

	public void setColor(String color){
		this.color = color;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public void setModel(String model){
		this.model = model;
	}
	public void setEngine(Engine engine){
		this.engine = engine;
	}

	public Car(String color,int price, String model, Engine engine){
		setColor(color);
		setPrice(price);
		setModel(model);
		setEngine(engine);
	}
	public String toString(){
		String info = "color :" + color + "\n";
		info += "price :" + price + "만원\n";
		info += "model :" + model + "\n";
		info += "engine :" + engine;
		return info;
	}

}

class CarTest {
	public static void main(String[] args) {
		Engine  e = new Engine(3000,235.2);
		Car c = new Car("Black",1000,"SM7",e);
		System.out.println(e);
		System.out.println(c);
		
	}
}
