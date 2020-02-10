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
public class InHousePart extends Part{
    private int machineID;
    
    InHousePart(int PartID,int Max,int Min,int Stock,double PartPrice,String PartName,int MachineID)
    {
        super(PartID,Max,Min,Stock,PartPrice,PartName);
        machineID = MachineID;
    }
    //getter
    public int getMachineID()
    {
        return machineID;
    }
    //setter
    public void setMachineID(int ID)
    {
        machineID = ID;
    }

}
