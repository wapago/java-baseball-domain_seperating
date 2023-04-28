package wapago.baseball.util;

import wapago.baseball.constant.BaseBallProperties;
import wapago.baseball.model.Result;

import java.util.Arrays;
import java.util.List;

public class MatchWithRndNumber {
    Integer[] randomNumber = new Integer[3];

    public void setRandomNumber(Integer[] numbers) {
        for(int i=0; i<BaseBallProperties.LENGTH_OF_NUMBER; i++) {
            randomNumber[i] = numbers[i];
        }
    }

    int strike = 0;
    int ball = 0;

    public Result setMatchWithRandomNumber(String inputNumber) {
        String[] inputNumberStringArr = inputNumber.split("");
        Integer[] inputNumberIntegerArr = new Integer[BaseBallProperties.LENGTH_OF_NUMBER];

        for(int i=0; i< BaseBallProperties.LENGTH_OF_NUMBER; i++) {
            inputNumberIntegerArr[i] = Integer.parseInt(inputNumberStringArr[i]);
        }

        countStrike(inputNumberIntegerArr);
        countBall(inputNumberIntegerArr);

        Result result = new Result(strike, ball);

        return result;
    }

    private void countStrike(Integer[] inputNumberIntegerArr) {
        strike = 0;

        for(int i=0; i<BaseBallProperties.LENGTH_OF_NUMBER; i++) {
            if(randomNumber[i].equals(inputNumberIntegerArr[i])) {
                strike++;
            }
        }
    }

    private void countBall(Integer[] inputNumberIntegerArr) {
        ball = 0;

        List<Integer>  randomNumberList = Arrays.asList(randomNumber);

        for(int i=0; i<BaseBallProperties.LENGTH_OF_NUMBER; i++) {
            if(randomNumberList.contains(inputNumberIntegerArr[i]) && !randomNumberList.get(i).equals(inputNumberIntegerArr[i])) {
                ball++;
            }
        }
    }
}
