import java.util.*;
class VectorEx4 {

	public static void printVectorInfo(Vector<String> temp, int count){
		System.out.println("==============================");
		System.out.println("count : " + count);
		System.out.println("==============================");
		System.out.println("vector size : " + temp.size());
		System.out.println("vector capacity : " + temp.capacity());
	}
	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();
		
		//capacity 용량 가질수 있는 size 가대 크기
		//용량은 size 초과시 2배로 증가
		int capacity = vec.capacity();
		System.out.println(capacity);

		for(int i=1; i<=10; i++){
			vec.add("a");
		}
		//남은 용량 낭비->size크기 만큼 용량을 줄인다.
		vec.trimToSize();
		printVectorInfo(vec, -1);

		vec.ensureCapacity(100);
		printVectorInfo(vec, -2);
	}
}