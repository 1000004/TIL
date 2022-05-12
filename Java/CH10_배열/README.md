## 1. 배열
> #### 01.배열의 선언과 사용
>```java
>public class ArrayTest1 {
>  public static void main(String[] args) {
>    int[] arr = new int[3];
>    int[] arr2 = {3, 5, 8};
>    int[] arr3 = new int[] {3, 5, 8};
>    System.out.println(arr3.length);//배열 길이
>  }
>}
>```
> #### 02. 객체들의 배열
 >```java
>public class ArrayTest2 {
>  public static void main(String[] args) {
>    Object[] arr = new Object[3];//모든 객체는 Object(최상의 객체)를 상속받는다.
>    arr[0] = {"abc", "abc"};
>    arr[1] = new int[] {1,2,3};
>    arr[2] = new int[][] {{4,5}, {6,7}, {8,9}};
>  }
>}
>```
> #### 03. 다차원 배열
 >```java
>interface ISalesConstants {
>	int AREA_COUNT = 3;
>	int DEPT_COUNT = 2;	
>	int MONTHLY = 12;
>}
>class ArrEx13 implements ISalesConstants {
>	public static void main(String[] args) {//다차원 배열
>		double[][][] sales = new double[AREA_COUNT][DEPT_COUNT][MONTHLY];
>	}
>}
>```
## 2. 가변길이 복수데이터
    
