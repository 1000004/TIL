import java.util.Scanner;
public class FToC {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("화씨 온도를 입력하십시오: ");
        int f = input.nextInt();

        input.close();

        System.out.println("섭씨 온도 :" + (5./9)*(f-32));
        //(5/9)의 경우 int/int로 값이 0이 되므로 5.0로 실수 형변환 해준다.
    }
}
