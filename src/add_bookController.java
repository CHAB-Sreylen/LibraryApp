import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class add_bookController {
    private Stage CancelButton;
    private Stage EnterButton;
    private Scene scene;
    private Parent root;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private TextField booktitle;

    @FXML
    private TextField Author;

    @FXML
    private TextField Year;

    @FXML
    private Button Enter;

    public void switchtoListBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
        CancelButton = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        CancelButton.setScene(scene);
        CancelButton.show();
    }

    public void enterbuttonOnAction(ActionEvent event) throws IOException {
        String title = booktitle.getText();
        String author = Author.getText();
        String year = Year.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "");
            pst = con.prepareStatement("INSERT INTO book(title, author, year) value(?,?,?)");
            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, year);
            pst.executeUpdate();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListBook.fxml"));
            root = loader.load();
            EnterButton = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            EnterButton.setScene(scene);
            EnterButton.centerOnScreen();
            EnterButton.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
