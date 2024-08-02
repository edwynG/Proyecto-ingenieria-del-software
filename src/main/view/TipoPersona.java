package main.view;

public class TipoPersona extends javax.swing.JFrame{
    public TipoPersona() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Tipo de persona");
        Contendor = new javax.swing.JPanel();
        Appbar = new javax.swing.JPanel();
        TituloInterfaz = new javax.swing.JLabel();
        ContenedorTabla = new javax.swing.JPanel();
        tituloTabla = new javax.swing.JLabel();
        botonInterfazPeronaJuridica = new javax.swing.JButton();
        botonRegistrar1 = new javax.swing.JButton();
        botonRegistrar2 = new javax.swing.JButton();
        botonInterfazPersonaNatural = new javax.swing.JButton();
        tablaSubTitle = new javax.swing.JLabel();

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
                .addContainerGap(674, Short.MAX_VALUE))
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
        tituloTabla.setText("Proponente");
        tituloTabla.setFont( new java.awt.Font("SansSerif", java.awt.Font.BOLD, 30));


        botonInterfazPeronaJuridica.setBackground(new java.awt.Color(167, 191, 199));
        botonInterfazPeronaJuridica.setText("Juridico");
        botonInterfazPeronaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInterfazPeronaJuridicaActionPerformed(evt);
            }
        });

        botonRegistrar1.setBackground(new java.awt.Color(167, 191, 199));
        botonRegistrar1.setText("Registrarse");
        botonRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrar1ActionPerformed(evt);
            }
        });

        botonRegistrar2.setBackground(new java.awt.Color(167, 191, 199));
        botonRegistrar2.setText("Registrarse");
        botonRegistrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrar2ActionPerformed(evt);
            }
        });

        botonInterfazPersonaNatural.setBackground(new java.awt.Color(167, 191, 199));
        botonInterfazPersonaNatural.setText("Natural");
        botonInterfazPersonaNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInterfazPersonaNaturalActionPerformed(evt);
            }
        });

        tablaSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tablaSubTitle.setText("¡Registrate con nosotros y propón tus cursos!");
        tablaSubTitle.setFont( new java.awt.Font("SansSerif", java.awt.Font.BOLD, 15));


        javax.swing.GroupLayout ContenedorTablaLayout = new javax.swing.GroupLayout(ContenedorTabla);
        ContenedorTabla.setLayout(ContenedorTablaLayout);
        ContenedorTablaLayout.setHorizontalGroup(
            ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorTablaLayout.createSequentialGroup()
                .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ContenedorTablaLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(botonInterfazPeronaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(botonInterfazPersonaNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ContenedorTablaLayout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonRegistrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonRegistrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(150, 150, 150)))
                    .addGroup(ContenedorTablaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tablaSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContenedorTablaLayout.setVerticalGroup(
            ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorTablaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablaSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInterfazPeronaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonInterfazPersonaNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(555, 555, 555)
                .addComponent(botonRegistrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271)
                .addComponent(botonRegistrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContendorLayout = new javax.swing.GroupLayout(Contendor);
        Contendor.setLayout(ContendorLayout);
        ContendorLayout.setHorizontalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContendorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        ContendorLayout.setVerticalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContendorLayout.createSequentialGroup()
                .addComponent(Appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        pack();
    }

    private void botonInterfazPeronaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        // TODO add your handling code here:
        System.out.println("Es persona Juridica");
        new PersonaJuridic().setVisible(true);
        setVisible(false);
    }                                                           
                                    

    private void botonInterfazPersonaNaturalActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        // TODO add your handling code here:
        System.out.println("Es persona Natural");
        new PersonaNatura().setVisible(true);
        setVisible(false);
    }                                                           

  
    private javax.swing.JPanel Appbar;
    private javax.swing.JPanel Contendor;
    private javax.swing.JPanel ContenedorTabla;
    private javax.swing.JLabel TituloInterfaz;
    private javax.swing.JButton botonInterfazPeronaJuridica;
    private javax.swing.JButton botonInterfazPersonaNatural;
    private javax.swing.JButton botonRegistrar1;
    private javax.swing.JButton botonRegistrar2;
    private javax.swing.JLabel tablaSubTitle;
    private javax.swing.JLabel tituloTabla;
}
