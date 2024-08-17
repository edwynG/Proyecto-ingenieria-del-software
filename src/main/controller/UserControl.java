package main.controller;

import main.model.User;

abstract class UserControl {
    protected User user;

    public UserControl(User user) {
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

}
