package main.view.components;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.CommonComponents.InterfaceWithForm;
import main.view.components.loginComponents.FormLogin;

public class Login extends InterfaceWithForm {

    public Login() {
        initLogin();
    }

    public Login(String src) {
        super(src);
        initLogin();

    }
    private void initLogin(){
        AbstractForm form = new FormLogin(18);
        setFormulation(form);

    };
    
}