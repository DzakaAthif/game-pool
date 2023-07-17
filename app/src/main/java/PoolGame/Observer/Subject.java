package PoolGame.Observer;

public abstract class Subject {

    private Observer observer;

    public void attach(Observer observer) {
        this.observer = observer;
    }

    public void detach() {
        this.observer = null;
    }

    public void alert() {
        this.observer.update();
    }
}
