package main.view;

import main.Env;
import main.controller.abstractControllers.UserControl;
import main.view.components.Login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    private int height;
    private int width;
    private JPanel window;
    private static JPanel content;
    private String windowName;
    private static UserControl userControl;

    public Main(String name) {
        this.configMain(name);
        this.initMain();
    }

    private void configMain(String name){
        userControl = null;
        content = new JPanel();
        this.window = new JPanel();
        this.height = 505;
        this.width = 870;
        this.windowName = name;
    }

    private void initMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(this.windowName);
        setContentPane(this.window);
        setSize(this.width, this.height);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(this.width, this.height));

        // Configuración de los paneles principales
        this.configContentWindow(this.window); // Contenedor de la App
        this.configContent(content); // Contenido de la ventana
        pack();
    }

    private void configContentWindow(JPanel main) {
        main.setLayout(new BorderLayout());
        main.add(content);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Env.PATH_ICON_WINDOW));
    }

    private void configContent(JPanel panel){
        panel.setLayout(new BorderLayout());
        panel.add(new Login(Env.PATH_IMAGE_MAIN),BorderLayout.CENTER);
    }

    // Metodos de gestión
    public static JPanel getContent() {
        return content;
    }

    public static void addContent(JPanel panel) {
        content.add(panel, BorderLayout.CENTER);
    }

    public static void removeContent() {
        content.removeAll(); // Elimina todos los componentes
        content.revalidate(); // Vuelve a validar el panel
        content.repaint(); // Redibuja el pane
    }
    
    public static void setUserControl(UserControl control){
        userControl=control;
    }

    public static UserControl getUserControl(){
        return userControl;
    }

}