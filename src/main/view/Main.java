package main.view;

import main.Env;
import main.controller.abstractControllers.UserControl;
import main.view.components.Login;
import main.view.components.CommonComponents.InterfaceWithForm;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main extends JFrame {
    private int height;
    private int width;
    public static JPanel WINDOW;
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
        WINDOW = new JPanel();
        this.height = 560;
        this.width = 870;
        this.windowName = name;
    }

    private void initMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(this.windowName);
        JScrollPane scrollPane = new JScrollPane(WINDOW);
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
        InterfaceWithForm desing = new InterfaceWithForm(Env.PATH_IMAGE_MAIN);
        InterfaceWithForm.setFormulation(new Login(25));
        panel.add(desing, BorderLayout.CENTER);
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

    public static void setUserControl(UserControl control) {
        userControl = control;
    }

    public static UserControl getUserControl() {
        return userControl;
    }

}