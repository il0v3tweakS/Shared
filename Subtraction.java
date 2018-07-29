package calculator;

public class Subtraction implements IOperation {
    @Override
    public double compute(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }
}
