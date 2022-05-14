interface IAa{
	void methodAa();
}
interface IBb{
	void methodBb();
}
interface ICc extends IAa, IBb{//같은 유형이면 extends
	void methodCc();
}
class Other{

	public void methodAa(){
		System.out.println("a");
	}
	public void methodBb(){
	}
	public void methodCc(){
	}
}
class YourObj extends Other implements ICc, IBb, IAa{//다른 유형이면 implementts
//상속 받으므로 구현x
	public void methodAa(){
		System.out.println("b");
	}
}
class  interfaceEx1 {
	public static void main(String[] args) {
		YourObj o = new YourObj();
		Other other = o;
		IAa a = o;
		IBb b = o;
		ICc c = o;
		Object obj = o;
		//type을 통해 사용할수 있는 범위를 알수 있다.
		a.methodAa();
		//호출시 override되므로 methodAa method 호출 가능

	}
}