import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class register_student_controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void initialize(URL url, ResourceBundle resourceBundle) {// initialize the table value

    }



    @FXML
    private TextField department;

    @FXML
    private TextField fullname;

    @FXML
    private TextField school_name;

    @FXML
    private Label signupmessage;

    @FXML
    private TextField stu_password;

    @FXML
    private TextField stu_username;

    @FXML
    private Button cancel_register;



    public void cancel_registerOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("Student.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }


    public void signupbuttonOnAction(ActionEvent event) throws IOException {
        String username = stu_username.getText();
        String password = stu_password.getText();
        // String studentId = stu_id.getText();
        String schoolname = school_name.getText();
        String fullName = fullname.getText();
        String Department = department.getText();
        
        if (username.equals("") && password.equals("")) {
            // Labeled signupmessagelabel;
            signupmessage.setText("Please enter the information.");
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:/library", "root", "");
                // pst = con.prepareStatement("SELECT * FROM students WHERE username=? AND
                // password=?");
                pst = con.prepareStatement(
                        "INSERT INTO student (fullname,username,password,school,department) value(?,?,?,?,?)");
                //  pst.setString(1, studentId);
                
                pst.setString(1, fullName);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, schoolname);
                pst.setString(5, Department);
                pst.executeUpdate();
                // if(rs.next()){
                // pst = con.prepareStatement("select id,username,password from user");
                JOptionPane.showMessageDialog(null, "Register success welcome " + username);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Student.fxml"));
                root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e.getMessage());
            }
        }
    }

}
