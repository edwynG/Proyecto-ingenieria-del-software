package main.controller.abstractControllers;

import main.model.ManagerDatabase;
import main.model.abstractModels.User;

public abstract class AbstractSesionControl {
    private User user;
    private ManagerDatabase managerDatabase;

    public AbstractSesionControl(){
        user = new User() {};
        managerDatabase = ManagerDatabase.getManagerDatabase();
    }

    public User getUser() {
        return user;
    }

    public ManagerDatabase getManagerDatabase() {
        return managerDatabase;
    }
}
