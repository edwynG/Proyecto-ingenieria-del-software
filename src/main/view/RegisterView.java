package main.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.w3c.dom.events.MouseEvent;


public class RegisterView extends JFrame {
	// paneles 
    private JPanel panelDark;
    private JPanel panelLight;
   
   	// Logo y título Registro
    private JLabel labelCourseStackLogo;
    private JLabel labelPanelLightRegister;
    
    // Etiqueta y campo nombres
    private JLabel labelName;
    private JTextField textfieldName;
    
    // Etiqueta y campo apellidos
	private JLabel labelLastName;
	private JTextField textfieldLastName;
	
	// Etiqueta y campo cédula (Combobox para el tipo de cédula V o E)
	private JLabel labelNumberID; 
	private JComboBox<String> comboboxCharacterID;
	private String selectedOptionComboboxCharacterID;
	private JTextField textfieldNumberID;
	
	// Etiqueta y campo teĺefono (Combobox para el tipo de operadora telefónica)
	private JLabel labelPhone;
	private JComboBox<String> comboboxPhoneCode;
	private String selectedOptionComboboxPhoneCode;
	private JTextField textfieldPhoneNumber;
	
	// Etiqueta y campo tipo de usuario (Combobox para el tipo de usuario proponente o administrador)

	private JComboBox<String> comboboxUserType;
	private String selectedOptionComboboxUserType;
   
   	// Etiqueta y campo correo 
    private JLabel labelEmail;
    private JTextField textfieldEmailRegisterForm;
    
    // Etiqueta y campo contraseña 
    private JLabel labelPasswordRegisterForm;
    private JPasswordField passwordfieldPasswordRegisterForm;
   
   	// Etiqueta y campo repetir contraseña 
    private JLabel labelRepeatPassword;
    private JPasswordField passwordfieldRepeatPassword;
    
	// Etiqueta y campo token
	private JPasswordField passwordfielAdminRegisterToken;

	
	
    
    private JLabel labelLoginMessage;

    private JButton buttonContinuar;

    private Color backgroundColor;
    private Color foregroundColor;
    private Color messageColor;

    private Font font;
    private Font dimensionTextFieldFont;
    private Font dimensionTextButton;
    private Font dimensionlabelLoginMessage;

    private Dimension frameDimension;


    private ImageIcon imageiconCourseStackLogo;
    private ImageIcon imageiconEmail;
    private ImageIcon imageiconPassword;
    private ImageIcon imageiconUser;

    private GroupLayout darkGroupLayout;
    private GroupLayout lightGroupLayout;
    
    

    public RegisterView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTRO");
        frameDimension = new Dimension(1000, 700);
        setPreferredSize(frameDimension);
        setResizable(false);

        backgroundColor = new Color(21, 21, 21);
        foregroundColor = new Color(255, 255, 255);
        messageColor = new Color(68, 83, 91);

        font = new Font("SansSerif", Font.BOLD, 30);
        dimensionTextFieldFont = new Font("SansSerif", Font.PLAIN, 12);
        dimensionTextButton = new Font("SansSerif", Font.BOLD, 20);
        dimensionlabelLoginMessage =  new Font("SansSerif", Font.BOLD, 12);
        
        imageiconUser = new ImageIcon("src/resources/img/user.png");

        imageiconCourseStackLogo = new ImageIcon("src/resources/img/logoCourseStack.png");
        labelCourseStackLogo = new JLabel(imageiconCourseStackLogo);

		// Etiqueta y campo Nombres
		labelName = new JLabel(imageiconUser);
		textfieldName = new JTextField();
		textfieldName.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Nombres", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
		
		// Etiqueta y campo Apellidos
		labelLastName = new JLabel(imageiconUser);
		textfieldLastName = new JTextField();
		textfieldLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Apellidos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
		
		// Etiqueta y campo cédula
		labelNumberID = new JLabel(imageiconUser);
		String[] stringCharacterID = {"V","E"};
		comboboxCharacterID = new JComboBox<String>(stringCharacterID);
        comboboxCharacterID.setSelectedIndex(0);
        selectedOptionComboboxCharacterID = "V";
        comboboxCharacterID.addActionListener(e -> {
            selectedOptionComboboxCharacterID = (String) comboboxCharacterID.getSelectedItem();
        });

        textfieldNumberID = new JTextField();
        textfieldNumberID.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Cédula", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		// Etiqueta y campo telefono
		labelPhone = new JLabel(imageiconUser);
		String[] stringPhoneCode = {"0412","0416","0426","0414","0424"};
		comboboxPhoneCode = new JComboBox<String>(stringPhoneCode);
        comboboxPhoneCode.setSelectedItem("0412");
        selectedOptionComboboxPhoneCode = "0412";
        comboboxPhoneCode.addActionListener(e -> {
            selectedOptionComboboxPhoneCode = (String) comboboxPhoneCode.getSelectedItem(); 
        });
        
        textfieldPhoneNumber = new JTextField();
		textfieldPhoneNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Teléfono", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
		
		// Etiqueta y campo tipo de usuario
		
		String[] stringUserType = {"proponente","administrador"};
		comboboxUserType = new JComboBox<String>(stringUserType);
        comboboxUserType.setSelectedIndex(0);
        selectedOptionComboboxUserType = "proponente";
        
        
        		
		passwordfielAdminRegisterToken = new JPasswordField();
		passwordfielAdminRegisterToken.setEnabled(false);
		JLabel labelAdminRegisterToken = new JLabel(imageiconUser);
	
		
		
        
        
        JLabel labelUserType = new JLabel(imageiconUser);
        comboboxUserType.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Tipo de Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
		
        imageiconEmail = new ImageIcon("src/resources/img/correo.png");
        labelEmail = new JLabel(imageiconEmail);
        textfieldEmailRegisterForm = new JTextField();
        textfieldEmailRegisterForm.setPreferredSize(new Dimension(260, 35));
        textfieldEmailRegisterForm.setFont(dimensionTextFieldFont);
        textfieldEmailRegisterForm.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Email", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        imageiconPassword = new ImageIcon("src/resources/img/candado.png");
        labelPasswordRegisterForm = new JLabel(imageiconPassword);
        passwordfieldPasswordRegisterForm = new JPasswordField();
        passwordfieldPasswordRegisterForm.setPreferredSize(new Dimension(260, 40));
        passwordfieldPasswordRegisterForm.setFont(dimensionTextFieldFont);
        passwordfieldPasswordRegisterForm.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Contraseña", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        
        
        //passwordImageIcon = new ImageIcon("candado.png");
        labelRepeatPassword = new JLabel(imageiconPassword);
        passwordfieldRepeatPassword = new JPasswordField();
        passwordfieldRepeatPassword.setPreferredSize(new Dimension(260, 40));
        passwordfieldRepeatPassword.setFont(dimensionTextFieldFont);
        passwordfieldRepeatPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Confirmar Contraseña", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
 

        buttonContinuar = new JButton("Continuar");
        buttonContinuar.setBackground(messageColor);
        buttonContinuar.setForeground(foregroundColor);
        buttonContinuar.setFont(dimensionTextButton);


		buttonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    addRegisterButtonListener(e);
				}
		});


        labelLoginMessage = new JLabel("¿Tiene usted una cuenta? Iniciar sesión");
        labelLoginMessage.setFont(dimensionlabelLoginMessage);
        labelLoginMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                eventoClickCambiarASesion(e);
            }
        });

        labelPanelLightRegister = new JLabel("Registro");
        labelPanelLightRegister.setForeground(messageColor);
        labelPanelLightRegister.setFont(font);

        panelDark = new JPanel();
        panelDark.setBackground(backgroundColor);
        darkGroupLayout = new GroupLayout(panelDark);
        panelDark.setLayout(darkGroupLayout);

        
        panelLight = new JPanel();
        panelLight.setBackground(foregroundColor);

// Configuración GroupLayout para lightPanel

lightGroupLayout = new GroupLayout(panelLight);
panelLight.setLayout(lightGroupLayout);
lightGroupLayout.setAutoCreateGaps(true);
lightGroupLayout.setAutoCreateContainerGaps(true);

lightGroupLayout.setHorizontalGroup( 
    lightGroupLayout.createSequentialGroup()// tengo un solo elemento en un grupo horizontal (el bloque desde bienvenido hasta la etiqueta login)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        //createParallelGroup en setHorizontal agrupa verticalmente (paralelos al eje x)
           // tengo tres bloques verticales bien definidos
           
            .addComponent(labelPanelLightRegister)//primer bloque (contiene solo un componente que es la etiqueta bienvenido)
           
            .addGroup(lightGroupLayout.createSequentialGroup() // inicio del segundo bloque (donde estan todos los campos)
            	// En este grupo tengo dos grupos secuenciales es decir tres grupos uno al lado del otro
            	// El primero es el grupo donde estan todas las etiquetas
                .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(labelName)
                    .addComponent(labelLastName)
                    .addComponent(labelNumberID)
                    .addComponent(labelPhone)
                    .addComponent(labelUserType)
                    .addComponent(labelEmail)
                    .addComponent(labelPasswordRegisterForm)
                    .addComponent(labelRepeatPassword)
                    

                )
                // y el segundo es donde estan todos los campos
                .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)//createParallelGroup en setHorizontal 
                	// agrupa los elementos verticalmente es decir paralelos al eje x
                    .addComponent(textfieldName)
                    .addComponent(textfieldLastName)
                    
                    .addGroup(lightGroupLayout.createSequentialGroup()// pero este grupo tiene dos elementos en horizontal
                        .addComponent(comboboxCharacterID, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textfieldNumberID)
                    )
                    .addGroup(lightGroupLayout.createSequentialGroup()// pero este grupo tiene dos elementos en horizontal
                        .addComponent(comboboxPhoneCode, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textfieldPhoneNumber)
                    )
                    .addComponent(comboboxUserType)
                    .addComponent(textfieldEmailRegisterForm)
                    .addComponent(passwordfieldPasswordRegisterForm)
                    .addComponent(passwordfieldRepeatPassword)
                

                    .addComponent(buttonContinuar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
            ) // fin del segundo bloque ( donde estan todos los campos)
            .addComponent(labelLoginMessage) // tercer bloque (contiene solo un componente que es la etiqueta login)
        )
);

lightGroupLayout.setVerticalGroup(
    lightGroupLayout.createSequentialGroup()
        .addGap(5)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(labelPanelLightRegister)
        )
        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(labelName)
            .addComponent(textfieldName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        )
        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(labelLastName)
            .addComponent(textfieldLastName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        )       
         .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(labelNumberID)

					.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                	.addComponent(comboboxCharacterID, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                	.addComponent(textfieldNumberID, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                	)
        	
		)
		.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(labelPhone)

					.addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                	.addComponent(comboboxPhoneCode, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                	.addComponent(textfieldPhoneNumber, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                	)
        	
		)
		.addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
			.addComponent(labelUserType)
            .addComponent(comboboxUserType, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)

        )

        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(labelEmail)
            .addComponent(textfieldEmailRegisterForm, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        )
        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(labelPasswordRegisterForm)
            .addComponent(passwordfieldPasswordRegisterForm, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        )
        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(labelRepeatPassword)
            .addComponent(passwordfieldRepeatPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        )
        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
     

        )

        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(buttonContinuar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        )
        .addGap(15)
        .addGroup(lightGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(labelLoginMessage)
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
                    .addGap(5) // Espacio arriba
                    .addGroup(darkGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelCourseStackLogo)
                        .addComponent(panelLight)
                    )
                    .addGap(5) // Espacio abajo
                )
        );

        setContentPane(panelDark);
        pack();
        setLocationRelativeTo(null);
    }
    
    	/* INICIO DE LOS METODOS */

    public String getTextfieldName() {
        return textfieldName.getText();
    }

    public String getTextfieldLastName() {
        return textfieldLastName.getText();
    }

    public String getComboboxCharacterID() {
        return selectedOptionComboboxCharacterID;
    }    
    
    public String getTextfieldNumberID() {
		return textfieldNumberID.getText();
    } 
	
	
	public String getTextfieldNumberIDstring() {
        return textfieldNumberID.getText();
    } 
	
    
    public String getComboboxPhoneCode(){
        return selectedOptionComboboxPhoneCode;
    }

    public String  getTextfieldPhoneNumber() {
        return  textfieldPhoneNumber.getText();
    }

    public String getComboboxUserType(){
        return selectedOptionComboboxUserType;
    }


    public String getTextfieldEmailRegisterForm() {
        return textfieldEmailRegisterForm.getText();
    }


    public String getPasswordfieldPasswordRegisterForm() {
        return new String(passwordfieldPasswordRegisterForm.getPassword()); 
    }


    public String  getPasswordfieldRepeatPassword() {
        return new String(passwordfieldRepeatPassword.getPassword()); 
    }


    public String getPasswordfielAdmindRegisterToken() {
		return new String(passwordfielAdminRegisterToken.getPassword());
	}  

    
    public void addRegisterButtonListener(ActionEvent listener) {
       System.out.println("Siguiente");
       new TipoPersona().setVisible(true);
       setVisible(false);
     
    }

    public void  eventoClickCambiarASesion(java.awt.event.MouseEvent e){
        new LoginView().setVisible(true);
        setVisible(false);
    };


}
