package main.controller.abstractControllers;

import main.controller.Validator;
import main.model.ManagerDatabase;
import main.model.TransformFileBinary;
import main.model.abstractModels.User;

public abstract class AbstractSesionControl {
    private User user;
    private ManagerDatabase managerDatabase;
    private Validator validator;
    private TransformFileBinary transformfile = new TransformFileBinary();

    public AbstractSesionControl() {
        user = new User() {
        };
        managerDatabase = ManagerDatabase.getManagerDatabase();
        validator = new Validator();
    }

    public User getUser() {
        return user;
    }

    public ManagerDatabase getManagerDatabase() {
        return managerDatabase;
    }

    public Validator getValidator() {
        return validator;
    }

    public TransformFileBinary getTransformfile() {
        return transformfile;
    }
}
