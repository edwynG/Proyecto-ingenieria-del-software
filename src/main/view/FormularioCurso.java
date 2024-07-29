package main.view;

public class FormularioCurso extends javax.swing.JFrame {
    public FormularioCurso() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Formulario del curso");
        Contendor = new javax.swing.JPanel();
        formulario = new javax.swing.JPanel();
        botonEnviar = new javax.swing.JToggleButton();
        inputDenominación = new javax.swing.JTextField();
        inputPerfilDeIngreso = new javax.swing.JTextField();
        inputperfilDocente = new javax.swing.JTextField();
        inputEstructuraCurricular = new javax.swing.JTextField();
        inputEstrategias = new javax.swing.JTextField();
        InputExigencias = new javax.swing.JTextField();
        inputEstructuraCosto = new javax.swing.JTextField();
        inputCronograma = new javax.swing.JTextField();
        inputUnidad = new javax.swing.JTextField();
        InputObjetivos = new javax.swing.JTextField();
        Appbar = new javax.swing.JPanel();
        TituloInterfaz = new javax.swing.JLabel();
        botonCerrarSesion = new javax.swing.JButton();
        botonExpediente = new javax.swing.JButton();
        botonMenuPrincipal = new javax.swing.JButton();

        
        inputDenominación.setText("Denominación");
        inputDenominación.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputDenominación.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputDenominación.getText().isEmpty()) {
                    inputDenominación.setText("Denominación");
                }
            }
        });

        InputObjetivos.setText("Objetivos y Fundamentos");
        InputObjetivos.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                InputObjetivos.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (InputObjetivos.getText().isEmpty()) {
                    InputObjetivos.setText("Objetivos y Fundamentos");
                }
            }
        });

        inputPerfilDeIngreso.setText("Perfil de ingreso y egreso");
        inputPerfilDeIngreso.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputPerfilDeIngreso.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputPerfilDeIngreso.getText().isEmpty()) {
                    inputPerfilDeIngreso.setText("Perfil de ingreso y egreso");
                }
            }
        });

        inputperfilDocente.setText("Perfil Docente");
        inputperfilDocente.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputperfilDocente.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputperfilDocente.getText().isEmpty()) {
                    inputperfilDocente.setText("Perfil de Docente");
                }
            }
        });

        inputEstructuraCurricular.setText("Estructura curricular por competencias");
        inputEstructuraCurricular.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputEstructuraCurricular.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputEstructuraCurricular.getText().isEmpty()) {
                    inputEstructuraCurricular.setText("Estructura curricular por competencias");
                }
            }
        });

        inputEstrategias.setText("Estrategias de evaluación y duración");
        inputEstrategias.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputEstrategias.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputEstrategias.getText().isEmpty()) {
                    inputEstrategias.setText("Estrategias de evaluación y duración");
                }
            }
        });

        InputExigencias.setText("Exigencias en materias y servicios");
        InputExigencias.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                InputExigencias.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (InputExigencias.getText().isEmpty()) {
                    InputExigencias.setText("Exigencias en materias y servicios");
                }
            }
        });

        inputEstructuraCosto.setText("Estructura de costos");
        inputEstructuraCosto.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputEstructuraCosto.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputEstructuraCosto.getText().isEmpty()) {
                    inputEstructuraCosto.setText("Estructura de costos");
                }
            }
        });

        inputCronograma.setText("Cronograma de ejecución");
        inputCronograma.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputCronograma.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputCronograma.getText().isEmpty()) {
                    inputCronograma.setText("Cronograma de ejecución");
                }
            }
        });

        inputUnidad.setText("Unidad responsable");
        inputUnidad.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                inputUnidad.setText("");
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputUnidad.getText().isEmpty()) {
                    inputUnidad.setText("Unidad responsable");
                }
            }
        });


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(33, 33, 33));
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setResizable(false);

        Contendor.setBackground(new java.awt.Color(33, 33, 33));
        Contendor.setPreferredSize(new java.awt.Dimension(1000, 620));

        botonEnviar.setBackground(new java.awt.Color(167, 191, 199));
        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        inputDenominación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDenominaciónActionPerformed(evt);
            }
        });

        inputPerfilDeIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPerfilDeIngresoActionPerformed(evt);
            }
        });

        inputperfilDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputperfilDocenteActionPerformed(evt);
            }
        });

        inputEstructuraCurricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEstructuraCurricularActionPerformed(evt);
            }
        });

        inputEstrategias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEstrategiasActionPerformed(evt);
            }
        });

        InputExigencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputExigenciasActionPerformed(evt);
            }
        });

        inputEstructuraCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEstructuraCostoActionPerformed(evt);
            }
        });

        inputCronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCronogramaActionPerformed(evt);
            }
        });

        inputUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUnidadActionPerformed(evt);
            }
        });

        InputObjetivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputObjetivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formularioLayout = new javax.swing.GroupLayout(formulario);
        formulario.setLayout(formularioLayout);
        formularioLayout.setHorizontalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formularioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputEstructuraCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPerfilDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputperfilDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDenominación, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEstructuraCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputExigencias, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEstrategias, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        formularioLayout.setVerticalGroup(
            formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formularioLayout.createSequentialGroup()
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formularioLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputEstrategias, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDenominación, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formularioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputExigencias, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputEstructuraCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPerfilDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputperfilDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(formularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEstructuraCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        Appbar.setBackground(new java.awt.Color(167, 191, 199));

        TituloInterfaz.setForeground(new java.awt.Color(255, 255, 255));
        TituloInterfaz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TituloInterfaz.setText("Course stack");
        TituloInterfaz.setFont( new java.awt.Font("SansSerif", java.awt.Font.BOLD, 40));


        botonCerrarSesion.setText("Cerrar Sesión");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });

        botonExpediente.setText("Proponente");
        botonExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExpedienteActionPerformed(evt);
            }
        });

        botonMenuPrincipal.setText("Principal");
        botonMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AppbarLayout = new javax.swing.GroupLayout(Appbar);
        Appbar.setLayout(AppbarLayout);
        AppbarLayout.setHorizontalGroup(
            AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppbarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(TituloInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(botonMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(botonExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(botonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        AppbarLayout.setVerticalGroup(
            AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonExpediente)
                    .addComponent(botonMenuPrincipal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContendorLayout = new javax.swing.GroupLayout(Contendor);
        Contendor.setLayout(ContendorLayout);
        ContendorLayout.setHorizontalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContendorLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Appbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContendorLayout.setVerticalGroup(
            ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContendorLayout.createSequentialGroup()
                .addComponent(Appbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contendor, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new LoginView().setVisible(true);
        setVisible(false);
    }

    private void botonExpedienteActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        new ExpedienteProponente().setVisible(true);
        setVisible(false);

    }    

    private void botonMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        new ProponentView().setVisible(true);
        setVisible(false);
    } 

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        System.out.println("Enviado");
    }   

    private javax.swing.JPanel Appbar;
    private javax.swing.JPanel Contendor;
    private javax.swing.JTextField inputEstructuraCosto;
    private javax.swing.JTextField InputExigencias;
    private javax.swing.JTextField InputObjetivos;
    private javax.swing.JLabel TituloInterfaz;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JToggleButton botonEnviar;
    private javax.swing.JButton botonExpediente;
    private javax.swing.JButton botonMenuPrincipal;
    private javax.swing.JPanel formulario;
    private javax.swing.JTextField inputCronograma;
    private javax.swing.JTextField inputDenominación;
    private javax.swing.JTextField inputEstrategias;
    private javax.swing.JTextField inputEstructuraCurricular;
    private javax.swing.JTextField inputPerfilDeIngreso;
    private javax.swing.JTextField inputUnidad;
    private javax.swing.JTextField inputperfilDocente;

}
