import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class controller {
    @FXML
    private Button cancelButton;
    public void cancelButtonOnAction(ActionEvent e){
         Stage stage = (Stage) cancelButton.getScene().getWindow();
         stage.close();
 
    }

   
}