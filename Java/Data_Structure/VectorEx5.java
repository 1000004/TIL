class Student{
	private String id;
	private String name;

	public Student(String id){
		setId(id);
	}
	public Student(String id, String name){
		setId(id);
		setName(name);
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return name + "(" + id + ")";
	}

	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Strudent)){
			return false;
		}
		Student temp = (Student)o;
		return id equals(temp.getId());
	}
}

class VectorEx5 {
	public static void main(String[] args) {
		Vector<Student> list = new Vector<Student>();
		list.add(new Student("1111111", "A"));
		list.add(new Student("1111111", "D"));
		list.add(new Student("1111111", "B"));
		list.add(new Student("1111111", "C"));
		list.add(new Student("1111111", "F"));
		list.add(new Student("1111111", "G"));
		list.add(new Student("1111111", "E"));
		/*
			개체를 복수 데이터로 사용할 시
			1. equals 고려
			2. 식별자 고려
			(equals를 통해 remove, indexOf, removeAll, retainAll, contains 등 사용 가능)
		*/
		list.remove(new Student("1111114"));

		System.out.println(list);

	}
}