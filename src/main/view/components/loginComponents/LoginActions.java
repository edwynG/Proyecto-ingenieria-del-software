package main.view.components.loginComponents;

import javax.swing.JOptionPane;

import main.view.Main;

public class LoginActions {
    
    public void eventOptionPassword(){
        JOptionPane.showMessageDialog(Main.WINDOW,"Lo sentimos, sistema en mantenimiento.","¿Olvidates tu contraseña?", JOptionPane.ERROR_MESSAGE);

    }

    public void eventOptionRegister(){
        JOptionPane.showMessageDialog(Main.WINDOW,"Opción no disponible","Registrate", JOptionPane.ERROR_MESSAGE);
       
    }

    public boolean eventButtonLogin(String email, String passwonrd){
        String message = String.format("Correo: %s \nContraseña: %s", email,passwonrd);
        JOptionPane.showMessageDialog(Main.WINDOW, message,"Iniciar sesión", JOptionPane.WARNING_MESSAGE);
        return true;
    }
}
