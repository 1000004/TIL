interface IMachine{
	void turnOn();
	void turnOff();
}
class Tv implements IMachine   {
	@Override
	public void turnOn(){
		System.out.println("turn on TV");
	}
	@Override
	public void turnOff(){
		System.out.println("turn off TV");
	}
}
class Phone implements IMachine  {
	@Override
	public void turnOn(){
		System.out.println("turn on Phone");
	}
	@Override
	public void turnOff(){
		System.out.println("turn off Phone");
	}
}
class HomeSrver {
	public void performTurnOn(IMachine m){
		m.turnOn();
	}
	public void performTurnOff(IMachine m) {
		m.turnOff();
	}
}
class MachineTest  {
	public static void main(String[] args) {
		HomeSrver server = new HomeSrver();

		Tv tv = new Tv();

		server.performTurnOn(tv);
		server.performTurnOff(tv);

		Phone p = new Phone();

		server.performTurnOn(p);
		server.performTurnOff(p);

	}
}