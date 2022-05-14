class ArrEx2 {
	public static void printSum(int n1, int n2){
		System.out.println(n1 + n2);
	}
	public static void printSum(int n1, int n2, int n3){
		System.out.println(n1 + n2 + n3);
	}
	// 배열을 파라미터로 활용하면 파라미터(동일한 타입) 갯수에 대해 자유롭게 사용가능하다.
	public static void printSum(int[] nums){
		int total = 0;
		for(int n : nums){
			total +=n;
		}
		System.out.println(total);
	}
	public static int todo1(){
		return 3;
	}
	// 배열로 리턴하면 여러개 값을 리턴하는 효과를 낼 수 있다.
	public static int[] returnValues(){
		return new int[] {1,2,3};
	}
	public static void main(String[] args) {
		printSum(3,4);
		printSum(3,4,5);
		
		printSum(new int[] {3,4,5,6,7});
		printSum(new int[] {3,4,5,6,7,8,9,10});

		int[] myArr = returnValues();
		printSum(myArr);
		
	}
}