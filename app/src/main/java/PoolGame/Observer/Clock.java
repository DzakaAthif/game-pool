package PoolGame.Observer;

import org.apache.commons.lang3.StringUtils;

public class Clock extends Subject {

    private int minutes;
    private int seconds;
    private int frames;
    private double fps;
    private boolean changed;

    public Clock() {
        changed = false;
    }

    public String getTime() {
        String secStr = StringUtils.leftPad(String.valueOf(seconds), 2, '0');
        String minStr = StringUtils.leftPad(String.valueOf(minutes), 2, '0');
        String time = String.format("%s:%s", minStr, secStr);

        return time;
    }

    public void setFPS(double fps) {this.fps = fps;}

    public void incrementFrame() {

        frames++;

        if (frames >= fps) {
            frames = 0;
            seconds++;
            changed = true;
        }

        if (seconds >= 60) {
            seconds = 0;
            minutes++;
        }

    }

    public void reset() {
        frames = 0;
        seconds = 0;
        minutes = 0;
        alert();
    }

    public void setChanged(boolean changed) {this.changed = changed;}

    public boolean isChanged() {return this.changed;}
}
