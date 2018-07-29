package calculator;

public class AdditionState implements IState {
    private IOperation subtraction;
    private IOperation multiplication;
    private IState multiplicationState;
    private IState subtractionState;

    public AdditionState(IOperation subtraction, IOperation multiplication) {
        this.subtraction = subtraction;
        this.multiplication = multiplication;
    }

    @Override
    public IOperation changeFirstGroup() {
        return multiplication;
    }

    @Override
    public IOperation changeSecondGroup() {
        return subtraction;
    }

    @Override
    public IState changeFirstGroupState() {
        return multiplicationState;
    }

    @Override
    public IState changeSecondGroupState() {
        return subtractionState;
    }


    public void setFirstState(IState multiplicationState) {
        this.multiplicationState = multiplicationState;
    }

    public void setSecondState(IState subtractionState) {
        this.subtractionState = subtractionState;
    }
}
