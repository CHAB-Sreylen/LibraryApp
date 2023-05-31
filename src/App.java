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
        Parent root = FXMLLoader.load(getClass().getResource("add_book2.fxml"));
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("Welcome to Library App");
=======

        Parent root = FXMLLoader.load(getClass().getResource("add_book.fxml"));

        stage.initStyle(StageStyle.UNDECORATED);
        // stage.setTitle("Welcome to Library App");
>>>>>>> 6b3d7a99262dc55c701e7a438e827ff7a43b2de4
        stage.setScene(new Scene(root));
        stage.show();
    }

}
