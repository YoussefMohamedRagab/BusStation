/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
public class ShowByPassenger {
    
    Stage stage;
    Scene scene;
    Passenger passenger;

    public ShowByPassenger(Stage stage) {
        this.stage = stage;
    }
    
    
    
    public void preparescene(ArrayList<Trip> trips,Scene backscene ,int flag){
        
        
        
        //DRAWING............................................................
        
        TableView tableview = new TableView();
        Button back = new Button("Back");
        Button add = new Button("AddTrip");
        Button cancel = new Button ("CancelTrip");
      
        
        
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
        
        TableColumn<String,Trip > column6 = new TableColumn<>("Stops");
        column6.setCellValueFactory(new PropertyValueFactory<>("stop"));
        
        TableColumn<String,Trip > column7 = new TableColumn<>("Transport");
        column7.setCellValueFactory(new PropertyValueFactory<>("transport"));
        
        TableColumn<String,Trip > column8 = new TableColumn<>("Type");
        column8.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        TableColumn<String,Trip > column9 = new TableColumn<>("Price");
        column9.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        
        tableview.getColumns().add(column1);
        tableview.getColumns().add(column2);
        tableview.getColumns().add(column3);
        tableview.getColumns().add(column4);
        tableview.getColumns().add(column5);
        tableview.getColumns().add(column6);
        tableview.getColumns().add(column7);
        tableview.getColumns().add(column8);
        tableview.getColumns().add(column9);
        
        
        
        for(int i =0;i<trips.size();i++){
            
             Trip temp = trips.get(i); 
           
            tableview.getItems().addAll(temp);
       
            
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
        
                
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setHeaderText(null);
        
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(back,add,cancel);
         
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
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               if(flag==0){
                
              Trip temp =  (Trip) tableview.getSelectionModel().getSelectedItem();
              
              if(temp.getAvalaibleseats()!=0){
                  
                alert.setTitle("Confirmation"); 
                alert.setContentText("This Trip price = " + temp.getPrice() + "\nDo you want to reserve?");
                
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get()==ButtonType.OK){
                    
                   int y = temp.getAvalaibleseats();
                    y--;
                    temp.getVehicle().setAvailaibleseats(y);
                    temp.setAvalaibleseats(y);
                    passenger.addtrip(temp);
                    
                    alert2.setContentText("Successfully reserved");
                    alert2.showAndWait();
                
                }
                
              }
              else
              {
                  alert2.setContentText("No Availaible seats");
                  alert2.showAndWait();
              }
              
                
            }
               else{
                   
                   alert2.setHeaderText(null);
                   alert2.setContentText("Please go to availaible trips to make reservations");
                     alert2.showAndWait();
               }
            }
        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(flag==1){
                
                Trip temp =  (Trip) tableview.getSelectionModel().getSelectedItem();
                
                alert.setTitle("Confirmation"); 
                alert.setHeaderText("Are you sure to cancel your reservation?");
                
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get()==ButtonType.OK){
                    
                    
                    passenger.removetrip(temp);
                  int y = temp.getAvalaibleseats();
                    y++;                    
                  temp.getVehicle().setAvailaibleseats(y);
                  temp.setAvalaibleseats(y);
                  
                  alert2.setHeaderText(null);
                  alert2.setContentText("Your trip is cancelled");
                  alert2.showAndWait();
                    
                }
                }
                else{

                     alert2.setHeaderText(null);
                     alert2.setContentText("Please go to your reserved trips to cancel reservations");
                     alert2.showAndWait();
                             
                }
                    
            }
        });
        
        
        
        scene = new Scene(grid, 635, 500);
        
    }

    public Scene getScene() {
        return scene;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
}
