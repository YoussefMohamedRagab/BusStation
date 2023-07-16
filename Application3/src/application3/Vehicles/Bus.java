/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3.Vehicles;

/**
 *
 * @author USER
 */
public class Bus implements Vehicle{
    
    
    private static String type = "Bus";
    private int availaibleseats;

    public Bus(int availaibleseats) {
        this.availaibleseats = availaibleseats;
        
    }
    public Bus() {
        this.availaibleseats =60;
        
    }
    

    @Override
    public void setAvailaibleseats(int availaibleseats) {
        
        this.availaibleseats=availaibleseats;
    }

    @Override
    public int getAvailaibleseats() {

        return availaibleseats;
        
        }

    @Override
    public String gettype() {
        return type;
    }


   
    
    
    
    
    
}
