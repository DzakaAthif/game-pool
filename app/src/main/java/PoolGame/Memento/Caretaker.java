package PoolGame.Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private List<Memento> mementos;

    public Caretaker() {this.mementos = new ArrayList<>();}

    public Memento getMemento() {

        if (mementos.size() == 0)
            return null;

        return mementos.remove(mementos.size()-1);
    }

    public void addMemento(Memento memento) {
        this.mementos.add(memento);

    }

    public void reset() {this.mementos.clear();}

}
