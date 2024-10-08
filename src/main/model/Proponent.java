package main.model;
import java.util.ArrayList;

import main.Env;
import main.model.abstractModels.User;

public class Proponent extends User {

    public Proponent(){
        
    }
    
    public Proponent(int id, String user,String password, String type){
        super(id, user, password,Env.TYPE_USER_PROPONENT);
        this.type = type;
        updateProposalsUser();
    }

    @Override
    public void updateProposalsUser() {
        if (getId() == null) return;
        getProposals().clear();
        ArrayList<ArrayList<String>> proposals = getManagerDatabase().getData(String.format(Env.QUERY_PROPOSAL_PROPONENT, getId()));
        for (ArrayList<String> proposal : proposals) {
            getProposals().add(new Proposal(proposal));
        }
   
    }

}
