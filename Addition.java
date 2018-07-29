package calculator;

public class Addition implements IOperation {
    @Override
    public double compute(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
}
