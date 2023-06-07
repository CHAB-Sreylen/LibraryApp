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
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class LaonFormController implements Initializable {
    // private Stage CancelButton;
    private Scene scene;
    private Stage stage;

    @FXML
    private TextField BookTitle;

    @FXML
    private Button CancelButton;

    @FXML
    private Button EnterButton;

    @FXML
    private DatePicker LaonDate;

    @FXML
    private DatePicker ReturnDate;

    @FXML
    private TextField stu_name;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void issue() {
        ResultSet rs = null, rs1, rs2, rs3 = null;
        PreparedStatement pst = null, pst1, pst2, pst3 = null;
        // ConnectToBook();
        // ConnectToStudent();

        String reg = stu_name.getText();
        String bId = BookTitle.getText();

        String sql1 = "select *from students where id = '" + reg + "'";
        String sql2 = "select *from books where id = '" + bId + "'";
        String sql = "insert into borrowlist (id,name,username,bid,booktitle,quantity,category,dateissued) value(?,?,?,?,?,?,?,?)";

        try {
            ConnectToStudent();
            // Connection con = Connectivity.ConnectDb();
            pst1 = con.prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            pst2 = con.prepareStatement(sql1);
            rs2 = pst2.executeQuery();
            if (rs1.next() && rs2.next()) {

                try {

                    // pst3 = conn.prepareStatement(sql4);
                    // rs3 = pst3.executeQuery();
                    // String numBook = rs3.getString(8);
                    // int numOfBook = Integer.parseInt(numBook);
                    pst = con.prepareStatement(sql);
                    {

                        pst.setString(1, stu_name.getText());
                        pst.setString(2, BookTitle.getText());

                        // LocalDate localDate = issueDate.getValue();
                        // pst.setString(8, localDate.toString());

                        pst.execute();
                        pst.close();
                        // JOptionPane.showMessageDialog(null, "Book issued Successfully");
                        System.out.println("book issued Successfully");

                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Either the book ID or the Student Registration number is incorrect");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ConnectToBook();
            String sql3 = "DELETE FROM books where id = '" + bId + "'";
            pst3 = con.prepareStatement(sql3);
            pst3.executeUpdate(sql3);
            pst3.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    private Button Delete2;

    @FXML
    private Button LaonFormButton;

    @FXML
    private Button ReturnFormButton;

    @FXML
    private Button ReturnListButton;

    @FXML
    private Button backstupage;

    @FXML
    void backstupageOnAction(ActionEvent event) {

    }

    @FXML
    void switchtoLaonForm(ActionEvent event) {

    }

    public void switchtoLoanList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Laonlist.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void ConnectToStudent() {

    }

    public void ConnectToBook() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
}
