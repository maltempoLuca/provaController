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

    void printView() {
        int cursorIndex = getCursorIndex();
        for (int i = 0; i < strList.size(); i++) {
            if (cursorIndex == i) {
                System.out.print("-> " + strList.get(i));
            } else
                System.out.print(strList.get(i));
        }
    }

    abstract String currentState();

    void addToList(String str) {
        strList.add(str);
    }

    int getCursorIndex() {
        return cursorIndex;
    }

    ArrayList<String> getStrList() {
        return new ArrayList<>(strList);  // Ritorna NUOVA lista, funziona. Non cancellare per ora.
    }

    void setState(int newState) {
        state = newState;
    }

    int getState() {
        return state;
    }

    void setUser(String name) {
        user = name;
    }

    public String getUser() {
        return user;
    }

    private String user = null;
    private int cursorIndex = 0;
    private int state = 0;
    //TODO: Trova un nome a strList, strList == lista di stringhe che ogni vista deve stampare a schermo. (printView)
    private final ArrayList<String> strList = new ArrayList<>();
}
