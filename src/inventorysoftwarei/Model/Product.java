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
public class Product 
{
    private ObservableList<Part> parts;
    private int productID;
    private int min;
    private int max;
    private int stock;
    private String productName;
    private double productPrice;
    
    //constuctors
    public Product()
    {
        parts = FXCollections.observableArrayList();
        productName = new String();
    }
    public Product(ObservableList<Part> Parts, int Min, int Max, int Stock, String ProductName, double ProductPrice)
    {
        parts = Parts;
        min = Min;
        max = Max;
        stock = Stock;
        productName = ProductName;
        productPrice = ProductPrice;
    }
    //getters 
    public int getProductID()
    {
        return productID;
    }
    public int getMax()
    {
        return max;
    }
    public int getMin()
    {
        return min;
    }
    public int getStock()
    {
        return stock;
    }
    public double getProductPrice()
    {
        return productPrice;
    }
    public String getProductName()
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
    
    public static String formCompleat(ObservableList<Part> Parts, int Min, int Max, int Stock, String ProductName, double ProductPrice)
    {
        double priceOfParts = 0.00;
        String errors = new String();
        for(int i = 0; i < Parts.size(); i++)
        {
            priceOfParts += Parts.get(i).getPartPrice();
        }
        if(priceOfParts > ProductPrice)
        {
            errors += "Price of product must be more than price of parts. ";
        }
        if(Max < Min)
        {
            errors += "Max must be greater than min. ";
        }
        if(Stock < 0)
        {
            errors += "Stock must be positive. ";
        }
        if(ProductName == null)
        {
            errors += "Product must have a name. ";
        }
        if(Parts.size() < 1)
        {
            errors += "Products must contain at least one part.";
        }
        
        return errors;
    }
    public void addPart(Part newPart)
    {
        parts.add(newPart);
    }
    
    public ObservableList<Part> getAllAssociatedParts()
    {
        return parts;
    }
    //testing 
    public void deletePart(Part selectedPart)
    {
        for(int i = 0; i < parts.size(); i++)
        {
            if(parts.get(i).getPartID()== selectedPart.getPartID())
            {
                parts.remove(i);
            }
        }        
    }
    public void replacePartList(ObservableList<Part> partList)
    {
        parts = partList;
    }
}
