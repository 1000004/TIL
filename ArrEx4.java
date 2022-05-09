import java.util.Arrays;

class ArrEx4 {
	public static void main(String[] args) {
		int[] nums = {1,6,2,8,10,3,4};

		//오름차순으로 정렬하라...
		Arrays.sort(nums);

		System.out.println(Arrays.toString(nums));

		String[] strs = {"abc", "ab", "acc", "abb", "a", "ac"};

		Arrays.sort(strs);

		System.out.println(Arrays.toString(strs));
	}
}
