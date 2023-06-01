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

public class register_student_controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void initialize(URL url, ResourceBundle resourceBundle){// initialize the table value
    
    }

    // @FXML
    // private TextField stu_usernameTextField;
    // @FXML
    // private TextField stu_idtTextField;
    // @FXML 
    // private TextField stu_passwordTextField;
    // @FXML
    // private TextField school_nameTextField;
    // @FXML 
    // private TextField fullnameTextField;
    // @FXML 
    // private TextField departmentTextField; 
    // @FXML 
    // private Label signupmessagelabel;
    // @FXML 
    // private Button signupbutton;

    @FXML
    private TextField department;

    @FXML
    private TextField fullname;

    @FXML
    private TextField school_name;

    @FXML
    private Button signupbutton;

    @FXML
    private Label signupmessage;

    @FXML
    private TextField stu_id;

    @FXML
    private TextField stu_password;

    @FXML
    private TextField stu_username;

    public void signupbuttonOnAction(ActionEvent event)throws IOException{
        String username = stu_username.getText();
        String password = stu_password.getText();
        String studentId = stu_id.getText();
        String schoolname = school_name.getText();
        String fullName = fullname.getText();
        String Department = department.getText();
        // TextInputControl stu_usernametextField;
        // String username = stu_usernametextField.getText();
        // TextInputControl stu_passwordtextField;
        // String passWord = stu_passwordtextField.getText();
        // TextInputControl stu_idtextField;
        // String studentId = stu_idtextField.getText();
        // TextInputControl school_nametextField;
        // String schoolname = school_nametextField.getText();
        // TextInputControl fullnametextField;
        // String Fullname = fullnametextField.getText();
        // TextInputControl departmenttextField;
        // String Department = departmenttextField.getText();
         
        if(username.equals("") && password.equals("")){
            // Labeled signupmessagelabel;
            signupmessage.setText("Please enter the information.");
        }else{
            try{ 
                Class.forName("com.mysql.jdbc.Driver"); 
                con = DriverManager.getConnection("jdbc:mysql://localhost:/library","root","");       
                // pst = con.prepareStatement("SELECT * FROM students WHERE username=? AND password=?"); 
                pst = con.prepareStatement("INSERT INTO student (fullname,username,password,school,department) value(?,?,?,?,?)");  
                // pst.setString(1, studentId); 
                pst.setString(1, fullName); 
                pst.setString(2, username); 
                pst.setString(3, password); 
                pst.setString(4, schoolname); 
                pst.setString(5, Department); 
                pst.executeUpdate(); 
                // if(rs.next()){  
                    // pst = con.prepareStatement("select id,username,password from user"); 
                    JOptionPane.showMessageDialog(null, "login success welcome "+username);   
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ListBook.fxml")); 
                    root = loader.load(); 
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                    scene = new Scene(root); 
                    stage.setScene(scene); 
                    stage.centerOnScreen(); 
                    stage.show(); 
                    // pst = con.prepareStatement("select id,username,password from user"); 
                    // JOptionPane.showMessageDialog(null, "login success welcome "+userName); 
                    
                        // FXMLLoader loader = new FXMLLoader(getClass().getResource("re2.fxml")); 
                        // root = loader.load(); 
                        // stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                        // scene = new Scene(root); 
                        // stage.setScene(scene); 
                        // stage.centerOnScreen(); 
                        // stage.show(); 
                        // }
                // }else{ 
                //     JOptionPane.showMessageDialog(null, "Login failed");    
                //     usernametextField.setText(""); 
                //     passwordtextField.setText(""); 
                //     usernametextField.requestFocus(); 
                
                }catch(Exception e){ 
                System.out.println("error"); 
                System.out.println(e.getMessage());
            }
        }
    }
    

}

