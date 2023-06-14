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
import javafx.scene.control.Label;

public class LaonFormController implements Initializable {

    //private static final ObservableList<LoanList> LoanList = null;
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
    private DatePicker LaonDate;

    @FXML
    private TextField stu_name;
    @FXML
    private Label signupmessage1;


    @FXML
    void issue(ActionEvent event) {
        ResultSet rs = null, rs1, rs2, rs3, rs4,rs5 = null;
        PreparedStatement pst = null, pst1, pst2, pst3, pst4,pst5 = null;

        String reg = stu_name.getText();
        String bId = BookTitle.getText();
        System.out.println(reg +" " + bId);

        String sql1 = "select *from student where id = '" + reg + "'";
        String sql2 = "select *from book where id = '" + bId + "'";
        String sql = "insert into borrowlist (id,fullname,bid,booktitle,laondate) value(?,?,?,?,?)";

        try {
            ConnectToDatabase();
            pst1 = con.prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            pst2 = con.prepareStatement(sql1);
            rs2 = pst2.executeQuery();
            if (rs1.next() && rs2.next()) {

                try {

                    pst = con.prepareStatement(sql);
                    pst3 = con.prepareStatement(sql1);
                    rs3 = pst3.executeQuery();
                    pst4 = con.prepareStatement(sql2);
                    rs4 = pst4.executeQuery();
                    if(rs3.next() && rs4.next()){

                        pst.setString(1, reg);
                        pst.setString(2, rs3.getString(2));
                        pst.setString(3,  bId);
                        pst.setString(4, rs4.getString(2));
                        LocalDate getDate = LaonDate.getValue();
                        pst.setString(5, getDate.toString());
                        pst.execute();
                        pst.close();
                        JOptionPane.showMessageDialog(null, "Book issued Successfully");
                        
                        Parent root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();

                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Either the book ID or the Student Registration number is incorrect");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    private void ConnectToDatabase() {
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

    @FXML
    void switchtoLoanList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConnectToDatabase();
        //Table();
    }
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            System.out.println("Good girl!");
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    // public void EnterbuttonOnAction(ActionEvent event) throws IOException {
        
    
        
    



    //     String id = stu_name.getText();
    //     String bid = BookTitle.getText();
    //     String loandate =LaonDate.getValue().toString();
        
    //     if (id.equals("") && bid.equals("")) {
    //         // Labeled signupmessagelabel;
    //         signupmessage1.setText("Please enter the information.");
    //     } else {
    //         try {
    //             Class.forName("com.mysql.jdbc.Driver");
    //             con = DriverManager.getConnection("jdbc:mysql://localhost:/library", "root", "");
    //             pst = con.prepareStatement("SELECT * FROM students WHERE username=? AND
    //             password=?");
    //             pst = con.prepareStatement(
    //                     "INSERT INTO borrowlist (fullname,booktitle,laondate) value(?,?,?)");
    //             //  pst.setString(1, studentId);
                
    //             pst.setString(1, id);
    //             pst.setString(2, );
    //             pst.setDate(3, (Date) laondate);
    //             pst.executeUpdate();
    //             // if(rs.next()){
    //             // pst = con.prepareStatement("select id,username,password from user");
    //             JOptionPane.showMessageDialog(null, "Your suggession has been record " +id);
    //             FXMLLoader loader = new FXMLLoader(getClass().getResource("LaonList.fxml"));
    //             Parent root = loader.load();
    //             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //             scene = new Scene(root);
    //             stage.setScene(scene);
    //             stage.centerOnScreen();
    //             stage.show();

    //         } catch (Exception e) {
    //             System.out.println("error");
    //             System.out.println(e.getMessage());
    //         }
    //     }
    // }
    // @FXML
    // public void CancelButtonOnAction(ActionEvent event) throws IOException {
    //     Parent root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
    //     stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.centerOnScreen();
    //     stage.show();
    // }

}

