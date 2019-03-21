/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetbookkeeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author dawoo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label billsLabel;
    @FXML
    private Label foodLabel;
    @FXML
    private Label techLabel;
    @FXML
    private Label otherLabel;
    @FXML
    private TextField addCashSource;
    @FXML
    private TextField addCashHowMuch;
    @FXML
    private DatePicker addCashDate;
    @FXML
    private Button addCashDoneButton;
    @FXML
    private Label balanceLabel;
    @FXML
    private TextField addExpensesPurpose;
    @FXML
    private TextField addExpensesHowMuch;
    @FXML
    private RadioButton radioBills;
    @FXML
    private RadioButton radioFood;
    @FXML
    private RadioButton radioTech;
    @FXML
    private RadioButton radioOther;
    @FXML
    private DatePicker addExpensesDate;
    @FXML
    private Button addExpensesDateButton;
    
    
    @FXML
    private void addCashDoneButtonAction(ActionEvent event) throws IOException
    {
        String source = addCashSource.getText();
        double money = Double.parseDouble(addCashHowMuch.getText());
        LocalDate myDate = addCashDate.getValue();
        
        FileWriter writer;
        writer = new FileWriter("record.csv", true);
        
        // write the data to a csv file which is in the root directory as record.txt
        // data is written in the following format
        
        /*
        1st value: String: "expense" or "income"
        2nd value: String: Purpose 
        3rd value: Double: Amount of money
        4th value: String: Category
        */
        writer.append("income," + source + ","+money + "," + myDate + "," + "income" + "\n");

        //close the file
        writer.close();
        updateLabel();
        
    }
    
    @FXML
    private void updateLabel()
    {
        FileReader reader;
        //change these initial values to read from file
        double myMoney=0.0;
        double myBills=0.0;
        double myTech=0.0;
        double myFood=0.0;
        double myOther=0.0;
        
        String [] holder;
        Path pathToFile = Paths.get("record.csv");
        try
        {
        BufferedReader br;
        br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
        String line;
        while( (line=br.readLine())!=null)
        {
            holder = line.split(",");
            myMoney += Double.parseDouble(holder[2]);
            if(holder[4]=="Bills")
            {
                myBills+=Double.parseDouble(holder[2]);
            }
            else if(holder[4]=="Tech")
            {
                myTech+=Double.parseDouble(holder[2]);
            }
            else if(holder[4]=="Food")
            {
                myFood+=Double.parseDouble(holder[2]);
            }
            else
            {
                myOther+=Double.parseDouble(holder[2]);
            }
            System.out.println(holder[2]);
        }
        
        balanceLabel.setText(Double.toString(myMoney));
        billsLabel.setText(Double.toString(myBills));

        /* 
        foodLabel.setText(Double.toString(myFood));
        techLabel.setText(Double.toString(myTech));
        */
        
        
        br.close();
        }
        catch(IOException e)
        {
            System.out.println("File doesn't exist");
        }
    }    
    @FXML
    private void addExpensesDoneButtonAction(ActionEvent event) throws IOException
    {
        String purpose;
        purpose = addExpensesPurpose.getText();
        double howMuch = Double.parseDouble(addExpensesHowMuch.getText());
        String radioButton="";
        if(radioBills.isSelected())
        {
            radioButton="Bills";
        }else if(radioTech.isSelected())
        {
            radioButton="Tech";
        }
        else if(radioFood.isSelected())
        {
            radioButton="Food";
        }
        else
        {
            radioButton="Other";
        }
        LocalDate myDate;
        myDate = addExpensesDate.getValue();
        
        FileWriter writer;
        writer = new FileWriter("record.csv", true);
        
        // write the data to a csv file which is in the root directory as record.txt
        // data is written in the following format
        
        /*
        1st value: String: "expense" or "income"
        2nd value: String: Purpose 
        3rd value: Double: Amount of money
        4th value: String: Category
        */
        writer.append("expense," + purpose + ","+"-"+howMuch + "," + myDate + "," + radioButton + "\n");

        //close the file
        writer.close();
        updateLabel();
        
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
