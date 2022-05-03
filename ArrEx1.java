class ArrEx1 {
	public static void main(String[] args) { //String 담는 배열
		// 1 : 원소 갯수는 아는데 뭐가 올지 모를때, 원소는 알고있으나 너무 많을때
		int[] arr;

		arr = new int[3];//정수가 3개담기는 배열

		arr[0] = 3;
		arr[1] = 5;
		arr[2] = 8;

		System.out.println(arr.length);
		
		//2(1과 동일한 정수를 3개를 가진 배열)
		//이미 원소를 다 알고 생성할 때
		int[] arr2 = {3, 5, 8};

		//3(1과 동일한 정수를 3개를 가진 배열)
		//이름없이 사용할 때(원소 내용을 알고 있음)
		int[] arr3 = new int[] {3, 5, 8};
		//2,3은 길이가 3개인건 알지만 뭐가 들어가는지 모를때 사용 못한다.
		//2은 선언정의 분리를 못한다.
	}
}
