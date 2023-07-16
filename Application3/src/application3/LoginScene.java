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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class LoginScene {
    
    Stage stage;
    Scene scene;
    Station station;
    Authentication authentication;
    DriverScene driverscene;
    PassengerScene passengerscene;
    MangerScene mangerscene;

   
    
    public LoginScene(Stage stage){
        
        this.stage=stage;
    
}
    public void Preparescene(){
        
        authentication = new Authentication();
        
        // DRAWING........................................................
        Label user = new Label("Username : ");
        Label password = new Label("Password  : ");
        TextField textfield = new TextField();
        PasswordField passwordfield = new PasswordField();
        RadioButton radio1 = new RadioButton("Passenger ");
        RadioButton radio2 = new RadioButton("Driver");
        RadioButton radio3 = new RadioButton("Manager");
        Button loginbtn = new Button("Login ");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                
        
          ToggleGroup radiogroup = new ToggleGroup();
          radio1.setToggleGroup(radiogroup);
          radio2.setToggleGroup(radiogroup);
          radio3.setToggleGroup(radiogroup);
        
        
        GridPane grid = new GridPane();
        grid.add(user, 0, 0);
        grid.add(password, 0, 1);
        grid.add(textfield, 1, 0);
        grid.add(passwordfield, 1, 1);
        grid.add(radio1, 0, 2);
        grid.add(radio2, 1, 2);
        grid.add(radio3, 2, 2);
        
        GridPane.setMargin(radio3,new Insets (17.5,15,15,-90));
        
        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().addAll(grid,loginbtn);
       
        StackPane.setMargin(grid,new Insets (90,15,15,30));
        StackPane.setMargin(loginbtn,new Insets (180,15,15,105));
    // END OF DRAWING .......................................................................    
        
        
    // SETTING ACTIONS......................................................................
    
    loginbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean valid;
                
                String user = textfield.getText();
                String pass= passwordfield.getText();
                if(radio1.isSelected()){
                     valid = authentication.passengervalidation(station.getPassengers(), user, pass);
                if(valid){
                    
                        textfield.clear();
                        passwordfield.clear();
                        Passenger temp = station.returnpassenger(user);
                        passengerscene.setPassenger(temp);
                        passengerscene.setStation(station);
                        passengerscene.preparescene();
                        stage.setScene(passengerscene.getScene());
                }
                else{
                    
                    alert.setContentText("Wrong user name or password");
                    alert.showAndWait();
                }
                }
                else if(radio2.isSelected()){
                    
                    valid = authentication.drivervalidation(station.getdrivers(), user, pass);
                  
                    if(valid){
                        
                        textfield.clear();
                        passwordfield.clear();
                        Driver temp = station.returndriver(user);
                        driverscene.setDriver(temp);
                        driverscene.preparescene();
                        stage.setScene(driverscene.getScene());
                    }
                
                    else{
                        alert.setContentText("Wrong user name or password");
                        alert.showAndWait();
                    }
                    
                }
                    
                else if(radio3.isSelected()){
                    
                    valid=authentication.managervalidation(station.getMangers(), user, pass);
                if(valid) {   
                    textfield.clear();
                    passwordfield.clear();
                    Manager temp = station.getmangerrbyname(user);
                    mangerscene.setManager(temp);
                    mangerscene.preparescene();
                    stage.setScene(mangerscene.getScene());
                    
                    
                }
                else{
                    alert.setContentText("Wrong user name or password");
                    alert.showAndWait();
                }
                    
                }
                
                else{
                    alert.setContentText("Please select your identity");
                    alert.showAndWait();
                }
                
                    
            }
        });
    
        
        scene = new Scene(root,300,300);
        
        
    }

    public Scene getScene() {
        return scene;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setDriverscene(DriverScene driverscene) {
        this.driverscene = driverscene;
    }

    public void setPassengerscene(PassengerScene passengerscene) {
        this.passengerscene = passengerscene;
    }

    public void setMangerscene(MangerScene mangerscene) {
        this.mangerscene = mangerscene;
    }
    
    
}
