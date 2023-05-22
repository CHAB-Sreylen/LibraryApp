
// import java.io.IOException;
// import java.net.URL;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Node;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.text.Text;
// import javafx.scene.control.PasswordField;
// import javafx.stage.Stage;
// import samples.db.DatabaseConnection;
// import java.sql.Connection;
// import java.util.ResourceBundle;


// public class loginpage_controller implements Initializable{
//     private Stage stage;
//     private Scene scene;
//     private Parent root;
//     @FXML
//     private Label LoginwordButton;
//     @FXML
//     private  TextField usernametextField;
//     @FXML
//     private PasswordField passwordtextField;
//     @FXML 
//     private Button LoginButton;

//     public void LogindButtonOnAction(ActionEvent event) throws IOException{
//         root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
//         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//         scene = new Scene(root);
//         stage.setScene(scene);
//         stage.show();       
//         // if (usernametextField.getText().isBlank()== false && passwordtextField.getText().isBlank() == false ){
//         //     LoginwordButton.setText("Please try again!");
//         //     //validateLogin();
//         // }else{
//         //     LoginwordButton.setText("Please enter username and password!");
//         }
//         @FXML
//         private Button CancelButton;
//         public void CancelButtonOnAction(ActionEvent e){
//              Stage stage = (Stage) CancelButton.getScene().getWindow();
//              stage.close();
//         }
//         @Override
//         public void initialize(URL location, ResourceBundle resources) {
//             // TODO Auto-generated method stub
//             throw new UnsupportedOperationException("Unimplemented method 'initialize'");
//         }
//     }
    









    

// //     @FXML 
// //     private Button borrowbutton;
// //     @FXML
// //     private Label word;
   
// //     @FXML
// //     private Text borrowword2;
// //     @FXML
// //     private Text borrowword1;
    

// //     // public void borrowbuttonOnAction(ActionEvent e) throws IOException{
// //     //     if (borrowword1.getText().isBlank()== false && borrowword2.getText().isBlank()== false ){
// //     //         word.setText("Please try again!");
// //     //     }else{
// //     //         word.setText("hi");
// //     //     }
// //     //      Parent root = FXMLLoader.load(getClass().getResource("Borrow_link.fxml"));

// //     //     EventObject event;
// //     //     Stage stage = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();


// //     // }


// //     public void validateLogin(){
// //         DatabaseConnection connectNow = new DatabaseConnection();

// //         Connection connectionDB = connectNow.getConnection();
// //     }
// //     // @FXML
// //     // private Button CancelButton;
// //     // public void CancelButtonOnAction(ActionEvent e){
// //     //      Stage stage = (Stage) CancelButton.getScene().getWindow();
// //     //      stage.close();
// //     // }
// //     // public void validateLogin(){
// //     //     DatabaseConnection connectNow = new DatabaseConnection();


// //     @Override
// //     public void initialize(URL location, ResourceBundle resources) {
// //         // TODO Auto-generated method stub
// //         throw new UnsupportedOperationException("Unimplemented method 'initialize'");
// //     }

// //     //     Connection connectionDB = connectNow.getConnection();
// //     // }

  
// // }


import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Node;
import java.net.URL;
import java.util.ResourceBundle;

import samples.db.ConnectDB;
import samples.db.SelectData;
//import script.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginpage_controller implements Initializable {
   
     public void initialize(URL url, ResourceBundle resourceBundle){// initialize the table value
    
     }
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void LogindButtonOnAction(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
