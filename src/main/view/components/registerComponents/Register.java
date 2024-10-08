package main.view.components.registerComponents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Env;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.commonComponents.ButtonRounded;
import main.view.components.commonComponents.Dropdown;
import main.view.components.commonComponents.ImageAndComponent;
import main.view.components.commonComponents.InputPassword;
import main.view.components.commonComponents.InputText;
import main.view.components.commonComponents.TextOption;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.Components;
import main.view.utils.CustomVariables;

public class Register extends AbstractForm {
    // Componentes de la interfaz
    private InputText inputEmail;
    private InputPassword inputPassword;
    private InputPassword inputPasswordConfirm;
    private Dropdown dropdown;
    private ButtonRounded button;
    private TextTitle title;
    private TextOption optionLogin;
    private int minWidthFormulation = 380;
    private int minHeightFormulation = 410;
    // Estilos globales
    private int fontSizeTitle = 40;
    private int fontSizeOptionLogin = 11;
    private int roundedButtonGlobal = CustomVariables.RADIO_DEFAULT_BUTTON;
    private int columnsInputStandard = 20;
    private int widthDropdown = 218;
    private int heightDropdown = 40;
    // Funcionalidad
    private RegisterActions actions;

    public Register(int rounded) {
        super(rounded);
        initRegister();
    }

    public Register() {
        initRegister();
    }

    private void initRegister() {
        configRegister();
        createTitle();
        createInputs();
        createDropdown();
        createButton();
        createAside();
    }

    public void configRegister() {
        actions = new RegisterActions();
        defaultWidth = minWidthFormulation;
        defaultHeigth = minHeightFormulation;
        redimentionRestore();

    }

    private void createTitle() {
        int marginBottom = 14;
        // titulo
        title = new TextTitle("Registro", SwingConstants.CENTER);
        TransparentPanel container = new TransparentPanel();
        container.add(title);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));
    };

    private void createInputs() {
        int width = 41;
        int height = 41;
        int gap = 17;

        // input correo
        inputEmail = createInputText("Correo electrónico", columnsInputStandard);
        ImageAndComponent labelEmail = new ImageAndComponent(Env.PATH_ICON_EMAIL, width, height, inputEmail);
        addContent(labelEmail);
        addContent(Box.createVerticalStrut(gap));

        // input contraseña
        inputPassword = createInputPassword("Contraseña", columnsInputStandard);
        ImageAndComponent labelPassword = new ImageAndComponent(Env.PATH_ICON_PADLOCK, width, height,
                inputPassword);
        addContent(labelPassword);
        addContent(Box.createVerticalStrut(gap));

        // input confirmar contraseña
        inputPasswordConfirm = createInputPassword("Confirmar contraseña", columnsInputStandard);
        ImageAndComponent labelPasswordConfirm = new ImageAndComponent(Env.PATH_ICON_PADLOCK, width, height,
                inputPasswordConfirm);
        addContent(labelPasswordConfirm);
        addContent(Box.createVerticalStrut(gap));

        inputEmail.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                widthDropdown = inputEmail.getWidth();
                heightDropdown = inputEmail.getHeight();
                resizeDropdown(widthDropdown, heightDropdown);
            }
        });

    };

    private void createDropdown() {
        int height = 41;
        int width = 41;
        int marginBottom = 20;
        ArrayList<String> options = new ArrayList<>();
        options.add(Env.TYPE_USER_PROPONENT);
        options.add(Env.TYPE_USER_ADMINISTRADOR);
        dropdown = new Dropdown("Tipo de usuario");
        dropdown.setListElements(options);
        ImageAndComponent container = new ImageAndComponent(Env.PATH_ICON_USER, width, height, dropdown);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

        dropdown.getOptionList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (dropdown.getSelectElement().equals(Env.TYPE_USER_PROPONENT)) {
                    button.setText("Continuar");
                    return;
                }
                button.setText("Registrarse");

            }
        });

    }

    private void createButton() {
        int marginBottom = 20;
        button = new ButtonRounded("Continuar", roundedButtonGlobal);
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 0);
        container.add(button, gbc);

        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                // La lista tiene que tener por la estructura de la consulta
                ArrayList<String> data = new ArrayList<>();
                data.add(inputEmail.getText().toLowerCase());
                data.add(inputPassword.getPassword());
                data.add(inputPasswordConfirm.getPassword());
                data.add(dropdown.getSelectElement());
                String option = dropdown.getSelectElement();
                if (option != null && option.equals(Env.TYPE_USER_PROPONENT)) {
                    actions.actionsButtonContinueRegisterProponent(data);
                    return;
                }
                actions.actionsTerminateRegistrationAdmin(data);
            }
        });

    };

    private void createAside() {
        optionLogin = new TextOption("¿Tiene usted una cuenta? Iniciar sesión", SwingConstants.CENTER);
        TransparentPanel container = new TransparentPanel();
        container.add(optionLogin);
        addContent(container);

        optionLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actions.actionsOptionLogin();
            }
        });

    };

    private void resizeDropdown(int width, int height) {
        Components.setRedimentionComponent(dropdown, width, height);

    }

    @Override
    protected void configResizeLarge() {
        int lgColum = 34;
        int lgRow = 45;
        setRedimentionFields(lgColum, lgRow);
        optionLogin.setFontSize(13);
        title.setFontSize(55);
    }

    @Override
    protected void configResizeMedium() {
        int smRow = 37;
        int midColum = 24;
        setRedimentionFields(midColum, smRow);
        optionLogin.setFontSize(fontSizeOptionLogin);
        title.setFontSize(fontSizeTitle);
    }

    @Override
    protected void configResizeSmall() {
        int smColum = columnsInputStandard;
        int smRow = 37;
        setRedimentionFields(smColum, smRow);
        optionLogin.setFontSize(fontSizeOptionLogin);
        title.setFontSize(fontSizeTitle);
    }

}
