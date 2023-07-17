package PoolGame.Builder;

import PoolGame.Items.Ball;
import PoolGame.Strategy.BallPocketStrategy;

public class BrownBallBuilder extends BlueBallBuilder{

    public BrownBallBuilder(Ball.BallType type, BallPocketStrategy action) {
        super(type, action);
    }

    public void reset() {
        super.reset();
        this.ball.setColour("brown");
        this.ball.setPoints(4);
    }
}
