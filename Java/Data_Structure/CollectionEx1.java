import java.util.*;
/*
	Vector, ArrayList
*/

class CollectionEx1 {
	public static void main(String[] args) {
		Collection<String> some = new Vector<String>();
		
		//원소 수(길이) 구하기
		System.out.println(some.size());

		//원소추가
		some.add("a");
		some.add("b");
		some.add("c");
		some.add("d");

		//원소 전부 삭제
		//some.clear();

		System.out.println(some.size());
		
		//원소 존재여부 확인
		//some 안에 "b"가 있습니까?
		System.out.println(some.contains("b"));
		System.out.println(some.contains("z"));
		
		//원소 삭제
		some.remove("c");
		System.out.println(some);

		//Collection -> 배열
		String[] arr1 = new String[some.size()];
		String[] arr2 = some.toArray(arr1);
		String[] arr = some.toArray(new String[0]);//빈도가 높음...(size룰 몰라도 사용 가능)
		System.out.println(Arrays.toString(arr));
		//주소동일
		System.out.println(arr1==arr2);
	}
}
