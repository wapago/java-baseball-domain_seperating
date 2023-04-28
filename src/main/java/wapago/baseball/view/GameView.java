package wapago.baseball.view;

import wapago.baseball.constant.BaseBallProperties;
import wapago.baseball.model.Result;
import wapago.baseball.util.InputValidator;

import java.util.Scanner;

public class GameView {
	Scanner scanner = new Scanner(System.in);

	InputValidator inputValidator = new InputValidator();

	public void requestInput() {
		System.out.println("숫자를 입력하세요 : ");
	}
	
	public String getInputNumber() {
		String inputNumber = scanner.next();
		inputValidator.playInputValidator(inputNumber);
		
		return inputNumber; 
	}

	public int getInputRestartNumber() {
		String inputRestart = scanner.next();
		inputValidator.restartInputValidator(inputRestart);

		return Integer.parseInt(inputRestart);
	}

	public int showResult(Result result) {
		int strike = result.getStrike();
		int ball = result.getBall();

		if(strike != 0 && ball == 0) {
			System.out.println(strike + "스트라이크");
        }

        if(strike == 0 && ball != 0) {
			System.out.println(ball + "볼");
        }

		if(strike != 0 && ball != 0) {
			System.out.println(strike + "스트라이크 " + ball + "볼");
		}

		if(strike == 0 && ball == 0) {
			System.out.println("낫싱");
		}

		if(strike == BaseBallProperties.LENGTH_OF_NUMBER) {
			System.out.println(BaseBallProperties.LENGTH_OF_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}

		return strike;
	}
	
	public void askRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
