package controller;

import java.util.ArrayList;

public class HomeView extends View {
    private HomeView() {
        createHome();
    }

    public static HomeView getInstance() {
        if (instance == null)
            instance = new HomeView();
        return instance;
    }

    private void createHome() {
        resetCursor();
        String str1 = "Login \n";
        String str2 = "Create account\n";
        addToList(str1);
        addToList(str2);
    }

    @Override
    void updateView() {
        clear();
        String str0 = "Benvenuto su pippo.com \n";
        System.out.print(str0);
        ArrayList<String> strList = getStrList();
        int cursorIndex = getCursorIndex();
        for (int i = 0; i < strList.size(); i++) {
            if (cursorIndex == i) {
                strList.set(i, "-> " + strList.get(i));
            }
            System.out.print(strList.get(i));
        }
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
