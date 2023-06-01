import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ListBookController {
    @FXML
    void AddBook(ActionEvent event) {
        System.out.println("hello");
    }

    @FXML
    void RegisterBook(ActionEvent event) {
        System.out.println("hello");
    }

    @FXML
    void UpdateBook(ActionEvent event) {
        System.out.println("hello");
    }
    @FXML
    private Button registernewstu;
    public void registernewstuOnAction(ActionEvent event)throws IOException{
        Object root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();
    }

}
