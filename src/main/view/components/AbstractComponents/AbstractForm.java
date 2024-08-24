package main.view.components.AbstractComponents;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTextField;

import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.InputPassword;

public abstract class AbstractForm extends AbstractPanelRounded {

    protected ArrayList<JTextField> listInputs;

    public AbstractForm(int rounded) {
        super(rounded);
        initAbstractForm();
    }

    public AbstractForm() {
        initAbstractForm();
    }

    private void initAbstractForm() {
        setPreferredSize(new Dimension(300, 400));
        this.listInputs = new ArrayList<>();
    }

    protected InputText createInputText(String placeholder, int columns) {
        InputText input = new InputText(columns, placeholder);
        input.addEffectPlaceHolder();
        return input;

    }

    protected InputPassword createInputPassword(String placeholder, int columns) {
        InputPassword input = new InputPassword(columns, placeholder);
        input.addEffectPlaceHolder();
        return input;
    }

    protected void setRedimentionFields(JTextField input, int columns, int height) {
        input.setColumns(columns);
        input.setPreferredSize(new Dimension(input.getWidth(), height));
        revalidate();
        repaint();
    }

    protected abstract void customInput(AbstractInputText input);

}