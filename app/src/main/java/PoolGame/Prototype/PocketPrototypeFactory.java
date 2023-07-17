package PoolGame.Prototype;

import PoolGame.Config.PocketConfig;
import PoolGame.Items.Pocket;

public class PocketPrototypeFactory {

    private Pocket prototype;

    public void setDefault(PocketConfig config) {
        prototype = new Pocket(0, 0,
                config.getRadius());
    }

    public Pocket create(PocketConfig config) {

        Pocket newPocket = prototype.clone();
        newPocket.setX(config.getPositionConfig().getX());
        newPocket.setY(config.getPositionConfig().getY());

        return newPocket;
    }
}
