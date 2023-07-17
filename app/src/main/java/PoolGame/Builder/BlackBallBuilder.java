package PoolGame.Builder;

import PoolGame.Items.Ball;
import PoolGame.Strategy.BallPocketStrategy;

public class BlackBallBuilder extends BlueBallBuilder{

    public BlackBallBuilder(Ball.BallType type, BallPocketStrategy action) {
        super(type, action);
    }

    public void reset() {
        super.reset();
        this.ball.setColour("black");
        this.ball.setPoints(7);
    }
}
