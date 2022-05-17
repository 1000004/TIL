class ExceptionEx3 {
	public static int[] makeArray(int length){
		int[] arr = null;
		try{
			arr = new int[length];
			for(int i=0; i<arr.length; i++){
				arr[i] = (int)(Math.random()*10)+1;
			}
		}catch(NegativeArraySizeException e){
			System.out.println("배열의 길이는 음수가 될 수 없습니다.");
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] myArr1 = makeArray(3);
		int[] myArr2 = makeArray(-4);
		System.out.println("end of main");

	}
}
