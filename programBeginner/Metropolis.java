import java.util.Scanner;
public class Metropolis {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        System.out.print("수도입니까?(수도:1 수도아님: 0)");
        //수도인경우 -> isCapital : ture, 수도가 아닌경우 -> isCapital : false
        boolean isCapital = (sc.nextInt()==1);
        //boolean isCapital = (Sc.nextInt()==1)? turn : false;
        //수도인지 아닌지 나타내는 변수
        System.out.print("인구(단위: 만)");
        int citizens = sc.nextInt();
        //인구 수
        System.out.print("부자의 수(단위: 만)");
        int riches = sc.nextInt();
        //부자(연소득 1억이상인 사람) 수

        sc.close();

        //메트로폴리스여부 = 조건1 || 조건2
        boolean isMetro = (isCapital && citizens >= 100)||(riches>=50);
        //수도이고 인구가 100만 이상 or 부자의 수가 50만 이상
        //둘중 하나라도 맞으면 isMetro = true
        System.out.println("메트로폴리스 여부: "+ isMetro);

    }

    
}
