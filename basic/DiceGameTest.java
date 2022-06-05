import java.util.Scanner;
class DiceGame{
	private int diceFace;
	private int userGuess;

	//주사위 눈 결정
	private int rollDice(){
		return (int)(Math.random()*6)+1;
	}
	//사용자 입력받기
	private int getUserInput(){
		System.out.println("예상값을 입력하시오: ");
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	//맞습니까?
	private boolean checkUserGuess(){
		if(diceFace == userGuess){
			System.out.println("맞습니다.");
			return false;
		}else{
			System.out.println("들렸습니다.");
			return true;
		}
	}
	//게임의 진행순서를 표현
	/*
		1. 주사위 눈결정
		2. 사용자입력
		3. 판정
	*/
	public void startPlaying(){
		diceFace = rollDice();
		do{
		userGuess = getUserInput();
		}while(checkUserGuess());
	}
}

public class DiceGameTest  {
	public static void main(String[] args) {
		DiceGame game = new DiceGame();
		game.startPlaying();
	/*
		사용자가 정답을 입력할때 까지 계속 입력받게 수정하라.
		단, 주사위 눈은 변하지 않는다.
	*/

	}
}
