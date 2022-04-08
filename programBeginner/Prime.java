//1~100까지 중 소수 구하기
public class  Prime {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 2; i<=100; ++i){
			boolean isPrime = true; //int k=0; 32비트 ->8비트
			for(int j=2; isPrime && j<=i/2; ++j){
                // refactoring
                // int =2; j<=i-1; ++1
                // 반복횟수 4851 -> 616
				count++;
				if(i%j==0){
					isPrime = false; //k++
					
				}
			}
			if (isPrime){ //k==0
				System.out.println(i);
			}
		}
		System.out.println("coumt : " + count);


	}
}
