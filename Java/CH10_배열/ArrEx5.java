class ArrEx6 {
	public static void change(int[] temp){ 
        //참조 변수 배열
		temp[0] = 100;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		change(arr);
        //파라미터에 참조 변수인 배열을 넣었기 때문에 베열 arr에 영향을 미친다.
        //파라미터에 배열 요소를 넣는 경우 배열 arr 요소에 영향을 안 미친다. 
		System.out.println(arr[0]);
	}
}
