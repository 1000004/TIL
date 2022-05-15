import java.util.Arrays;
import java.util.Comparator;

class Human implements Comparable<Human> {
	private int age;
	private String name;

	public Human(String name, int age){
		setAge(age);
		setName(name);
	}

	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return name + "(" + age + ")";
	}

	@Override
	public int compareTo(Human other){
		//이름으로 오림차순 정렬한다.
		return name.compareTo(other.getName());
	}
}
class OrderByAge implements Comparator<Human>{
	/*
		h1 > h2 : 양수
		h1 < h2 : 음수
		h1 == h2 : 0
	*/
	@Override
	public int compare(Human h1, Human h2){
		//나이로 오름자순 정렬한다.
		return h1.getAge() - h2.getAge();
	}
}
class SortEx1{
	public static void main(String[] args){
		Human[] arr = {
			new Human("아이유", 30),
			new Human("에일리", 32),
			new Human("A", 40),
			new Human("B", 22),
			new Human("C", 29),
			new Human("D", 42)
		};
		//Human natura ordering 사용 정렬 -> 이름으로 오림차순 정렬
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		//나이 오름차순으로 바꾸어 정렬한다.
		Arrays.sort(arr, new OrderByAge());
		System.out.println(Arrays.toString(arr));

	}
}