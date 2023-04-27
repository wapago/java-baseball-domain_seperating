package wapago.baseball.model;

public class Result {
    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

}
