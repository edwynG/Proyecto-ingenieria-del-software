package main.controller;
import main.model.ControlValidator;

public class Validator {
    ControlValidator controlValidator = new ControlValidator();

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

}
