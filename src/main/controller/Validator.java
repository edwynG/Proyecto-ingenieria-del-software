package main.controller;

import main.model.ControlValidator;

public class Validator {
    ControlValidator controlValidator = new ControlValidator();

    public boolean isThereAnEmailRegister(String email) {
        if (controlValidator.isThereAnEmailRegister(email)) {
            return true;
        }

        return false;
    }

    public boolean isThereAnIdRegister(Integer id) {
        if (controlValidator.isThereAnIdRegister(id)) {
            return true;
        }

        return false;
    }
}
