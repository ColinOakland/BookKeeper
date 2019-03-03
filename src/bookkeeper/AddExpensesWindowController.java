/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookkeeper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;

/**
 *
 * @author colin
 */
public class AddExpensesWindowController implements Initializable {
    
    @FXML
    private Button addExpensesDoneButton;
    
    @FXML
    private TextField purposeTextField;
    @FXML
    private TextField addExpenseshowMuchTextField;
    @FXML
    private DatePicker date;
    @FXML
    private TextField AddExpensesCategory;
    
    @FXML
    private void addExpensesDoneButtonAction(ActionEvent event) throws IOException
    {
        FileWriter writer;
        writer = new FileWriter("record.csv", true);
        
        //get all the data from fields, so we can write them
        String purpose = purposeTextField.getText();
        String howMuch = addExpenseshowMuchTextField.getText();
        LocalDate expenseDate = date.getValue();
        String category = AddExpensesCategory.getText();
        
        
        //write the data to a csv file which is in the root directory as record.txt
        writer.append("expense," + purpose + "," +"-" +howMuch + "," + expenseDate + ","+category+"\n");
        
        //close the file
        writer.close();
        
        Stage stage = (Stage) addExpensesDoneButton.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
