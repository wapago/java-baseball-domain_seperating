package wapago.baseball.util;

import wapago.baseball.constant.BaseBallProperties;
import wapago.baseball.controller.BaseBallController;
import wapago.baseball.model.Result;

import java.util.Arrays;
import java.util.List;

public class MatchWithRndNumber {
    static Integer[] randomNumber = BaseBallController.randomNumber;

    static int strike = 0;
    static int ball = 0;

    public static int[] setMatchWithRandomNumber(String inputNumber) {
        String[] inputNumberStringArr = inputNumber.split("");
        Integer[] inputNumberIntegerArr = new Integer[BaseBallProperties.LENGTH_OF_NUMBER];

        for(int i=0; i< BaseBallProperties.LENGTH_OF_NUMBER; i++) {
            inputNumberIntegerArr[i] = Integer.parseInt(inputNumberStringArr[i]);
        }

        countStrike(inputNumberIntegerArr);
        countBall(inputNumberIntegerArr);

        Result result = new Result(strike, ball);

        int resultStrike = result.getStrike();
        int resultBall = result.getBall();

        int[] resultArray = {resultStrike, resultBall};

        return resultArray;
    }

    private static void countStrike(Integer[] inputNumberIntegerArr) {
        strike = 0;

        for(int i=0; i<BaseBallProperties.LENGTH_OF_NUMBER; i++) {
            if(randomNumber[i].equals(inputNumberIntegerArr[i])) {
                strike++;
            }
        }
    }

    private static void countBall(Integer[] inputNumberIntegerArr) {
        ball = 0;

        List<Integer>  randomNumberList = Arrays.asList(randomNumber);

        for(int i=0; i<BaseBallProperties.LENGTH_OF_NUMBER; i++) {
            if(randomNumberList.contains(inputNumberIntegerArr[i]) && !randomNumberList.get(i).equals(inputNumberIntegerArr[i])) {
                ball++;
            }
        }
    }
}
