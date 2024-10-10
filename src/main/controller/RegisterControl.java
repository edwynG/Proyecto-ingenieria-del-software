package main.controller;

import java.util.ArrayList;

import main.Env;
import main.controller.abstractControllers.AbstractSesionControl;
import main.model.Proponent;
import main.model.abstractModels.User;

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

    

}
