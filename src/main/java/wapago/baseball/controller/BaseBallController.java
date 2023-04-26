package wapago.baseball.controller;

import wapago.baseball.constant.BaseBallProperties;
import wapago.baseball.model.Computer;
//import wapago.baseball.model.Match;
import wapago.baseball.util.CreateRandomNumber;
import wapago.baseball.util.InputValidator;
import wapago.baseball.view.GameView;

public class BaseBallController {
	public static Integer[] randomNumber = new Integer[BaseBallProperties.LENGTH_OF_NUMBER];
	
	GameView gameView = new GameView();
	Computer computer = new Computer();
//	Match match = new Match();
	
	public void start() {
		randomNumber = CreateRandomNumber.createRandomNumber();
		play();
	}
	
	public void play() {
		gameView.requestInput();
		String inputNumber = gameView.getInputNumber();
		InputValidator.setValidator(inputNumber);
//		match.setMatchWithRndNumber(inputNumber);
	}
	
	public void askRestart() {
		gameView.askRestart();
	}
}
