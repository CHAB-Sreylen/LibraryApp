import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controller {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginButtonlLabel;

    public void loginButtonlLabelOnAction(ActionEvent e){
        loginButtonlLabel.setText("You did not have account");
    }
    public void cancelButtonOnAction(ActionEvent e){
         Stage stage = (Stage) cancelButton.getScene().getWindow();
         stage.close();

    }
  
}