package wapago.baseball.controller;

import wapago.baseball.constant.BaseBallProperties;
import wapago.baseball.model.Result;
import wapago.baseball.util.CreateRandomNumber;
import wapago.baseball.util.MatchWithRndNumber;
import wapago.baseball.view.GameView;

public class BaseBallController {
	public Integer[] randomNumber = new Integer[3];
	
	GameView gameView = new GameView();
	CreateRandomNumber createRandomNumber = new CreateRandomNumber();
	MatchWithRndNumber matchWithRandomNumber = new MatchWithRndNumber();

	public void start() {
		createRandomNumber();
		play();
	}

	public void createRandomNumber() {
		randomNumber = createRandomNumber.createRandomNumber();
	}

	public void play() {
		int strike = 0;

		while(strike != 3) {
			gameView.requestInput();
			String inputNumber = gameView.getInputNumber();
			matchWithRandomNumber.setRandomNumber(randomNumber);
			Result result = matchWithRandomNumber.setMatchWithRandomNumber(inputNumber);
			strike = gameView.showResult(result);
		}

		isRestart();
	}
	
	public void isRestart() {
		gameView.askRestart();
		int inputRestart = gameView.getInputRestartNumber();

		if(inputRestart == BaseBallProperties.RESTART) {
			start();
		}

		System.exit(0);
	}
}
