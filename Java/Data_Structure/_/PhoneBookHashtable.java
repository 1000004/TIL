import java.util.*;
class MyUtils{
	public static int getRandomNumber(int from, int to){
		return (int)(Math.random()*(to - from + 1))+from;
	}
	public static char getRandomChar(){
		int num = getRandomNumber(0,1);
		char c;
		if(num ==0){
			c = (char)getRandomNumber('A','Z');
		}else{
			c = (char)getRandomNumber('a','z');
		}
		return c;
	}
	public static String getRandomString(int length){
		String str = "";
		for(int i=0; i<length; i++){
			str += getRandomChar();
		}
		return str;
	}
}
class Human {
	private String name;
	private int age;
	private String mail;
	private String tel;

	//for test
	public Human(){
		setName(MyUtils.getRandomString(3));
		setAge(MyUtils.getRandomNumber(10,40));
		int length = MyUtils.getRandomNumber(3,5);
		setMail(MyUtils.getRandomNumber(10,40)+"@doo.com");
		setTel(MyUtils.getRandomNumber(100,9999)+"-"+MyUtils.getRandomNumber(100,9999));
	}

	public Human(String name, int age, String mail, String tel){
		setName(name);
		setAge(age);
		setMail(mail);
		setTel(tel);
	}
	//get
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getMail(){
		return mail;
	}
	public String getTel(){
		return tel;
	}
	//set
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setMail(String mail){
		this.mail = mail;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	@Override
	public String toString(){
		return name + "(" + tel + ","+mail+","+age+")";
	}
	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof Human)){
			return false;
		}
		Human temp = (Human)o;
		return name.equals(temp.getName());
	}
}
interface HumanManager{
	void add(Human h);
	Human[] search(String name);
	boolean delete(String name);
}
class PhoneBook implements HumanManager{
	private Hashtable<String, Vector<Human>> book;

	public PhoneBook(){
		book = new Hashtable<String, Vector<Human>>();
		//String key,Vector<Human> values를 가지는 Hashtable 객체 생성

	}

	public void add(Human h){
		String name = h.getName();//해당 Human의 이름을 가져온다.
		Vector<Human> list;
		if(book.containsKey(name)){//Hashtable book에 name을 가지는 key가 있으면
			list = book.get(name);//name을 Key로 가지는 Vector를 list에 가져온다.
		}else{
			list = new Vector<Human>();//새로운 Vector를 만든다.
			book.put(name,list);//name key와 list를 book에 추가한다.
		}

		list.add(h);//list에 해당 human을 추가한다.
		//book에서 key를 해당 Haman의 name로 가지는 Vector의 주소가 list의 주소와 같으므로 동일하게 영향을 미친다. 
	}
	public Human[] search(String name){
		Vector<Human> list = book.get(name);//해당 이름을 key로 가지는 Vector를 가져온다.
		Human[] arr;
		if(list == null){//해당 이름을 key로 가지는 Vector가 없으면
			arr = new Human[0];//길이가 0인 배열
		}else{
			arr = list.toArray(new Human[0]);//list를 배열로 변경
		}
		return arr;//배열 반환
	}
	public boolean delete(String name){
		Vector<Human> list = book.get(name);//해당 이름을 key로 가지는 Vector를 가져온다.

		if(list == null || list.size() == 0){
			return false;//해당 이름을 key로 가지는 Vector가 없으면 false
		}else{
			for(int idx =0; idx<list.size(); idx++){//list에 있는 Human을 toString으로 출력
				System.out.println((idx+1)+"."+list.get(idx));
			}
			System.out.print(" 삭제할 번호를 선택하세요 : ");
			Scanner scan = new Scanner(System.in);
			int idx = Integer.parseInt(scan.nextLine())-1;
			list.remove(idx);//해당하는 idx를 다진 Human객체 삭제
			return true;//ture 반환
		}
	}
	@Override
	public String toString(){
		Collection<Vector<Human>> values = book.values();
		String info = "";
		for(Vector<Human> list : values){
			for(Human temp : list){
				info += temp + "\n";
			}
		}
		return info;
	} 
}
class PhoneBookHashtable {
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook();

		pb.add(new Human());
		pb.add(new Human());
		pb.add(new Human());
		pb.add(new Human("a",20,"abc@doo.org","123-4567"));
		pb.add(new Human("a",21,"abc@doo.org","143-4567"));
		pb.add(new Human("a",22,"abc@doo.org","153-4567"));
		pb.add(new Human("a",23,"abc@doo.org","163-4567"));
		System.out.println(pb);
		System.out.println(pb.delete("a"));
		Human[] arr = pb.search("a");
		for(Human h : arr){
			System.out.println(h);
		}
	}
}
