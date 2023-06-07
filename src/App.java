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

<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
=======
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("LaonForm.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
>>>>>>> 8d6a6dbd85992e3e3f17361bb15748560b4e1ab9
>>>>>>> ab705553eee05591f90284a0fade0bdf1fbd9d9d

        // stage.initStyle(StageStyle.UNDECORATED);
        // stage.setTitle("Welcome to Library App");

        stage.setScene(new Scene(root));
        stage.show();
    }

}
