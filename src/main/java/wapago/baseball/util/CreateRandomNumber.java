package wapago.baseball.util;

import wapago.baseball.constant.BaseBallProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateRandomNumber {
	private List<Integer> oneToNine = new ArrayList<>();
	private final Integer[] randomNumberArr = new Integer[BaseBallProperties.LENGTH_OF_NUMBER];
	
	public Integer[] createRandomNumber() {
		createOneToNine();
		shuffle(oneToNine);
		
		for(int i=0; i<BaseBallProperties.LENGTH_OF_NUMBER; i++) {
			randomNumberArr[i] = oneToNine.get(i);
		}
		
		return randomNumberArr;
	}
	
	private void createOneToNine() {
		for(int i=BaseBallProperties.MIN_NUMBER_RANGE; i<=BaseBallProperties.MAX_NUMBER_RANGE; i++) {
			oneToNine.add(i);
		}
	}
	
	private static void shuffle(List<Integer> oneToNine) {
		Collections.shuffle(oneToNine);
	}
}
