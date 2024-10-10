package main.controller;

import main.Env;
import main.model.ControlValidator;

public class Validator {
    private ControlValidator controlValidator = new ControlValidator();

    public boolean isThereAnEmailRegister(String email) {
        return controlValidator.isThereAnEmailRegister(email);

    }

    public boolean isThereAnProponentIDRegister(Integer id) {
        return controlValidator.isThereAnProponentIDRegister(id);

    }

    public boolean isAcceptedProposal(Integer id) {
        return controlValidator.isAcceptedProposal(id);
    }

    public boolean existResultProposal(Integer id) {
        return controlValidator.existResultProposal(id);
    }

    public boolean isValidEvaluate(Integer ProposalID, Integer adminID) {
        if (!existResultProposal(ProposalID)) {
            return true;
        }
        return controlValidator.isEvaluateForAdminID(ProposalID, adminID);
    }

    public boolean isThisValidEmail(String email){
        return controlValidator.isValidString(email, Env.REGEX_EMAIL);
    }

    public boolean isThisValidPassword(String password){
        return controlValidator.isValidString(password, Env.REGEX_PASSWORD);
    }

    public boolean isNumber(String number){
        return controlValidator.isValidString(number, Env.REGEX_DIGI);
    }
    
}
