package main.view.components.registerComponents;

import java.util.ArrayList;

import main.Env;
import main.controller.AdministratorControl;
import main.controller.ProponentControl;
import main.controller.RegisterControl;
import main.model.abstractModels.User;
import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.commonComponents.CardMessage;
import main.view.components.loginComponents.Login;
import main.view.utils.CustomVariables;
import raven.glasspanepopup.GlassPanePopup;

public class RegisterActions {
    public static RegisterControl control = new RegisterControl();

    public void actionsOptionLogin() {
        InterfaceWithoutAppbar.setFormulation(new Login(CustomVariables.RADIO_DEFAULT_PANEL));

    }

    public void actionsButtonContinueRegisterProponent(ArrayList<String> data) {
        if (!isValid(data) || !IsThereAnPasswordToRegister(data)) {
            return;
        }
        control.getUser().setUser(data.getFirst());
        control.getUser().setPassword(data.get(1));
        control.getUser().setTypeUser(data.getLast());

        if (isThereAnEmailToRegister()) {
            return;
        }

        InterfaceWithoutAppbar.setFormulation(new ProponentType(CustomVariables.RADIO_DEFAULT_PANEL));

    }

    public void actionsTerminateRegistrationAdmin(ArrayList<String> data) {
        if (!isValid(data) || !IsThereAnPasswordToRegister(data)) {
            return;
        }
        control.getUser().setUser(data.getFirst());
        control.getUser().setPassword(data.get(1));
        control.getUser().setTypeUser(data.getLast());

        if (!isThereAnEmailToRegisterAdmin()) {
            return;
        }

        User user = control.initRegisterAdministrator();
        if (!isValidUser(user)) {
            return;
        }
        System.out.println(user);
        Main.setUserControl(new AdministratorControl(user));
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        home.createInterfaceAdministrator();
        InterfaceWithAppbar.AdministratorDesing.openAdminWidown(user.getType());
        Main.setContent(home);
    }

    public void actionsTerminateRegistrationProponent(ArrayList<String> documents) {
        if (!isValid(documents)) {
            return;
        }
        control.getUser()
                .setId(control.getUser().getType().equals(Env.TYPE_USER_PROPONENT_NATURAL)
                        ? Integer.parseInt(documents.getFirst())
                        : Integer.parseInt(documents.get(1)));

        if (isThereAnIdToRegisterProponent()) {
            return;
        }
        control.setDocuments(documents);
        User user = control.initRegisterProponent();
        if (!isValidUser(user)) {
            return;
        }

        Main.setUserControl(new ProponentControl(user));
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        home.createInterfaceProponent();
        Main.setContent(home);
    }

    public void actionsButtonBefore() {
        InterfaceWithoutAppbar.setFormulation(new Register(CustomVariables.RADIO_DEFAULT_PANEL));
    }

    public void actionsButtonNext(String type) {
        if (type == null) {
            GlassPanePopup.showPopup(new CardMessage("Oops..", "Aún faltan datos por completar."));
            return;
        }
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

    private boolean isValidUser(User user) {
        if (user == null) {
            GlassPanePopup.showPopup(
                    new CardMessage("Lo sentimos..", "hubo un problema al intentar registrarlo."));
            return false;
        }
        return true;
    }

    private boolean isThereAnEmailToRegisterAdmin() {
        if (control.getValidator().isThereAnEmailRegister(control.getUser().getUser())) {
            return true;
        }
        CardMessage pane = new CardMessage("No eres administrador", "El usuario no se encuantra registrado.");
        pane.settWidthCard(500);
        pane.setHeightCard(280);
        GlassPanePopup.showPopup(pane);
        return false;
    }

    private boolean isThereAnEmailToRegister() {
        if (control.getValidator().isThereAnEmailRegister(control.getUser().getUser())) {
            GlassPanePopup.showPopup(new CardMessage("Lo sentimos..", "El correo pertenece a otro usuario."));
            return true;
        }
        return false;
    }

    private boolean isThereAnIdToRegisterProponent() {
        if (control.getValidator().isThereAnIdRegister(control.getUser().getId())) {
            GlassPanePopup.showPopup(new CardMessage("Lo sentimos..", "La cedula pertenece a otro usuario."));
            return true;
        }
        return false;
    }

    private boolean IsThereAnPasswordToRegister(ArrayList<String> data) {
        if (!data.get(1).equals(data.get(2))) {
            GlassPanePopup.showPopup(new CardMessage("Contraseña", "La contraseña no coincide."));
            return false;
        }

        return true;
    }

    private boolean isValid(ArrayList<String> data) {
        if (!isValidInput(data)) {
            GlassPanePopup.showPopup(new CardMessage("Oops..", "Aún faltan datos por completar."));
            return false;
        }

        return true;
    }

    private boolean isValidInput(ArrayList<String> data) {
        for (String str : data) {
            if (str == null) {
                return false;
            }
        }

        for (String str : data) {
            if (str.isEmpty()) {
                return false;
            }
        }

        return true;
    }

}
