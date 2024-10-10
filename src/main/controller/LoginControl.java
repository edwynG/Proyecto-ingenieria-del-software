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

            return new Proponent(getUser().getId(), getUser().getUser(), getUser().getPassword(), getUser().getType());
        }

        return new Administrator(getUser().getId(), getUser().getUser(), getUser().getPassword(), getUser().getType());

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

}
