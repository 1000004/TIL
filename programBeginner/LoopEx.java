public class LoopEx {
    public static void main(String[] args){
        //1.1~10까지 합으 구하시오
        //분할정복(divide and conquer)
        /*
            0+1+2+3+~
        */
        int sum = 0;
        int num = 1;
        while(num <= 10){
            //num : 1 ~ 10
            sum = sum + num;
            num++;
        }
        System.out.println(sum);
        //2. 1~1000까지 홀수의 합을 구하시오

        /*
        sum = 0;
        num = 1;
        sum = sum + 1
        sum = sum + 3
        sum = sum + 5
        ...
        sum = sum + 999
        (sum = sum + ) 가 반복된다. -> 반복문
        */
 
        /*
        sum = 0;
        num = 1;
        while(num<=1000){
            if(num % 2 !=0){    // 1~1000까지 반복해야한다.
                sum += num;
            }
            num++;
        }
 
        */
        sum = 0;
        num = 1;
        while(num <= 1000){
            //num : 1~1000
            sum += num;
            num += 2; //  바로 2를 더함으로써 홀수 값만 반복함으로써 반복수를 반으로 줄일수 있다.
            
        }

        System.out.println(sum);
        /*
            3. 4단을 역으로 출력하시오.
            4 * 9 = 36
            4 * 8 = 32
            4 * 7 = 28
            ...
            4 * 1 = 4
        */
        int dan = 4;
        num = 9;
        while(num>=1){
            //num : 9 ~ 1
            System.out.println(dan + "*" + num + "=" + (dan*num));
            num--;
        }
    }
}
