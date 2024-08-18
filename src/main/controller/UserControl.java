package main.controller;

import java.util.List;
import java.util.Map;

import main.model.ManagerDatabase;
import main.model.Proposal;
import main.model.User;

public abstract class UserControl {
    protected User user;
    protected ManagerDatabase managerdfDatabase;

    public UserControl(User user) {
        this.user = user;
        this.managerdfDatabase = ManagerDatabase.getManagerDatabase();
    }

    public List<Proposal> getProposals(){
        return user.getProposals();
    }

    public boolean courseFormulation(Map<String,String> form){
        return false;
    };
}
