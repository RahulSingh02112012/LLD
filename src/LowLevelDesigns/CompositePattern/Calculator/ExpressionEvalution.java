package LowLevelDesigns.CompositePattern.Calculator;

public class ExpressionEvalution implements ArithmeticExpression{

    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operation operation;

    public ExpressionEvalution(ArithmeticExpression left,ArithmeticExpression rightExpression,Operation operation) {
        this.leftExpression = left;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    @Override
    public int evaluate() {
        int val =0;

        switch (operation) {
            case ADD:
                val = leftExpression.evaluate() + rightExpression.evaluate();
                break;
            case SUBSTRACT:
                val = leftExpression.evaluate() - rightExpression.evaluate();
                break;
            case MULTIPLY:
                val = leftExpression.evaluate() * rightExpression.evaluate();
                break;
            case DIVIDE:
                val = leftExpression.evaluate() /rightExpression.evaluate();
                break;
        }

        return val;
    }
}
