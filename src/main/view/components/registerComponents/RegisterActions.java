package main.view.components.registerComponents;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.Login;
import main.view.components.Register;
import main.view.components.CommonComponents.InterfaceWithForm;

public class RegisterActions {

    public void eventOptionLogin() {
        InterfaceWithForm.setFormulation(new Login(25));
        
    }

    public void eventButtonRegister(){
        InterfaceWithForm.setFormulation(new ProponentType(25));
    }

    public void eventButtonBefore(){
        InterfaceWithForm.setFormulation(new Register(25));
    }

    public void eventButtonNext(){
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos, opción no disponible.", "Continuar registro", JOptionPane.INFORMATION_MESSAGE);
    }

}
