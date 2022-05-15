import java.util.*;
class VectorEx3 {
	public static void main(String[] args) {
		Vector<String> list = new Vector<String>();

		list.add("a");//0
		list.add("b");//1
		list.add("c");//2
		list.add("d");//3
		list.add("e");//4

		List<String> temp = list.subList(1,4);
		System.out.println(temp);

		temp.add("f");

		System.out.println(List); //슬라이스된 temp가지고 연산을 하면 기존 list에도 영향을 미침
		System.out.println(temp);

	}
}