
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javax.swing.JOptionPane;
import samples.db.ConnectDB;
import samples.db.SelectData;
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

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private Label LoginwordButton;
    @FXML
    private TextField usernametextField;
    @FXML
    private PasswordField passwordtextField;
    @FXML 
    private Button LogindButton;

                ///* Login_page_controller *///

    public void LogindButtonOnAction(ActionEvent event)throws IOException,ClassNotFoundException{
        String userName = usernametextField.getText();
        String password = passwordtextField.getText();
        if(userName.equals("") && password.equals("")){
            LoginwordButton.setText("Please enter username and password.");
        }else{
            try{ 
                Class.forName("com.mysql.jdbc.Driver"); 
                con = DriverManager.getConnection("jdbc:mysql://localhost:/library","root","");       
                // pst = con.prepareStatement("SELECT * FROM students WHERE username=? AND password=?"); 
                pst = con.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");  
                pst.setString(1, userName); 
                pst.setString(2, password); 
                rs = pst.executeQuery(); 
                if(rs.next()){  
                    pst = con.prepareStatement("select id,username,password from user"); 
                    JOptionPane.showMessageDialog(null, "login success welcome "+userName);   
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("List_Book.fxml")); 
                    root = loader.load(); 
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                    scene = new Scene(root); 
                    stage.setScene(scene); 
                    stage.centerOnScreen(); 
                    stage.show(); 
                }else{ 
                    JOptionPane.showMessageDialog(null, "Login failed");    
                    usernametextField.setText(""); 
                    passwordtextField.setText(""); 
                    usernametextField.requestFocus(); 
                }  
            }catch(Exception e){ 
                System.out.println("error"); 
            }
        }
    }
    public void borrowbutton1OnAction(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("Borrow_link.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private Button CancelButton;
    public void CancelButtonOnAction(ActionEvent event)throws IOException{
         Stage stage = (Stage) CancelButton.getScene().getWindow();
         stage.close();
    }
}
