import java.util.*;
class MyUtils{
	public static int getRandomNumber(int from, int to){
		return (int)(Math.random()*(to - from + 1))+from;
	}
	public static char getRandomChar(){//랜덤으로 대문자 알파벳 or 소문자 알파벳
		int num = getRandomNumber(0,1);//0~1 정수
		char c;
		if(num ==0){
			c = (char)getRandomNumber('A','Z');//A~Z 대문자 알파벳(A=65, Z=90)
		}else{
			c = (char)getRandomNumber('a','z');//a~z 소문자 알파벳(a=97, z=122)
		}
		return c;
	}
	public static String getRandomString(int length){//원하는 길이로 문자열을 랜덤으로 생성
		String str = "";
		for(int i=0; i<length; i++){
			str += getRandomChar();//랜덤으로 알파벳을 문자열에 추가한다.
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
		int length = MyUtils.getRandomNumber(3,5);//3~5사이 정수 랜덤으로 length 설정
		setName(MyUtils.getRandomString(length));//3글자의 문자열을 생성
		setAge(MyUtils.getRandomNumber(10,40));//나이를 10~40사이 정수 랜덤으로 설정
		setMail(MyUtils.getRandomNumber(10,40)+"@doo.com");//10~40사이 정수 랜덤으로 이메일 설정
		setTel(MyUtils.getRandomNumber(100,999)+"-"+MyUtils.getRandomNumber(1000,9999));//100~9999상 정수 랜덤으로 전화번호 설정
	}
	//비교를 위한 식별자 name를 가지고 생성
	public Human(String name){
		setName(name);
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
	//이름이 같드면 Human객체는 같다.
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
	private Vector<Human> list;

	public PhoneBook(){
		list = new Vector<Human>();
	}
	public void add(Human h){//Vector list 추가
		list.add(h);
	}

	public boolean delete(String name){
		Integer[] indices = getIndices(name);//해당 이름과 동일한 이름 가진 Human idx 배열 생성 
		if(indices.length != 0){//idices길이가 0이 아니면
			int num = 1;
			for(int idx : indices){//ideces에있는 idx에 대한 Human 객체를 toString으로 보여준다.
				Human temp = list.get(idx);
				System.out.println(num + "." + temp.toString());//출력할 Hunan객체에 1부터 순서대로 번호를 붙인다.
				num++;
			}
			System.out.print("삭제할 번호를 입력하시오 : ");
			Scanner scan = new Scanner(System.in);
			int deleteIdx = scan.nextInt()-1;//배열은 0부터 시작 하므로 삭제하고자 하는 index의 위치는 번호 -1
			list.remove(indices[deleteIdx].intValue());//list에서 삭제하고자 하는 index를 찾아 삭제 Integer->Int
			return true;
		}else{
			return false;//행당 이름과 동일한 이름을 가지는 객체가 없으면 false반환
		}
	}

	private Integer[] getIndices(String name){
		//해당 name을 가진 Human을 생성
		Human target = new Human(name);

		boolean flag = true;
		int idx = 0;
		Vector<Integer> indices = new Vector<Integer>();
		while(flag){
			idx = list.indexOf(target,idx);//Human taget과 동일한(equals: 이름이 같다)객체의 idx 찾기 
			if(idx == -1){//없으면 -1
				flag = false;//반복문이 끝난다.
			}else{
				indices.add(idx);//있으면 해당 idx를 Vector indices에 추가한다.
				idx++;//추가적인 taget과 동일한 객체가 없을 때까지 idx + 1하면서 반복한다.
			}
		}

		return indices.toArray(new Integer[0]);//Vector를 배열 형태로 변경하여 반환
	}
	public Human[] search(String name){
		Integer[] indices = getIndices(name);//해당 이름과 동일한 이름 가진 Human idx 배열 생성 
		Human[] arr;
		if(indices.length == 0){//길이가 0이면 해당 이름과 동일한 객체가 없다.
			arr = null;
		}else{
			arr = new Human[indices.length];//인덱스 배열 길이를 크기로 가지는 Human 배열 생성
			for(int idx=0; idx<arr.length; idx++){//이덱스 배열에서 존재하는 idx로 Human을 찾아 배열에 저장
				arr[idx] = list.get(indices[idx]);
			}
		}
		return arr;//Human 배열 반환
	}
	@Override
	public String toString(){
		String info = "";
		for(Human temp : list){
			info += temp.toString() + "\n";
		}
		return info;
	}
}
class PhoneBookVector {
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
