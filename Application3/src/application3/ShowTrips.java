/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ShowTrips {
    
    
    Stage stage;
    Scene scene;
    Passenger passenger;

    public ShowTrips(Stage stage) {
        this.stage = stage;
    }
    
    
    
    public void preparescene(ArrayList<Trip> trips,Scene backscene ){
        
        
        
        //DRAWING............................................................
        
        TableView tableview = new TableView();
        Button back = new Button("Back");
      
        TableColumn<String, Trip> column1 = new TableColumn<>("Source");
        column1.setCellValueFactory(new PropertyValueFactory<>("source"));

        TableColumn<String, Trip> column2 = new TableColumn<>("Destination");
        column2.setCellValueFactory(new PropertyValueFactory<>("destination"));
        
        TableColumn<String, Trip> column3 = new TableColumn<>("Date");
        column3.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        TableColumn<String, Trip> column4 = new TableColumn<>("Departure");
        column4.setCellValueFactory(new PropertyValueFactory<>("departuretime"));
        
        TableColumn<String, Trip> column5 = new TableColumn<>("AvailaibleSeats");
        column5.setCellValueFactory(new PropertyValueFactory<>("avalaibleseats"));
        
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
        
        tableview.getColumns().add(column1);
        tableview.getColumns().add(column2);
        tableview.getColumns().add(column3);
        tableview.getColumns().add(column4);
        tableview.getColumns().add(column5);
        
        for(int i =0;i<trips.size();i++){
            Trip temp = trips.get(i);
            
             tableview.getItems().add(temp);
            
        }
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(back);
         
        GridPane grid = new GridPane();
        
        grid.add(tableview, 0, 0);
        grid.add(hbox, 0, 1);
             
       //END OF DRAWING............................................................................
       
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                stage.setScene(backscene);
            }
        });
        
        
        
        scene = new Scene(grid, 400, 400);
        
    }

    public Scene getScene() {
        return scene;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
    
    
    
    
    
}
