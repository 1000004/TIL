import java.util.*;
class ListEx2 {
	public static void main(String[] args) {
		String[] arr = {"some", "any", "other", "where"};

		//배열 -> List(fixed-size List) : 길이변경불가
		List<String> list = Arrays.asList(arr);

		System.out.println(list);

		//list.add("new");
		
		//길이 변경이 필요시 기존 list를 가지는 ArrayList로 새로 생성 필요
		ArrayList<String> newList = new ArrayList<String>(list);
		newList.add("new");
		System.out.println(newList);
	}
}
