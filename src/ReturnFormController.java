import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

public class ReturnFormController implements Initializable {

    private static final String Node = null;
    Connection con;
    PreparedStatement pst;
    ResultSet resultSet;

    Stage stage;
    Scene scene;



    @FXML
    private TextField BookTitle;

    @FXML
    private Button CancelButton;

    @FXML
    private Button EnterButton;

    @FXML
    private TextField LaonDate;

    @FXML
    private DatePicker ReturnDate;

    @FXML
    private TextField stu_name;



    @FXML
    void search(ActionEvent event) {
        String bid = BookTitle.getText();
        System.out.println(bid);
        ResultSet rs;
        PreparedStatement pst;
        String sql = "SELECT *FROM borrowlist WHERE bid = '" + bid + "'";
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                stu_name.setText(rs.getString(2));
                LaonDate.setText(rs.getString(5));
                stu_name.setDisable(false);
                LaonDate.setDisable(false);
                ReturnDate.setDisable(false);
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void returned(){
        String bid = BookTitle.getText();
        String id = stu_name.getText();
        ResultSet rs,rs3;
        PreparedStatement pst;
        PreparedStatement pst3;

        String sql2 = "insert into returningbookliist (id,fullname,bid,booktitle,laondate,returningdate) value(?,?,?,?,?,?)";
        String sql3 = "SELECT *FROM borrowlist WHERE bid = '" + bid + "'";
        try {
            pst = con.prepareStatement(sql2);

            pst3 = con.prepareStatement(sql3);
            rs3 = pst3.executeQuery();

            if (rs3.next()) {
                pst.setString(1, rs3.getString(1));
                pst.setString(2, stu_name.getText());
                pst.setString(3, bid);
                pst.setString(4, rs3.getString(4));
                pst.setString(5, rs3.getString(5));
                LocalDate getDate = ReturnDate.getValue();
                pst.setString(6, getDate.toString());
            }

            pst.execute();
            JOptionPane.showMessageDialog(null, "Book returned succesfully");
            pst.close();
        
            // Parent root = FXMLLoader.load(getClass().getResource("Return_list.fxml"));
            //             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //             scene = new Scene(root);
            //             stage.setScene(scene);
            //             stage.centerOnScreen();
            //             stage.show();

            
            
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getMessage());
        }
    }

    public void del(){
        ResultSet rs;
        PreparedStatement pst;

        try {
            // Connection conn = Connectivity.ConnectDb();
            String bId = BookTitle.getText();
            String sql = "DELETE FROM borrowlist where bid = '" + bId + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

   
    }

    @FXML
    void ReturnBook(ActionEvent event) throws IOException {
        returned();
        del();
        Parent root = FXMLLoader.load(getClass().getResource("Return_list.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);  
        stage.centerOnScreen();
        stage.show();
        // updateBook();
    }

    public void switchtoReturnList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Return_list.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    

    public void connectToDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:/library","root","");
            System.out.println("sucessfully connected to student database yayyy");
        } catch (ClassNotFoundException ex) {
          System.out.println("hikhik");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectToDatabase();
        stu_name.setDisable(true);
        LaonDate.setDisable(true);
        ReturnDate.setDisable(true);
    }
}
