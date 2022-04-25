class BankAccount{
	private int balance;
	public int getBalance(){
		return balance;
	}
	public void deposit(int amount){
		balance += amount;
	}
	public boolean withdraw(int amount){
		if(amount <= balance){
			balance -=amount;
			return true;
		}else{
			System.out.println("잔액이 부족합니다.");
			return false;
		}
	}
	public void transfer(int amount, BankAccount otherAccount){
		// 송금할때 일어날일
		// 보내는 계좌 : 송금액만큼 감소
		System.out.println("송금시작");
		if(withdraw(amount)){
			withdraw(amount);
			otherAccount.deposit(amount);
			System.out.println("송금 완료");
		}
	}
	public String toString(){
		return "현재 잔액은 "+balance+"입니다.";
	}
}

public class BankAccountTest  {
	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		BankAccount b2 = new BankAccount();
		b1.deposit(10);
		// b1에서 b2로 4만원 송금한다.
		b1.transfer(4,b2);
		System.out.println(b1);
		System.out.println(b2);
	}
}
