package main.model.abstractModels;

import java.util.ArrayList;
import java.util.List;

import main.model.Proposal;

public abstract class User {
    private String user;
    private Integer id;
    protected String typeUser;
    protected String type;
    private String password;
    private List<Proposal> proposals;

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

    public int getId() {
        return id;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public String getPassword() {
        return password;
    }

    public List<Proposal> getProposals() {
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

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void refreshListOfProposals() {
        return;
    };

}
