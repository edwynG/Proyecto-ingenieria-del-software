package main.controller;

import main.Env;
import main.model.ControlValidator;

public class Validator {
    ControlValidator controlValidator = new ControlValidator();

    public boolean isThereAnEmailRegister(String email) {
        if (controlValidator.isThereAnEmailRegister(email)) {
            return true;
        }

        return false;
    }

    public boolean isThereAnProponentIDRegister(Integer id) {
        if (controlValidator.isThereAnProponentIDRegister(id)) {
            return true;
        }

        return false;
    }

    public boolean  isAcceptedProposal(Integer id){
        return controlValidator.doesTheDataExist(Env.TABLE_FIELD_PROPOSAL_ID, Env.TABLE_FIELD_PROPOSAL_ID, id+"");
    }
    
}
