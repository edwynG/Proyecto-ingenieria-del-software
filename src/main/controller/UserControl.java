package main.controller;

import java.util.List;
import java.util.Map;

import main.model.ManagerDatabase;
import main.model.Proposal;
import main.model.User;

public abstract class UserControl {
    protected User user;
    protected ManagerDatabase managerDatabase;

    public UserControl(User user) {
        this.user = user;
        this.managerDatabase = ManagerDatabase.getManagerDatabase();
    }

    public List<Proposal> getProposals(){
        return user.getProposals();
    }

    public boolean proposeCourse(Map<String,String> form){
        return false;
    };
    
    public boolean evaluateCourse(String assessment, String observations, int id){
        return false;
    };
}
