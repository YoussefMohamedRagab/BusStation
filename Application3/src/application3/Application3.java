/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Application3 extends Application{
      
    
     public static void main(String[] args) {
        launch(args);
    }
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Bus Station");
        
         Station station = new Station();
         station.readtrips();
         station.readdrivers();
         station.readmangers();
         station.readpassengers();
        
        LoginScene loginscene = new LoginScene(primaryStage);
        DriverScene driverscene = new DriverScene(primaryStage);
        PassengerScene passengerscene = new PassengerScene(primaryStage);
        MangerScene mangerscene = new MangerScene(primaryStage);
        ShowTrips showtrip = new ShowTrips(primaryStage);
        ShowByPassenger showbypassenger = new ShowByPassenger(primaryStage);
        ShowByManager showbymanager = new ShowByManager(primaryStage);
        AssignDriver assigndriver = new AssignDriver(primaryStage);
        
        
              
        loginscene.Preparescene();
        
        
        loginscene.setStation(station);
        mangerscene.setStation(station);
        passengerscene.setStation(station);
        
        
        loginscene.setDriverscene(driverscene);
        loginscene.setPassengerscene(passengerscene);
        loginscene.setMangerscene(mangerscene);
        
        driverscene.setLoginscene(loginscene);
        driverscene.setShowtrips(showtrip);
        
        passengerscene.setLoginscene(loginscene);
        passengerscene.setShowbypassenger(showbypassenger);
        
        mangerscene.setLoginscene(loginscene);
        mangerscene.setShowbymanger(showbymanager);
        mangerscene.setAssigndriver(assigndriver);
        
        primaryStage.setScene(loginscene.getScene());
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    
    
}
