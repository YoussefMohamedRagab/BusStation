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
public class Passenger {
    
    private String username;
    private String password;
    private ArrayList<Trip> reserved = new ArrayList<>();
  
    

    public Passenger(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Trip> getReserved() {
        return reserved;
    }
   
    public void addtrip(Trip trip){
        
        reserved.add(trip);
        
    }
 
    public void removetrip(Trip trip){
        
        for(int i =0;i<reserved.size();i++){
            Trip temp = reserved.get(i);
            if(temp == trip)
                reserved.remove(i);
        }
    }


    
    
}
