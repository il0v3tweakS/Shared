package calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField firstField;
    private JTextField secondField;
    private JButton computeButton;
    private JTextField resultField;
    private JRadioButton aRadioButon;
    private JRadioButton bRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton dRadioButton;
    private ButtonGroup firstRadioButtonGroup;
    private ButtonGroup secondRadioButtonGroup;
    private IOperation operation;
    private IState operationState;
    private double firstOperand;
    private double secondOperand;
    private double result;

    public Calculator() {
        initOps();
        initialize();
        adjustWindow();
        applyStyle();
        centerWindow();
        addToFrame();
        addListeners();


    }

    private void initOps() {
        IOperation addition = new Addition();
        IOperation subtraction = new Subtraction();
        IOperation multiplication = new Multiplication();
        IOperation division = new Division();

        IState add = new AdditionState(subtraction, multiplication);
        IState sub = new SubtractionState(addition, division);
        IState div = new DivisionState(subtraction, multiplication);
        IState mult = new MultiplicationState(addition, division);

        add.setFirstState(mult);
        add.setSecondState(sub);

        sub.setFirstState(div);
        sub.setSecondState(add);

        div.setFirstState(mult);
        div.setSecondState(sub);

        mult.setFirstState(div);
        mult.setSecondState(add);

        operation = addition;
        operationState = add;

    }


    private void addListeners() {
        computeButton.addActionListener(e -> {
            firstOperand = Double.parseDouble(firstField.getText());
            secondOperand = Double.parseDouble(secondField.getText());
            result = operation.compute(firstOperand, secondOperand);
            resultField.setText(Double.toString(result));
        });


        aRadioButon.addActionListener(e -> {
            operation = operationState.changeFirstGroup();
            operationState = operationState.changeFirstGroupState();
        });


        bRadioButton.addActionListener(e -> {
            operation = operationState.changeFirstGroup();
            operationState = operationState.changeFirstGroupState();

        });


        cRadioButton.addActionListener(e -> {
            operation = operationState.changeSecondGroup();
            operationState = operationState.changeSecondGroupState();
        });


        dRadioButton.addActionListener(e -> {
            operation = operationState.changeSecondGroup();
            operationState = operationState.changeSecondGroupState();
        });
    }

    private void addToFrame() {
        mainPanel.add(firstField);
        mainPanel.add(secondField);
        mainPanel.add(computeButton);
        mainPanel.add(aRadioButon);
        mainPanel.add(bRadioButton);
        mainPanel.add(cRadioButton);
        mainPanel.add(dRadioButton);

        firstRadioButtonGroup.add(aRadioButon);
        firstRadioButtonGroup.add(bRadioButton);
        secondRadioButtonGroup.add(cRadioButton);
        secondRadioButtonGroup.add(dRadioButton);

        firstRadioButtonGroup.clearSelection();
        secondRadioButtonGroup.clearSelection();

        aRadioButon.setSelected(true);
        cRadioButton.setSelected(true);

        mainPanel.add(resultField);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initialize() {
        firstOperand = 0;
        secondOperand = 0;
        frame = new JFrame("Calculator");
        mainPanel = new JPanel();
        firstField = new JTextField();
        secondField = new JTextField();
        computeButton = new JButton("Compute");
        resultField = new JTextField();

        aRadioButon = new JRadioButton("A");
        bRadioButton = new JRadioButton("B");
        cRadioButton = new JRadioButton("C");
        dRadioButton = new JRadioButton("D");

        firstRadioButtonGroup = new ButtonGroup();
        secondRadioButtonGroup = new ButtonGroup();
    }

    private void adjustWindow() {
        frame.setSize(300, 300);
    }

    private void centerWindow() {
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension screenSize = tool.getScreenSize();

        double screenHeight = screenSize.height;
        double screenWidth = screenSize.width;

        double currentWindowHeight = frame.getHeight();
        double currentWindowWidth = frame.getWidth();

        int windowHeight = (int) ((screenHeight / 2) - (currentWindowHeight / 2));
        int windowWidth = (int) ((screenWidth / 2) - (currentWindowWidth / 2));

        frame.setLocation(windowWidth, windowHeight);
    }

    private void applyStyle() {
        firstField.setPreferredSize(new Dimension(240, 30));
        secondField.setPreferredSize(new Dimension(240, 30));
        resultField.setPreferredSize(new Dimension(240, 30));
        computeButton.setPreferredSize(new Dimension(240, 30));
    }
}
