package PoolGame.Memento;

import PoolGame.Items.Ball;

import java.util.List;

public class Memento {

    private List<Ball> balls;
    private int score;

    public Memento(List<Ball> balls, int score) {

        this.balls = balls;
        this.score = score;
    }

    public void setState(List<Ball> balls, int score) {
        this.balls = balls;
        this.score = score;
    }
    public List<Ball> getBalls() {return this.balls;}
    public int getScore() {return this.score;}
}
