package main.model;

public class Administrator extends User {
    
    public Administrator(int id, String user,String password, String typeUser, String type){
        super(id, user, password, typeUser);
        this.type= type;
    }
}
