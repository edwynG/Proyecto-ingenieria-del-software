package main.view.components.loginComponents;

import javax.swing.JOptionPane;

import main.Env;
import main.controller.AdministratorControl;
import main.controller.LoginControl;
import main.controller.ProponentControl;
import main.model.abstractModels.User;
import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.commonComponents.CardMessage;
import main.view.components.registerComponents.Register;
import raven.glasspanepopup.GlassPanePopup;

public class LoginActions {
    private LoginControl control = new LoginControl();

    public void actionsOptionPassword() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos, sistema en mantenimiento.",
                "¿Olvidates tu contraseña?", JOptionPane.ERROR_MESSAGE);

    }

    public void actionsOptionRegister() {
        InterfaceWithoutAppbar.setFormulation(new Register(25));

    }

    public void actionsButtonLogin(String email, String passwonrd) {
        if (!isValidInput()) {
            GlassPanePopup.showPopup(new CardMessage("Oops..", "Aún faltan datos por completar."));
            return;
        }

        control.setEmail(email);
        control.setPassword(passwonrd);
        User user = control.initLoginUser();
        if (user == null) {
            GlassPanePopup.showPopup(new CardMessage("Lo sentimos..", "El usuario proposionado no existe."));
            return;
        }

        InterfaceWithAppbar home = new InterfaceWithAppbar();
        Main.setContent(home);
        user.refreshListOfProposals();
        if (user.getTypeUser().equals(Env.TYPE_USER_PROPONENT)) {
            Main.setUserControl(new ProponentControl(user));
            home.createInterfaceProponent();
            return;
        }
        Main.setUserControl(new AdministratorControl(user));
        home.createInterfaceAdministrator();

    }

    private boolean isValidInput() {
        if (control.getEmail() == null || control.getPassword() == null) {
            return false;
        }

        if (control.getEmail().isEmpty() || control.getPassword().isEmpty()) {
            return false;
        }

        return true;
    }
}
