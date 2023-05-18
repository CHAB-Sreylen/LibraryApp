import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class controller {
    @FXML
    private Label LoginwordButton;
    @FXML
    private  TextField usernametextField;
    @FXML
    private PasswordField passwordtextField;

    public void LogindButtonOnAction(ActionEvent e){
        if (usernametextField.getText().isBlank()== false && passwordtextField.getText().isBlank() == false ){
            LoginwordButton.setText("Please try again!");
        }else{
            LoginwordButton.setText("Please enter username and password!");
        }
    }
    @FXML
    private Button CancelButton;
    public void CancelButtonOnAction(ActionEvent e){
         Stage stage = (Stage) CancelButton.getScene().getWindow();
         stage.close();
    }
  
}