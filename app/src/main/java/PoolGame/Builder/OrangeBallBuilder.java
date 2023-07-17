package PoolGame.Builder;

import PoolGame.Items.Ball;
import PoolGame.Strategy.BallPocketStrategy;

public class OrangeBallBuilder extends RedBallBuilder{

    public OrangeBallBuilder(Ball.BallType type, BallPocketStrategy action) {
        super(type, action);
    }

    public void reset() {
        super.reset();
        this.ball.setColour("orange");
        this.ball.setPoints(8);
    }

}
