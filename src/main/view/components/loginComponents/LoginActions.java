package main.view.components.loginComponents;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.Register;
import main.view.components.CommonComponents.InterfaceWithForm;

public class LoginActions {

    public void eventOptionPassword() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos, sistema en mantenimiento.",
                "¿Olvidates tu contraseña?", JOptionPane.ERROR_MESSAGE);

    }

    public void eventOptionRegister() {
        InterfaceWithForm.setFormulation(new Register(25));

    }

    public boolean eventButtonLogin(String email, String passwonrd) {
        String message = String.format("Correo: %s \nContraseña: %s", email, passwonrd);
        JOptionPane.showMessageDialog(Main.WINDOW, message, "Iniciar sesión", JOptionPane.WARNING_MESSAGE);
        return true;
    }
}
