/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookkeeper;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 *
 * @author colin
 */
public class AddCashWindowController implements Initializable {
    
    @FXML 
    TextField sourceTextField;
    @FXML
    TextField howMuchTextField;
    @FXML
    DatePicker date;
    @FXML
    Button addCashDoneButton;
    
    
    @FXML
    private void addCashDoneButtonAction(ActionEvent action) throws IOException
    {
        
        FileWriter writer;
        writer = new FileWriter("record.csv", true);
        
        //get all the data from fields, so we can write them
        String source = sourceTextField.getText();
        String howMuch = howMuchTextField.getText();
        LocalDate theDate = date.getValue();
        
        
        
        // write the data to a csv file which is in the root directory as record.txt
        // data is written in the following format
        
        /*
        1st value: String: "expense" or "income"
        2nd value: String: Purpose 
        3rd value: Double: Amount of money
        */
        writer.append("income," + source + "," +"-" +howMuch + "," + theDate + ","+"income"+"\n");

        //close the file
        writer.close();
        
        Stage stage;
        stage = (Stage) addCashDoneButton.getScene().getWindow();
        stage.close();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
