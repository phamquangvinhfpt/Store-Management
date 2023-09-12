/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ui.Menu;
import ui.ProductList;
import utils.File;
import utils.Utils;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        boolean check = true;
        boolean cont = false;
        int choice = 0;
        Menu menu = new Menu();
        ProductList list = new ProductList();
        File file = new File();
        menu.addItem("1. Manage products");
        menu.addItem("2. Manage Warehouse");
        menu.addItem("3. Report");
        menu.addItem("4. Store data to files");
        menu.addItem("5. Exit.");
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    int choose = 0;
                    System.out.println("1.1 Add a product");
                    System.out.println("1.2 Update product information");
                    System.out.println("1.3 Delete product");
                    System.out.println("1.4 Show all product");
                    boolean innerLoopFlag = true;
                    do {
                        choose = menu.getChoose();
                        switch (choose) {
                            case 1:
                                list.add();
                                //Ask to continuous or not
                                cont = menu.confirmYesNo("Do you want to continue?");
                                //If user choose yes, the program will back to the main menu.
                                if (cont) {
                                    innerLoopFlag = false;
                                }
                                break;
                            case 2:
                                list.update();
                                innerLoopFlag = false;
                                break;
                            case 3:
                                list.remove();
                                innerLoopFlag = false;
                                break;
                            case 4:
                                list.printAll();
                                break;
                            case 5:
                                //Ask to continuous or not
                                cont = menu.confirmYesNo("Do you want to continue?");
                                //If user choose yes, the program will back to the main menu.
                                if (cont) {
                                    innerLoopFlag = false;
                                }
                                break;
                        }
                    } while (innerLoopFlag);
                    break;
                case 2:
                    System.out.println("ahihi");
                    break;
                case 3:
                    
                    break;
                case 4:
                    Utils.saveData("product.dat", list);
                    break;
                case 5:
                    System.exit(0);
            }
        } while (choice != 8 || !cont);
    }
}
