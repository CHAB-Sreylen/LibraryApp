
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.ToggleButton;
// import javafx.scene.control.Label;
// import javafx.scene.control.Labeled;
// import javafx.scene.control.TextField;
// import javafx.scene.control.PasswordField;
// import javafx.stage.Stage;

// public class RegisterBook_Controller {
//     @FXML
//     private ToggleButton borrow;

//     @FXML
//     void toggleButton(ActionEvent event){
//         if(event.getSource() == borrow){
//             Labeled text;
//             text.setText("borrow");
//         }
    
//     }
   
// }
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.ToggleButton;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;

// public class RegisterBook_Controller extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         ToggleButton toggleButton = new ToggleButton("Borrow");
        
//         toggleButton.setOnAction(event -> {
//             if (toggleButton.isSelected()) {
//                 System.out.println("Button is toggled on");
//             } else {
//                 System.out.println("Button is toggled off");
//             }
//         });
        
//         StackPane root = new StackPane();
//         root.getChildren().add(toggleButton);
        
//         Scene scene = new Scene(root, 200, 150);
//         primaryStage.setTitle("Toggle Button Example");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
// // import javafx.event.ActionEvent;
// // import javafx.fxml.FXML;
// // //import javafx.scene.control.Button;
// // import javafx.scene.control.Label;
// // import javafx.scene.control.TextField;

// // //import javafx.scene.control.PasswordField;
// // //import javafx.stage.Stage;

// // public class RegisterBook_Controller {
// //     @FXML
// //     private Label word;
   
// //     @FXML
// //     private TextField borrowword;
// //     @FXML
// //     private TextField borrowword1;
   
    
    
// //     public void borrowbutton1OnAction(ActionEvent e){
// //         if (borrowword1.getText().isBlank()== false && borrowword.getText().isBlank()== false ){
// //             word.setText("Please try again!");
// //     }
// // }
// //     // @FXML
// //     // private Button CancelButton;
// //     // public void CancelButtonOnAction(ActionEvent e){
// //     //      Stage stage = (Stage) CancelButton.getScene().getWindow();
// //     //      stage.close();
// //     // }
  
// // }