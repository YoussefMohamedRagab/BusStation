/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import application3.Vehicles.Vehicle;

/**
 *
 * @author USER
 */
public class Trip {
    
    private String source;
    private String destination;
    private String type;
    private String stop;
    private String driver;
    private int price;
    private String date;
    private String departuretime;
    private int avalaibleseats;
    private int index;
    private Vehicle vehicle;
    private String transport;
    

    public void setSource(String source) {
        this.source = source;

    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getType() {
        return type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public void setAvalaibleseats(int avalaibleseats) {
        this.avalaibleseats = avalaibleseats;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public int getAvalaibleseats() {
        return avalaibleseats;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDate() {
        return date;
    }

    public int getIndex() {
        return index;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getStop() {
        return stop;
    }

    public String getDriver() {
        return driver;
    }

    public String getTransport() {
        return transport;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }
    
    
}
