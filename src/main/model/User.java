package main.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String user;
    private int id; 
    protected String typeUser;
    private String typePerson;
    private String password;
    private List<Proposal> courseProposal;
    
    public User(int id, String user,String password, String typeUser,String typePerson){
        this.user=user;
        this.id=id;
        this.typePerson=typePerson;
        this.typeUser=typeUser;
        this.password=password;
        this.courseProposal = new ArrayList<>();
    }
    
    public String getUser(){
        return this.user;
    }

    public int getId(){
        return this.id;
    }

    public String getTypeUser(){
        return this.typeUser;
    }

    public String getPassword(){
        return this.password;
    }

    public List<Proposal> getCourseProposal(){
        return this.courseProposal;
    }

    public void AddProposal(Proposal proposal){
        this.courseProposal.add(proposal);
    }

    public String getTypePerson(){
        return this.typePerson;
    }

    public String getTyperUser(){
        return this.typeUser;
    }
    
}
