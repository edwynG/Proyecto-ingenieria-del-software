package main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.Env;
import main.model.abstractModels.User;

public class Administrator extends User {
    
    public Administrator(){

    }

    public Administrator(int id, String user,String password, String type){
        super(id, user, password, Env.TYPE_USER_ADMINISTRADOR);
        this.type= type;
        this.refreshListOfProposals();

    }

    
    @Override
    public void refreshListOfProposals() {
        this.getProposals().clear();
        ManagerDatabase db = ManagerDatabase.getManagerDatabase();
        ArrayList<ArrayList<String>> proposals = db.getData(String.format(Env.QUERY_PROPOSAL_ADMINISTRADOR,this.getType()));
        List<String> namefields = db.getNameFields("Propuestas");
        Map<String, String> proposal = new HashMap<>();

        for(int i = 0; i< proposals.size() ;i++){
            List<String> value = proposals.get(i);
            for (int j = 0; j < namefields.size(); j++) {
                proposal.put(namefields.get(j), value.get(j));
            }
            this.getProposals().add(new Proposal(proposal));
            proposal.clear();

        }

    }
}
