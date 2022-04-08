public class IfExCaution {
    public static void main(String[] args){
        /*
            블럭이 나오면 실행이 보장이 되는지 아닌지 확인
            변수, 상수 주위
        */
        int n;

        boolean flag=true;

        //변수 : 값이 바뀔수 있다.
        /* 
        
            if(flag){
                n=4;
            }
        
            결과 변수 n 정의 오류

            if(flag){
                n=4;
            } else if(!flag){
                n=3;
            }

            결과 변수 n 정의 오류
        
        */
        //flag 변수로 바뀔 수 있는 값
        //변수는 초기화와 상관없이 조건문에는 변수가 ture인 경우와 false인 경우를 생각한다.
        //[해결책 1] flag를 상수(변하지 않는 수) ture로 변경
        //[해결책 2] else 추가

        if(flag) {
            n = 4;
        }else {
            n = 2;
        }

        System.out.println(n);

        if(flag) {
            n = 4;
        } else if(!flag){
            n = 2;
        }else{
            n=1;
        }

        System.out.println(n);
    
    }
}
