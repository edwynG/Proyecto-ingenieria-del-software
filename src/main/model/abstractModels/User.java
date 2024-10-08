package main.model.abstractModels;

import java.util.ArrayList;
import main.model.ManagerDatabase;
import main.model.Proposal;

public abstract class User {
    private String user;
    private Integer id;
    protected String typeUser;
    protected String type;
    private String password;
    private ArrayList<Proposal> proposals;
    private ManagerDatabase managerDatabase;
    public User() {
        initUser();
    }

    public User(int id, String user, String password, String typeUser) {
        this.user = user;
        this.id = id;
        this.typeUser = typeUser;
        this.password = password;
        initUser();
    }

    private void initUser() {
        managerDatabase = ManagerDatabase.getManagerDatabase();
        proposals = new ArrayList<>();

    }

    @Override
    public String toString() {
        return (String.format("User(id=%s,user=%s,password=%s,type=%s,typeUser=%s)", id + "", user,
                password, type, typeUser));
    }

    public String getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Proposal> getProposals() {
        return proposals;
    }

    public String getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProposals(ArrayList<Proposal> proposals) {
        this.proposals = proposals;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ManagerDatabase getManagerDatabase() {
        return managerDatabase;
    }

    public void updateProposalsUser() {
        return;
    };

}
