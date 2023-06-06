
    import java.io.IOException;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.stage.Stage;
    import javafx.scene.Node;
    import java.net.URL;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.*;
    import java.util.ResourceBundle;
    
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.*;
    import javafx.scene.control.Alert;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableRow;
    import javafx.scene.control.TableView;
    import javafx.stage.Stage;
    
    public class studentList_controller implements Initializable {
        private Stage stage;
        private Scene scene;
        private Parent root;
    
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        int myIndex, id;
    
        @FXML
        private TableColumn<StudentList, String> Borrowedcolumn1;

        @FXML
        private TableColumn<StudentList,String > Departmentcolumn;

        @FXML
        private TableColumn<StudentList,String > Fullnamecolumn;

        @FXML
        private TableColumn<StudentList,String > IDcolumn;

        @FXML
        private TableColumn<StudentList, String> titlecolumn;

        @FXML
        private Button back;

        @FXML
        private TableColumn<StudentList, String> laonedcolumn;

        @FXML
        private TableColumn<StudentList, String> schoolcolumn;
    
    
        public void initialize(URL url, ResourceBundle resourceBundle) {// initialize the table value

        }


        @FXML
        private Button stu_list;
    
        public void stu_listOnAction(ActionEvent event) throws IOException {
            Object root = FXMLLoader.load(getClass().getResource("Listbook.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene((Parent) root);
            stage.setScene(scene);
            stage.show();
        }
    
        @FXML
        private Button registernewstu;
    
        public void registernewstuOnAction(ActionEvent event) throws IOException {
            Object root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene((Parent) root);
            stage.setScene(scene);
            stage.show();
        }

        // @Override
        // public void initialize(URL location, ResourceBundle resources) {
        //     // TODO Auto-generated method stub
        //     throw new UnsupportedOperationException("Unimplemented method 'initialize'");
        // }
        
        
    
    
    }
    


