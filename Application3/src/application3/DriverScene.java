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

/**
 *
 * @author USER
 */
public class DriverScene {
    
    Stage stage;
    Scene scene;
    LoginScene loginscene;
    Driver driver;
    ShowTrips showtrips;

    public DriverScene(Stage stage) {
        this.stage = stage;
        
    }
    
    public void preparescene(){
        
        //Drawing ......................................
        Label infolabel = new Label();
        infolabel.setText("Username : " + driver.getUsername() +"\nPassword : " 
                + driver.getPassword()+ "\nAge:age\nEmail:email@domain.com");
        Button show = new Button("Show Assigned Trips");
        Button logout = new Button("Logout");
        
     
        StackPane stackpane = new StackPane();
        stackpane.setAlignment(Pos.TOP_LEFT);
        stackpane.getChildren().addAll(infolabel,show,logout);
        StackPane.setMargin(show,new Insets (70,15,15,0));
        StackPane.setMargin(logout,new Insets (100,15,15,0));
        
        //ACTIONS.....!!!!!!!!!!!!!!!!!!!!!!!!
        
        show.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                showtrips.preparescene(driver.getAssignedtrips(),scene);
                stage.setScene(showtrips.getScene());
                
            }
        });
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginscene.getScene());
            }
        });
        
        scene = new Scene(stackpane, 580,450);
        
    }

    public Scene getScene() {
        return scene;
    }

    public void setDriver(Driver driver) {
        
        this.driver = driver;
    }

    public void setShowtrips(ShowTrips showtrips) {
        this.showtrips = showtrips;
    }

    public void setLoginscene(LoginScene loginscene) {
        this.loginscene = loginscene;
    }
    
    
    
}
