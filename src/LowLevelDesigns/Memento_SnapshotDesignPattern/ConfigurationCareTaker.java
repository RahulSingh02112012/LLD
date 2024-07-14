package LowLevelDesigns.Memento_SnapshotDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {
    List<CofigurationMemento> history;

    public ConfigurationCareTaker() {
        this.history = new ArrayList<>();
    }

    public void addMemento(CofigurationMemento memento) {
        history.add(memento);
    }

    public CofigurationMemento undo() {
        if(!history.isEmpty()) {
            CofigurationMemento last = history.get(history.size()-1);
            history.remove(history.size()-1);
            return last;
        }
        return null;
    }
}
