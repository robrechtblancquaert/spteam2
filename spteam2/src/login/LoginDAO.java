package login;

import java.sql.*;

public class LoginDAO {
	
	
	
	Connection connection;
	public LoginDAO() {
		
		connection = DbConnection.Connect();
		
		if(connection == null) {
			System.out.println("Connection not successful");
			System.exit(1);
			
		}
	}
	public boolean isConnected(){
	
		try {
			return	!connection.isClosed();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	public boolean isLogin(String user , String pass) throws SQLException {
		PreparedStatement ps = null;
		ResultSet  rs = null;
		String query = "Select * from users WHERE username = ? AND  password = ?";
	
		try 
		{
			ps = connection.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			
			
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
				
			}else {
				
				return false;
			}
			
		}
		catch(Exception e) {
			return false;
		}
		finally {
			ps.close();
			rs.close();
		}
	}
}
