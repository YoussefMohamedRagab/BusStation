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

public class SavePassengers {
    
    
    public void save(ArrayList<Passenger> passengers) throws IOException{
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        
        Passenger temp;
            File file = new File("Passengers.txt");
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw);
            String text;
        
            for(int i=0;i<passengers.size();i++){
                
                temp = passengers.get(i);
                text = (temp.getUsername() +"," + temp.getPassword());
                for(int j=0;j<temp.getReserved().size();j++)
                    text = text + ("," + temp.getReserved().get(j).getIndex());
                
                pw.println(text);
                
            }
            pw.close();
            try {
                fw.close();
            } catch (IOException ex) {
                alert.showAndWait();
            }
        
        
        
        
    }
    
    
}
