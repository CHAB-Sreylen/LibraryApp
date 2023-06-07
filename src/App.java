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
        Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
>>>>>>> b8c727f2ed0a8699dd93c28685d34a7f72705c23

        // stage.initStyle(StageStyle.UNDECORATED);
        // stage.setTitle("Welcome to Library App");

        stage.setScene(new Scene(root));
        stage.show();
    }

}
