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
public class Limousine implements Vehicle{
    
    private static String type = "limousine";
    private int availaibleseats;

    public Limousine(int availaibleseats) {
        
        this.availaibleseats = availaibleseats;
    }
    
    public Limousine() {
        
        this.availaibleseats = 10;
    }
    
    @Override
    public void setAvailaibleseats(int availaibleseats) {
        this.availaibleseats = availaibleseats;
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
