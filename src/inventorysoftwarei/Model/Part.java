/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Model;

/**
 *
 * @author Djok
 */
public abstract class Part
{
    private int partID;
    private int max;
    private int min;
    private int stock;
    private double partPrice;
    private String partName;
    //constuctor
    public Part(int PartID,int Max,int Min,int Stock,double PartPrice,String PartName)
    {
        partID = PartID;
        max = Max;
        min = Min;
        stock = Stock;
        partPrice = PartPrice;
        partName = PartName;
    }
    //getters 
    public int getPartID()
    {
        return partID;
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
    public double getPartPrice()
    {
        return partPrice;
    }
    public String getPartName()
    {
        return partName;
    }
    //setters
    public void setPartID(int newPartID)
    {
        partID = newPartID;
    }
    public void setMax(int newMax)
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
    public void setPartPrice(double newPartPrice)
    {
        partPrice = newPartPrice;
    }
    public void setPartName(String newPartName)
    {
        partName = newPartName;
    }
    
    public static String formCompleat(int max, int min, int stock, double price, String name)
    {
       String errors = new String();

       if(max < min)
       {
           errors += "Max must be larger than min. ";
       }
       if(stock < 0)
       {
           errors += "Stock must be positive. ";
       }
       if(price <= 0)
       {
           errors+= "Price must be more than 0. ";
       }
       if(name == null)
       {
           errors += "Must Name part. ";
       }        
       return errors; 
    }
}
