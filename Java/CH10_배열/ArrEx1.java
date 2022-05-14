class ArrEx1{
	public static void main(String[] args) {
		String[] arr = {"banna", "grape", "kiwi", "apple"};
		
		for(int idx=0; idx<arr.length; idx++){
			//idx : 0, 1, 2, 3
			System.out.println(arr[idx]);
		}
		for(int idx=arr.length-1;idx>=0; idx--){
			//idx : 3, 2, 1, 0
			System.out.println(arr[idx]);
		}
		//인덱스로 접근(X)
		//대입연산이 어려움 -> 원소 변경이 어려움
		//접근방향을 변경할 수 없다.
		//선택적 접근 불가능
		for(String fruit : arr){//for-each 문 JDK 1.5~
			System.out.println(fruit);
		}
	}
}
