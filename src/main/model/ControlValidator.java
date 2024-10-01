package main.model;

import main.Env;

public class ControlValidator {
    private ManagerDatabase managerDatabase;

    public ControlValidator() {
        this.managerDatabase = ManagerDatabase.getManagerDatabase();

    }

    public boolean doesTheDataExist(String table, String campo, String dato) {
        return this.managerDatabase.isThereDataInTheQuery(String.format(Env.QUERY_VALIDATE_DATA, table, campo, dato));
    }

    public boolean isThereAnIdRegister(Integer id) {
        return this.managerDatabase.isThereDataInTheQuery(
                String.format(Env.QUERY_VALIDATE_DATA,Env.TABLE_NAME_PROPONENTS, Env.TABLE_FIELD_PROPOENENT_ID, id + ""));

    }

    public boolean isThereAnEmailRegister(String email) {
        return this.managerDatabase.isThereDataInTheQuery(
                String.format(Env.QUERY_VALIDATE_DATA,Env.TABLE_NAME_PROPONENTS, Env.TABLE_FIELD_EMAIL, email)) || this.managerDatabase.isThereDataInTheQuery(
                    String.format(Env.QUERY_VALIDATE_DATA,Env.TABLE_NAME_ADMINISTRATORS, Env.TABLE_FIELD_EMAIL, email));

    }
}
