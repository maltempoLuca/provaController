package controller;

import java.util.ArrayList;

public class UserView extends View {

    private UserView() {
        createDialogue();
    }

    public static UserView getInstance() {
        if (instance == null)
            instance = new UserView();
        return instance;
    }


    private void createDialogue() {
        resetCursor();
        String str1 = "Catalogo \n";
        String str2 = "Le mie spedizioni \n";
        addToList(str1);
        addToList(str2);
    }


    @Override
    void updateView() {
        clear();
        String str0 = "Ciao " + getUser() + ", benvenuto su Pippo.com :D\n";
        System.out.println(str0);
        ArrayList<String> strList = getStrList();
        int cursorIndex = getCursorIndex();
        for (int i = 0; i < strList.size(); i++) {
            if (cursorIndex == i) {
                strList.set(i, "-> " + strList.get(i));
            }
            System.out.print(strList.get(i));
        }
    }

    @Override
    String currentState() {
        setState(getCursorIndex());
        return switch (getCursorIndex()) {
            case 0 -> "USER";
            case 1 -> "USER";
            default -> null;
        };
    }

    private static UserView instance = null;
}
