package main.view;

public class PersonaJuridic extends javax.swing.JFrame {
    public PersonaJuridic() {
        initComponents();
    }


    private void initComponents() {
        setTitle("Persona Juridica");
        Contendor = new javax.swing.JPanel();
        Appbar = new javax.swing.JPanel();
        TituloInterfaz = new javax.swing.JLabel();
        ContenedorTabla = new javax.swing.JPanel();
        tituloTabla = new javax.swing.JLabel();
        registroMercantil = new javax.swing.JTextField();
        CedulaDeIdentidad = new javax.swing.JTextField();
        registroDeInformacion = new javax.swing.JTextField();
        certificadoDeclaracion = new javax.swing.JTextField();
        resumenCurricular = new javax.swing.JTextField();
        CopiaDeTituloUniversitario = new javax.swing.JTextField();
        botonRegistrar = new javax.swing.JButton();



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setResizable(false);

        Contendor.setBackground(new java.awt.Color(33, 33, 33));
        Contendor.setPreferredSize(new java.awt.Dimension(1000, 620));

        Appbar.setBackground(new java.awt.Color(167, 191, 199));

        TituloInterfaz.setForeground(new java.awt.Color(255, 255, 255));
        TituloInterfaz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TituloInterfaz.setText("Course stack");
        TituloInterfaz.setFont( new java.awt.Font("SansSerif", java.awt.Font.BOLD, 40));


        javax.swing.GroupLayout AppbarLayout = new javax.swing.GroupLayout(Appbar);
        Appbar.setLayout(AppbarLayout);
        AppbarLayout.setHorizontalGroup(
            AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppbarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(TituloInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AppbarLayout.setVerticalGroup(
            AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ContenedorTabla.setMinimumSize(new java.awt.Dimension(853, 415));

        tituloTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloTabla.setText("Persona juridica");
        tituloTabla.setFont( new java.awt.Font("SansSerif", java.awt.Font.BOLD, 30));


        registroMercantil.setText("Registro mercantil");
        registroMercantil.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                registroMercantil.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (registroMercantil.getText().isEmpty()) {
                    registroMercantil.setText("Registro mercantil");
                }
            }
        });

        CedulaDeIdentidad.setText("Cédula de identidad del personal legal");
        CedulaDeIdentidad.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                CedulaDeIdentidad.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (CedulaDeIdentidad.getText().isEmpty()) {
                    CedulaDeIdentidad.setText("Cédula de identidad del personal legal");
                }
            }
        });
        

        registroDeInformacion.setText("Registro de información");
        registroDeInformacion.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                registroDeInformacion.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (registroDeInformacion.getText().isEmpty()) {
                    registroDeInformacion.setText("Registro de información");
                }
            }
        });

        certificadoDeclaracion.setText("Certificados de Declaración ISLR");
        certificadoDeclaracion.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                certificadoDeclaracion.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (certificadoDeclaracion.getText().isEmpty()) {
                    certificadoDeclaracion.setText("Certificados de Declaración ISLR");
                }
            }
        });

        resumenCurricular.setText("Resumen curricular");
        resumenCurricular.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                resumenCurricular.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (resumenCurricular.getText().isEmpty()) {
                    resumenCurricular.setText("Resumen curricular");
                }
            }
        });

        CopiaDeTituloUniversitario.setText("Copia de titulo universitario");
        CopiaDeTituloUniversitario.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                CopiaDeTituloUniversitario.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (CopiaDeTituloUniversitario.getText().isEmpty()) {
                    CopiaDeTituloUniversitario.setText("Copia de titulo universitario");
                }
            }
        });

        botonRegistrar.setBackground(new java.awt.Color(167, 191, 199));
        botonRegistrar.setText("Registrarse");
     
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContenedorTablaLayout = new javax.swing.GroupLayout(ContenedorTabla);
        ContenedorTabla.setLayout(ContenedorTablaLayout);
        ContenedorTablaLayout.setHorizontalGroup(
            ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorTablaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(tituloTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorTablaLayout.createSequentialGroup()
                .addGap(0, 124, Short.MAX_VALUE)
                .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(certificadoDeclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ContenedorTablaLayout.createSequentialGroup()
                        .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CedulaDeIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registroMercantil, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registroDeInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121)
                        .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(resumenCurricular)
                            .addComponent(CopiaDeTituloUniversitario, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(botonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(128, 128, 128))
        );
        ContenedorTablaLayout.setVerticalGroup(
            ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorTablaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resumenCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registroMercantil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorTablaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(CopiaDeTituloUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContenedorTablaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(CedulaDeIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroDeInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(certificadoDeclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContendorLayout = new javax.swing.GroupLayout(Contendor);
        Contendor.setLayout(ContendorLayout);
        ContendorLayout.setHorizontalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ContendorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        ContendorLayout.setVerticalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContendorLayout.createSequentialGroup()
                .addComponent(Appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        System.out.println("Registrado");
        new ProponentView().setVisible(true);
        setVisible(false);
        
    }

    private javax.swing.JPanel Appbar;
    private javax.swing.JTextField CedulaDeIdentidad;
    private javax.swing.JPanel Contendor;
    private javax.swing.JPanel ContenedorTabla;
    private javax.swing.JTextField CopiaDeTituloUniversitario;
    private javax.swing.JLabel TituloInterfaz;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField certificadoDeclaracion;
    private javax.swing.JTextField registroDeInformacion;
    private javax.swing.JTextField registroMercantil;
    private javax.swing.JTextField resumenCurricular;
    private javax.swing.JLabel tituloTabla;
}
