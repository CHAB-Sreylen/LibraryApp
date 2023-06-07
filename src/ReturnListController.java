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

public class ReturnListController {
    private Stage LoanListButton;
    private Stage LaonFormButton;
    private Stage ReturnFormButton;
    private Scene scene;

    public void switchtoLoanList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
        LoanListButton = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        LoanListButton.setScene(scene);
        LoanListButton.show();
    }

    public void switchtoLaonForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LaonForm.fxml"));
        LaonFormButton = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        LaonFormButton.setScene(scene);
        LaonFormButton.show();
    }

    public void switchtoReturnForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReturnForm.fxml"));
        ReturnFormButton = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ReturnFormButton.setScene(scene);
        ReturnFormButton.show();
    }
}
