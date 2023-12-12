package DecoraterPattern;

public class ExtraCheese extends BasePizza{

    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
