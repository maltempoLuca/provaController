package com.company;

import controller.LoginController;
import store.UserDepartment;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserDepartment userDepartment = UserDepartment.getInstance();
        LoginController loginController = new LoginController(userDepartment);
        loginController.startDialogue();
        while(true)
            loginController.scan();

    }
}
