class First{
	public void todo(){
		System.out.println("A");
	}
}
class Second extends First{
	//나는 B를 사전작업으로 수행하고 싶다... -> super
	@Overrride
	public void todo(){
		System.out.println("B");
		super.todo();
	}
}

public class ExtendsEx2  {
	public static void main(String[] args) {
		new Second().todo();

	}
}
