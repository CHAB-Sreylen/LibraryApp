import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

public class LaonListController implements Initializable {
    
    private static final LoanList LoanList = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int myIndex, id;

    @FXML
    private Button Delete2;

    @FXML
    private Button LaonForm;

    @FXML
    private Button ReturnForm;

    @FXML
    private Button ReturnList;

    @FXML
    private Button back1;
    @FXML
    private TableColumn<LoanList, String> bidcolumn;

    @FXML
    private TableColumn<LoanList, String> bookcolumn;

    @FXML
    private TableColumn<LoanList, String> laondatecolumn;

    @FXML
    private TableColumn<LoanList, String> stu_idcolumn;

    @FXML
    private TableColumn<LoanList, String> stu_namecolumn;

    @FXML
    private TableView<LoanList> table;

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

    public void  Table() {
        Connect();
        ObservableList <LoanList> loanlists = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select id,fullname,bid,booktitle,laondate from borrowlist");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {

                    LoanList loanlist = new LoanList();
                    loanlist.setid(rs.getString("id"));
                    loanlist.setfullname(rs.getString("fullname"));
                    loanlist.setbid(rs.getString("bid"));
                    loanlist.setbooktitle(rs.getString("booktitle"));
                    loanlist.setlaondate(rs.getString("laondate"));
                    loanlists.add(loanlist);
                    System.out.println(""+rs.getString("fullname"));
                }
            }
            table.setItems(loanlists);
            stu_idcolumn.setCellValueFactory(f -> f.getValue().idProperty());
            stu_namecolumn.setCellValueFactory(f -> f.getValue().fullnameProperty());
            bidcolumn.setCellValueFactory(f -> f.getValue().bidProperty());
            bookcolumn.setCellValueFactory(f -> f.getValue().booktitleProperty());
            laondatecolumn.setCellValueFactory(f -> f.getValue().laondateProperty());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        table.setRowFactory(tv -> {
            TableRow<LoanList> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));

                } else {
                    table.getSelectionModel().clearSelection();
                }
            });
            return myRow;
        });
    }
    // private void Table() {
    //     Connect();
    //     ObservableList<LoanList> borrowlist = FXCollections.observableArrayList();
    //     try {
    //         pst = con.prepareStatement("select id,bid,booktitle,laondate from borrowlist");
    //         ResultSet rs = pst.executeQuery();
    //         {
    //             while (rs.next()) {

    //                 LoanList Llist = new LoanList();
    //                 Llist.setid(rs.getString("id"));
    //                 Llist.setfullname(rs.getString("fullname"));
    //                 Llist.setbid(rs.getString("bid"));
    //                 Llist.setbooktitle(rs.getString("booktitle"));
    //                 Llist.setlaondate(rs.getString("laondate"));                   
    //                 borrowlist.add(LoanList);
    //             }
    //         }
    //         table.setItems(borrowlist);
    //         stu_idcolumn.setCellValueFactory(f -> f.getValue().idProperty());
    //         stu_namecolumn.setCellValueFactory(f -> f.getValue().fullnameProperty());
    //         bidcolumn.setCellValueFactory(f -> f.getValue().bidProperty());
    //         bookcolumn.setCellValueFactory(f -> f.getValue().booktitleProperty());
    //         laondatecolumn.setCellValueFactory(f -> f.getValue().laondateProperty());
            
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     }
    //     table.setRowFactory(tv -> {
    //         TableRow<LoanList> myRow = new TableRow<>();
    //         myRow.setOnMouseClicked(event -> {
    //             if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
    //                 myIndex = table.getSelectionModel().getSelectedIndex();

    //              id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getid()));
                    

    //             } else {
    //                 table.getSelectionModel().clearSelection();
    //             }
    //         });
    //         return myRow;
    //     });

    // }
    

    public void back1OnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("ListBook.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    public void LaonFormOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("LaonForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }
    
    public void ReturnFormOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("ReturnForm.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }
    public void ReturnListOnAction(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("Return_list.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }
    // public void switchtoLaonForm(ActionEvent event ) throws IOException{
    //     Parent root = FXMLLoader.load(getClass().getResource("LaonForm.fxml"));
    //     LaonFormButton = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     scene = new Scene(root);
    //     LaonFormButton.setScene(scene);
    //     LaonFormButton.show();
    // }

    // public void ReturnFormOnAction(ActionEvent event) throws IOException {
    //     Object root = FXMLLoader.load(getClass().getResource("ReturnForm.fxml"));
    //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     Scene scene = new Scene((Parent) root);
    //     stage.setScene(scene);
    //     stage.show();

    // }

    // public void ReturnListOnAction(ActionEvent event) throws IOException {
    //     Object root = FXMLLoader.load(getClass().getResource("Return_list.fxml"));
    //     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //     Scene scene = new Scene((Parent) root);
    //     stage.setScene(scene);
    //     stage.show();

    // }


}
