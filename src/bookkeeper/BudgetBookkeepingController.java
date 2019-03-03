
package bookkeeper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class BudgetBookkeepingController implements Initializable {
    
    
    @FXML
    private Button settings;
    @FXML
    private Button addCash;
    @FXML
    private Button addExpense;
    
    @FXML
    private Label balance;
    
    @FXML
    private Button updateButton;
    
    @FXML
    private void updateButtonAction(ActionEvent event) throws IOException
    {
        updateLabel();
    }
    
    @FXML
    private void addCashAction(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddCashWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Add Cash");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void settingsClick(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("SettingsWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Settings");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void addExpenseAction(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddExpensesWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Add Expense");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void updateLabel()
    {
        FileReader reader;
        double myMoney=0.0;
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
            System.out.println(holder[2]);
        }
        
        balance.setText(Double.toString(myMoney));
        br.close();
        }
        catch(IOException e)
        {
            System.out.println("File doesn't exist");
        }
    }    
        
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    updateLabel();
    }
    
}
