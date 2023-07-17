package PoolGame.Config;

import org.json.simple.JSONObject;

public class PocketConfig implements Configurable{

    private PositionConfig position;
    private double radius;

    public PocketConfig(Object obj) { this.parseJSON(obj); }

    public void init(PositionConfig posConf, double radius) {
        this.position = posConf;
        this.radius = radius;
    }

    public Configurable parseJSON(Object obj) {

        JSONObject json = (JSONObject) obj;
        PositionConfig posConf = new PositionConfig(json.get("position"));
        double radius = (double) json.get("radius");
        this.init(posConf, radius);

        return null;
    }

    public PositionConfig getPositionConfig() {return this.position;}

    public double getRadius() {return this.radius;}
}
