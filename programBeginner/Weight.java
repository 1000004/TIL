import java.util.Scanner;
public class Weight  {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("키를 입력하오(cm): ");
		int h = scan.nextInt();
		System.out.print("체중을 입력하시오(kg): ");
		int w = scan.nextInt();
		scan.close();
		double weight = (h -100)*0.9;
		String stWeight = "표준";
		int gap = 5; //표준 범위 설정
		if (w>(weight + gap)){
			stWeight = "과체중";
		}
		else if (w<(weight - gap)){
			stWeight = "저체중";
		}
		System.out.println("표준체중 : " + weight);
		System.out.println("당신은 " + stWeight + " 입니다.");
			
	}
}

