public class SynchVsNotCynch {
	private static final long CALL_COUNT = 100000000L;
	//safe not Thread / safe Thread 연산 속도 차이(유의미하지 않다)
	//safe한 Vector나 HashSet을 사용할지는 판단하기 나름
	//synchronized 비용지불(성능차이)
	public static void main(String[] args){
		trial(CALL_COUNT, new NoSynch());
		trial(CALL_COUNT, new Synch());
	}
	private static void trial(long count, Object obj){
		String msg = obj.toString();
		System.out.println(msg + " : BEGIN");
		long startTime = System.currentTimeMillis();
		for(int i=0; i<count;i++){
			obj.toString();
		}
		System.out.println(
			"Elaapsed time = "+
			(System.currentTimeMillis() - startTime)+"ms"
		);
		System.out.println(msg+" : END");
	}
}
class Synch{
	private final String name = "Synch";
	@Override
	public synchronized String toString(){
		return "[ "+name+" ]";
	}
}
class NoSynch extends Synch{
	private final String name = "NoSynch";
	@Override
	public String toString(){
		return "[ "+ name+" ]";
	}
}
