package wapago.baseball.util;

import wapago.baseball.constant.BaseBallProperties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
	private final static String NUMERIC = "^[1-9]+$";
	
	public void playInputValidator(String inputNumber) {
		isNumeric(inputNumber);
		isContainZero(inputNumber);
		isThreeNumber(inputNumber);
		isDuplicate(inputNumber);
	}

	public void isNumeric(String inputNumber) {
		if(!inputNumber.matches(NUMERIC)) {
			throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
		}
	}

	public void isContainZero(String inputNumber) {
		if(inputNumber.contains("0")) {
			throw new IllegalArgumentException("0은 입력할 수 없습니다.");
		}
	}

	public void isThreeNumber(String inputNumber) {
		if(inputNumber.length() != BaseBallProperties.LENGTH_OF_NUMBER) {
			throw new IllegalArgumentException("세 자리 정수를 입력해주세요");
		}
	}

	public void isDuplicate(String inputNumber) {
		Set<String> checkSet = new HashSet<>(Arrays.asList(inputNumber.split("")));
		if(checkSet.size() != BaseBallProperties.LENGTH_OF_NUMBER) {
			throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
		}
	}

	public void isOneNumber(String inputRestart) {
		if(inputRestart.length() != 1) {
			throw new IllegalArgumentException("한 자리 정수를 입력해주세요");
		}
	}

	public void restartInputValidator(String restart) {
		isNumeric(restart);
		isOneNumber(restart);
	}
}
