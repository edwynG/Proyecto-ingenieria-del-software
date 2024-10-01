package main.controller;

import java.util.ArrayList;

import main.Env;
import main.controller.abstractControllers.AbstractSesionControl;
import main.model.Proponent;
import main.model.TransformFileBinary;
import main.model.abstractModels.User;

public class RegisterControl extends AbstractSesionControl {
    private ArrayList<String> documents;
    private Validator validator = new Validator();
    private TransformFileBinary transformfile = new TransformFileBinary();

    public User initRegisterProponent() {
        documents.remove(getUser().getId() + "");
        ArrayList<String> documentsRegister = transformDocuments(documents);
        String queryUser = String.format(Env.QUERY_REGISTER_USER, getUser().getId() + "", getUser().getUser(),
                getUser().getPassword(), getUser().getType());
        String queryDocuments = getUser().getType().equals(Env.TYPE_USER_PROPONENT_NATURAL)
                ? String.format(Env.QUERY_REGISTER_DOCUMENT_NATURAL, getUser().getId() + "",
                        String.join(",", documentsRegister))
                : String.format(Env.QUERY_REGISTER_DOCUMENT_LEGAL, getUser().getId() + "",
                        String.join(",", documentsRegister));

        Boolean resultRegisterUserBool = getManagerDatabase().updateOrInsertData(queryUser + "\n" + queryDocuments);

        if (!resultRegisterUserBool) {
            return null;
        }

        return new Proponent(getUser().getId(), getUser().getUser(), getUser().getPassword(), getUser().getType());
    }

    public User initRegisterAdministrator() {
        String query = String.format(Env.QUERY_REGISTER_ADMIN,getUser().getPassword(),getUser().getUser());
        System.out.println(query);
        if (!getManagerDatabase().updateOrInsertData(query)) {
            return null;

        }
        LoginControl login = new LoginControl(getUser().getUser(), getUser().getPassword());
        return login.initLoginUser();

    }

    private ArrayList<String> transformDocuments(ArrayList<String> arr) {
        ArrayList<String> newList = new ArrayList<>();
        for (String string : arr) {
            newList.add(formate(transformfile.transformToBase(string)));
        }
        return newList;
    }

    private String formate(String str) {
        return '"' + str + '"';
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<String> documents) {
        this.documents = documents;
    }

    public Validator getValidator() {
        return validator;
    }
    /*
     * public User registerProponent(Map<String, String> data, Map<String, String>
     * documents) {
     * List<String> fieldsUser = new ArrayList<>(data.keySet());
     * List<String> dataUser = new ArrayList<>(data.values());
     * List<String> fieldsDocument = new ArrayList<>(documents.keySet());
     * List<String> dataDocument = new ArrayList<>(documents.values());
     * 
     * String user = String.format(Env.QUERY_REGISTER_USER, String.join(",",
     * fieldsUser), String.join(",", dataUser));
     * 
     * String document = String.format(Env.QUERY_REGISTER_DOCUMENT,
     * "ProponenteID" + "," + String.join(",", fieldsDocument),
     * data.get("ProponenteID") + "," + String.join(",", dataDocument));
     * 
     * String query = user + document;
     * boolean singIn = managerDatabase.updateOrInsertData(query);
     * 
     * if (singIn) {
     * this.user = new Proponent(Integer.parseInt(data.get("ProponenteID")),
     * data.get("Correo").replace("'", ""), data.get("Contraseña").replace("'",""),
     * data.get("TipoDePersona").replace("'", ""));
     * 
     * }
     * 
     * return this.user;
     * };
     * 
     * public User registerAdmin(Map<String, String> data) {
     * List<String> fieldsUser = new ArrayList<>(data.keySet());
     * List<String> dataUser = new ArrayList<>(data.values());
     * 
     * String admin = String.format(Env.QUERY_REGISTER_ADMIN, String.join(",",
     * fieldsUser),
     * String.join(",", dataUser));
     * 
     * boolean singIn = managerDatabase.updateOrInsertData(admin);
     * if (singIn) {
     * this.user = new
     * Administrator(Integer.parseInt(data.get("AdministradorID")),data.get("Correo"
     * ).replace("'", ""), data.get("Contraseña").replace("'", ""),
     * data.get("TipoDeAdministrador").replace("'", ""));
     * }
     * 
     * return this.user;
     * 
     * }
     */
}
