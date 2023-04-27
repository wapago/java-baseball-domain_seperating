package wapago.baseball.controller;

import wapago.baseball.constant.BaseBallProperties;
import wapago.baseball.util.CreateRandomNumber;
import wapago.baseball.util.InputValidator;
import wapago.baseball.util.MatchWithRndNumber;
import wapago.baseball.view.GameView;

public class BaseBallController {
	public static Integer[] randomNumber = new Integer[BaseBallProperties.LENGTH_OF_NUMBER];
	
	GameView gameView = new GameView();

	public void start() {
		randomNumber = CreateRandomNumber.createRandomNumber();
		play();
	}
	
	public void play() {
		int strike = 0;

		while(strike != 3) {
			gameView.requestInput();
			String inputNumber = gameView.getInputNumber();
			InputValidator.playInputValidator(inputNumber);
			int[] result = MatchWithRndNumber.setMatchWithRandomNumber(inputNumber);
			strike = gameView.showResult(result);
		}

		isRestart();
	}
	
	public void isRestart() {
		gameView.askRestart();
		String inputRestart = gameView.getInputNumber();
		InputValidator.restartInputValidator(inputRestart);

		if(inputRestart.equals("1")) {
			start();
		}

		System.exit(0);
	}
}
