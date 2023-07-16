/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;


import application3.Vehicles.Bus;
import application3.Vehicles.Limousine;
import application3.Vehicles.MiniBus;
import application3.Vehicles.Vehicle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Station {
    
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Manager> mangers = new ArrayList<>();
    private ArrayList<Trip> trips = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    
    

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public ArrayList<Driver> getdrivers() {
        return drivers;
    }
  
    public ArrayList<Manager> getMangers() {
        return mangers;
    }


    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

   
    
    
    public Trip gettripbyindex(int x){
        
        for(int i=0;i<trips.size();i++)
        {
            Trip temp = trips.get(i);
            if(temp.getIndex()==x)
                return temp;
        }
        return null;
        
        
    }
    
    public Driver returndriver(String username){
        
        Driver temp;
        for(int i=0;i<drivers.size();i++){
            temp = drivers.get(i);
            if(temp.getUsername().equalsIgnoreCase(username))
                return temp;
        }
        
        return null;
    }
    
    public Passenger returnpassenger(String username){
        for(int i=0;i<passengers.size();i++){
            Passenger temp = passengers.get(i);
            if(temp.getUsername().equalsIgnoreCase(username))
                return temp;
        }
        return null;
    }
    
    public Manager getmangerrbyname(String username){
        for(int i=0;i<mangers.size();i++){
            Manager temp = mangers.get(i);
            if(temp.getUsername().equalsIgnoreCase(username))
                return temp;
        }
        return null;
    }
    

    public void readdrivers(){
           
        File file = new File("Drivers.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String [] data = line.split(",");
                Driver x = new Driver(data[0], data[1]);
                Trip temp;
                

              for(int i=0;i<trips.size();i++){
                  
                  temp = trips.get(i);
                  if(x.getUsername().equalsIgnoreCase(temp.getDriver())){
                      
                      x.addtrip(temp);
                  }
                  
                  
              }
                           
                drivers.add(x);
        
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    public void readmangers(){
           
        File file = new File("Mangers.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String [] names = line.split(",");
                Manager x = new Manager(names[0], names[1]);
                mangers.add(x);
        
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
   
    public void readpassengers(){
           
        File file;
        file = new File("Passengers.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String [] data = line.split(",");
                Passenger x = new Passenger(data[0], data[1]);      
                
               for(int i=2;i<data.length;i++){
                  
                    Trip temp = gettripbyindex(Integer.parseInt(data[i]));
                    
                    x.addtrip(temp);
                }
             
                passengers.add(x);
        
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    
    public Vehicle vehiclefactory(String name){
        Vehicle x;
        if(name.equalsIgnoreCase("Bus"))
            x=new Bus();
        else if(name.equalsIgnoreCase("MiniBus"))
            x=new MiniBus();
        else if(name.equalsIgnoreCase("Limousine"))
            x=new Limousine();
        else
            x=null;
        
        return x;
    }
    
    public void readtrips(){
           
        File file = new File("Trips.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String [] data = line.split(",");
                Trip trip = new Trip();
                Vehicle vehicle;
                trip.setIndex(Integer.parseInt(data[0]));
                trip.setSource(data[1]);
                trip.setDestination(data[2]);
                trip.setDate(data[3]);
                trip.setDeparturetime(data[4]);
                trip.setAvalaibleseats(Integer.parseInt(data[5]));
                
                vehicle = vehiclefactory(data[6]);
                trip.setTransport(vehicle.gettype());
                vehicle.setAvailaibleseats(Integer.parseInt(data[5]));
               
                trip.setVehicle(vehicle);
                trip.setPrice(Integer.parseInt(data[7]));
                trip.setStop(data[8]);
                trip.setType(data[9]);
                trip.setDriver(data[10]);
                
                trips.add(trip);           
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
    public void readvehicles(){
           
        File file = new File("Vehicles.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                
                
        
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
    }
    
    public int getmaxindex(){
        int x=0;
        for(int i =0;i<trips.size();i++){
            if(trips.get(i).getIndex()>x)
                x=trips.get(i).getIndex();
        }
        
        return x;
    }
    public void addtrip(Trip trip){
        trips.add(trip);
    }
    public void removetrip(Trip trip){
        
        for(int i =0;i<trips.size();i++)
        {
            if(trips.get(i).getIndex()== trip.getIndex())
                trips.remove(i);
        }   
    }
    
public void removetripfrompassenger(Trip trip){    
        Passenger temp;
        for(int i =0;i<passengers.size();i++){
            
            temp=passengers.get(i);
            for(int j=0;j<temp.getReserved().size();j++){
                
                Trip x = temp.getReserved().get(j);
                if(trip==x){
                    
                    temp.getReserved().remove(x);
                }
            }
    }
    }

  public void removetripfromdriver(Trip trip){    
        Driver temp;
        for(int i =0;i<drivers.size();i++){
            
            temp=drivers.get(i);
            for(int j=0;j<temp.getAssignedtrips().size();j++){
                
                Trip x = temp.getAssignedtrips().get(j);
                if(trip==x)
                    temp.getAssignedtrips().remove(x);
            }
    }
    }


}