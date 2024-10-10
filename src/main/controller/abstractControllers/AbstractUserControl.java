package main.controller.abstractControllers;

import java.util.ArrayList;

import main.controller.Validator;
import main.model.ManagerDatabase;
import main.model.Proposal;
import main.model.TransformFileBinary;
import main.model.abstractModels.User;

public abstract class AbstractUserControl {
    private User user;
    private ManagerDatabase managerDatabase;
    private TransformFileBinary transformfile = new TransformFileBinary();
    private Validator valid = new Validator();

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

    public Validator getValidator() {
        return valid;
    }

    public Integer searchProponentForProposalID(Integer id) {
        for (Proposal proposal : getProposals()) {
            if (proposal.getProposalId() == id) {
                return proposal.getProponentId();
            }
        }

        return -1;
    }
}
