package PoolGame.Builder;

import PoolGame.Items.Ball;
import PoolGame.Strategy.BallPocketStrategy;

public class PurpleBallBuilder extends BlueBallBuilder{

    public PurpleBallBuilder(Ball.BallType type, BallPocketStrategy action) {
        super(type, action);
    }

    public void reset() {
        super.reset();
        this.ball.setColour("purple");
        this.ball.setPoints(6);
    }

}
