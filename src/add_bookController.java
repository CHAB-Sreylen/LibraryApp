import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class add_bookController {
    private Stage AddButton;
    private Scene scene;
    //private Parent root;
    public void switchtoAddBook2(ActionEvent event) throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("add_book2.fxml"));
        AddButton = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        AddButton.setScene(scene);
        AddButton.show();   
    }
    
}
