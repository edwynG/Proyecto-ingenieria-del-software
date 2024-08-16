package main.controller;

import main.model.User;

public class UserControl {
    private User user;

    public UserControl(User user) {
        this.user = user;
        System.out.println(this.user);
    }

}
