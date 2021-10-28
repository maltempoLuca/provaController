package controller;

import java.util.ArrayList;

public abstract class View {
    void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    void moveCursorDown() {
        if (cursorIndex < strList.size() - 1)
            cursorIndex++;
    }

    void moveCursorUp() {
        if (cursorIndex > 0)
            cursorIndex--;
    }

    void resetCursor() {
        cursorIndex = 0;
    }

    abstract void updateView();

    abstract String currentState();

    void addToList(String str) {
        strList.add(str);
    }

    int getCursorIndex() {
        return cursorIndex;
    }

    ArrayList<String> getStrList() {
        ArrayList<String> cloneList = new ArrayList<>();
        for (String str: strList) {
            cloneList.add(str);
        }
        return cloneList;
    }

    int getStrSize() {
        return strList.size();
    }


    private int cursorIndex = 0;
    private final ArrayList<String> strList = new ArrayList<>();
}
