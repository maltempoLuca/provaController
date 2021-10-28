package controller;

import store.UserDepartment;

import java.util.Scanner;

public class LoginController {
    public LoginController(UserDepartment userDepartment) {
        this.userDepartment = userDepartment;
    }

    public void startDialogue() {
        currentView.updateView();
    }

    public void nextView(String state) {
        switch (state) {
            case "HOME":
                currentView = HomeView.getInstance();
                currentView.updateView();
                break;

            case "LOGIN":
                currentView = LoginView.getInstance();
                currentView.updateView();
                scanLogin();
                break;

            case "REGISTER":
                currentView = RegisterView.getInstance();
                currentView.updateView();
                scanRegister();
                break;

            case "USER":
                currentView = UserView.getInstance();
                currentView.setUser(currentUser);
                currentView.updateView();
                break;
        }
    }


    public void scan() {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("u")) {
            currentView.moveCursorUp();
            currentView.updateView();
        }
        if (input.equalsIgnoreCase("d")) {
            currentView.moveCursorDown();
            currentView.updateView();
        }
        if (input.equalsIgnoreCase("o")) {
            nextView(currentView.currentState());
        }
    }

    private void scanLogin() {
        LoginView loginView = LoginView.getInstance();
        loginView.emailView();
        String email = scanner.nextLine();
        loginView.passwordView();
        String password = scanner.nextLine();
        int success = userDepartment.loginUser(email, password);
        if (success == 0) {
            loginView.accessDenied();
        } else {
            loginView.accessGranted();
            currentUser = email;
        }
        String input = "";
        while (!input.equalsIgnoreCase("p")) {
            input = scanner.nextLine();
        }
        nextView(currentView.currentState());
    }

    private void scanRegister() {
        RegisterView registerView = RegisterView.getInstance();
        registerView.emailView();
        String email = scanner.nextLine();
        registerView.passwordView();
        String password = scanner.nextLine();
        int success = userDepartment.registerUser(email, password);
        if (success == 0) {
            registerView.accessDenied();
        } else
            registerView.accessGranted();
        String input = "";
        while (!input.equalsIgnoreCase("p")) {
            input = scanner.nextLine();
        }
        nextView(currentView.currentState());
    }

    private final UserDepartment userDepartment;
    private String currentUser = null;
    private static View currentView = HomeView.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
}
