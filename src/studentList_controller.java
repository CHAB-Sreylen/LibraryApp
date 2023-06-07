
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
            private Button delete1;
        
            @FXML
            private TableColumn<StudentList,String > Departmentcolumn;

            @FXML
            private TableColumn<StudentList,String > Fullnamecolumn;

            @FXML
            private TableColumn<StudentList,String > IDcolumn;

            @FXML
            private TableColumn<StudentList, String> usernamecolumn;

            // @FXML
            // private Button back;

            @FXML
            private TableColumn<StudentList, String> passwordcolumn;

            @FXML
            private TableColumn<StudentList, String> schoolcolumn;
        
            @FXML
            private TableView<StudentList> table;

        
            public void initialize(URL url, ResourceBundle resourceBundle) {// initialize the table value
                Connect();
                Table();
            }
            public void Connect() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
                    System.out.println("Good girl!");
                } catch (Exception e) {
                    e.printStackTrace();
                }        
            }
            public void Table() {
                Connect();
                ObservableList<StudentList> student = FXCollections.observableArrayList();
                try {
                    pst = con.prepareStatement("select id,fullname,username,password,school,department from student");
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
        
                            StudentList StuList = new StudentList();
                            StuList.setid(rs.getString("id"));
                            StuList.setfullname(rs.getString("fullname"));
                            StuList.setusername(rs.getString("username"));
                            StuList.setpassword(rs.getString("password"));
                            StuList.setschool(rs.getString("school"));
                            StuList.setdepartment(rs.getString("department"));
                            student.add(StuList);
                        }
                    }
                    table.setItems(student);
                    IDcolumn.setCellValueFactory(f -> f.getValue().idProperty());
                    Fullnamecolumn.setCellValueFactory(f -> f.getValue().fullnameProperty());
                    usernamecolumn.setCellValueFactory(f -> f.getValue().usernameProperty());
                    Departmentcolumn.setCellValueFactory(f -> f.getValue().departmentProperty());
                    schoolcolumn.setCellValueFactory(f -> f.getValue().schoolProperty());
                    passwordcolumn.setCellValueFactory(f -> f.getValue().passwordProperty());
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                table.setRowFactory(tv -> {
                    TableRow<StudentList> myRow = new TableRow<>();
                    myRow.setOnMouseClicked(event -> {
                        if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
        
                            myIndex = table.getSelectionModel().getSelectedIndex();
                            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));
        
                        } else {
                            table.getSelectionModel().clearSelection();
                        }
                    });
                    return myRow;
                });
        
            }
            @FXML
            void delete1(ActionEvent event) {
            myIndex = table.getSelectionModel().getSelectedIndex();

            id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));

                try {
                pst = con.prepareStatement("delete from student where id = ? ");
                pst.setInt(1, id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Students List");

                alert.setHeaderText("Students List");
                alert.setContentText("Deleted!");

                alert.showAndWait();
                Table();
                } catch (SQLException ex) {
                System.out.println("error");
                }
            }
            


            // @FXML
            // private Button stu_list;
        
            // public void stu_listOnAction(ActionEvent event) throws IOException {
            //     Object root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
            //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //     Scene scene = new Scene((Parent) root);
            //     stage.setScene(scene);
            //     stage.show();
            // }
        
            // @FXML
            // private Button registernewstu;
        
            // public void registernewstuOnAction(ActionEvent event) throws IOException {
            //     Object root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
            //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //     Scene scene = new Scene((Parent) root);
            //     stage.setScene(scene);
            //     stage.show();
            // }
            @FXML
            private Button addStudent;

            public void addStudentOnAction(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }

            @FXML
            private Button backstupage;

            public void backstupageOnAction(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("Listbook.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }
            


            // @Override
            // public void initialize(URL location, ResourceBundle resources) {
            //     // TODO Auto-generated method stub
            //     throw new UnsupportedOperationException("Unimplemented method 'initialize'");
            // }
}
            
        


