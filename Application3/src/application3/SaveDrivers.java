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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class SaveDrivers {
    
    public void save(ArrayList<Driver> drivers) throws IOException{
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        
        File file = new File("Drivers.txt");
            FileWriter filewriter = new FileWriter(file, false);
            PrintWriter printwriter = new PrintWriter(filewriter);
            String text = new String();
            Driver temp;
            
            for(int i = 0;i<drivers.size();i++)
            {
                temp = drivers.get(i);
                text=(temp.getUsername() + "," + temp.getPassword());
                
                for(int j=0;j<temp.getAssignedtrips().size();j++){
                    
                    text = text + ("," + temp.getAssignedtrips().get(j).getIndex());
                }
                
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
