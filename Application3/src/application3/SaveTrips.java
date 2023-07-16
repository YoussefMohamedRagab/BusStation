/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application3;

/**
 *
 * @author USER
 */

import java.io.*;
import java.util.ArrayList;
import javafx.scene.control.Alert;

public class SaveTrips {
    
    public void save(ArrayList<Trip> trips) throws IOException{
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
        Trip temp;
            File file = new File("trips.txt");
            FileWriter filewriter = new FileWriter(file, false);
            PrintWriter printwriter = new PrintWriter(filewriter);
            String text = new String();
            for(int i =0;i<trips.size();i++){
                
                temp = trips.get(i);
                text = (temp.getIndex() + "," +temp.getSource() +"," +temp.getDestination() +"," +temp.getDate()
                        +"," +temp.getDeparturetime() +"," + temp.getAvalaibleseats() +"," +temp.getTransport()
                        +"," +temp.getPrice() +"," +temp.getStop() +"," +temp.getType() +"," + temp.getDriver());
                
                
                printwriter.println(text);
            }
            printwriter.close();
            try {
                filewriter.close();
            } catch (IOException ex) {
                alert.showAndWait();
            }
        
    }
    
    
}
