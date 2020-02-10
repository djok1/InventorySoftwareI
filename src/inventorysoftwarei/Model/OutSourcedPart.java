/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftwarei.Model;

/**
 *
 * @author dodell
 */
public class OutSourcedPart extends Part
{
    private String companyName;
    
    public OutSourcedPart(int PartID,int Max,int Min,int Stock,double PartPrice,String PartName,String CompanyName)
    {        
        super(PartID,Max,Min,Stock,PartPrice,PartName);
        companyName = CompanyName; 

    }
    //getter
    public String GetCompanyName()
    {
        return companyName;
    }
    //setter
    public void SetCompanyName(String CompanyName)
    {
        companyName = CompanyName; 
    }
}
