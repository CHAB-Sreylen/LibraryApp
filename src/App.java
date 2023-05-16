import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("my_categories.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("Welcome to Library App");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }
  
}
