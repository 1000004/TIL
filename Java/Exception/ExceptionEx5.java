class ExceptionEx5 {
	public static void makeException(int length){
        //동시 상황 객체 발생 되지 않는다.
        //위 코드가 예외 처리시 더 이상 코드가 실행 되지 않으며 추가적인 예외 처리가 발생하지 않는다.
		//여러 catch 블럭은 순차적으로 확인
        try{
			int[] arr = new int[length];

			A a = new A();
			B b = (B)a;
        /*
        } catch(Exception e){ 
            //다형성
            //모든 예외 처리 가능
            //추가적인 catch블럭이 실행 되지 않으므로 error
            System.out.println("All");
        */
		} catch(ClassCastException e){
			System.out.println("A");
            e.printStackTrace();
			String msg = e.getMessage();//상황 객체 메시지를 가져온다. 
			System.out.println(msg);
		} catch(NegativeArraySizeException e){
			System.out.println("B");
            System.out.println(e.getMessage());//NegativeArraySizeException는 메시지가 없으므로 null
		}
        //catch블럭에 따른 해야 할 일이 달라진다.
        //일구분
        //Objcet 일구분
	}
	public static void main(String[] args) {
		makeException(3);
		makeException(-1);
	}
}
