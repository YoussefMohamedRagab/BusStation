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
public class Authentication {
    
    boolean result;

    public Authentication() {
        result = false;
    }
    
    
    public boolean passengervalidation(ArrayList<Passenger> x,String user,String pass){
        
        result = false;
        for(int i=0;i<x.size();i++){
            Passenger temp = x.get(i);
            
            if(temp.getUsername().equalsIgnoreCase(user)){
                
                if(temp.getPassword().equalsIgnoreCase(pass)){
                    result = true;                 
                }
            }
            
            
        }
        
        return result;
             
    }
    
    public boolean drivervalidation(ArrayList<Driver> x,String user,String pass){
        
        result = false;
        for(int i=0;i<x.size();i++){
            Employee temp = x.get(i);
            
            if(temp.getUsername().equalsIgnoreCase(user)){
                
                if(temp.getPassword().equalsIgnoreCase(pass)){
                    result = true;                 
                }
            }
            
            
        }
        
        return result;
             
    }
    public boolean managervalidation(ArrayList<Manager> x,String user,String pass){
        
        result = false;
        for(int i=0;i<x.size();i++){
            Employee temp = x.get(i);
            
            if(temp.getUsername().equalsIgnoreCase(user)){
                
                if(temp.getPassword().equalsIgnoreCase(pass)){
                    result = true;                 
                }
            }
            
            
        }
        
        return result;
             
    }
    
    
        
    }
    

