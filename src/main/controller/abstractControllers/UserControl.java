package main.controller.abstractControllers;

import java.util.ArrayList;
import java.util.List;

import main.model.ManagerDatabase;
import main.model.Proposal;
import main.model.TransformFileBinary;
import main.model.abstractModels.User;

public abstract class UserControl {
    private User user;
    private ManagerDatabase managerDatabase;
    private TransformFileBinary transformfile = new TransformFileBinary();

    public UserControl(User user) {
        this.user = user;
        this.managerDatabase = ManagerDatabase.getManagerDatabase();
    }

    public List<Proposal> getProposals() {
        return user.getProposals();
    }

    public User getUser() {
        return user;
    }

    public boolean proposeCourse(ArrayList<String> data) {
        return false;
    };

    public boolean evaluateCourse(String assessment, String observations, int id) {
        return false;
    };

    public TransformFileBinary getTransformfile() {
        return transformfile;
    }

    public ManagerDatabase getManagerDatabase() {
        return managerDatabase;
    }

}
