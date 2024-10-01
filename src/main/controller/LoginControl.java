package main.controller;

import java.util.ArrayList;
import main.Env;
import main.controller.abstractControllers.AbstractSesionControl;
import main.model.Administrator;
import main.model.Proponent;
import main.model.abstractModels.User;

public class LoginControl extends AbstractSesionControl {
    private String email = null;
    private String password = null;

    public LoginControl() {

    }

    public LoginControl(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User initLoginUser() {
        if (!isValidLogin()) {
            return null;
        }
        configUserData();
        boolean option = getUser().getTypeUser().equalsIgnoreCase(Env.TYPE_USER_PROPONENT);
        if (option) {

            return new Proponent(getUser().getId(), getUser().getUser(), getUser().getPassword(),
                    getUser().getType());
        }

        return new Administrator(getUser().getId(), getUser().getUser(), getUser().getPassword(),
                getUser().getType());

    }

    private void configUserData() {
        boolean option = getManagerDatabase()
                .isThereDataInTheQuery(String.format(Env.QUERY_LOGIN_PROPONENT, email, password));
        ArrayList<String> date;
        if (option) {
            date = getManagerDatabase().getData(String.format(Env.QUERY_LOGIN_PROPONENT, email, password)).get(0);
            configData(getUser(), Env.TYPE_USER_PROPONENT, date);
            return;
        }
        date = getManagerDatabase().getData(String.format(Env.QUERY_LOGIN_ADMISTRATOR, email, password)).get(0);
        configData(getUser(), Env.TYPE_USER_ADMINISTRADOR, date);

    }

    private void configData(User user, String typeUser, ArrayList<String> data) {
        System.out.println(data);
        user.setId(Integer.parseInt(data.get(0)));
        user.setUser(data.get(1));
        user.setPassword(data.get(2));
        user.setType(data.get(3));
        user.setTypeUser(typeUser);
    }

    private boolean isValidLogin() {
        boolean argValid = email != null && password != null;
        if (!argValid)
            return false;

        boolean existProponent = getManagerDatabase()
                .isThereDataInTheQuery(String.format(Env.QUERY_LOGIN_PROPONENT, email, password));
        boolean existAdministrator = existProponent ? false
                : getManagerDatabase()
                        .isThereDataInTheQuery(String.format(Env.QUERY_LOGIN_ADMISTRATOR, email, password));

        return existProponent || existAdministrator;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public AbstractUser loginUser(String email, String password, String type) {
    // String query = Env.QUERY_LOGIN;
    // boolean option = type.equalsIgnoreCase("Proponente");

    // String table = option ? "Proponentes" : "Administradores";
    // query = String.format(query, table, email, password);

    // List<List<String>> registro = getManagerDatabase().getData(query);
    // if (!registro.isEmpty()) {
    // List<String> fields = registro.get(0);

    // if (option) {
    // this.user = new Proponent(Integer.parseInt(fields.get(0)), fields.get(1),
    // fields.get(2), fields.get(3));

    // } else {
    // this.user = new Administrator(Integer.parseInt(fields.get(0)), fields.get(1),
    // fields.get(2),
    // fields.get(3));

    // }
    // }

    // return this.user;
    // }

    // public AbstractUser registerProponent(Map<String, String> data, Map<String,
    // String> documents) {
    // List<String> fieldsUser = new ArrayList<>(data.keySet());
    // List<String> dataUser = new ArrayList<>(data.values());
    // List<String> fieldsDocument = new ArrayList<>(documents.keySet());
    // List<String> dataDocument = new ArrayList<>(documents.values());

    // String user = String.format(Env.QUERY_REGISTER_USER, String.join(",",
    // fieldsUser), String.join(",", dataUser));

    // String document = String.format(Env.QUERY_REGISTER_DOCUMENT,
    // "ProponenteID" + "," + String.join(",", fieldsDocument),
    // data.get("ProponenteID") + "," + String.join(",", dataDocument));

    // String query = user + document;
    // boolean singIn = managerDatabase.updateOrInsertData(query);

    // if (singIn) {
    // this.user = new Proponent(Integer.parseInt(data.get("ProponenteID")),
    // data.get("Correo").replace("'", ""), data.get("Contraseña").replace("'",""),
    // data.get("TipoDePersona").replace("'", ""));

    // }

    // return this.user;
    // };

    // public AbstractUser registerAdmin(Map<String, String> data) {
    // List<String> fieldsUser = new ArrayList<>(data.keySet());
    // List<String> dataUser = new ArrayList<>(data.values());

    // String admin = String.format(Env.QUERY_REGISTER_ADMIN, String.join(",",
    // fieldsUser),
    // String.join(",", dataUser));

    // boolean singIn = managerDatabase.updateOrInsertData(admin);
    // if (singIn) {
    // this.user = new
    // Administrator(Integer.parseInt(data.get("AdministradorID")),data.get("Correo").replace("'",
    // ""), data.get("Contraseña").replace("'", ""),
    // data.get("TipoDeAdministrador").replace("'", ""));
    // }

    // return this.user;

    // }

}
