import java.util.*;
public class SwitchEx  {
	public static void main(String[] args) {
		int year = 2009;
		int days = 0;

		System.out.print("일수를 알고 싶은 달을 입력하시오: ");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		/*
			if(month ==1 || month ==3 || month ==5 || month ==7 || month == 8...)
		*/

		switch (month){
			case 1 :
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 :
			case 12 :
				days =31;
				break;
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				days = 30;
				break;
			case 2 :
				if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
					days = 29;
				}else{
					days = 28;
				}
				break;
			default:
				System.out.println("월이 잘못 입력되었습니다.");
				break;
		}
		if (days != 0){
		System.out.println("월의 날수는 " + days);
		}
	}
	/*
	1 ~ 12월까지 입력 경우 : day출력
	범위를 벗어난 경우 "월이 잘못 입력되었습니다." 만 출력, 날수를 출력하지 않는다.
	*/	
}
