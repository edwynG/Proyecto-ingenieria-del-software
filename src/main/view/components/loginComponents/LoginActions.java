package main.view.components.loginComponents;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.registerComponents.Register;

public class LoginActions {

    public void eventOptionPassword() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos, sistema en mantenimiento.",
                "¿Olvidates tu contraseña?", JOptionPane.ERROR_MESSAGE);

    }

    public void eventOptionRegister() {
        InterfaceWithoutAppbar.setFormulation(new Register(25));

    }

    public void eventButtonLogin(String email, String passwonrd) {
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        home.createInterfaceProponent();
        Main.setContent(home);
        
    }
}
