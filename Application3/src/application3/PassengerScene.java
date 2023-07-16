/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;


import WriteToFile.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class PassengerScene {
    
    Stage stage;
    Scene scene;
    LoginScene loginscene;
    Passenger passenger;
    ShowByPassenger showbypassenger;
    Station station;

    public PassengerScene(Stage stage) {
        this.stage = stage;
    }
    
    public void preparescene(){
        
        
        //DRAWING................................................
        Label infolabel = new Label();
        infolabel.setText("Username : " + passenger.getUsername() +"\nPassword : " 
                + passenger.getPassword()+ "\nAge:age\nEmail:email@domain.com");
        Button showavailable = new Button("Show Available Trips");
        Button showreserved = new Button("Show Reserved Trips");
        Button save = new Button("Save");
        Button logout = new Button("Logout");
        
        StackPane stackpane = new StackPane();
        stackpane.setAlignment(Pos.TOP_LEFT);
        stackpane.getChildren().addAll(infolabel,showavailable,showreserved,save,logout);
        StackPane.setMargin(showavailable,new Insets (70,15,15,0));
        StackPane.setMargin(showreserved,new Insets (100,15,15,0));
        StackPane.setMargin(save,new Insets (130,15,15,0));
        StackPane.setMargin(logout,new Insets (160,15,15,0));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
        
   
        //END OF DRAWING...............................................
        
        //ACTIONS..........................................
        showavailable.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                showbypassenger.setPassenger(passenger);
                showbypassenger.preparescene(station.getTrips(),scene,0);
                stage.setScene(showbypassenger.getScene());
                
            }
        });
        
        showreserved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                showbypassenger.setPassenger(passenger);
                showbypassenger.preparescene(passenger.getReserved(), scene,1);
                stage.setScene(showbypassenger.getScene());
                
            }
        });
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginscene.getScene());
            }
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            //   WritePassengers writePassengers = new WritePassengers();
               SavePassengers savepassengers = new SavePassengers();
               SaveTrips savetrips = new SaveTrips();
             //  WriteTrips writetrips = new WriteTrips();
                try {
                    
                  //  writePassengers.Write("Passengers.txt", station.getPassengers());
                   // writetrips.write("Trips.txt", station.getTrips());
                   savepassengers.save(station.getPassengers());
                  // savetrips.save(station.getTrips());
                   
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                alert.setContentText("Actions Saved !!");
                alert.showAndWait();
                    
            }
        });
        
        scene = new Scene(stackpane, 580,450);
        
        
        
    }
    public Scene getScene() {
        return scene;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setStation(Station station) {
        this.station = station;
    }

  

    public void setShowbypassenger(ShowByPassenger showbypassenger) {
        this.showbypassenger = showbypassenger;
    }

    public void setLoginscene(LoginScene loginscene) {
        this.loginscene = loginscene;
    }
}
