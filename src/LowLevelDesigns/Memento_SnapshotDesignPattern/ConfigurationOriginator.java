package LowLevelDesigns.Memento_SnapshotDesignPattern;

public class ConfigurationOriginator {
    int height;
    int weight;

    public ConfigurationOriginator(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CofigurationMemento createMemento() {
        return new CofigurationMemento(this.height, this.weight);
    }

    public void restoreMemento(CofigurationMemento mementoToRestore) {
        this.weight = mementoToRestore.weight;
        this.height = mementoToRestore.height;
    }


}
