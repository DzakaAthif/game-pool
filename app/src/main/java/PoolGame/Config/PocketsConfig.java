package PoolGame.Config;

import PoolGame.Items.Pocket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PocketsConfig implements Configurable{

    private List<PocketConfig> pockets;
    public PocketsConfig(Object jSONObject) { this.parseJSON(jSONObject);}

    public void init(List<PocketConfig> pockets) {this.pockets = pockets;}

    public Configurable parseJSON(Object obj) {

        JSONArray json = (JSONArray) obj;
        List<PocketConfig> list = new ArrayList<>();
//        System.out.print("from pocketsconfig: ");
//        System.out.println(obj);
        for (Object o : json) {
            list.add(new PocketConfig(o));
        }

        this.init(list);
        return this;
    }

    public List<PocketConfig> getPocketConfigs() {return this.pockets;}
}
