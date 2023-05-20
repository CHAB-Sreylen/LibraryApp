// package samples.db;

// import java.sql.Connection;
// import java.sql.DriverManager;
// public class data_connection_loginpage {
//     public Connection databaselink;

//     public Connection getConnection(){
//         String databaseName = "sreylen";
//         String databaseUser = "";
//         String databasePassword = "";
//         String url = "jdbc:mysql://localhost/" +databaseName;
//         try{
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             databaselink = DriverManager.getConnection(url, databaseUser, databasePassword);
//         } catch (Exception e){
//             e.printStackTrace();
//         }
//         return databaselink;

//     }


    
// }
