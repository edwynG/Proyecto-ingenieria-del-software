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
import main.view.components.commonComponents.CardMessage;
import main.view.components.registerComponents.Register;
import raven.glasspanepopup.GlassPanePopup;

public class LoginActions extends ActionsInterface{
    private LoginControl control = new LoginControl();

    public void actionsOptionPassword() {
        CardMessage pane = new CardMessage("No disponible", "Lo sentimos, sistema en mantenimiento.");
        pane.settWidthCard(350);
        pane.setHeightCard(250);
        GlassPanePopup.showPopup(pane);

    }

    public void actionsOptionRegister() {
        InterfaceWithoutAppbar.setFormulation(new Register(25));

    }

    public void actionsButtonLogin(String email, String password) {
        if (!isValidData(new ArrayList<>(Arrays.asList(email,password)))) {
            return;
        }

        control.setEmail(email);
        control.setPassword(password);
        User user = control.initLoginUser();
        if (!isValidUser(user,"Lo sentimos..","El usuario proposionado no existe.")) {
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
        InterfaceWithAppbar.AdministratorDesing.openAdminWidown(user.getType());


    }


 
}
