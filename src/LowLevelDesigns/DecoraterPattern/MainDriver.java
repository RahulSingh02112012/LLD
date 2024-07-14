package LowLevelDesigns.DecoraterPattern;

public class MainDriver {
    public static void main(String[] args) {
        BasePizza basePizzaCost = new ExtraCheese(new Margarita());
        System.out.printf("Cost of Pizza is: %d%n",basePizzaCost.cost());
    }
}
