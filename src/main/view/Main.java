package main.view;

import main.Env;
import main.controller.abstractControllers.UserControl;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.CommonComponents.ScrollPaneWin11;
import main.view.components.loginComponents.Login;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Main extends JFrame {
    private int height;
    private int width;
    public static final JPanel WINDOW = new JPanel();
    public static final JLayeredPane LEVEL = new JLayeredPane();
    private static JPanel content;
    private String windowName;
    private static UserControl userControl;

    public Main(String name) {
        this.configMain(name);
        this.initMain();
    }

    private void configMain(String name) {
        userControl = null;
        content = new JPanel();
        this.height = 580;
        this.width = 940;
        this.windowName = name;
    }

    private void initMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(this.windowName);
        ScrollPaneWin11 scrollPane = new ScrollPaneWin11(WINDOW);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setContentPane(scrollPane);
        setSize(this.width, this.height);
        setLocationRelativeTo(null);

        // Configuración de los paneles principales
        this.configContentWindow(WINDOW); // Contenedor de la App
        this.configContent(content); // Contenido de la ventana
        
    }

    private void configContentWindow(JPanel main) {
        main.setLayout(new BorderLayout());
        main.add(content,BorderLayout.CENTER);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Env.PATH_ICON_WINDOW));
    }

    private void configContent(JPanel panel) {
        panel.setLayout(new BorderLayout());
        InterfaceWithoutAppbar desing = new InterfaceWithoutAppbar(Env.PATH_IMAGE_MAIN);
        InterfaceWithoutAppbar.setFormulation(new Login(25));
        panel.add(desing, BorderLayout.CENTER);
    }

    // Metodos de gestión
    public static JPanel getContent() {
        return content;
    }

    public static void setContent(JPanel panel) {
        cleanContent();
        content.add(panel, BorderLayout.CENTER);
    }

    public static void cleanContent() {
        content.removeAll(); // Elimina todos los componentes
        content.revalidate(); // Vuelve a validar el panel
        content.repaint(); // Redibuja el pane
    }

    public static void setUserControl(UserControl control) {
        userControl = control;
    }

    public static UserControl getUserControl() {
        return userControl;
    }

    
}