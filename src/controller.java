import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class controller {
    @FXML
    private Button CancelButton;
    @FXML
    private Label loginButtonlLabel;

    public void loginButtonlLabelOnAction(ActionEvent e){
        loginButtonlLabel.setText("You did not have account");
    }
    public void CancelButtonOnAction(ActionEvent e){
         Stage stage = (Stage) CancelButton.getScene().getWindow();
         stage.close();

    }
  
}