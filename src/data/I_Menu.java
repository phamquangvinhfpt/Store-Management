package data;

public interface I_Menu {
    void addItem(String s);
    int getChoice();
    void showMenu();
    boolean confirmYesNo(String welcome);
}