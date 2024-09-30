package main.view.components.registerComponents;

import javax.swing.JOptionPane;

import main.Env;
import main.controller.RegisterControl;
import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.loginComponents.Login;
import main.view.utils.CustomVariables;

public class RegisterActions {
    RegisterControl control = new RegisterControl();

    public void actionsOptionLogin() {
        InterfaceWithoutAppbar.setFormulation(new Login(CustomVariables.RADIO_DEFAULT_PANEL));

    }

    public void actionsButtonContinueRegister(String type) {
        if (type.toLowerCase().contains("proponente")) {
            InterfaceWithoutAppbar.setFormulation(new ProponentType(CustomVariables.RADIO_DEFAULT_PANEL));
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
        InterfaceWithoutAppbar.setFormulation(new Register(CustomVariables.RADIO_DEFAULT_PANEL));
    }

    public void actionsButtonNext(String type) {
        InterfaceWithAppbar UI = new InterfaceWithAppbar();
        if (type.equals(Env.TYPE_USER_PROPONENT_NATURAL)) {
            control.getUser().setType(Env.TYPE_USER_PROPONENT_NATURAL);
            UI.createFormulationNatural();
            Main.setContent(UI);
            return;
        }
        control.getUser().setType(Env.TYPE_USER_PROPONENT_LEGAL);
        UI.createFormulationJuridico();
        Main.setContent(UI);

    }

}
