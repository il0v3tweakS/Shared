package calculator;

public class Division implements IOperation {
    @Override
    public double compute(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }
}
