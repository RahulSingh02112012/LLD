package CompositePattern.Calculator;

public class Main {
    public static void main(String[] args) {
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);

        ArithmeticExpression addExpresion = new ExpressionEvalution(one,seven,Operation.ADD);
        ArithmeticExpression multipleExpression = new ExpressionEvalution(addExpresion,two,Operation.MULTIPLY);

        System.out.println(multipleExpression.evaluate());
    }
}
