import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthToolTipUI;

import samples.db.InsertData;

public class test {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost/book";
        String user = "root";
        String password = "";

        try{
            
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("data insert");

        }catch(SQLException ex){
            System.out.println("fail");
        }
    }
}
