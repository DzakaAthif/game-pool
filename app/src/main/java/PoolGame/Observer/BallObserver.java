package PoolGame.Observer;

import PoolGame.Items.Ball;

public class BallObserver implements Observer{

    private Ball ball;
    private Score score;

    public BallObserver(Ball ball, Score score) {
        this.ball = ball;
        this.score = score;
    }
    public void update() {
        int point = ball.getPoints();
        int totalPoint = score.getPoints() + point;
        score.setPoints(totalPoint);

    }
}
