/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import WriteToFile.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author USER
 */
public class MangerScene {
    
    Stage stage;
    Scene scene;
    Station station;
    Manager manager;
    LoginScene loginscene;
    ShowByManager showbymanger;
    AssignDriver assigndriver;
    
    public MangerScene(Stage stage){
        
        this.stage = stage;
    }
    
    
    public void preparescene(){
        
        
        //DRAWING.....................................
        Label infolabel = new Label();
        infolabel.setText("Username : " + manager.getUsername() +"\nPassword : " 
                + manager.getPassword()+ "\nAge:age\nEmail:email@domain.com");
        
        Button trips = new Button("Show/Add Trips");
        Button cancel = new Button("Cancel Trips");
        Button save = new Button("Save");
        Button logout = new Button("Logout");
        Button assign = new Button("AssignDriver");
        
        StackPane stackpane = new StackPane();
        stackpane.setAlignment(Pos.TOP_LEFT);
        stackpane.getChildren().addAll(infolabel,trips,cancel,save,logout,assign);
        StackPane.setMargin(trips,new Insets (70,15,15,0));
        StackPane.setMargin(cancel,new Insets (100,15,15,0));
        StackPane.setMargin(save,new Insets (160,15,15,0));
        StackPane.setMargin(logout,new Insets (190,15,15,0));
        StackPane.setMargin(assign,new Insets (130,15,15,0));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        
        
        //END OF DRAWING.....................................
        
        //ACTIONS............................................
        
        trips.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                showbymanger.setStation(station);
                showbymanger.preparescene(station.getTrips(), scene,1);
                stage.setScene(showbymanger.getScene());
            }
        });
        
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                showbymanger.setStation(station);
                showbymanger.preparescene(station.getTrips(), scene,0);
                stage.setScene(showbymanger.getScene());
            }
        });
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginscene.getScene());
            }
        });
        
        assign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                assigndriver.setStation(station);
                assigndriver.preparescene(station.getTrips(), scene);
                stage.setScene(assigndriver.getScene());
            }
        });
        
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                   // WriteDrivers writedrivers = new WriteDrivers();
                   // WritePassengers writepassengers = new WritePassengers();
                   // WriteTrips writetrips = new WriteTrips();
                   SavePassengers savepassengers = new SavePassengers();
                   SaveTrips saveTrips = new SaveTrips();
                   SaveDrivers saveDrivers = new SaveDrivers();
                
                try {
                    
                    
                 //   writepassengers.Write("Passengers.txt", station.getPassengers());
                  //  writedrivers.write("Drivers.txt",station.getdrivers());
                  //  writetrips.write("Trips.txt", station.getTrips());
                  savepassengers.save(station.getPassengers());
                  saveTrips.save(station.getTrips());
                  saveDrivers.save(station.getdrivers());
                    
                    alert.setContentText("Actions Saved !!");
                    alert.showAndWait();
                    
                } catch (IOException ex) {
                   // Logger.getLogger(MangerScene.class.getName()).log(Level.SEVERE, null, ex);
                    Alert alert3 = new Alert(Alert.AlertType.ERROR);
                    alert3.setHeaderText(null);
                    alert3.showAndWait();
                }
                
                
            }
        });
        
        
        scene = new Scene(stackpane, 580, 450);
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setLoginscene(LoginScene loginscene) {
        this.loginscene = loginscene;
    }

    public void setShowbymanger(ShowByManager showbymanger) {
        this.showbymanger = showbymanger;
    }

    public Scene getScene() {
        return scene;
    }

    public Station getStation() {
        return station;
    }

    public Manager getManager() {
        return manager;
    }

    public void setAssigndriver(AssignDriver assigndriver) {
        this.assigndriver = assigndriver;
    }

  
    
}
