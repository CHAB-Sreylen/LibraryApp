
import java.beans.BeanProperty;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LaonListController implements Initializable {
    public void initialize(URL url, ResourceBundle resourceBundle) {// initialize the table value

    }
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button Delete2;

    @FXML
    private Button LaonForm;

    @FXML
    private Button ReturnForm;

    @FXML
    private Button ReturnList;

    @FXML
    private Button back1;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void back1OnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    // public void delete2OnAction(ActionEvent event) throws IOException {
    //     Object root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
    //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     Scene scene = new Scene((Parent) root);
    //     stage.setScene(scene);
    //     stage.show();

    // }
    
    public void LaonFormOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("LaonForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    public void ReturnFormOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("ReturnForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    public void ReturnListOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("Return_list.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }


}


   

