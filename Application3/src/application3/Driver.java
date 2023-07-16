/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Driver extends Employee {
    
    
    ArrayList<Trip> assignedtrips = new ArrayList<>();
    
    
    public Driver(String username, String password) {
        super(username, password);
    }

    public void setAssignedtrips(ArrayList<Trip> assignedtrips) {
        this.assignedtrips = assignedtrips;
    }

    public ArrayList<Trip> getAssignedtrips() {
       
        return assignedtrips;
    }

    
    
    public void addtrip(Trip trip){
        
        assignedtrips.add(trip);
    }
    
    public void removetrip(Trip trip){
        
        for(int i =0;i<assignedtrips.size();i++){
            
            Trip temp = assignedtrips.get(i);
            if(temp.getIndex()== trip.getIndex())
                assignedtrips.remove(i);
        }
    }
}
