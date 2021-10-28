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
        String str0 = "Benvenuto su pippo.com \n";
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
    public String currentState() {
        int cursorIndex = getCursorIndex();
        return switch (cursorIndex) {
            case 0 -> "USER";
            case 1 -> "USER";
            default -> null;
        };
    }

    private int state = 0;
    private static UserView instance = null;
}
