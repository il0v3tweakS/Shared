package calculator;

public class Multiplication implements  IOperation {
    @Override
    public double compute(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
}
