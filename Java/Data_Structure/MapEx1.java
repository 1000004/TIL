import java.util.*;
class MapEx1 {
	public static void main(String[] args) {
		Hashtable<String, String> map = new Hashtable<String, String>();

		//원소 추가(Key, value)
		map.put("아이유","010-1004-1004");
		map.put("에일리","010-1004-5858");
		map.put("아이유","010-5858-1004");
		map.put("김유정","010-5858-5858");
		
		System.out.println(map.size());

		String tel = map.get("에일리");
		System.out.println(tel);

		map.put("아이유", "010-1111-1111");//존재하는 key인 경우 기존 자료 회손
		System.out.println(map.size());
		System.out.println(map);

		System.out.println(map.containsKey("김해수"));//해당 키가 있는가
		System.out.println(map.containsValue("010-1111-1111"));//해당 Value가 있는가

		map.remove("김유정");//제거
		System.out.println(map);
	}
}
