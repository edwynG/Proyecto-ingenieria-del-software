package main.controller;

import java.util.ArrayList;

import main.Env;
import main.controller.abstractControllers.AbstractSesionControl;
import main.model.Proponent;
import main.model.abstractModels.User;
import main.view.components.commonComponents.CardMessage;
import raven.glasspanepopup.GlassPanePopup;

public class RegisterControl extends AbstractSesionControl {
    private ArrayList<String> documents;

    public User initRegisterProponent() {
        getUser().setId(Integer.parseInt(documents.getFirst()));
        ArrayList<String> preparedListToQuery = getTransformfile().tranformToBaseOnlyWidthExt(documents, "'");
        String queryUser = String.format(Env.QUERY_REGISTER_USER, getUser().getId() + "", getUser().getUser(),
                getUser().getPassword(), getUser().getType());
        String queryDocuments = getUser().getType().equals(Env.TYPE_USER_PROPONENT_NATURAL)
                ? String.format(Env.QUERY_REGISTER_DOCUMENT_NATURAL, String.join(",", preparedListToQuery))
                : String.format(Env.QUERY_REGISTER_DOCUMENT_LEGAL, String.join(",", preparedListToQuery));

        Boolean resultRegisterUserBool = getManagerDatabase().updateOrInsertData(queryUser + "\n" + queryDocuments);

        if (!resultRegisterUserBool) {
            return null;
        }

        return new Proponent(getUser().getId(), getUser().getUser(), getUser().getPassword(), getUser().getType());
    }

    public User initRegisterAdministrator() {
        String query = String.format(Env.QUERY_REGISTER_ADMIN, getUser().getPassword(), getUser().getUser());
        if (!getManagerDatabase().updateOrInsertData(query)) {
            return null;

        }
        LoginControl login = new LoginControl(getUser().getUser(), getUser().getPassword());
        return login.initLoginUser();

    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<String> documents) {
        this.documents = documents;
    }

    public boolean isThereAnEmailToRegisterAdmin() {
        if (getValidator().isThereAnEmailRegister(getUser().getUser())) {
            return true;
        }
        CardMessage pane = new CardMessage("No eres administrador", "El usuario no se encuantra registrado.");
        pane.settWidthCard(500);
        pane.setHeightCard(280);
        GlassPanePopup.showPopup(pane);
        return false;
    }

    public boolean isThereAnEmailToRegister() {
        if (getValidator().isThereAnEmailRegister(getUser().getUser())) {
            GlassPanePopup.showPopup(new CardMessage("Lo sentimos..", "El correo pertenece a otro usuario."));
            return true;
        }
        return false;
    }

    public boolean isThereAnIdToRegisterProponent() {
        if (getValidator().isThereAnIdRegister(getUser().getId())) {
            GlassPanePopup.showPopup(new CardMessage("Lo sentimos..", "La cedula pertenece a otro usuario."));
            return true;
        }
        return false;
    }

    public boolean IsThereAnPasswordToRegister(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            GlassPanePopup.showPopup(new CardMessage("Contraseña", "La contraseña no coincide."));
            return false;
        }

        return true;
    }

}
