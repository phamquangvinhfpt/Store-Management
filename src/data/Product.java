/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Product implements Serializable{
    //-	Product information: 
    private String code;
    private String name;
    private String manuDate;
    private String expDate;
    private int quantity;
    private double price;
    public Product() {
    }

    public Product(String code, String name, String manuDate, String expDate, int quantity, double price) {
        this.code = code;
        this.name = name;
        this.manuDate = manuDate;
        this.expDate = expDate;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManuDate() {
        return manuDate;
    }

    public void setManuDate(String manuDate) {
        this.manuDate = manuDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return code + ", " + name + ", " + manuDate + ", " + expDate + ", " + quantity + ", " + price;
    }
    
}
