package main.view.components.loginComponents;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Env;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.AbstractComponents.AbstractButtonRounded;
import main.view.components.CommonComponents.ButtonRounded;
import main.view.components.CommonComponents.ImageAndComponent;
import main.view.components.CommonComponents.InputPassword;
import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.TextOption;
import main.view.components.CommonComponents.TextSubtitle;
import main.view.components.CommonComponents.TextTitle;
import main.view.components.CommonComponents.TransparentPanel;

public class Login extends AbstractForm {
    // Componentes
    public InputText inputEmail;
    public InputPassword inputPassword;
    private AbstractButtonRounded button;
    private TransparentPanel containerOptions;
    private TextTitle title;
    private TextSubtitle subTitle;
    private TextOption optionPassword;
    private TextOption optionRegister;

    // Estilos globales
    private int roundedButtonGlobal = 15;
    private int fontSizeTitle = 40;
    private int fontSizeSubTitle = 12;
    private int fontSizeOptionPassword = 11;
    private int fontSizeOptionRegister = 11;
    private int columnsInputStandard = 20;
    private int gapOptions = 26;
    private int minWidthFormulation = 380;
    private int minHeightFormulation = 410;
    // Funcionalidad
    LoginActions actions;

    public Login() {
        initForm();
    }

    public Login(int rounded) {
        super(rounded);
        initForm();
    }

    public void initForm() {
        this.configLogin();
        this.createTitle();
        this.createInputs();
        this.createBoton();
        this.createAside();

    };

    private void configLogin() {
        this.actions = new LoginActions();
        defaultWidth = minWidthFormulation;
        defaultHeigth = minHeightFormulation;
        resizeRestore();
        resizeRestore();

    }

    private void createTitle() {
        int marginBottom = 7;
        int gap = 6;
        // Titula
        this.title = new TextTitle("Bienvenido", SwingConstants.CENTER);
        // sub-Titulo
        this.subTitle = new TextSubtitle("Iniciar sesión", SwingConstants.CENTER);

        // contenedor
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridLayout(2, 1, gap, gap));
        container.add(this.title);
        container.add(this.subTitle);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));// margin vertical

    }

    private void createInputs() {
        int widthImage = 42;
        int heightImage = 42;
        int gap = 17;
        int marginBottom = 15;
        // input Correo
        this.inputEmail = createInputText("Correo electrónico", this.columnsInputStandard);
        ImageAndComponent labelEmail = new ImageAndComponent(Env.PATH_ICON_EMAIL, widthImage, heightImage, inputEmail);
        addContent(labelEmail);
        addContent(Box.createVerticalStrut(gap));

        // input password
        this.inputPassword = createInputPassword("Contraseña", this.columnsInputStandard);
        ImageAndComponent labelPassword = new ImageAndComponent(Env.PATH_ICON_PADLOCK, widthImage, heightImage,
                this.inputPassword);
        addContent(labelPassword);
        addContent(Box.createVerticalStrut(marginBottom));

    }

    private void createBoton() {
        int marginBottom = 8;
        this.button = new ButtonRounded("Iniciar sesión", this.roundedButtonGlobal);
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 0);
        container.add(this.button, gbc);

        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));// margin vertical

        // Accion del boton
        this.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.actionsButtonLogin(inputEmail.getInput(), inputPassword.getPassword());
            }
        });

    };

    private void createAside() {
        // primer titulo
        this.optionPassword = new TextOption("¿Olvidaste tu Contraseña?", SwingConstants.CENTER);

        TransparentPanel opPass = new TransparentPanel();
        opPass.setLayout(new FlowLayout());

        // segundo titulo
        this.optionRegister = new TextOption("¿Aún no tiene cuenta? Registrate", SwingConstants.RIGHT);
        TransparentPanel opRegis = new TransparentPanel();
        opRegis.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // contenedor
        this.containerOptions = new TransparentPanel();
        this.containerOptions.setLayout(new GridLayout(2, 1, this.gapOptions, this.gapOptions));
        opPass.add(this.optionPassword);
        opRegis.add(this.optionRegister);
        this.containerOptions.add(opPass);
        this.containerOptions.add(opRegis);
        // se añade al contenido del formulario
        addContent(this.containerOptions);

        this.optionPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.actionsOptionPassword();
            }
        });

        this.optionRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.actionsOptionRegister();
            }
        });

    }

    private void resizeOptionsLg(int gap) {
        this.containerOptions.setLayout(new GridLayout(2, 1, gap, gap));

    }

    @Override
    protected void configResizeLarge() {
        int lgColum = 34;
        int lgRow = 45;
        for (JTextField input : getInputList()) {
            setRedimentionFields(input, lgColum, lgRow);
        }
        optionPassword.setFontSize(13);
        optionRegister.setFontSize(13);
        title.setFontSize(55);
        subTitle.setFontSize(14);
        resizeOptionsLg(45);

    }

    @Override
    protected void configResizeMedium() {

        int smRow = 37;
        int midColum = 24;

        for (JTextField input : getInputList()) {
            setRedimentionFields(input, midColum, smRow);
        }
        optionPassword.setFontSize(fontSizeOptionPassword);
        optionRegister.setFontSize(fontSizeOptionRegister);
        title.setFontSize(fontSizeTitle);
        subTitle.setFontSize(fontSizeSubTitle);
        resizeOptionsLg(gapOptions);
    }

    @Override
    protected void configResizeSmall() {
        int smColum = this.columnsInputStandard;
        int smRow = 37;

        for (JTextField input : getInputList()) {
            setRedimentionFields(input, smColum, smRow);
        }
        optionPassword.setFontSize(fontSizeOptionPassword);
        optionRegister.setFontSize(fontSizeOptionRegister);
        title.setFontSize(fontSizeTitle);
        subTitle.setFontSize(fontSizeSubTitle);
        resizeOptionsLg(gapOptions);
    }

}
