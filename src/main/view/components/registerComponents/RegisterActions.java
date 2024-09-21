package main.view.components.registerComponents;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.loginComponents.Login;

public class RegisterActions {

    public void eventOptionLogin() {
        InterfaceWithoutAppbar.setFormulation(new Login(25));

    }

    public void eventButtonContinueRegister(String type) {
        if (type.toLowerCase().contains("proponente")) {
            InterfaceWithoutAppbar.setFormulation(new ProponentType(25));
            return;
        }
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos, opción no disponible.", "Administrador",
                JOptionPane.ERROR_MESSAGE);
    }

    public void eventButtonFinishRegister() {
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        home.createInterfaceProponent();
        Main.setContent(home);
    }

    public void eventButtonBefore() {
        InterfaceWithoutAppbar.setFormulation(new Register(25));
    }

    public void eventButtonNext(String type) {
        InterfaceWithAppbar UI = new InterfaceWithAppbar();
        if (type.toLowerCase().contains("natural")) {
            UI.createFormulationNatural();
            Main.setContent(UI);
            return;
        }
        UI.createFormulationJuridico();
        Main.setContent(UI);

    }

}
