package main.view;

public class PersonaNatura extends javax.swing.JFrame{
    public PersonaNatura() {
        initComponents();
    }

    private void initComponents(){
        setTitle("Persona Natural");
        Contendor = new javax.swing.JPanel();
        Appbar = new javax.swing.JPanel();
        TituloInterfaz = new javax.swing.JLabel();
        ContenedorTabla = new javax.swing.JPanel();
        tituloTabla = new javax.swing.JLabel();
        inputCedulaIdentidad = new javax.swing.JTextField();
        inputISLR = new javax.swing.JTextField();
        inputResumenCurricular = new javax.swing.JTextField();
        inputTituloUniversitario = new javax.swing.JTextField();
        inputRif = new javax.swing.JTextField();
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
        ContenedorTabla.setPreferredSize(new java.awt.Dimension(400, 474));

        tituloTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloTabla.setText("Persona Natural");
        tituloTabla.setFont( new java.awt.Font("SansSerif", java.awt.Font.BOLD, 30));


        inputCedulaIdentidad.setText("Cédula de identidad");
        inputCedulaIdentidad.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputCedulaIdentidad.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputCedulaIdentidad.getText().isEmpty()) {
                    inputCedulaIdentidad.setText("Cédula de identidad");
                }
            }
        });

        inputISLR.setText("Certificados de Declaración ISLR");
        inputISLR.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputISLR.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputISLR.getText().isEmpty()) {
                    inputISLR.setText("Certificados de Declaración ISLR");
                }
            }
        });

        inputResumenCurricular.setText("Resumen curricular");
        inputResumenCurricular.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputResumenCurricular.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputResumenCurricular.getText().isEmpty()) {
                    inputResumenCurricular.setText("Resumen curricular");
                }
            }
        });

        inputTituloUniversitario.setText("Copias titulo universitario");
        inputTituloUniversitario.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputTituloUniversitario.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputTituloUniversitario.getText().isEmpty()) {
                    inputTituloUniversitario.setText("Copias titulo universitario");
                }
            }
        });

        inputRif.setText("Registro de infromación fisical ( RIF )");
        inputRif.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputRif.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputRif.getText().isEmpty()) {
                    inputRif.setText("Registro de infromación fisical ( RIF )");
                }
            }
        });

        botonRegistrar.setBackground(new java.awt.Color(167, 191, 199));
        botonRegistrar.setText("Registrarse");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContenedorTablaLayout = new javax.swing.GroupLayout(ContenedorTabla);
        ContenedorTabla.setLayout(ContenedorTablaLayout);
        ContenedorTablaLayout.setHorizontalGroup(
            ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenedorTablaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(tituloTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(ContenedorTablaLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTituloUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputResumenCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputISLR, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRif, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContenedorTablaLayout.setVerticalGroup(
            ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorTablaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputCedulaIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputRif, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputISLR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputResumenCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputTituloUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContendorLayout = new javax.swing.GroupLayout(Contendor);
        Contendor.setLayout(ContendorLayout);
        ContendorLayout.setHorizontalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContendorLayout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        ContendorLayout.setVerticalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContendorLayout.createSequentialGroup()
                .addComponent(Appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Contendor, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
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
    private javax.swing.JPanel Contendor;
    private javax.swing.JPanel ContenedorTabla;
    private javax.swing.JLabel TituloInterfaz;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField inputCedulaIdentidad;
    private javax.swing.JTextField inputISLR;
    private javax.swing.JTextField inputResumenCurricular;
    private javax.swing.JTextField inputRif;
    private javax.swing.JTextField inputTituloUniversitario;
    private javax.swing.JLabel tituloTabla;
}
