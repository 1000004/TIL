/*
	배열 : length말고 제공하는 기능이나 정보가 없다.

	배열의 도우미 클래스 
		-Arrys-
			-> 배열로 할 수 있는 빈도높은 연산들을 제공
			-> static 메서드로 기능제공
*/
import java.util.Arrays;
class ArrEx16 {
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		/*
		for(int n : arr){
			System.out.println(n);
		}
		*/

		String strArr = Arrays.toString(arr);
		System.out.println(strArr);

		//오름차순으로 정렬하라...
		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		String[] strs = {"abc", "ab", "acc", "abb", "a", "ac"};

		Arrays.sort(strs);

		System.out.println(Arrays.toString(strs));
	}
}