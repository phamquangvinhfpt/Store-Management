package ui;
import java.util.ArrayList;
import data.I_Menu;
import java.util.ArrayList;
import utils.Utils;
public class Menu extends ArrayList<String> implements I_Menu {
    @Override
    public void addItem(String s) {
        this.add(s);
    }
    @Override
    public void showMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
    @Override
    public boolean confirmYesNo(String welcome) {
        boolean check = Utils.confirmYesNo(welcome);
        return check;
    }
    @Override
    public int getChoice() {
        return Utils.getInt("Input your choice:", 1, this.size());
    }

    public int getChoose() {
        return Utils.getInt("Input your choose:", 1, this.size());
    }
}