package calculator;

public class MultiplicationState implements IState {
    private IOperation addition;
    private IOperation division;
    private IState divisionState;
    private IState additionState;

    public MultiplicationState(IOperation addition, IOperation division) {
        this.addition = addition;
        this.division = division;
    }

    @Override
    public IOperation changeFirstGroup() {
        return addition;
    }

    @Override
    public IOperation changeSecondGroup() {
        return division;
    }

    @Override
    public IState changeFirstGroupState() {
        return additionState;
    }

    @Override
    public IState changeSecondGroupState() {
        return divisionState;
    }

    @Override
    public void setFirstState(IState divisionState) {
        this.divisionState = divisionState;
    }

    @Override
    public void setSecondState(IState additionState) {
        this.additionState = additionState;
    }
}
