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
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Welcome to Library App");
        stage.setScene(new Scene(root, 1200, 800));
=======

        Parent root = FXMLLoader.load(getClass().getResource("my_categories.fxml"));

        stage.setTitle("Welcome to Library App");
        stage.setScene(new Scene(root));
>>>>>>> 1ebe5bf3387854453b0d62fb08a5aec04e2ef1e3
        stage.show();
    }
}
