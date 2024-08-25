package main.view.components;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.AbstractComponents.AbstractInputText;
import main.view.components.CommonComponents.InputPassword;
import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.JText;
import main.view.components.registerComponents.RegisterActions;

public class Register extends AbstractForm {
    // Componentes de la interfaz
    private InputText inputName;
    private InputText inputLastName;
    private InputText inputEmail;
    private InputPassword inputPassword;
    private InputPassword inputPasswordConfirm;
    private JComboBox selectType;
    private JText title;
    private JText optionLogin;

    private RegisterActions actions;

    public Register(int rounded) {
        super(rounded);
        initRegister();
    }

    public Register() {
        initRegister();
    }

    private void initRegister() {
        this.configRegister();
        this.createTitle();
        this.createInputs();
        this.createButton();
        this.createAside();
        this.settingResize();
    }

    public void configRegister() {
        this.actions = new RegisterActions();
   
    }

    private void createTitle() {
        
    };

    private void createInputs() {

    };

    private void createButton() {

    };

    private void createAside() {

    };

    private void settingResize() {
        // Tamaños del input
        int smColum = 16;
        int midColum = 22;
        int lgColum = 32;
        int smRow = 36;
        int lgRow = 42;

        // Tamaño de la pantalla para el resize
        int sm = 400;
        int mid = 540;

        // Ajuste de tamaños
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (getWidth() > mid) {
                    // Inputs
                    for (JTextField input : getInputList()) {
                        setRedimentionFields(input, lgColum, lgRow);
                    }

                }

                if (getWidth() > sm && getWidth() <= mid) {
                    // Inputs
                    for (JTextField input : getInputList()) {
                        setRedimentionFields(input, midColum, smRow);
                    }

                }

                if (getWidth() <= sm) {
                    // Inputs
                    for (JTextField input : getInputList()) {
                        setRedimentionFields(input, smColum, smRow);
                    }

                }
            }
        });

    }

    @Override
    protected void customInput(AbstractInputText input) {

    }
}
