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
 * @author dodell
 */
public class Inventory 
{
    private final ObservableList<Part> allParts = FXCollections.observableArrayList();
    private final ObservableList<Product> allProducts = FXCollections.observableArrayList();
    //needs to be changed to 0 in final 
    private int currentPartID = 2;
    private int currentProductID = 2;
    public void Inventory()
    {
    }
    public int nextPartID()
    {
        currentPartID++;
        return currentPartID;
    }
    public int nextProductID()
    {
        currentProductID++;
        return currentProductID;
    }
    public void addProduct(Product newProduct)
    {
        allProducts.add(newProduct);
    }
    
    public void addPart(Part newPart)
    {
        allParts.add(newPart);
    }

    public ObservableList lookUpPart(String LookupTerm)
    {
        ObservableList<Part> PartSearch = FXCollections.observableArrayList();
        if("".equals(LookupTerm) || LookupTerm == null)
        {
            return allParts;
        }
        for(int i = 0; i < allParts.size(); i++)
        {
            if(allParts.get(i).getPartName().equals(LookupTerm))
            {
                PartSearch.add(allParts.get(i));
            }
            if(Integer.toString(allParts.get(i).getPartID()).equals(LookupTerm))
            {
                PartSearch.add(allParts.get(i));
            }
        }
        return PartSearch;
    }
    
    public ObservableList lookUpProduct(String LookupTerm)
    {
        ObservableList<Product> ProductSearch = FXCollections.observableArrayList();
        if("".equals(LookupTerm) || LookupTerm == null)
        {
            return allProducts;
        }
        for(int i = 0; i < allProducts.size(); i++)
        {
            if(allProducts.get(i).getProductName().equals(LookupTerm))
            {
                ProductSearch.add(allProducts.get(i));
            }
            if(Integer.toString(allProducts.get(i).getProductID()).equals(LookupTerm))
            {
                ProductSearch.add(allProducts.get(i));
            }
        }
        return ProductSearch;
    }
    
    public void deletePart(Part deletePart)
    {
        for(int i = 0; i < allParts.size(); i++)
        {
            if(allParts.get(i).getPartID() == deletePart.getPartID())
            {
                allParts.remove(i);
            }
        }
    }
    
    public void deleteProduct(Product deleteProduct)
    {
        for(int i = 0; i < allProducts.size(); i++)
        {
            if(allProducts.get(i).getProductID() == deleteProduct.getProductID())
            {
                allProducts.remove(i);
            }
        }
    }
    public String GetCompID(int ID)
    {
        String IDComp = new String();
        for(int i = 0; i < allParts.size(); i++)
        {
            if(allParts.get(i).getPartID() == ID)
            {
                if(allParts.get(i).getPartType() == 0)
                {
                    InHousePart tempPart = (InHousePart) allParts.get(i);
                    IDComp = String.valueOf(tempPart.getMachineID());
                }
                if(allParts.get(i).getPartType() == 1)
                {
                    OutSourcedPart tempPart = (OutSourcedPart) allParts.get(i);
                    IDComp = tempPart.GetCompanyName();
                }
            }
        }
        return IDComp;
    }
    public int GetPartCount()
    {
        return currentPartID;
    }
    public int GetProductCount()
    {
        return currentProductID;
    }
    public ObservableList<Part> getAllParts()
    {
        return allParts;
    }
    public ObservableList<Product> getAllProducts()
    {
        return allProducts;
    }
    public void updatePart(Part part)
    {
        deletePart(part);
        addPart(part);
    }
    
    public int IndexID(int ID)
    {
        int index = -1;
        for(int i = 0; i < allParts.size(); i++)
        {
            if(allParts.get(i).getPartID() == ID)
            {
                index = i;
            }
        }
        return index;
    }
    public void updateProduct(Product product)
    {
        deleteProduct(product);
        addProduct(product);
    }
    
}
