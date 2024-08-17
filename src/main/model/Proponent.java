package main.model;

public class Proponent extends User {
    
    public Proponent(int id, String user,String password, String typeUser, String type){
        super(id, user, password,typeUser);
        this.type = type;

    }
}
