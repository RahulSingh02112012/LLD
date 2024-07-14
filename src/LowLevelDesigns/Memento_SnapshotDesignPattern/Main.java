package LowLevelDesigns.Memento_SnapshotDesignPattern;

public class Main {
    public static void main(String[] args) {
          ConfigurationOriginator originator = new ConfigurationOriginator(5,10);

          CofigurationMemento snapshot1 = originator.createMemento();
          ConfigurationCareTaker careTaker = new ConfigurationCareTaker();
          careTaker.addMemento(snapshot1);

          originator.setHeight(9);
          originator.setWeight(10);
         CofigurationMemento snapshot2 = originator.createMemento();
         careTaker.addMemento(snapshot2);

         originator.setWeight(15);
         originator.setHeight(20);

         CofigurationMemento restored = careTaker.undo();
         originator.restoreMemento(restored);

         System.out.println("Height is : " + originator.getHeight() + " Weight is : " + originator.getWeight());


    }
}
