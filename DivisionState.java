package calculator;

public class DivisionState implements IState {
    private IOperation subtraction;
    private IOperation multiplication;
    private IState multiplicationState;
    private IState subtractionState;

    public DivisionState(IOperation subtraction, IOperation multiplication) {
        this.subtraction = subtraction;
        this.multiplication = multiplication;
    }

    @Override
    public IOperation changeFirstGroup() {
        return subtraction;
    }

    @Override
    public IOperation changeSecondGroup() {
        return multiplication;
    }

    @Override
    public IState changeFirstGroupState() {
        return subtractionState;
    }

    @Override
    public IState changeSecondGroupState() {
        return multiplicationState;
    }


    @Override
    public void setFirstState(IState multiplicationState) {
        this.multiplicationState = multiplicationState;
    }

    @Override
    public void setSecondState(IState subtractionState) {
        this.subtractionState = subtractionState;
    }
}
