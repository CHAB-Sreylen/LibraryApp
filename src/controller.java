
//import java.io.IOException;
//import java.util.EventObject;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import samples.db.DatabaseConnection;

import java.sql.Connection;

public class controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label LoginwordButton;
    @FXML
    private  TextField usernametextField;
    @FXML
    private PasswordField passwordtextField;

    public void LogindButtonOnAction(ActionEvent e){
       // if (usernametextField.getText().isBlank()== false && passwordtextField.getText().isBlank() == false ){
            //LoginwordButton.setText("Please try again!");
            //validateLogin();
        ////}else{
          //  LoginwordButton.setText("Please enter username and password!");
        }
    }
    @FXML
    private Button CancelButton;
    public void CancelButtonOnAction(ActionEvent e){
         Stage stage = (Stage) CancelButton.getScene().getWindow();
         stage.close();
    }









    

    @FXML 
    private Button borrowbutton;
    @FXML
    private Label word;
   
    @FXML
    private Text borrowword2;
    @FXML
    private Text borrowword1;
    

    // public void borrowbuttonOnAction(ActionEvent e) throws IOException{
    //     if (borrowword1.getText().isBlank()== false && borrowword2.getText().isBlank()== false ){
    //         word.setText("Please try again!");
    //     }else{
    //         word.setText("hi");
    //     }
    //      Parent root = FXMLLoader.load(getClass().getResource("Borrow_link.fxml"));

    //     EventObject event;
    //     Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();


    // }


    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();

        Connection connectionDB = connectNow.getConnection();
    }
    // @FXML
    // private Button CancelButton;
    // public void CancelButtonOnAction(ActionEvent e){
    //      Stage stage = (Stage) CancelButton.getScene().getWindow();
    //      stage.close();
    // }
    // public void validateLogin(){
    //     DatabaseConnection connectNow = new DatabaseConnection();

    //     Connection connectionDB = connectNow.getConnection();
    // }

  
}