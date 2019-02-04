
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
import javafx.stage.Stage;

public class BudgetBookkeepingController implements Initializable {
    
    
    @FXML
    private Button settings;
    @FXML
    private Button addCash;
    @FXML
    private Button addExpense;
    
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
    

            
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
