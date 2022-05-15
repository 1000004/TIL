import java.util.*;

class VectorEx1 {
	public static void main(String[] args) {
		//List에서 index의 개념이 추가됨.
		Vector<String> vec = new Vector<String>();

		vec.add("a");		//0
		vec.add("b");		//1
		vec.add("c");		//2
		vec.add("d");		//3
		vec.add("e");		//4

		//2번 인덱스 원소 구하기
		System.out.println(vec.get(2));

		//3번 이덱스 원소 삭제하기
		//vec.remove(3);

		//삽입
		vec.add(2,"x");
		//변경
		vec.set(2,"y");
		
		/*
		//순회할때 조심하자 자리변경이 생긴다.
		for(int idex=vec.size()-1; idx>=0; idx++){// 삭제는 뒤에서부터 추가는 앞에서 부터
			//System.out.println(vec.get(index)); 순회 하나씩 확인

			vec.remove(idx);

		}
		*/
		System.out.println(vec);
		
		//해당원소의 인덱스를 구한다.
		//존재하지 않는 경우 -1
		//찾을 수 있지만 정렬 필요 원소가 많아지면 indexOf로 인덱스를 구하면 성능 떨어짐
		int idx = vec.indexOf("c");//중복 원소가 있는경우 제일 앞의 원소의 인덱스를 구해준다.
		System.out.println(idx);
		idx = vec.indexOf("c",2);//몇번부터 찾을지 정해준다.

		idx = vec.lastIndexOf("c");//중복 원소가 있는경우 제일 마지막 원소의 인덱스를 구해준다.
		System.out.println(idx);
		
		Iterator<String> itr = vec.iterator();
		while(itr.hasNext()){
			String str = itr.next();
			System.out.println(str);
		}
		
		for(String a : vec){
			System.out.println(a);
		}
		

	}
}