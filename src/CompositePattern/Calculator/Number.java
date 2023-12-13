package CompositePattern.Calculator;

public class Number implements ArithmeticExpression{

    int number;

    public Number (int value) {
        this.number = value;
    }

    @Override
    public int evaluate() {
        return this.number;
    }
}
