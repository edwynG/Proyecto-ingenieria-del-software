package main.view.components.loginComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Env;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.AbstractComponents.AbstractInputText;
import main.view.components.CommonComponents.ButtonRounded;
import main.view.components.CommonComponents.ImageAndInput;
import main.view.components.CommonComponents.InputPassword;
import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.utils.ColorPalette;

public class FormLogin extends AbstractForm {

    public InputText emailInput;
    public InputPassword passwordInput;
    private String fontFamily = "Arial";
    private int radiusGobal = 15;
    private ButtonRounded button;

    public FormLogin() {
        initForm();

    }

    public FormLogin(int rounded) {
        super(rounded);
        initForm();
    }

    public void initForm() {
        setBorderColor(ColorPalette.COLOR_SENCOD);
        

        int widthImage = 42;
        int heightImage = 42;

        int smColum = 16;
        int midColum = 24;
        int lgColum = 38;
        int smRow = 36;
        int lgRow = 42;


        int sm = 400;
        int mid = 540;
        
        this.createTitle();
        this.createInputs(smColum, widthImage, heightImage);
        this.createBoton();
        this.createAside();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                super.componentResized(e);
                if (getWidth() > mid) {
                    for (JTextField input : listInputs) {
                        setRedimentionFields(input, lgColum, lgRow);

                    }
                }

                if (getWidth() > sm && getWidth() <= mid) {
                    for (JTextField input : listInputs) {
                        setRedimentionFields(input, midColum, smRow);

                    }
                }

                if (getWidth() <= sm) {
                    for (JTextField input : listInputs) {
                        setRedimentionFields(input, smColum, smRow);

                    }

                }
            }
        });

    };

    private void createAside(){
               // primer titulo
               JLabel titlefirt = new JLabel("¿Olvidaste tu Contraseña?",SwingConstants.CENTER);
               Font styleTitlefirt = new Font(this.fontFamily,Font.PLAIN,12);
               titlefirt.setFont(styleTitlefirt);
       
               // segundo titulo
               JLabel sencodTitle = new JLabel("¿Aún no tiene cuenta? Registrate",SwingConstants.RIGHT);
               Font styleSencodTitle =new Font(this.fontFamily,Font.PLAIN,12);
               sencodTitle.setFont(styleSencodTitle);
       
               // contenedor
               TransparentPanel container = new TransparentPanel();
               container.setLayout(new GridLayout(2,1,20,10));
               container.add(titlefirt);
               container.add(sencodTitle);
       
               this.add(container);
    }

    private void createTitle(){
        // Titula
        JLabel title = new JLabel("Bienvenido",SwingConstants.CENTER);
        Font styleTitle = new Font(this.fontFamily,Font.BOLD,30);
        title.setForeground(ColorPalette.COLOR_TITLE);
        title.setFont(styleTitle);

        // sub-Titulo
        JLabel subTitle = new JLabel("Iniciar sesión",SwingConstants.CENTER);
        Font styleSubTitle =new Font(this.fontFamily,Font.PLAIN,12);
        subTitle.setFont(styleSubTitle);

        // contenedor
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridLayout(2,1));
        container.add(title);
        container.add(subTitle);

        this.add(container);

    }

    private void createBoton() {
        button = new ButtonRounded("Iniciar Sesión", radiusGobal);
        button.setFontWeightText(Font.BOLD);
        button.setFontSizeText(13);
        button.setColorText(Color.WHITE);
        button.setFontFamilyText(this.fontFamily);
        this.add(button);

    };

    private void createInputs(int colums, int widthImage, int heightImage) {
        // input Correo
        emailInput = this.createInputText("Correo", colums);
        this.customInput(emailInput);
        this.listInputs.add(emailInput);
        ImageAndInput labelEmail = new ImageAndInput(Env.PATH_ICON_EMAIL, widthImage, heightImage, emailInput);
        this.add(labelEmail);

        // input password
        passwordInput = this.createInputPassword("Contraseña", colums);
        this.customInput(passwordInput);
        this.listInputs.add(passwordInput);
        ImageAndInput labelPassword = new ImageAndInput(Env.PATH_ICON_PADLOCK, widthImage, heightImage, passwordInput);
        this.add(labelPassword);
    }

    @Override
    protected void customInput(AbstractInputText input) {
        input.setFontFamilyText(this.fontFamily);
        input.setBorderColorField(ColorPalette.COLOR_FIELD);
    }


}
