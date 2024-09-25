package main.view.components.loginComponents;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.registerComponents.Register;

public class LoginActions {

    public void actionsOptionPassword() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos, sistema en mantenimiento.",
                "¿Olvidates tu contraseña?", JOptionPane.ERROR_MESSAGE);

    }

    public void actionsOptionRegister() {
        InterfaceWithoutAppbar.setFormulation(new Register(25));

    }

    public void actionsButtonLogin(String email, String passwonrd) {
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        home.createInterfaceProponent();
        Main.setContent(home);

    }
}
