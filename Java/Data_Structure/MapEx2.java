import java.util.*;
class MapEx2 {
	public static void main(String[] args) {
		Hashtable<String, String> map = new Hashtable<String, String>();

		//원소 추가(key, value)
		map.put("아이유","010-1004-1004");
		map.put("에일리","010-1004-5858");
		map.put("아이유","010-5858-1004");
		map.put("아이유","010-5858-5858");	
		
		// key만 다 가져온다.
		Set<String> keys = map.keySet();
		for(String key : keys){
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}

		//value만 다 가져온다.
		Collection<String> values = map.values();
		for(String tel : values){
			System.out.println(tel);
		}
		/*
		Set<String> keys = map.keySet();
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()){
			String key = itr.next();
			String value = map,get(key);
			System.out.println(key + " : " + value);
		}
		*/
		
		}
}