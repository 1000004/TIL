public class BlockedEx {
	public static void main(String[] args) {
		
		//사용자 입력이 있을때까지 스레드 멈춤 BLOCKED 입출력 대기
    //대기열, 실행 상태 말고도 NotRunable 상태(BLOCKED, TIMED_WAITING, WARITING)가 있다 다시 대기열에 입력되야 실행 가능
		String input = JOptionPane.showInputDialog(
			"아무 값이나 입력하세요."
		);
		System.out.println("입력하신 값은 "+ input + "입니다.");
		
		for(int i=10; i>0;i--){
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
}
