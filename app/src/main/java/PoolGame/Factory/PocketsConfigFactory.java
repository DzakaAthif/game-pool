package PoolGame.Factory;

import PoolGame.Config.Configurable;
import PoolGame.Config.PocketsConfig;

public class PocketsConfigFactory implements ConfigFactory{


    public Configurable make(Object jSONObject) {
//        System.out.print("from pocketsConfigFactory");
//        System.out.println(jSONObject);
        return new PocketsConfig(jSONObject);
    }
}
