package main.model;

import main.Env;

public class ControlValidator {
    private ManagerDatabase managerDatabase;

    public ControlValidator() {
        this.managerDatabase = ManagerDatabase.getManagerDatabase();

    }
    public boolean doesTheDataExist(String table,String campo, String dato) {
        return this.managerDatabase.isThereDataInTheQuery(String.format(Env.QUERY_VALIDATE_DATA, table, campo, dato));
    }
}
