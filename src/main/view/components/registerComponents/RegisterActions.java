package main.view.components.registerComponents;

import java.util.ArrayList;

import main.Env;
import main.controller.AdministratorControl;
import main.controller.ProponentControl;
import main.controller.RegisterControl;
import main.controller.Validator;
import main.model.abstractModels.User;
import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.InterfaceWithoutAppbar;
import main.view.components.commonComponents.ActionsInterface;
import main.view.components.loginComponents.Login;
import main.view.utils.CustomVariables;

public class RegisterActions extends ActionsInterface {
    public static RegisterControl control = new RegisterControl();

    public void actionsOptionLogin() {
        InterfaceWithoutAppbar.setFormulation(new Login(CustomVariables.RADIO_DEFAULT_PANEL));

    }

    public void actionsButtonContinueRegisterProponent(ArrayList<String> data) {
        if (!isValidData(data) || !IsThereAnPasswordToRegister(data.get(1), data.get(2))) {
            return;
        }

        if (!isThisValidEmail(data.getFirst()) || !isThisValidPassword(data.get(1))) {
            return;
        }
        if (isThereAnEmailToRegister(data.getFirst())) {
            return;
        }
        control.getUser().setUser(data.getFirst());
        control.getUser().setPassword(data.get(1));
        control.getUser().setTypeUser(data.getLast());

        InterfaceWithoutAppbar.setFormulation(new ProponentType(CustomVariables.RADIO_DEFAULT_PANEL));

    }

    public void actionsTerminateRegistrationAdmin(ArrayList<String> data) {
        if (!isValidData(data) || !IsThereAnPasswordToRegister(data.get(1), data.get(2))) {
            return;
        }

        if (!isThisValidEmail(data.getFirst()) || !isThisValidPassword(data.get(1))) {
            return;
        }
        if (!isThereAnEmailToRegisterAdmin(data.getFirst())) {
            return;
        }

        control.getUser().setUser(data.getFirst());
        control.getUser().setPassword(data.get(1));
        control.getUser().setTypeUser(data.getLast());

        User user = control.initRegisterAdministrator();
        if (!isValidUser(user, "Lo sentimos..", "hubo un problema al intentar registrarlo.")) {
            return;
        }
        Main.setUserControl(new AdministratorControl(user));
        InterfaceWithAppbar home = new InterfaceWithAppbar();
        home.createInterfaceAdministrator();
        InterfaceWithAppbar.AdministratorDesing.openAdminWidown(user.getType());
        Main.setContent(home);
    }

    public void actionsTerminateRegistrationProponent(ArrayList<String> documents) {
        if (!isValidData(documents)) {
            return;
        }
        if (!isNumber(documents.getFirst())) {
            return;
        }

        if (isThereAnProponentIDToRegister(Integer.parseInt(documents.getFirst()))) {
            return;
        }
        control.getUser().setId(Integer.parseInt(documents.getFirst()));
        control.setDocuments(documents);
        User user = control.initRegisterProponent();
        if (!isValidUser(user, "Lo sentimos..", "hubo un problema al intentar registrarlo.")) {
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
            informationPanePopup("Oops..", "Aún faltan datos por completar.");
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

    private boolean isThereAnEmailToRegisterAdmin(String email) {
        if (new Validator().isThereAnEmailRegister(email)) {
            return true;
        }
        informationPanePopup("No eres administrador", "El usuario no se encuantra registrado.", 500, 280);
        return false;
    }

    private boolean isThereAnEmailToRegister(String email) {
        if (new Validator().isThereAnEmailRegister(email)) {
            informationPanePopup("Lo sentimos..", "El correo pertenece a otro usuario.");
            return true;
        }
        return false;
    }

    private boolean isThereAnProponentIDToRegister(Integer id) {
        if (new Validator().isThereAnProponentIDRegister(id)) {
            informationPanePopup("Lo sentimos..", "La cedula pertenece a otro usuario.");
            return true;
        }
        return false;
    }

    public boolean IsThereAnPasswordToRegister(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            informationPanePopup("Contraseña", "La contraseña no coincide.");
            return false;
        }

        return true;
    }
}
