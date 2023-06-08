import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// import javafx.stage.StageStyle;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // stage.initStyle(StageStyle.UNDECORATED); 3q

        Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));

        // stage.initStyle(StageStyle.UNDECORATED);
        // stage.setTitle("Welcome to Library App");

        stage.setScene(new Scene(root));
        stage.show();
    }

}
