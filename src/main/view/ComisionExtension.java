package main.view;

public class ComisionExtension extends javax.swing.JFrame {
    public ComisionExtension() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Comisión de Extensión");
        jToolBar1 = new javax.swing.JToolBar();
        Contendor = new javax.swing.JPanel();
        Appbar = new javax.swing.JPanel();
        TituloInterfaz = new javax.swing.JLabel();
        botonCerrarSesion = new javax.swing.JButton();
        ContenedorTabla = new javax.swing.JPanel();
        tituloTabla = new javax.swing.JLabel();
        Scrollist = new javax.swing.JScrollPane();
        List = new javax.swing.JPanel();
        Item = new javax.swing.JPanel();
        itemName = new javax.swing.JLabel();
        itemEstado = new javax.swing.JLabel();
        botoIntemDescargar = new javax.swing.JButton();
        itemTiempo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputObservaciones = new javax.swing.JTextField();
        inputEvaluación = new javax.swing.JTextField();
        optionCurso = new javax.swing.JLabel();
        optionTipo = new javax.swing.JLabel();
        optionEvaluación = new javax.swing.JLabel();
        optionPropuesta = new javax.swing.JLabel();
        optionTiempo = new javax.swing.JLabel();
        optionObsevaciones = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

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

        itemName.setText("Java Fundamentals");

        itemEstado.setText("Validado");

        botoIntemDescargar.setBackground(new java.awt.Color(167, 191, 199));
        botoIntemDescargar.setText("Descargar");
        botoIntemDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoIntemDescargarActionPerformed(evt);
            }
        });

        itemTiempo.setText("Hace 2 dias");

        inputObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputObservacionesActionPerformed(evt);
            }
        });

        inputEvaluación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEvaluaciónActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ItemLayout = new javax.swing.GroupLayout(Item);
        Item.setLayout(ItemLayout);
        ItemLayout.setHorizontalGroup(
                ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(itemEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botoIntemDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ItemLayout.createSequentialGroup()
                                                .addGap(264, 264, 264)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(ItemLayout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(itemTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(inputObservaciones,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44,
                                                        Short.MAX_VALUE)
                                                .addComponent(inputEvaluación, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))));
        ItemLayout.setVerticalGroup(
                ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ItemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(itemName, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(itemEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botoIntemDescargar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(itemTiempo)
                                        .addComponent(jLabel4)
                                        .addComponent(inputObservaciones)
                                        .addComponent(inputEvaluación, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));

        javax.swing.GroupLayout ListLayout = new javax.swing.GroupLayout(List);
        List.setLayout(ListLayout);
        ListLayout.setHorizontalGroup(
                ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ListLayout.createSequentialGroup()
                                .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 111, Short.MAX_VALUE)));
        ListLayout.setVerticalGroup(
                ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ListLayout.createSequentialGroup()
                                .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)));

        Scrollist.setViewportView(List);

        optionCurso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        optionCurso.setText("Curso");

        optionTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optionTipo.setText("Estado");

        optionEvaluación.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        optionEvaluación.setText("Evaluación");

        optionPropuesta.setText("Propuesta");

        optionTiempo.setText("Tiempo");

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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(optionTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(optionPropuesta, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(optionTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(optionObsevaciones,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
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
                                        .addComponent(optionTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(optionEvaluación, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(optionPropuesta)
                                        .addComponent(optionTiempo)
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
                                .addContainerGap(76, Short.MAX_VALUE)
                                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)));
        ContendorLayout.setVerticalGroup(
                ContendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ContendorLayout.createSequentialGroup()
                                .addComponent(Appbar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(ContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 407,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 96, Short.MAX_VALUE)));

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
        new LoginView().setVisible(true);
        setVisible(false);
    }

    private void botoIntemDescargarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("Descargando propuesta..");
    }

    private void inputObservacionesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void inputEvaluaciónActionPerformed(java.awt.event.ActionEvent evt) {

    }
 
    private javax.swing.JPanel Appbar;
    private javax.swing.JPanel Contendor;
    private javax.swing.JPanel ContenedorTabla;
    private javax.swing.JPanel Item;
    private javax.swing.JPanel List;
    private javax.swing.JScrollPane Scrollist;
    private javax.swing.JLabel TituloInterfaz;
    private javax.swing.JButton botoIntemDescargar;
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JTextField inputEvaluación;
    private javax.swing.JTextField inputObservaciones;
    private javax.swing.JLabel itemEstado;
    private javax.swing.JLabel itemName;
    private javax.swing.JLabel itemTiempo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel optionCurso;
    private javax.swing.JLabel optionEvaluación;
    private javax.swing.JLabel optionObsevaciones;
    private javax.swing.JLabel optionPropuesta;
    private javax.swing.JLabel optionTiempo;
    private javax.swing.JLabel optionTipo;
    private javax.swing.JLabel tituloTabla;
}
