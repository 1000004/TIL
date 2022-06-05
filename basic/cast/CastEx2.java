class Parent{
	public int num = 10;
}
class Child extends Parent{
	public int other = 5;
}
class CastEx2 {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.num);
		System.out.println(c.other);

		Parent p = c;
		System.out.println(p.num);
		//System.out.println(p.other);
		
		//강제 형변환
		//하위 타입 객체는 상위타입로 형변환 후 다시 하위타입로 형변환 가능
		Child c2 = (Child)p;
		if(c2 instanceof Child){
		System.out.println(c2.num);
		System.out.println(c2.other);
		}

		Parent p2 = new Parent();
		if(p2 instanceof Child){
			Child c3 = (Child)p2;//상위 객체는 하위객체로 형변환 불가능
		}
	}
}
