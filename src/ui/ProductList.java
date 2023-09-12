package ui;

import data.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import data.Product;
import data.I_List;
import utils.Utils;

public class ProductList extends ArrayList<Product> implements I_List {

    @Override
    public void add() {
        boolean check = true;
        String code = "";
        do {
            code = Utils.getString("Input product code:");
            int index = this.find(code);
            if (index >= 0) {
                System.out.println("Id is existed!");
            } else {
                check = false;
            }
        } while (check);
        String name = Utils.getString("Input product name:").replaceAll("\\s", "");
        String manuDate = "";
        do {
            manuDate = Utils.getString("Input manufacture date:");
            if (Utils.checkDate(manuDate) == false) {
                System.out.println("Date is not valid!");
                check = true;
            }
        } while (check);

        String expDate = "";
        do {
            expDate = Utils.getString("Input expiry date:");
            if (Utils.checkDate(expDate) == false) {
                System.out.println("Date is not valid!");
                check = true;
            } else if (Utils.checkDate(expDate) == true) {
                if (Utils.compareDate(manuDate, expDate) == false) {
                    System.out.println("Expiry date must be after manufacture date!");
                    check = true;
                }
            }
        } while (check);
        int quantity = Utils.getInt("Input quantity:", 0, 1000);
        double price = Utils.getDouble("Input price:", 0, 100000000);
        Product p = new Product(code, name, manuDate, expDate, quantity, price);
        this.add(p);
        System.out.println("Add success!");
    }

    @Override
    public void update() {
        List<Product> list = Utils.loadData("product.dat");
        String code = Utils.getString("Input update product code:");
        int index = this.find(code);
        if (index >= 0) {
            String name = Utils.getString("Input update name:", list.get(index).getName());
            boolean check = true;
            String manuDate = "";
            String expDate = "";
            do {
                manuDate = Utils.getString("Input update manufacture date:", list.get(index).getManuDate());
                if (Utils.checkDate(manuDate) == false) {
                    System.out.println("Date is not valid!");
                    check = true;
                }
                check = false;
            } while (check);
            do {
                expDate = Utils.getString("Input update expiry date:", list.get(index).getExpDate());
                if (Utils.checkDate(expDate) == false) {
                    System.out.println("Date is not valid!");
                    check = true;
                } else if (Utils.checkDate(expDate) == true) {
                    if (Utils.compareDate(manuDate, expDate) == false) {
                        System.out.println("Expiry date must be after manufacture date!");
                        check = true;
                    }
                } else {
                    check = false;
                }
            } while (check);
            int Quantity = Utils.getInt("Enter update quantity: ", 0, 1000, list.get(index).getQuantity());
            double price = Utils.getDouble("Enter update price: ", 0, 100000000, list.get(index).getPrice());
            Product p = new Product(code, name, manuDate, expDate, Quantity, price);
            list.set(index, p);
            //print out the result
            for (Product thi : list) {
                if (thi.getCode().equals(code)) {
                    System.out.println(thi.toString());
                }
            }
        } else {
            System.out.println("Product does not exist!");
        }
        //save data to file
        Utils.saveData("product.dat", list);
    }

    @Override
    public void remove() {
        List<Product> productList = (List<Product>) Utils.loadData("product.dat");
        String code = Utils.getString("Input code:");
        int index = this.find(code);
        if (index >= 0) {
            boolean check = Utils.confirmYesNo("Do you want to remove?");
            if (check) {
                productList.remove(index);
                System.out.println("Remove successfully!");
            } else {
                System.out.println("Remove failed!");
            }
        } else {
            System.out.println("Code is not existed!");
        }
        if (productList.size() == 0) {
            File file = new File("product.dat");
            file.delete();
        } else {
            Utils.saveData("product.dat", productList);
        }
    }

    @Override
    public int find(String code) {
        List<Product> list = Utils.loadData("product.dat");
        int posId = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equals(code)) {
                posId = i;
            }
        }
        return posId;
    }

    public void display() {
        if (!this.isEmpty()) {
            for (Product thi : this) {
                System.out.println(thi.toString());
            }
        } else {
            System.out.println("There is no any product!");
        }
    }

    public void printAll() {
        List<Product> list = Utils.loadData("product.dat");
        File file = new File("product.dat");
        if (!list.isEmpty() && file.exists()) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).getQuantity() < list.get(j).getQuantity()) {
                        Product temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                    } else if (list.get(i).getQuantity() == list.get(j).getQuantity()) {
                        if (list.get(i).getPrice() > list.get(j).getPrice()) {
                            Product temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                        }
                    }
                }
            }
        } else {
            System.out.println("No Product Found!");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        boolean check = Utils.confirmYesNo("Do you want to continue?");
        if (check) {
            Menu mnu = new Menu();
            mnu.showMenu();
        } else {
            System.exit(0);
        }
    }
}
