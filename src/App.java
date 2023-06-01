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
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("Welcome to Library App");

        // stage.setTitle("Welcome to Library App");
        

        stage.initStyle(StageStyle.UNDECORATED);
=======

        Parent root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));

        // stage.initStyle(StageStyle.UNDECORATED);
        // stage.setTitle("Welcome to Library App");
>>>>>>> 768e92817a2b1f507a4ad9d7812f7b225437c643

        stage.setScene(new Scene(root));
        stage.show();
    }

}
