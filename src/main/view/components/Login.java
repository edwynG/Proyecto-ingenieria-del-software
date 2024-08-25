package main.view.components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Env;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.AbstractComponents.AbstractInputText;
import main.view.components.AbstractComponents.AbstractButtonRounded;
import main.view.components.CommonComponents.ButtonRounded;
import main.view.components.CommonComponents.ImageAndInput;
import main.view.components.CommonComponents.InputPassword;
import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.JText;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.components.loginComponents.LoginActions;
import main.view.utils.ColorPalette;

public class Login extends AbstractForm {
    // Componentes
    public InputText inputEmail;
    public InputPassword inputPassword;
    private AbstractButtonRounded button;

    private JText title;
    private JText subTitle;
    private JText optionPassword;
    private JText optionRegister;

    // Estilos globales
    private String fontFamily = "Arial";
    private int radiusGobal = 15;
    private int fontSizeTitle = 30;
    private int fontSizeSubTitle = 12;
    private int fontSizeOptionPassword = 11;
    private int fontSizeOptionRegister = 11;

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
        this.settingResize();

    };

    private void configLogin() {
        this.actions = new LoginActions();
      
    }

    private void createTitle() {
        // Titula
        this.title = new JText("Bienvenido", SwingConstants.CENTER);
        Font style = new Font(this.fontFamily, Font.BOLD, fontSizeTitle);
        this.title.setForeground(ColorPalette.COLOR_TITLE);
        this.title.setConfig(style);

        // sub-Titulo
        this.subTitle = new JText("Iniciar sesión", SwingConstants.CENTER);
        style = new Font(this.fontFamily, Font.PLAIN, fontSizeSubTitle);
        this.subTitle.setConfig(style);

        // contenedor
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridLayout(2, 1, 5, 6));
        container.add(this.title);
        container.add(this.subTitle);
        this.addContent(container);
        this.addContent(Box.createVerticalStrut(7));// margin vertical

    }

    private void createInputs() {
        int colums = 16;
        int widthImage = 42;
        int heightImage = 42;

        // input Correo
        this.inputEmail = this.createInputText("Correo", colums);
        this.customInput(this.inputEmail);
        this.addInputList(this.inputEmail);
        ImageAndInput labelEmail = new ImageAndInput(Env.PATH_ICON_EMAIL, widthImage, heightImage, inputEmail);
        this.addContent(labelEmail);
        this.addContent(Box.createVerticalStrut(10));


        // input password
        this.inputPassword = this.createInputPassword("Contraseña", colums);
        this.customInput(this.inputPassword);
        this.addInputList(this.inputPassword);
        ImageAndInput labelPassword = new ImageAndInput(Env.PATH_ICON_PADLOCK, widthImage, heightImage, this.inputPassword);
        this.addContent(labelPassword);
        this.addContent(Box.createVerticalStrut(25));

    }

    private void createBoton() {
        this.button = new ButtonRounded("Iniciar Sesión", radiusGobal);
        this.button.setFontWeightText(Font.BOLD);
        this.button.setFontSizeText(13);
        this.button.setColorText(Color.WHITE);
        this.button.setFontFamilyText(this.fontFamily);
        TransparentPanel containerBtn = new TransparentPanel();
        containerBtn.setLayout(new GridBagLayout());

        // Accion del boton
        this.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.eventButtonLogin(inputEmail.getText(), inputPassword.getPassword());
            }
        });

        // se añade al contenido del formulario
        this.addContent(button);
        this.addContent(Box.createVerticalStrut(8));// margin vertical

    };

    private void createAside() {
        // primer titulo
        this.optionPassword = new JText("¿Olvidaste tu Contraseña?", SwingConstants.CENTER);
        Font style = new Font(this.fontFamily, Font.PLAIN, this.fontSizeOptionPassword);
        this.optionPassword.setConfig(style);
        this.optionPassword.createEventHover(Color.BLUE);
        TransparentPanel opPass = new TransparentPanel();
        opPass.setLayout(new FlowLayout());

        this.optionPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.eventOptionPassword();
            }
        });

        // segundo titulo
        this.optionRegister = new JText("¿Aún no tiene cuenta? Registrate", SwingConstants.RIGHT);
        style = new Font(this.fontFamily, Font.PLAIN, this.fontSizeOptionRegister);
        this.optionRegister.setConfig(style);
        this.optionRegister.createEventHover(Color.BLUE);
        TransparentPanel opRegis = new TransparentPanel();
        opRegis.setLayout(new FlowLayout(FlowLayout.RIGHT));

        this.optionRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                actions.eventOptionRegister();
            }
        });

        // contenedor
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridLayout(2, 1, 20, 25));
        opPass.add(this.optionPassword);
        opRegis.add(this.optionRegister);
        container.add(opPass);
        container.add(opRegis);

        // se añade al contenido del formulario
        this.addContent(container);

    }

    private void settingResize() {
        // Tamaños del input
        int smColum = 16;
        int midColum = 22;
        int lgColum = 32;
        int smRow = 36;
        int lgRow = 42;

        // Tamaño de la pantalla para la redimención
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
                    optionPassword.setFontSize(13);
                    optionRegister.setFontSize(13);
                    title.setFontSize(40);
                    subTitle.setFontSize(14);

                }

                if (getWidth() > sm && getWidth() <= mid) {
                    // Inputs
                    for (JTextField input : getInputList()) {
                        setRedimentionFields(input, midColum, smRow);
                    }
                    optionPassword.setFontSize(fontSizeOptionPassword);
                    optionRegister.setFontSize(fontSizeOptionRegister);
                    title.setFontSize(fontSizeTitle);
                    subTitle.setFontSize(fontSizeSubTitle);
                }

                if (getWidth() <= sm) {
                    // Inputs
                    for (JTextField input : getInputList()) {
                        setRedimentionFields(input, smColum, smRow);
                    }
                    optionPassword.setFontSize(fontSizeOptionPassword);
                    optionRegister.setFontSize(fontSizeOptionRegister);
                    title.setFontSize(fontSizeTitle);
                    subTitle.setFontSize(fontSizeSubTitle);

                }
            }
        });

    }

    @Override
    protected void customInput(AbstractInputText input) {
        input.setFontFamilyText(this.fontFamily);
        input.setBorderColorField(ColorPalette.COLOR_FIELD);
    }

}
