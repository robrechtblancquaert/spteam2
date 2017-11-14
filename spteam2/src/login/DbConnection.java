package login;

import java.sql.*;



public class DbConnection {

	
	public static  Connection Connect() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SoftwareProject2","root","");	
			return conn;
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
			
		}
		
		
	}
	/*public static void main(String[] ags) {
		try {
		/*
		 *String url ="";
		String user="";
		String password ="";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
		
		} catch (ClassNotFoundException | SQLException ex) {
			
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null,ex);
		}
		return null;
		
			
			
		
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/SoftwareProject2","root","");	
			
			Statement stm =  myCon.createStatement();
			ResultSet res = stm.executeQuery("SELECT * FROM users");
			while(res.next()) {
				
				System.out.println(res.getString("username")+ ","+ res.getString("email"));
			}
			
		}catch(Exception exc) {
		
		exc.printStackTrace();
		
		
	}*/
	
	}
