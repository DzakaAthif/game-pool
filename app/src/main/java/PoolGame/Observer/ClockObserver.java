package PoolGame.Observer;

import javafx.scene.text.Text;

public class ClockObserver implements Observer {

    private String timeStr;
    private Clock clock;
    private Text text;

    public ClockObserver(Clock clock, Text text) {
        this.clock = clock;
        this.timeStr = "00:00";
        this.text = text;
    }
    public void update() {
        timeStr = clock.getTime();
        text.setText(timeStr);
    }

}
