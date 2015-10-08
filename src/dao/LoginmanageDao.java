package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Loginbean;
import util.DbUtil;

public class LoginmanageDao 
{
	private Connection connection;

public LoginmanageDao() {
	connection = DbUtil.getConnection();
}


public void deleteUser(String name) {
	try {
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from login where name=?");
		
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//address,phone,qualification,specialization
public List<Loginbean> getAllUsers() {
	List<Loginbean> users = new ArrayList<Loginbean>();
	try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from login");
		while (rs.next()) {
			Loginbean user = new Loginbean();
		
			user.setName(rs.getString("name"));
			user.setPass(rs.getString("pass"));
			
			user.setRole(rs.getString("Role"));
			
			users.add(user);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return users;
	
}

}

