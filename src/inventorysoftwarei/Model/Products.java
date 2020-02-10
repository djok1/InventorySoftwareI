/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Djok
 */
public class Products 
{
    private ObservableList<Parts> parts;
    private int productID;
    private int min;
    private int max;
    private int stock;
    private String productName;
    private double productPrice;
    
    //constuctors
    public Products()
    {
        parts = FXCollections.observableArrayList();
        productName = new String();
    }
    
    //getters 
    public int getproductID()
    {
        return productID;
    }
    public int getmax()
    {
        return max;
    }
    public int getmin()
    {
        return min;
    }
    public int getstock()
    {
        return stock;
    }
    public double getproductPrice()
    {
        return productPrice;
    }
    public String getproductName()
    {
        return productName;
    }
    
    //setters
    public void setproductID(int newproductID)
    {
        productID = newproductID;
    }
    public void setmax(int newMax)
    {
        max = newMax;
    }
    public void setMin(int newMin)
    {
        min = newMin;
    }
    public void setStock(int newStock)
    {
        stock = newStock;
    }
    public void setproductPrice(double newproductPrice)
    {
        productPrice = newproductPrice;
    }
    public void setproductName(String newproductName)
    {
        productName = newproductName;
    }
    
    /*public static String formCompleat()
    {
    
    }*/
}
