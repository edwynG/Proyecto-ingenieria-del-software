package main.model;

import java.util.ArrayList;

import main.Env;
import main.model.abstractModels.User;

public class Administrator extends User {
    
    public Administrator(){

    }

    public Administrator(int id, String user,String password, String type){
        super(id, user, password, Env.TYPE_USER_ADMINISTRADOR);
        this.type= type;
        updateProposalsUser();

    }

    @Override
    public void updateProposalsUser() {
        if (getType() == null) return;
        getProposals().clear();
        ArrayList<ArrayList<String>> proposals = getManagerDatabase().getData(String.format(Env.QUERY_PROPOSAL_ADMINISTRADOR, getType()));
        for (ArrayList<String> proposal : proposals) {
            getProposals().add(new Proposal(proposal));
        }
    }

}
