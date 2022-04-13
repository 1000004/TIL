/*
	클래스 명 -> Stock
	
	상품번호 -> id : String
	재고수량 -> amount : int
	재고증가 -> increase(count:int) : void
	재고감소 -> decrease(count:int) : void
*/
class Stock{
	String id;
	int amount;

	void increase(int count){
        //증가 count가 0보다 크면 if 실행
		if(checkCount(count, "증가")){
			amount += count;
			printAmount();
		}
	}
	void decrease(int count){
		boolean flag = checkCount(count, "감소");
        //감소 count가 0보다 크면 if 실행
		if(flag){
            //재고 이상의 수만 감소 가능
			if(amount >= count){
				amount += count;//amount = ammount - count;
				printAmount();
			} else {
				System.out.println("재고가 부족합니다.");
			}
		}
	}
    //증가 감소 count가 0보다 크면 true 작으면 false
	boolean checkCount(int count,String kind){
		if(count>0){
			return true;
		}else{
			System.out.println(kind + "수량은 0보다 큰 수여야 합니다.");
			return false;
		}
	}
	void printAmount(){
		System.out.println("재고수량 : " + amount);
	}
}


public class  UseStock  {
	public static void main(String[] args) {
		Stock s = new Stock();

		s.id = "green0001";
		s.amount =100;

		s.increase(20);
		//s.printAmount();
		s.increase(-10);

		s.decrease(40);
		//s.printAmount();
		s.decrease(400);

        Stock other = s;//동일한 객체를 주소로 둔다

		other.printAmount();

		other.increase(10);

		s.printAmount();

	}
}