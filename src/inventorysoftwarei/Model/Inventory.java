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
    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;
    
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
        for(int i = 0; i < allParts.size(); i++)
        {
            if(allParts.get(i).getPartName() == LookupTerm)
            {
                PartSearch.add(allParts.get(i));
            }
            if(Integer.toString(allParts.get(i).getPartID()) == LookupTerm)
            {
                PartSearch.add(allParts.get(i));
            }
        }
        return PartSearch;
    }
    
    public ObservableList lookUpProduct(String LookupTerm)
    {
        ObservableList<Product> ProductSearch = FXCollections.observableArrayList();
        for(int i = 0; i < allProducts.size(); i++)
        {
            if(allProducts.get(i).getProductName() == LookupTerm)
            {
                ProductSearch.add(allProducts.get(i));
            }
            if(Integer.toString(allProducts.get(i).getProductID()) == LookupTerm)
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
    
    public ObservableList<Part> getAllParts()
    {
        return allParts;
    }
    public ObservableList<Product> getAllProducts()
    {
        return allProducts;
    }
    //unfinished methods
    public void updatePart()
    {
        //unsure of how to implement
    }
    
}
