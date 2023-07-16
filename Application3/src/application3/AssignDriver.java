/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;

/**
 *
 * @author USER
 */
public class AssignDriver {
    
    Stage stage;
    Scene scene;
    Station station;
   
    
    
    public AssignDriver(Stage stage){
        this.stage = stage;
    }
    
    public void preparescene(ArrayList<Trip> trips,Scene backscene) throws NullPointerException {
        
        
        
        TableView tableview = new TableView();
        Button assign = new Button("Assign Driver");
        Label label = new Label("Choose a Driver : ");
        ChoiceBox driverBox = new ChoiceBox();
        Button back = new Button("Back");
        
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setHeaderText(null);
        
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
        
        TableColumn<String,Trip > column9 = new TableColumn<>("Driver");
        column9.setCellValueFactory(new PropertyValueFactory<>("driver"));
        
        tableview.getColumns().add(column1);
        tableview.getColumns().add(column2);
        tableview.getColumns().add(column3);
        tableview.getColumns().add(column4);
        tableview.getColumns().add(column5);
        tableview.getColumns().add(column6);
        tableview.getColumns().add(column7);
        tableview.getColumns().add(column9);
        
        for(int i =0;i<trips.size();i++){
            
             Trip temp = trips.get(i); 
           
            tableview.getItems().addAll(temp);        
        }
        
        for(int i=0;i<station.getdrivers().size();i++){
            
            driverBox.getItems().addAll(" " + station.getdrivers().get(i).getUsername());
        }
        
        
        StackPane stackpane = new StackPane();
        stackpane.setAlignment(Pos.TOP_LEFT);
        stackpane.getChildren().addAll(label,driverBox,assign);
        StackPane.setMargin(label,new Insets (70,15,15,0));
        StackPane.setMargin(driverBox,new Insets (70,15,15,100));
        StackPane.setMargin(assign,new Insets (70,15,15,240));
     
        
        GridPane grid = new GridPane();
        grid.add(tableview, 0, 0);
        grid.add(stackpane, 0, 1);
        grid.add(back, 0, 2);
        
        
        //ACTIONS.......................................................
        assign.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                
                Trip temp =  (Trip) tableview.getSelectionModel().getSelectedItem();
                              
                String value = (String) driverBox.getValue();
                
                if(value==null)
                {

                    alert2.setContentText("Please Choose a driver !!");
                    alert2.showAndWait();
                }
                else{
                    temp.setDriver(value);
                    
                    //driver=station.returndriver(value);
                    
                   // driver.addtrip(temp);
                    alert2.setContentText("Successfully Assigned");
                    alert2.showAndWait();
                }
                
               // Driver driver = station.returndriver(temp.getDriver());
               // driver.addtrip(temp);
                
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                stage.setScene(backscene);
                
            }
        });
        
        scene= new Scene(grid,620,500);
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Scene getScene() {
        return scene;
    }
    
}
