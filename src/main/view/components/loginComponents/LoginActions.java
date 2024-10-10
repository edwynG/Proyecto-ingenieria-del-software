package main.view.components.loginComponents;

import java.util.ArrayList;
import java.util.Arrays;

import main.Env;
import main.controller.AdministratorControl;
import main.controller.LoginControl;
import main.controller.ProponentControl;
import main.model.abstractModels.User;
import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.commonComponents.ActionsInterface;
import main.view.components.registerComponents.Register;
import main.view.utils.CustomVariables;


public class LoginActions extends ActionsInterface {
    private LoginControl control = new LoginControl();

    public void actionsOptionPassword() {
        informationPanePopup("No disponible", "Lo sentimos, sistema en mantenimiento.", 350,250);

    }

    public void actionsOptionRegister() {
        InterfaceWithoutAppbar.setFormulation(new Register(CustomVariables.RADIO_DEFAULT_PANEL));

    }

    public void actionsButtonLogin(String email, String password) {
        if (!isValidData(new ArrayList<>(Arrays.asList(email, password)))) {
            return;
        }
        if (!isThisValidEmail(email) || !isThisValidPassword(password)) {
            return;
        }
        
        control.setEmail(email);
        control.setPassword(password);
        User user = control.initLoginUser();
        if (!isValidUser(user, "Lo sentimos..", "El usuario proposionado no existe.")) {
            return;
        }
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        Main.setContent(home);
        if (user.getTypeUser().equals(Env.TYPE_USER_PROPONENT)) {
            Main.setUserControl(new ProponentControl(user));
            home.createInterfaceProponent();
            return;
        }
        Main.setUserControl(new AdministratorControl(user));
        home.createInterfaceAdministrator();
        InterfaceWithAppbar.AdministratorDesing.openAdminWidown(user.getType());

    }

}
