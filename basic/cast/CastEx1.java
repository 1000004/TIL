class Clothes{
}
// Pants is a Clothes
class Pants extends Clothes{
}
class Tshirts extends Clothes{
}
class Hat extends Clothes{
}
class Human{
	// Clothes c = panrts;
	public void buy(Clothes p){
		// 바지를 산다.
	}
}
//is-a 관계일때만 형변환가능
public class CastEx1 {
	public static void main(String[] args) {
		Human h = new Human();
		Pants pants = new Pants();
		h.buy(pants);
		Tshirts t = new Tshirts();
		h.buy(t);

		//Pants -> Clothes
		Clothes c1 = pants;
		//Tshirts -> clothes
		Clothes c2 = t;

		Object o = pants;
		//pants는 다형성을 3개 가짐
		//상위타입(정보의 수가 적)을수록 크다
	}
}
