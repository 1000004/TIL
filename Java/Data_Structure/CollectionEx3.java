import java.util.*;
class CollectionEx3 {
	public static void main(String[] args) {
		Collection<String> col1 = new ArrayList<String>();
		Collection<String> col2 = new ArrayList<String>();

		col1.add("a");
		col1.add("b");
		col1.add("c");
		col1.add("d");

		col2.add("a");
		col2.add("b");
		col2.add("e");
		col2.add("f");


		// col1.addAll(col2);

		System.out.println(col1);
		System.out.println(col2);
		

		// col2의 모든 원소가 col1에 존재하면 true
		System.out.println(col1.containsAll(col2));
		

		// col1에서 col2의 원소들중 동일한 원소 모두 삭제
		col1.removeAll(col2);
		

		// col1에서 col2의 원소들 중 동일한 원소를 제외하고 모두 제거
		col1.retainAll(col2);
		
		System.out.println(col1);
		System.out.println(col2);
		
		col1.clear();
		System.out.println(col1);
		System.out.println(col1.isEmpty());

	}
}