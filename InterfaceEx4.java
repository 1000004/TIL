class Fruit {
}
interface IFood{
}
// Mark InterFace(표시하는 목적을 위한 인터페이스)
interface ILoverIt{
}
class Apple extends Fruit implements IFood{
}
class Banana extends Fruit implements IFood,ILoverIt {
}
class Kiwi extends Fruit implements IFood{
}
class Grape extends Fruit implements IFood{
}
class Meat implements IFood,ILoverIt{
}
class Girl{
	//신거 싫어함. 단, 고기는 좋아함.
	public void eat(ILoverIt sweety){//같은 상위객체로 상속되어 있지않아도 인터페이스를 통해 다형성을 나타낼 수 있다.
	}
}
class Boy {
	public void eat(Fruit f){
	}
}

public class  InterfaceEx4 {
	public static void main(String[] args) {
		Girl g = new Girl();
		g.eat(new Banana());
		Boy b = new Boy();
		b.eat(new Apple());
		b.eat(new Banana());
		b.eat(new Kiwi());
		b.eat(new Grape());

	}
}