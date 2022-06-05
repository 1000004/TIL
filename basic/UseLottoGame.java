import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class LottoGame10{
   private Scanner scan;
   private MyNums[] nums;
   private LottoNums goal;

   public LottoGame() {
      scan = new Scanner(System.in);
      howManyPlay();
      getGoal();
      showResult();
   }
   // 로또번호 구매
   private void howManyPlay() {
      System.out.print("몇개를 살까요 ? : ");
      int count = scan.nextInt();
      nums = new MyNums[count];   // MyNums배열을 count만큼 만듦
      // nums[0] ~ nums[count]까지 로또번호 생성
      for(int idx = 0; idx<count; idx++) {
         nums[idx] = new MyNums();
         System.out.println(idx+1 + "회 번호 : " + nums[idx]);
      }
   }
   // 로또번호 추첨
   private void getGoal() {
      goal = new LottoNums();   // goal에 로또번호(보너스번호포함) 생성
      System.out.println("당첨번호를 추첨 합니다.");
      System.out.println("당첨번호 : " + goal);
   }
   // 결과확인
   private void showResult() {
      // Integer배열 : goal의 인덱스 0번부터 5번까지 복사해서 저장
      Integer[] excBonus = Arrays.copyOfRange(
         goal.getNums(), 0, LottoNums.BONUS //골에서 0~보너스번호까지(보너스 번호 뺴고!)
      );
      // Integer배열을 List로 변경
      List<Integer> goalList = new Vector<Integer>(
         Arrays.asList(excBonus)
      );
      int no = 1;
      // 내가 구매한 로또번호을 당첨번호와 확인
      for(MyNums temp : nums) {
         // 구매한 로또번호를 List로 변경
         List<Integer> myList =
            new Vector<Integer>(Arrays.asList(temp.getNums()));
         // 구매한 로또번호 중에 당첨번호와 같은 번호만 남김
         myList.retainAll(goalList);
         int count = myList.size();
         int rank = 0;
         
         switch(count) {
            case 6 :
               rank = 1;
               break;
            case 5 :
               // 구매한 로또번호 에서 보너스 번호의 인덱스 번호 확인 -> 없으면 -1
               int indexOfBonus = Arrays.binarySearch(
                  temp.getNums(), goal.getBonusNum()
               );
               // 보너스 번호가 존재하면 index번호는 0이상으로 출력됨
               if(indexOfBonus >= 0) {
                  rank = 2;
               // 보너스 번호가 없으면 index번호는 0미만으로 출력됨
               } else {
                  rank = 3;
               }
               break;
            case 4 :
               rank = 4;
               break;
            case 3 :
               rank = 5;
               break;
         }
         String result;
         if(rank == 0) {
            result = "꽝";
         } else {
            result = rank + "등";
         }
         System.out.print(no + "회 게임 결과 : " + result);
         System.out.println("\t일치번호 -> " + myList);
         no++;
      }
   }
}
class UseLottoGame {
   public static void main(String[] args) {
      new LottoGame10();

   }
}
