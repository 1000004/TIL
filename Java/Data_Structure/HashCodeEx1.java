import java.util.*;

class MyKey{
	private int num;

	public MyKey(int num){
		setNum(num);
	}

	public int getNum(){
		return num;
	}
	public void setNum(int num){
		this.num = num;
	}

	@Override
	public String toString(){
		return "MyKey(" + num + ")";
	}

	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof MyKey)){
			return false;
		}
		MyKey temp = (MyKey)o;
		return num == temp.getNum();
	}
	@Override
	public int hashCode() {
		return getNum() % 4;
	}
}

class HashCodeEx1 {
	public static void main(String[] args) {
		HashMap<MyKey, String> map = new HashMap<MyKey, String>();
		map.put(new MyKey(2), "A");
		map.put(new MyKey(1), "B");
		map.put(new MyKey(3), "C");
		map.put(new MyKey(4), "D");
		map.put(new MyKey(5), "E");
		map.put(new MyKey(7), "F");

		map.remove(new MyKey(3));

		System.out.println(map);

		/*
			hashxxxx
			1. 대상의 hashCode()값을 구해온다.
			2. 찾으려하는 복수데이터의 hashCode()과 1을 비교한다.
			3. 결과 
				3-1. 2에서 동일값이 없으면 찾으려하는 값이 없다고 판단한다.
				3-2. 2에서 동일한 값을 발견하면 해당 값을 만들어낸 요소들과 equals 검사를 수행한다.
	
		*/
		System.out.println(map.get(new MyKey(100)));
	}
}