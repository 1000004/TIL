import java.util.Scanner;
//45분 일찍 울리는 알람시계
public class AlarmClock {
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int realH = sc.nextInt();//시간입력
         int realM = sc.nextInt();
         int gap = 45;//45분 차이
         int visibleH = realH;
         int visibleM = realM - gap;
         if (visibleM < 0){
			 if (visibleH==0){
				visibleH = 23;
			 }else{
				 visibleH = realH-1;
			 }
             visibleM = realM - gap + 60;
         }
         System.out.println(visibleH+" "+visibleM);
     }   
}
