import java.util.*;

class CollectionEx2 {
	public static void main(String[] args) {
		// index 개념이 없음 -> 원소들 사이에 순서가 없다.
		Collection<String> some = new HashSet<String>();

		some.add("apple");
		some.add("tesla");
		some.add("microsoft");
		some.add("netflix");
		some.add("google");


		// Collection은 원소에 바로 접근이 불가능하다. 
		// 원소접근을 담당하는 다른 객체를 이용한다.(Iterator)
		Iterator<String> itr = some.iterator();
		while(itr.hasNext()) {
			String element = itr.next();
			System.out.println(element);
		}
		

		// JDK1.5~
		for(String str : some) {
			System.out.println(str);
		}
	}
}