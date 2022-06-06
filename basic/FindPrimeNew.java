import java.util.*;
class FindPrimeNew {
	static int count = 0;
	public static Integer[] getPrimes(int end){
		vector<Integer> primes = new Vector<Integer>();
		for(int i=2; i<=end; i++){
			booleam isPrime =true;
			for(int idx=0; isPrime && idx<primes.size() && primes.get(idx) <= i/2; idx++){
				if(i%primes.get(idx)==0){
					isPrime = false;
				}
				count++;
			}
			if(isPrime){
				primes.add(i);
			}
		}
		return primes.toArray(new Integer[0]);
	}

	public static void main(String[] args) {
		//2~100까지 소수를 구한다.
		Integer[] nums = getPrimes(100);
		for(int n : nums{
			System.out.println(n);
		}
		System.out.println("count: " + count);
	}
}
