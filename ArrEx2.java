class ArrEx2 {
	public static void main(String[] args) {
		double[][][][][][][][][][][][][][][] list = new double[2][][][][][][][][][][][][][][];


		int[][] arr = new int[2][3];
		
		int n = arr[0][0];
		System.out.println(n);
		System.out.println(arr[0].length);
		arr[0] = new int[] {1,2,3,4,5,6,7};
		arr[1] = new int[] {4,8,9};
		System.out.println(arr[0].length);//길이 3->7로 변경
		System.out.println(arr[1].length);//길이 3
		/*
		for(int[] temp : arr) {
			for(int n : temp) {
				System.out.println(n);
			}
			System.out.println("----------------");
		}
		*/
	}
}
