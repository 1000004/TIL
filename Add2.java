import java.util.Scanner;
//java.util : Package 이름
//클래스 밖 언사 아닌 설정
//동일한 클래스 이름 충돌 방지
//유일한 문자열
//Java에서 만든 API를 제외하고 도메인 이름을 뒤집어서 쓴다.
public class Add2 {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        //input 사용가능
        //Scanner input; //선언
        //input = new Scanner(System.in); //정의 
        //scanner(System.in) 키보드를 읽는 녀석
        //System.in 표준입력장치 : 키보드

        int x;
        int y;
        int sum;

        System.out.print("첫번째 숫자를 입력하시오: ");
        //System.out 표준입력장치(콘솔:입출력장치)
        x = input.nextInt();
        //키보드 입력 -> 입력
        //x 초기화

        System.out.print("두번째 숫자를 입력하시오: ");
        y = input.nextInt();
        //y 초기화

        sum = x + y;//sum 초기화
        
        System.out.println(sum);

    }
}