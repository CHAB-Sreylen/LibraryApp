
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateBookController implements Initializable{

    @FXML
    private TextField Author;

    @FXML
    private Button CancelButton;

    @FXML
    private Button EnterButton;

    @FXML
    private TextField Year;

    @FXML
    private TextField booktitle;

    private Stage stage;
    private Scene scene;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    int bid;

    @FXML
    void enterbuttonOnAction(ActionEvent event) throws IOException {
         try
        {
            pst = con.prepareStatement("update book set title = ?,author = ? ,year = ? where id = ? ");
            pst.setString(1, booktitle.getText());
            pst.setString(2, Author.getText());
            pst.setString(3, Year.getText());
            pst.setInt(4, bid);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Book");
            
            alert.setHeaderText("You will change the info of book. ");
            alert.setContentText("Updateddd!");
            
            alert.showAndWait();
           Parent root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void switchtoListBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        System.out.println("Hello world!");
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
     

        try {
            pst = con.prepareStatement("delete from book where id = ? ");
            pst.setInt(1, bid);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Book");

            alert.setHeaderText("Book will delete form the list.");
            alert.setContentText("Deleted!");

            alert.showAndWait();
                       Parent root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
      
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }

    
    public void getIDBook(int id, String title, String author, String year) {
        bid = id;
        System.out.println("Hello is update by id " + id + title + author + year);
        booktitle.setText(title);
        Author.setText(author);
        Year.setText(year);
    }

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            System.out.println("bzip2");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connect();
    }

}
