package main.model;

import java.util.ArrayList;

import main.Env;
import main.model.abstractModels.User;

public class Administrator extends User {

    public Administrator() {

    }

    public Administrator(int id, String user, String password, String type) {
        super(id, user, password, Env.TYPE_USER_ADMINISTRADOR);
        this.type = type;
        updateProposalsUser();

    }

    @Override
    public void updateProposalsUser() {
        if (getType() == null)
            return;
        getProposals().clear();
        ArrayList<ArrayList<String>> proposals = getManagerDatabase()
                .getData(String.format(Env.QUERY_PROPOSAL_ADMINISTRADOR, getType()));
        ControlValidator validator = new ControlValidator();
        for (ArrayList<String> proposal : proposals) {
            Proposal p = new Proposal(proposal);
            if (!validator.existResultProposal(p.getProposalId())) {
                getProposals().add(p);
                break;
            }
            if (validator.isEvaluateForAdminID(p.getProposalId(),getId())) {
                getProposals().add(p);
            }
        }

    }

}
