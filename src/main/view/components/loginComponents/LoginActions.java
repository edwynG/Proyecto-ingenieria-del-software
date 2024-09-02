package main.view.components.loginComponents;

import javax.swing.JOptionPane;

import main.view.Main;
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

    public boolean eventButtonLogin(String email, String passwonrd) {
        String message = String.format("Correo electrónico: %s\nContraseña: %s", email, passwonrd);
        JOptionPane.showMessageDialog(Main.WINDOW, message, "Iniciar sesión", JOptionPane.WARNING_MESSAGE);
        return true;
    }
}
