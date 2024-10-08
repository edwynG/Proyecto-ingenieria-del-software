package main.controller.abstractControllers;
import java.util.ArrayList;
import main.model.ManagerDatabase;
import main.model.Proposal;
import main.model.TransformFileBinary;
import main.model.abstractModels.User;

public abstract class AbstractUserControl {
    private User user;
    private ManagerDatabase managerDatabase;
    private TransformFileBinary transformfile = new TransformFileBinary();

    public AbstractUserControl(User user) {
        this.user = user;
        this.managerDatabase = ManagerDatabase.getManagerDatabase();
    }

    public ArrayList<Proposal> getProposals() {
        return user.getProposals();
    }


    public void updateProposalsUser() {
        user.updateProposalsUser();
    }

    public User getUser() {
        return user;
    }


    public TransformFileBinary getTransformfile() {
        return transformfile;
    }

    public ManagerDatabase getManagerDatabase() {
        return managerDatabase;
    }

}
