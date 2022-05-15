import java.util.*;
class ListEx1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("d");	//0
		list.add("e");	//0
		list.add("c");	//0
		list.add("a");	//0
		list.add("b");	//0
		
		Collections.sort(list);
		System.out.println(list);
		
		int idx = Collections.binarySearch(list, "c");

		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));

		Collections.shuffle(list);
		System.out.println(list);

		Collections.reverse(list);
		System.out.println(list);
	}
}