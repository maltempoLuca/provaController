package controller;

public class HomeView extends View {
    private HomeView() {
        createDialogue();
    }

    public static HomeView getInstance() {
        if (instance == null)
            instance = new HomeView();
        return instance;
    }

    private void createDialogue() {
        resetCursor();
        String str1 = "Login \n";
        String str2 = "Create account\n";
        addToList(str1);
        addToList(str2);
        updateView();
    }

    @Override
    void updateView() {
        clear();
        String str0 = "Benvenuto su pippo.com \n";
        System.out.print(str0);
        printView();
    }

    public String currentState() {
        setState(getCursorIndex());
        return switch (getState()) {
            case 0 -> "LOGIN";
            case 1 -> "REGISTER";
            default -> null;
        };
    }


    private static HomeView instance = new HomeView();

}
