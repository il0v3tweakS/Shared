package calculator;

public class SubtractionState implements  IState {
    private IOperation addition;
    private IOperation division;
    private IState divisionState;
    private IState additionState;

    public SubtractionState(IOperation addition, IOperation division) {
        this.addition = addition;
        this.division = division;
    }

    @Override
    public IOperation changeFirstGroup() {
        return division;
    }

    @Override
    public IOperation changeSecondGroup() {
        return addition;
    }

    @Override
    public IState changeFirstGroupState() {
        return divisionState;
    }

    @Override
    public IState changeSecondGroupState() {
        return additionState;
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
