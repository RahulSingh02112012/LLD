package LowLevelDesigns.Memento_SnapshotDesignPattern;

public class CofigurationMemento {
    int height;
    int weight;

    public CofigurationMemento(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
