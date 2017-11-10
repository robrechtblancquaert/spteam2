package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.MySQLConnection;

public class MySQLConnect {

	public static void main (String[] args) {
        try {
        	//connectie met de DB
            String url = "jdbc:mysql://dt5.ehb.be/SP2Team2";
            Connection conn = DriverManager.getConnection(url,"SP2Team2","xkpRRfJ");
            Statement stmt = conn.createStatement();
            ResultSet rs;
 
            // Select statement om te zien of het werkt
            rs = stmt.executeQuery("SELECT * FROM COURS WHERE CoursID = 1");
            while ( rs.next() ) {
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                System.out.println(title);
                System.out.println(author);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
	

}
