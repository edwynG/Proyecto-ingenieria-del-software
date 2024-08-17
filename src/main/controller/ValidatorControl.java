package main.controller;

import main.Env;
import main.model.ManagerDatabase;

public class ValidatorControl {
    private ManagerDatabase managerDatabase;

    public ValidatorControl() {
        this.managerDatabase = ManagerDatabase.getManagerDatabase();

    }
    public boolean doesTheDataExist(String campo, String dato) {
        return this.managerDatabase.isThereDataInTheQuery(String.format(Env.QUERY_VALIDATE_DATA, campo, dato));
    }
}
