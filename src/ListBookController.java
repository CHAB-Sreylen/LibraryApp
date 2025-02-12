import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

public class ListBookController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int myIndex, id;
    String title ,author, Year;

    @FXML
    private TableColumn<Book, String> Authorcolumn;

    @FXML
    private TableColumn<Book, String> BIDcolumn;

    @FXML
    private TableColumn<Book, String> Titlecolumn;

    @FXML
    private TableColumn<Book, String> year;

    @FXML
    private TableView<Book> table;

    @FXML
    private Label Name;

    @FXML
    void AddBook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("add_book2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void RegisterBook(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("re2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        System.out.println("Hello world!");

    }

    @FXML
    void UpdateBook(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Update_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        System.out.println("Hello world!");

    }

    public void displayUserName(String userName) {
        Name.setText(userName);
    }

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            System.out.println("bzip2");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Table(){
        Connect();
        ObservableList<Book> books = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select id,title,author,year from book");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    Book bk = new Book();
                    bk.setid(rs.getString("id"));
                    bk.settitle(rs.getString("title"));
                    bk.setauthor(rs.getString("author"));
                    // System.out.println(rs.getString("year"));
                    bk.setyear(rs.getString("year"));

                    books.add(bk);
                }
            }
            table.setItems(books);
            BIDcolumn.setCellValueFactory(f -> f.getValue().idProperty());
            Titlecolumn.setCellValueFactory(f -> f.getValue().titleProperty());
            Authorcolumn.setCellValueFactory(f -> f.getValue().authorProperty());
            year.setCellValueFactory(f -> f.getValue().yearProperty());

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        table.setRowFactory(tv -> {
            TableRow<Book> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))  {

                    myIndex = table.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));
                    title = String.valueOf(table.getItems().get(myIndex).gettitle());
                    author = (String.valueOf(table.getItems().get(myIndex).getauthor()));
                     Year = (String.valueOf(table.getItems().get(myIndex).getyear()));
                    System.out.println(id+title+author+Year);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Update_form.fxml"));
                    try {
                        root = loader.load();
                        UpdateBookController sdc = loader.getController();
                        sdc.getIDBook(id, title, author, Year);
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    // FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateBook.fxml"));
                    // // root = loader.load();
                    // UpdateBookController sdc = loader.getController();
                    // sdc.getIDBook(id);
                    // txtBookTitle.setText(table.getItems().get(myIndex).getBookTitle());
                    // txtBookQuantity.setText(table.getItems().get(myIndex).getQuantity());
                    // txtBookCategory.setText(table.getItems().get(myIndex).getCategory());

                } else {
                    table.getSelectionModel().clearSelection();
                    // txtBookTitle.setText("");
                    // txtBookQuantity.setText("");
                    // txtBookCategory.setText("");
                }
            });
            return myRow;
        });

    }

    @FXML
    void delete(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();

        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));

        try {
            pst = con.prepareStatement("delete from book where id = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Book Registation");

            alert.setHeaderText("Book Registation");
            alert.setContentText("Deleted!");

            alert.showAndWait();
            Table();
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        Table();
        // RegisterBook
    }

    @FXML
    private Button stu_list;

    public void stu_listOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Student.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // @FXML
    // private Button registernewstu;

    // public void registernewstuOnAction(ActionEvent event) throws IOException {
    // Object root = FXMLLoader.load(getClass().getResource("Register_form.fxml"));
    // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // Scene scene = new Scene((Parent) root);
    // stage.setScene(scene);
    // stage.show();
    // }

    @FXML
    private Button loanandreturn;

    public void loanandreturnOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void LogoutOnAction(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to logout");

        // Add buttons to the alert dialog
        ButtonType buttonTypeOk = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);

        // Wait for the user's response
        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeOk) {
                System.out.println("User clicked OK");
                try {
                    root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show(); 
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (response == buttonTypeCancel) {
                System.out.println("User clicked Cancel");
                alert.close();
            }
        });
    }

}
