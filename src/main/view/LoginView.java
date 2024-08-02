package main.view;

import main.controller.UserController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.View;


public class LoginView extends JFrame {

    private JPanel panelDark;
    private JPanel panelLight;
    private JLabel labelCourseStackLogo;
    private JLabel labelPanelLightWelcome;
    private JLabel labelEmail;
    private JTextField textfieldEmail;
    private JLabel labelPassword;
    private JPasswordField passwordfieldPassword;
    private JLabel labelRegisterMessage;
    private JLabel labelForgotYourPasswordMessage;
    private JButton buttonLogin;

    private Color backgroundColor;
    private Color foregroundColor;
    private Color messageColor;

    private Font font;
    private Font dimensionTextFieldFont;
    private Font dimensionTextButton;
    private Font dimensionLabelRegisterMessage;

    private Dimension frameDimension;


    private ImageIcon courseStackLogo;
    private ImageIcon emailImageIcon;
    private ImageIcon passwordImageIcon;

    private GroupLayout darkGroupLayout;
    private GroupLayout lightGroupLayout;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        frameDimension = new Dimension(1000, 620);
        setPreferredSize(frameDimension);
        setResizable(false);

        backgroundColor = new Color(21, 21, 21);
        foregroundColor = new Color(255, 255, 255);
        messageColor = new Color(68, 83, 91);

        font = new Font("SansSerif", Font.BOLD, 42);
        dimensionTextFieldFont = new Font("SansSerif", Font.PLAIN, 20);
        dimensionTextButton = new Font("SansSerif", Font.BOLD, 20);
        dimensionLabelRegisterMessage =  new Font("SansSerif", Font.BOLD, 15);

        courseStackLogo = new ImageIcon("src/resources/img/logoCourseStack.png");
        labelCourseStackLogo = new JLabel(courseStackLogo);

        emailImageIcon = new ImageIcon("src/resources/img/correo.png");
        labelEmail = new JLabel(emailImageIcon);
        textfieldEmail = new JTextField();
        textfieldEmail.setPreferredSize(new Dimension(260, 35));
        textfieldEmail.setFont(dimensionTextFieldFont);
        textfieldEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Email", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        passwordImageIcon = new ImageIcon("src/resources/img/candado.png");
        labelPassword = new JLabel(passwordImageIcon);
        passwordfieldPassword = new JPasswordField();
        passwordfieldPassword.setPreferredSize(new Dimension(260, 40));
        passwordfieldPassword.setFont(dimensionTextFieldFont);
        passwordfieldPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Contraseña", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        buttonLogin = new JButton("Iniciar Sesión");
        buttonLogin.setBackground(messageColor);
        buttonLogin.setForeground(foregroundColor);
        buttonLogin.setFont(dimensionTextButton);


        labelForgotYourPasswordMessage = new JLabel("¿Olvidó su Contraseña?");
        labelRegisterMessage = new JLabel("¿Aún no tiene cuenta? Registrarse");
        labelRegisterMessage.setFont(dimensionLabelRegisterMessage);

        labelPanelLightWelcome = new JLabel("Bienvenido");
        labelPanelLightWelcome.setForeground(messageColor);
        labelPanelLightWelcome.setFont(font);

        panelDark = new JPanel();
        panelDark.setBackground(backgroundColor);
        darkGroupLayout = new GroupLayout(panelDark);
        panelDark.setLayout(darkGroupLayout);

        
        panelLight = new JPanel();
        panelLight.setBackground(foregroundColor);

        buttonLogin.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en el botón de iniciar sesión
                UserController entra = new UserController();
                if(entra.leer(textfieldEmail.getText())){
                    System.out.print("cerró");
                    setVisible(false);
                }
            } 
            
                
        });

        labelRegisterMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                // Acción al hacer clic en el mensaje de registro
                new RegisterView().setVisible(true);
                setVisible(false);
            }
            
        });

// Configuración GroupLayout para lightPanel

lightGroupLayout = new GroupLayout(panelLight);
panelLight.setLayout(lightGroupLayout);
lightGroupLayout.setAutoCreateGaps(true);
lightGroupLayout.setAutoCreateContainerGaps(true);

lightGroupLayout.setHorizontalGroup(
	lightGroupLayout.createSequentialGroup()
    	.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
    		.addComponent(labelPanelLightWelcome)
    		.addGroup(lightGroupLayout.createSequentialGroup()
    			.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addComponent(labelEmail)
					.addComponent(labelPassword)
				)
				.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(textfieldEmail)
					.addComponent(passwordfieldPassword)
					.addComponent(buttonLogin,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE )
					
				)
    		)
    		.addComponent(labelForgotYourPasswordMessage)
    		.addComponent(labelRegisterMessage)
    	)
);

	lightGroupLayout.setVerticalGroup(
		lightGroupLayout.createSequentialGroup()
				.addGap(50)
				.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(labelPanelLightWelcome)
				)
				.addGap(50)
				.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(labelEmail)
					.addComponent(textfieldEmail,GroupLayout.PREFERRED_SIZE,40,GroupLayout.PREFERRED_SIZE)
				)
				.addGap(25)
				.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(labelPassword)
					.addComponent(passwordfieldPassword,GroupLayout.PREFERRED_SIZE,40,GroupLayout.PREFERRED_SIZE)
				)
				.addGap(25)
				.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(buttonLogin,GroupLayout.PREFERRED_SIZE,35,GroupLayout.PREFERRED_SIZE)
				)
				.addGap(15)
				.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(labelForgotYourPasswordMessage)
				)
				.addGap(20)
				.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(labelRegisterMessage)
				)

				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	);

// Configuración GroupLayout para darkGroupLayout
        darkGroupLayout.setHorizontalGroup(
            darkGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(darkGroupLayout.createSequentialGroup()
                    .addGap(100) // Espacio a la izquierda
                    .addComponent(labelCourseStackLogo)
                    .addGap(100) // Espacio entre el logo y el panel claro
                    .addComponent(panelLight)
                    .addGap(50) // Espacio a la derecha
                )
        );
        
        darkGroupLayout.setVerticalGroup(
            darkGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(darkGroupLayout.createSequentialGroup()
                    .addGap(50) // Espacio arriba
                    .addGroup(darkGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelCourseStackLogo)
                        .addComponent(panelLight)
                    )
                    .addGap(50) // Espacio abajo
                )
        );

        setContentPane(panelDark);
        pack();
        setLocationRelativeTo(null);
    }

}
