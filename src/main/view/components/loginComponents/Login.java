package main.view.components.loginComponents;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.SwingConstants;

import main.Env;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.commonComponents.ButtonRounded;
import main.view.components.commonComponents.ImageAndComponent;
import main.view.components.commonComponents.InputPassword;
import main.view.components.commonComponents.InputText;
import main.view.components.commonComponents.TextOption;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.AbstractComponents.AbstractButtonRounded;
import main.view.utils.CustomVariables;

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
    private int roundedButtonGlobal = CustomVariables.RADIO_DEFAULT_BUTTON;
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
        configLogin();
        createTitle();
        createInputs();
        createBoton();
        createAside();

    };

    private void configLogin() {
        actions = new LoginActions();
        defaultWidth = minWidthFormulation;
        defaultHeigth = minHeightFormulation;
        redimentionRestore();
    }

    private void createTitle() {
        int marginBottom = 7;
        int gap = 6;
        // Titula
        title = new TextTitle("Bienvenido", SwingConstants.CENTER);
        // sub-Titulo
        subTitle = new TextSubtitle("Iniciar sesión", SwingConstants.CENTER);

        // contenedor
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridLayout(2, 1, gap, gap));
        container.add(title);
        container.add(subTitle);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));// margin vertical

    }

    private void createInputs() {
        int widthImage = 42;
        int heightImage = 42;
        int gap = 17;
        int marginBottom = 15;
        // input Correo
        inputEmail = createInputText("Correo electrónico", columnsInputStandard);
        ImageAndComponent labelEmail = new ImageAndComponent(Env.PATH_ICON_EMAIL, widthImage, heightImage, inputEmail);
        addContent(labelEmail);
        addContent(Box.createVerticalStrut(gap));

        // input password
        inputPassword = createInputPassword("Contraseña", columnsInputStandard);
        ImageAndComponent labelPassword = new ImageAndComponent(Env.PATH_ICON_PADLOCK, widthImage, heightImage,
                inputPassword);
        addContent(labelPassword);
        addContent(Box.createVerticalStrut(marginBottom));

    }

    private void createBoton() {
        int marginBottom = 8;
        button = new ButtonRounded("Iniciar sesión", roundedButtonGlobal);
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
        addContent(Box.createVerticalStrut(marginBottom));// margin vertical

        // Accion del boton
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.actionsButtonLogin(inputEmail.getInput().toLowerCase(), inputPassword.getInput());
            }
        });

    };

    private void createAside() {
        // primer titulo
        optionPassword = new TextOption("¿Olvidaste tu Contraseña?", SwingConstants.CENTER);

        TransparentPanel opPass = new TransparentPanel();
        opPass.setLayout(new FlowLayout());

        // segundo titulo
        optionRegister = new TextOption("¿Aún no tiene cuenta? Registrate", SwingConstants.RIGHT);
        TransparentPanel opRegis = new TransparentPanel();
        opRegis.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // contenedor
        containerOptions = new TransparentPanel();
        containerOptions.setLayout(new GridLayout(2, 1, gapOptions, gapOptions));
        opPass.add(optionPassword);
        opRegis.add(optionRegister);
        containerOptions.add(opPass);
        containerOptions.add(opRegis);
        // se añade al contenido del formulario
        addContent(containerOptions);

        optionPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.actionsOptionPassword();
            }
        });

        optionRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.actionsOptionRegister();
            }
        });

    }

    private void resizeOptionsLg(int gap) {
        containerOptions.setLayout(new GridLayout(2, 1, gap, gap));

    }

    @Override
    protected void configResizeLarge() {
        int lgColum = 34;
        int lgRow = 45;
        setRedimentionFields(lgColum, lgRow);
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
        setRedimentionFields(midColum, smRow);
        optionPassword.setFontSize(fontSizeOptionPassword);
        optionRegister.setFontSize(fontSizeOptionRegister);
        title.setFontSize(fontSizeTitle);
        subTitle.setFontSize(fontSizeSubTitle);
        resizeOptionsLg(gapOptions);
    }

    @Override
    protected void configResizeSmall() {
        int smColum = columnsInputStandard;
        int smRow = 37;
        setRedimentionFields(smColum, smRow);
        optionPassword.setFontSize(fontSizeOptionPassword);
        optionRegister.setFontSize(fontSizeOptionRegister);
        title.setFontSize(fontSizeTitle);
        subTitle.setFontSize(fontSizeSubTitle);
        resizeOptionsLg(gapOptions);
    }

}
