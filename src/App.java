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

        // stage.initStyle(StageStyle.UNDECORATED);

<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("UpdateBook.fxml"));
=======
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
>>>>>>> 4d02377d07fc228620e1016657629c914738df4b
>>>>>>> f57da2da930aee7f7646641e55074e725294927e

        // stage.initStyle(StageStyle.UNDECORATED);
        // stage.setTitle("Welcome to Library App");

        stage.setScene(new Scene(root));
        stage.show();
    }

}
