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

public class ReturnFormController {
    private Stage CancelButton;
    private Scene scene;

    public void switchtoReturnList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Return_list.fxml"));
        CancelButton = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        CancelButton.setScene(scene);
        CancelButton.show();
    }
}
