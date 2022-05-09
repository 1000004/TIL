import java.util.Arrays;
import java.util.Comparator;
class SortEx1 {
	public static void main(String[] args) {
		String[] arr = {"apple", "apply", "application", "adapter", "america"};

		Arrays.sort(arr);
		// String natura ordering -> 알파벳 순
		System.out.println(Arrays.toString(arr));

		// 알파벳 역순으로 정렬
		Arrays.sort(arr, new ReverseOrderingOfString());
		System.out.println(Arrays.toString(arr));

	}
}
class ReverseOrderingOfString implements Comparator<String> {
	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2) * -1;
	}
}