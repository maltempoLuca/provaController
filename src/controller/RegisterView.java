package controller;

public class RegisterView extends View {
    private RegisterView() {
        updateView();
    }

    public static RegisterView getInstance() {
        if (istance == null)
            istance = new RegisterView();
        return istance;
    }

    private static RegisterView istance = null;

    @Override
    void updateView() {
        clear();

        String str1 = "Per registrarti a Pippo.com segui le indicazioni.";
        System.out.println(str1);
    }

    @Override
    String currentState() {
        return switch (getState()) {
            case 0 -> "REGISTER";
            case 1 -> "HOME";
            default -> null;
        };
    }

    public void emailView() {
        String str1 = "Inserire una mail: ";
        System.out.println(str1);
    }

    public void passwordView() {
        String str1 = "Inserire una password: ";
        System.out.println(str1);
    }

    public void accessDenied() {
        String str1 = "Email o Password errata, per riprovare digitare 'p'. \n";
        System.out.println(str1);
        setState(0);
    }

    public void accessGranted() {
        setState(1);
        System.out.println("Account creato, digitare 'p' continuare.");
    }

    private static RegisterView instance = null;
}
