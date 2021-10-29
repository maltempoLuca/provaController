package com.company;

import controller.LoginController;
import store.UserDepartment;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserDepartment userDepartment = UserDepartment.getInstance();
        LoginController loginController = new LoginController(userDepartment);
        while (true)
            loginController.scan();
    }
}
