/*
  // instanceof : 형변환의 안정성 보장
		if(some instanceof Food){
			  some.eat();
		}
*/
public class  CastEx3 {
	public static void main(String[] args) {
		
		double f = 5/4;
		System.out.println(f);
		f=((double) 5)/4;
		System.out.println(f);
		f=5/((double) 4);
		System.out.println(f);
		f=((double) 5) / ((double) 4);
		System.out.println(f);
		int i = (((int) 1.3) + ((int) 1.8));
		System.out.println(i);
	}
}
