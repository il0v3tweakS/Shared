package calculator;

public interface IState {
    IOperation changeFirstGroup();

    IOperation changeSecondGroup();

    IState changeFirstGroupState();

    IState changeSecondGroupState();

    void setFirstState(IState firstState);

    void setSecondState(IState secondState);


}
