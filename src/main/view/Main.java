package main.view;

import main.Env;
import main.controller.AdministratorControl;
import main.controller.ProponentControl;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.commonComponents.ScrollPaneWin11;
import main.view.components.loginComponents.Login;
import main.view.utils.Components;
import main.view.utils.CustomVariables;
import raven.glasspanepopup.GlassPanePopup;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main extends JFrame {
    private int height;
    private int width;
    public static final JPanel WINDOW = new JPanel();
    private static JPanel content;
    private String windowName;
    private static AdministratorControl admin;
    private static ProponentControl proponent;

    public Main(String name) {
        this.configMain(name);
        this.initMain();
    }

    private void configMain(String name) {
        admin = null;
        proponent = null;
        content = new JPanel();
        this.height = 660;
        this.width = 980;
        this.windowName = name;
    }

    private void initMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(this.windowName);
        ScrollPaneWin11 scrollPane = new ScrollPaneWin11(WINDOW);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setContentPane(scrollPane);
        GlassPanePopup.install(this);
        setSize(this.width, this.height);
        setLocationRelativeTo(null);

        // Configuración de los paneles principales
        this.configContentWindow(WINDOW);
        this.configContentInitial(content);
        System.out.println("Bienvenido a course stack!!");

    }

    private void configContentWindow(JPanel main) {
        main.setLayout(new BorderLayout());
        main.add(content, BorderLayout.CENTER);
        setIconImage(Components.getClassImage(this, Env.PATH_ICON_WINDOW));

    }

    private void configContentInitial(JPanel panel) {
        panel.setLayout(new BorderLayout());
        InterfaceWithoutAppbar desing = new InterfaceWithoutAppbar(Env.PATH_IMAGE_MAIN);
        InterfaceWithoutAppbar.setFormulation(new Login(CustomVariables.RADIO_DEFAULT_PANEL));
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
        Components.removeElementAll(content);

    }

    public static void setUserControl(AdministratorControl control) {
        admin = control;
    }

    public static void setUserControl(ProponentControl control) {
        proponent = control;
    }

    public static ProponentControl getProponentControl() {
        return proponent;
    }

    public static AdministratorControl getAdminControl() {
        return admin;
    }

}