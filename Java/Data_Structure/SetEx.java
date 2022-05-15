import java.util.*;

class SetEx {
	public static void main(String[] args) {
		// 로또 : 1~45까지 중복 없이 6개 뽑기
		
		//Set<Integer> nums = new HashSet<Integer>();
		Set<Integer> nums = new TreeSet<Integer>();//TreeSet 순서가 없어도 정렬(단, 인덱스 개념은 없다)
		Random r = new Random();
		while(nums.size() != 6) {
			int num = r.nextInt(45) + 1;
			nums.add(num);
		}

		System.out.println(nums);
	}
}
