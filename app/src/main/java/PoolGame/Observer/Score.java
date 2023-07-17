package PoolGame.Observer;

import javafx.scene.text.Text;

public class Score {

    private int points;
    private Text text;

    public Score(Text text) {
        this.points = 0;
        this.text = text;
    }

    public void setPoints(int points) {
        this.points = points;
        this.text.setText(String.format("Score: %d", this.points));
    }

    public int getPoints() {return this.points;}
}
