package wapago.baseball.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import wapago.baseball.constant.BaseBallProperties;
import wapago.baseball.controller.BaseBallController;

public class InputValidator {
	static BaseBallController baseBallController = new BaseBallController();
	
	private static String inputNumStr;
	private static String[] inputNumberArr = new String[BaseBallProperties.LENGTH_OF_NUMBER];
	private static List<String> inputNumStrList = new ArrayList<>();
	private static Set<String>  inputNumStrSet = new HashSet<>(); 
	
	public static void setValidator(String inputNumber) {
		inputNumStr = inputNumber;
		inputNumberArr = inputNumStr.split("");
		inputNumStrList = Arrays.asList(inputNumberArr);
		inputNumStrSet = new HashSet<>(inputNumStrList);
		
		isContainZero();
		isThreeNumber();
		isDuplicate();
	}
	
	private static void isContainZero() {
		if(inputNumStr.contains("0")) {
			throw new IllegalArgumentException("0은 입력할 수 없습니다.");
		}
	}
	
	private static void isThreeNumber() {
		if(inputNumStr.length() != BaseBallProperties.LENGTH_OF_NUMBER) {
			throw new IllegalArgumentException("세 자리 정수를 입력해주세요");
		}
	}
	
	private static void isDuplicate() {
		if(inputNumStrList.size() != inputNumStrSet.size()) {
			throw new IllegalArgumentException("같은 숫자는 입력할 수 없습니다.");
		}
	}
	
	private static void isOne() {
		if(inputNumStr.equals("1")) {
			baseBallController.start();
		}
	}
}
