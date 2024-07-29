package main.view;

import java.util.List;

public class Coordinacion extends javax.swing.JFrame {
    public Coordinacion() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Coordinación de extensión");
        Contendor = new javax.swing.JPanel();
        Appbar = new javax.swing.JPanel();
        TituloInterfaz = new javax.swing.JLabel();
        botonCerrarSesion = new javax.swing.JButton();
        ContenedorTabla = new javax.swing.JPanel();
        tituloTabla = new javax.swing.JLabel();
        Scrollist = new javax.swing.JScrollPane();
        List = new javax.swing.JPanel();
        Item = new javax.swing.JPanel();
        itemCurso = new javax.swing.JLabel();
        botonItemDescargarCrendenciales = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        inputObservaciones = new javax.swing.JTextField();
        inputResultado = new javax.swing.JTextField();
        botonItemDescargarPropuesta = new javax.swing.JButton();
        Item1 = new javax.swing.JPanel();
        itemName1 = new javax.swing.JLabel();
        botonItemDescargarCredenciales1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        inputObservaciones1 = new javax.swing.JTextField();
        inputResultado1 = new javax.swing.JTextField();
        botonItemDescargarPropuesta1 = new javax.swing.JButton();
        optionCurso = new javax.swing.JLabel();
        optionProbidad = new javax.swing.JLabel();
        optionEvaluación = new javax.swing.JLabel();
        optionInfromacion = new javax.swing.JLabel();
        optionObsevaciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setResizable(false);

        Contendor.setBackground(new java.awt.Color(33, 33, 33));
        Contendor.setPreferredSize(new java.awt.Dimension(1000, 620));

        Appbar.setBackground(new java.awt.Color(167, 191, 199));

        TituloInterfaz.setForeground(new java.awt.Color(255, 255, 255));
        TituloInterfaz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TituloInterfaz.setText("Course stack");
        TituloInterfaz.setFont(new java.awt.Font("sansSerif", java.awt.Font.BOLD, 40));

        botonCerrarSesion.setText("Cerrar Sesión");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AppbarLayout = new javax.swing.GroupLayout(Appbar);
        Appbar.setLayout(AppbarLayout);
        AppbarLayout.setHorizontalGroup(
                AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AppbarLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(TituloInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 325,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 119,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)));
        AppbarLayout.setVerticalGroup(
                AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AppbarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(AppbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TituloInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        ContenedorTabla.setMinimumSize(new java.awt.Dimension(853, 415));

        tituloTabla.setText("Cursos propuestos");
        tituloTabla.setFont(new java.awt.Font("sansSerif", java.awt.Font.BOLD, 30));

        Scrollist.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scrollist.setAutoscrolls(true);

        itemCurso.setText("Java Fundamentals");

        botonItemDescargarCrendenciales.setBackground(new java.awt.Color(167, 191, 199));
        botonItemDescargarCrendenciales.setText("Descargar");
        botonItemDescargarCrendenciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonItemDescargarCrendencialesActionPerformed(evt);
            }
        });

        inputObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputObservacionesActionPerformed(evt);
            }
        });

        inputResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputResultadoActionPerformed(evt);
            }
        });

        botonItemDescargarPropuesta.setBackground(new java.awt.Color(167, 191, 199));
        botonItemDescargarPropuesta.setText("Descargar");
        botonItemDescargarPropuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonItemDescargarPropuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ItemLayout = new javax.swing.GroupLayout(Item);
        Item.setLayout(ItemLayout);
        ItemLayout.setHorizontalGroup(
                ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ItemLayout.createSequentialGroup()
                                .addGap(631, 631, 631)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(ItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(itemCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(botonItemDescargarPropuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(botonItemDescargarCrendenciales, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(inputObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43,
                                        Short.MAX_VALUE)
                                .addComponent(inputResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)));
        ItemLayout.setVerticalGroup(
                ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53))
                        .addGroup(ItemLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonItemDescargarCrendenciales,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonItemDescargarPropuesta, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(itemCurso, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputObservaciones)
                                        .addComponent(inputResultado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));

        itemName1.setText("Inteligencia Artificial");

        botonItemDescargarCredenciales1.setBackground(new java.awt.Color(167, 191, 199));
        botonItemDescargarCredenciales1.setText("Descargar");
        botonItemDescargarCredenciales1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonItemDescargarCredenciales1ActionPerformed(evt);
            }
        });

        inputObservaciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputObservaciones1ActionPerformed(evt);
            }
        });

        inputResultado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputResultado1ActionPerformed(evt);
            }
        });

        botonItemDescargarPropuesta1.setBackground(new java.awt.Color(167, 191, 199));
        botonItemDescargarPropuesta1.setText("Descargar");
        botonItemDescargarPropuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonItemDescargarPropuesta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Item1Layout = new javax.swing.GroupLayout(Item1);
        Item1.setLayout(Item1Layout);
        Item1Layout.setHorizontalGroup(
                Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Item1Layout.createSequentialGroup()
                                .addGap(631, 631, 631)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Item1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(itemName1, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(botonItemDescargarPropuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(botonItemDescargarCredenciales1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(inputObservaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43,
                                        Short.MAX_VALUE)
                                .addComponent(inputResultado1, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)));
        Item1Layout.setVerticalGroup(
                Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Item1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53))
                        .addGroup(Item1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonItemDescargarCredenciales1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonItemDescargarPropuesta1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(itemName1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputObservaciones1)
                                        .addComponent(inputResultado1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));

        javax.swing.GroupLayout ListLayout = new javax.swing.GroupLayout(List);
        List.setLayout(ListLayout);
        ListLayout.setHorizontalGroup(
                ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ListLayout.createSequentialGroup()
                                .addGroup(ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Item1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 111, Short.MAX_VALUE)));
        ListLayout.setVerticalGroup(
                ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ListLayout.createSequentialGroup()
                                .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Item1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)));

        Scrollist.setViewportView(List);

        optionCurso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        optionCurso.setText("Curso");

        optionProbidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optionProbidad.setText("Propuesta");

        optionEvaluación.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        optionEvaluación.setText("Resultado");

        optionInfromacion.setText("Credenciales");

        optionObsevaciones.setText("Observaciones");

        javax.swing.GroupLayout ContenedorTablaLayout = new javax.swing.GroupLayout(ContenedorTabla);
        ContenedorTabla.setLayout(ContenedorTablaLayout);
        ContenedorTablaLayout.setHorizontalGroup(
                ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ContenedorTablaLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(ContenedorTablaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(ContenedorTablaLayout.createSequentialGroup()
                                                .addComponent(optionCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(71, 71, 71)
                                                .addComponent(optionProbidad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(87, 87, 87)
                                                .addComponent(optionInfromacion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(optionObsevaciones,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66)
                                                .addComponent(optionEvaluación, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ContenedorTablaLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Scrollist, javax.swing.GroupLayout.PREFERRED_SIZE, 796,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE)));
        ContenedorTablaLayout.setVerticalGroup(
                ContenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ContenedorTablaLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(tituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(ContenedorTablaLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(optionCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(optionProbidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(optionEvaluación, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(optionInfromacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(optionObsevaciones))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Scrollist, javax.swing.GroupLayout.PREFERRED_SIZE, 251,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout ContendorLayout = new javax.swing.GroupLayout(Contendor);
        Contendor.setLayout(ContendorLayout);
        ContendorLayout.setHorizontalGroup(
                ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Appbar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContendorLayout.createSequentialGroup()
                                .addContainerGap(68, Short.MAX_VALUE)
                                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)));
        ContendorLayout.setVerticalGroup(
                ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ContendorLayout.createSequentialGroup()
                                .addComponent(Appbar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 407,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 114, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Contendor, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Contendor, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new LoginView().setVisible(true);
        setVisible(false);
    }

    private void botonItemDescargarCrendencialesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("Descargando credenciales..");
    }

    private void inputObservacionesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void inputResultadoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botonItemDescargarPropuestaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("Descargando propuesta..");

    }

    private void botonItemDescargarCredenciales1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("Descargando credenciales..");

    }

    private void inputObservaciones1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void inputResultado1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void botonItemDescargarPropuesta1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("Descargando Propuesta..");

    }

    private javax.swing.JPanel Appbar;
    private javax.swing.JPanel Contendor;
    private javax.swing.JPanel ContenedorTabla;
    private javax.swing.JPanel Item;
    private javax.swing.JPanel Item1;
    private javax.swing.JPanel List;
    private javax.swing.JScrollPane Scrollist;
    private javax.swing.JLabel TituloInterfaz;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonItemDescargarCredenciales1;
    private javax.swing.JButton botonItemDescargarCrendenciales;
    private javax.swing.JButton botonItemDescargarPropuesta;
    private javax.swing.JButton botonItemDescargarPropuesta1;
    private javax.swing.JTextField inputObservaciones;
    private javax.swing.JTextField inputObservaciones1;
    private javax.swing.JTextField inputResultado;
    private javax.swing.JTextField inputResultado1;
    private javax.swing.JLabel itemCurso;
    private javax.swing.JLabel itemName1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel optionCurso;
    private javax.swing.JLabel optionEvaluación;
    private javax.swing.JLabel optionInfromacion;
    private javax.swing.JLabel optionObsevaciones;
    private javax.swing.JLabel optionProbidad;
    private javax.swing.JLabel tituloTabla;
}
