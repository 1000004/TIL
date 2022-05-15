import java.util.Arrays;
class Engine implements Comparable<Engine>{
	private int cc;
	private int weight;

	public Engine(int cc, int weight) {
		setCc(cc);
		setWeight(weight);
	}

	public int getCc() {
		return cc;
	}
	public int getWeight() {
		return weight;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return cc + "cc, " + weight + "kg";
	}
	@Override
	public int compareTo(Engine other){
		return getCc()-other.getCc();
	}
}
class Car implements Comparable<Car>{
	private String model;
	private Engine engine;
	
	public Car(String model, Engine engine) {
		setModel(model);
		setEngine(engine);
	}

	public String getModel() {
		return model;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		String info = "model : " + model + "\n";
		info += "engine : " + engine;

		return info;
	}
	@Override
	public int compareTo(Car other){
		return getEngine().compareTo(other.getEngine());
	}
}
class SortEx4 {
	public static void main(String[] args) {
		Car[] carList = {
			new Car("avante", new Engine(1600, 200)),
			new Car("G80", new Engine(3300, 350)),
			new Car("sonata", new Engine(2000, 280)),
			new Car("G90", new Engine(5000, 400))
		};
		Arrays.sort(carList);
		System.out.println(Arrays.toString(carList));
		// 자동차를 배기량 기준으로 오름차순 정렬하라.
	}
}