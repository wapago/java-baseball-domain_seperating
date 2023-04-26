package wapago.baseball.view;

import java.util.Scanner;

public class GameView {
	Scanner scanner = new Scanner(System.in);
	
	public void requestInput() {
		System.out.println("숫자를 입력하세요 : ");
	}
	
	public String getInputNumber() {
		String inputNumber = scanner.next();
		
		return inputNumber; 
	}
	
	public void askRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
