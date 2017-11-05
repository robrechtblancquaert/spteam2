package DatabaseConnection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/phpmyadmin","root","");
			System.out.println("Database is connected!");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Do not connect to DB - Error: " +e);
		}
	}

}
