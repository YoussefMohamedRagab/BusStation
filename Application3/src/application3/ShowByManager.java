/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

import application3.Vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ShowByManager {
    
    Stage stage;
    Scene scene;
    Station station;
    
    public ShowByManager(Stage stage){
        this.stage = stage;
    }
    
    
    public void preparescene(ArrayList<Trip> trips,Scene backscene ,int flag ){
        
        //Drawing..............................................
        
        TableView tableview = new TableView();
        Label label = new Label("Adding Trip");
        TextField source = new TextField("Trip Source");
        TextField destination = new TextField("Trip destination");
        TextField date = new TextField("Trip date (dd/mm/yy)");
        TextField departure = new TextField("DepartureTime (24hformat)");
        TextField price = new TextField("Price");
        ChoiceBox vehiclebox = new ChoiceBox();
        ChoiceBox stopBox = new ChoiceBox();
        ChoiceBox typeBox = new ChoiceBox();
        ChoiceBox driverBox = new ChoiceBox();
        Label seplabel1 = new Label("\n\n");
        Button add = new Button("Add Trip");
        Button cancel = new Button("Cancel Trip");
        Button back = new Button("Back");
        
        Label seplabel2 = new Label("\n\n");
        
        
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
        
        TableColumn<String,Trip > column10 = new TableColumn<>("Price");
        column10.setCellValueFactory(new PropertyValueFactory<>("price"));
        
         
        tableview.getColumns().add(column1);
        tableview.getColumns().add(column2);
        tableview.getColumns().add(column3);
        tableview.getColumns().add(column4);
        tableview.getColumns().add(column5);
        tableview.getColumns().add(column6);
        tableview.getColumns().add(column7);
        tableview.getColumns().add(column8);
        tableview.getColumns().add(column9);
        tableview.getColumns().add(column10);
        
        
        
        for(int i =0;i<trips.size();i++){
            
             Trip temp = trips.get(i); 
           
            tableview.getItems().addAll(temp);        
        }
        
        TilePane tilepane = new TilePane();
        
        tilepane.getChildren().add(source);
        tilepane.getChildren().add(destination);
        tilepane.getChildren().add(date);
        tilepane.getChildren().add(departure);
        tilepane.getChildren().add(price);
        tilepane.getChildren().add(vehiclebox);        
        tilepane.getChildren().add(typeBox);
        tilepane.getChildren().add(stopBox);
        tilepane.getChildren().add(driverBox);
        tilepane.getChildren().add(add);
        tilepane.getChildren().add(cancel);
            
        tilepane.setTileAlignment(Pos.TOP_LEFT);
        
        tilepane.setHgap(10);
        tilepane.setVgap(10);
        
        for(int i=0;i<station.getdrivers().size();i++){
            
            driverBox.getItems().addAll(" " + station.getdrivers().get(i).getUsername());
        }
        
        typeBox.getItems().add("One-Way");
        typeBox.getItems().add("Round");
        
        vehiclebox.getItems().add("Bus");
        vehiclebox.getItems().add("MiniBus");
        vehiclebox.getItems().add("Limousine");
        
        stopBox.getItems().add("Nonstop");
        stopBox.getItems().add("Onestop");
        stopBox.getItems().add("Manystops");
        
        
        GridPane grid = new GridPane();
        grid.add(tableview, 0, 0);
        grid.add(seplabel1, 0, 1);
        grid.add(label, 0, 2);
        grid.add(tilepane, 0, 3);
        grid.add(seplabel2, 0, 4);
        grid.add(back, 0, 5);
        
        //END OF DRAWING..................................
        //ACTIONS...........................................
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(flag == 1){
                int x = station.getmaxindex();
                String value;
                Trip temp = new Trip();
     
                temp.setIndex(x+1);
                temp.setSource(source.getText());
                temp.setDestination(destination.getText());
                temp.setDate(date.getText());
                temp.setDeparturetime(departure.getText());
                temp.setPrice(Integer.parseInt(price.getText()));
                
                value = (String) vehiclebox.getValue();
                Vehicle vehicle = station.vehiclefactory(value);
                temp.setTransport(value);
                temp.setAvalaibleseats(vehicle.getAvailaibleseats());
                value =(String) typeBox.getValue();
                temp.setType(value);
                value = (String) stopBox.getValue();
                temp.setStop(value);
                value = (String) driverBox.getValue();
                temp.setDriver(value);
                
                station.addtrip(temp);
               // station.returndriver(value).addtrip(temp);
                
                
                
                alert2.setContentText("Trip is Successfully added");
                alert2.showAndWait();
                }
                else
                {
                    alert2.setContentText("Please go to AddTrip screen!!");
                alert2.showAndWait();
                }
                
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(backscene);
            }
        });
        
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(flag==0){
                Trip temp =  (Trip) tableview.getSelectionModel().getSelectedItem();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmation"); 
                alert.setContentText("Are you sure to cancel this trip?\nFrom : " + temp.getSource()
                 +" To : " + temp.getDestination() +" On : " + temp.getDate());
                
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get()==ButtonType.OK){
                    
                    
                    
                station.removetrip(temp);
                station.removetripfrompassenger(temp);
                station.removetripfromdriver(temp);
                
                alert2.setContentText("Successfully removed");
                alert2.showAndWait();
                    
                
                }
                
            }
                else{
                    alert2.setContentText("Please go to CancelTrip screen!!");
                    alert2.showAndWait();
                }
            }
        });
        
        
        scene = new Scene(grid, 740,600);
        
    }

    public Scene getScene() {
        return scene;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    
    
}