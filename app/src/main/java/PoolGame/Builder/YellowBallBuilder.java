package PoolGame.Builder;

import PoolGame.Items.Ball;
import PoolGame.Strategy.BallPocketStrategy;

public class YellowBallBuilder extends RedBallBuilder{

    public YellowBallBuilder(Ball.BallType type, BallPocketStrategy action) {
        super(type, action);
    }

    public void reset() {
        super.reset();
        this.ball.setColour("yellow");
        this.ball.setPoints(2);
    }

}
