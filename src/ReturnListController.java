import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

public class ReturnListController implements Initializable {
    private static final LoanList LoanList = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int myIndex, id;


    @FXML
    private Button LaonForm1;

    @FXML
    private Button ReturnForm1;

    @FXML
    private Button LoanList1;

    @FXML
    private Button back1page;

    @FXML
    private TableColumn<ReturnList, String> bidcolumn;

    @FXML
    private TableColumn<ReturnList, String> bookcolumn;

    @FXML
    private TableColumn<ReturnList, String> laondatecolumn;

    @FXML
    private TableColumn<ReturnList, String> returncolumn;

    @FXML
    private TableColumn<ReturnList, String> stu_idcolumn;

    @FXML
    private TableColumn<ReturnList, String> stu_namecolumn;
    

    @FXML
    private TableView<ReturnList> table;

    public void initialize(URL url, ResourceBundle resourceBundle) {// initialize the table value
        Connect();
        Table();
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            System.out.println("Good boy!");
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }

    private void Table() {
        Connect();
        ObservableList<ReturnList> returningbookliist = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select id,fullname,bid,booktitle,laondate,returningdate from returningbookliist");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    ReturnList Rlist = new ReturnList();
                    Rlist.setid(rs.getString("id"));
                    Rlist.setfullname(rs.getString("fullname"));
                    Rlist.setbid(rs.getString("bid"));
                    Rlist.setbooktitle(rs.getString("booktitle"));
                    Rlist.setlaondate(rs.getString("laondate")); 
                    Rlist.setreturningdate(rs.getString("returningdate"));                   
                    returningbookliist.add(Rlist);
                    System.out.println(""+rs.getString("fullname"));
                }
            }
            table.setItems(returningbookliist);
            stu_idcolumn.setCellValueFactory(f -> f.getValue().idProperty());
            stu_namecolumn.setCellValueFactory(f -> f.getValue().fullnameProperty());
            bidcolumn.setCellValueFactory(f -> f.getValue().bidProperty());
            bookcolumn.setCellValueFactory(f -> f.getValue().booktitleProperty());
            laondatecolumn.setCellValueFactory(f -> f.getValue().laondateProperty());
            returncolumn.setCellValueFactory(f -> f.getValue().returningdateProperty());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        table.setRowFactory(tv -> {
            TableRow<ReturnList> myRow = new TableRow<>();
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
    
    public void back1pageOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void LaonForm1OnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("LaonForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public  void ReturnForm1OnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("ReturnForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void LoanList1OnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("LaonList.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    
}
    

    