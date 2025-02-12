
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginpage_controller implements Initializable {

    public void initialize(URL url, ResourceBundle resourceBundle) {// initialize the table value

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

    /// * Login_page_controller *///

    public void LogindButtonOnAction(ActionEvent event) throws IOException, ClassNotFoundException {
        String userName = usernametextField.getText();
        String password = passwordtextField.getText();
        if (userName.equals("") && password.equals("")) {
            LoginwordButton.setText("Please enter username and password.");
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:/library", "root", "");
                pst = con.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery(); // reset.
                if (rs.next()) {
                    pst = con.prepareStatement("select id,username,password from user");
                    JOptionPane.showMessageDialog(null, "login success welcome " + userName);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ListBook.fxml"));
                    root = loader.load();
                    ListBookController sdc = loader.getController();
                    sdc.displayUserName(userName);
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();

                    // FXMLLoader loader = new FXMLLoader(getClass().getResource("Listbook.fxml"));
                    // root = loader.load();
                    // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    // scene = new Scene(root);
                    // stage.setScene(scene);
                    // stage.centerOnScreen();
                    // stage.show();
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed");
                    usernametextField.setText("");
                    passwordtextField.setText("");
                    usernametextField.requestFocus();
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }

    // @FXML
    // private Circle addbookbutton;
    // public void addbookbuttonOnAction(ActionEvent event)throws IOException{
    // root = FXMLLoader.load(getClass().getResource("add_book.fxml"));
    // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // scene = new Scene(root);
    // stage.setScene(scene);
    // stage.show();
    // }
    public void borrowbutton1OnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Borrow_link.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // @FXML
    // private Button new_studentbutton;
    // public void new_studentbuttonOnAction(ActionEvent event)throws IOException{
    // root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
    // stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // scene = new Scene(root);
    // stage.setScene(scene);
    // stage.show();
    // }
    @FXML
    private Button CancelButton;

    public void CancelButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button registernewstu;

    public void registernewstuOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
