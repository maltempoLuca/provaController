package controller;

import java.util.ArrayList;

public class LoginView extends View {

    private LoginView() {
        updateView();
    }

    public static LoginView getInstance() {
        if (istance == null)
            istance = new LoginView();
        return istance;
    }

    @Override
    void updateView() {
        clear();
        String str1 = "Ciao, per entrare su Pippo.com segui le indicazioni:\n";
        System.out.println(str1);
    }

    public void emailView() {
        String str1 = "Per effettuare il Login inserire la mail utilizzata durante la registrazione al sito. \n";
        System.out.print(str1);
    }

    void passwordView() {
        String str1 = "Per effettuare il login inserire la password. \n";
        System.out.print(str1);
    }

    void accessDenied() {
        String str1 = "Email o Password errata, per riprovare premere p. \n";
        System.out.println(str1);
        setState(0);
    }

    void accessGranted() {
        setState(1);
        System.out.println("Login riuscito, digitare 'p' continuare.");
    }

    @Override
    String currentState() {
        return switch (getState()) {
            case 0 -> "HOME";
            case 1 -> "USER";
            default -> null;
        };
    }

    private static LoginView istance = null;


}
