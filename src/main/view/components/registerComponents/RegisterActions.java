package main.view.components.registerComponents;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.loginComponents.Login;

public class RegisterActions {

    public void actionsOptionLogin() {
        InterfaceWithoutAppbar.setFormulation(new Login(25));

    }

    public void actionsButtonContinueRegister(String type) {
        if (type.toLowerCase().contains("proponente")) {
            InterfaceWithoutAppbar.setFormulation(new ProponentType(25));
            return;
        }
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos, opción no disponible.", "Administrador",
                JOptionPane.ERROR_MESSAGE);
    }

    public void actionsButtonFinishRegister() {
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        home.createInterfaceProponent();
        Main.setContent(home);
    }

    public void actionsButtonBefore() {
        InterfaceWithoutAppbar.setFormulation(new Register(25));
    }

    public void actionsButtonNext(String type) {
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
