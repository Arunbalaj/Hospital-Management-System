package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;
import model.Report;
import util.DbUtil;

public class AppointmentDao
{
	private Connection connection;

public AppointmentDao() {
	connection = DbUtil.getConnection();
}

public void addUser(Appointment user) {
	try {
		
	PreparedStatement preparedStatement = connection.prepareStatement("insert into appointment(doctor,patient,appdate,apptime,descrip,pemail,demail,status) values (?,?,?,?,?,?,?,?)");
		
		preparedStatement.setString(1, user.getdoctor());
		preparedStatement.setString(2, user.getpatient());

		preparedStatement.setString(3, user.getappdate());
		preparedStatement.setString(4, user.getapptime());
		preparedStatement.setString(5, user.getdescrip());
		preparedStatement.setString(6, user.getpemail());
		preparedStatement.setString(7, user.getdemail());
		preparedStatement.setString(8, "WAITING");
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void deleteUser(int userId) {
	try {
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from appointment where appid=?");
		preparedStatement.setInt(1, userId);
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void confirmapp(int userId) {
	try {
		PreparedStatement preparedStatement = connection
				.prepareStatement("update appointment set status=?"+
						"where appid=?");
			preparedStatement.setString(1, "CONFIRMED");
		preparedStatement.setInt(2, userId);
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
}


public void completapp(int userId) {
	try {
		PreparedStatement preparedStatement = connection
				.prepareStatement("update appointment set status=?"+
						"where appid=?");
		
		preparedStatement.setString(1, "COMPLETED");
		preparedStatement.setInt(2, userId);
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//address,phone,qualification,specialization

public void updateUser(Appointment user) {
	try {
		
		PreparedStatement preparedStatement = connection
				.prepareStatement("update appointment set doctor=?, patient=?, appdate=?, apptime=?, descrip=?,pemail=?,demail=?"+
						"where appid=?");
		
		
		
		preparedStatement.setString(1, user.getdoctor());
		preparedStatement.setString(2, user.getpatient());
		preparedStatement.setString(3, user.getappdate());
		preparedStatement.setString(4, user.getapptime());
		preparedStatement.setString(5, user.getdescrip());
		preparedStatement.setString(6, user.getpemail());
		preparedStatement.setString(7, user.getdemail());
		preparedStatement.setInt(8, user.getappid());
		preparedStatement.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public List<Appointment> getAllUsers() {
	List<Appointment> users = new ArrayList<Appointment>();
	try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from appointment");
		while (rs.next()) {
			Appointment user = new Appointment();
			user.setappid(rs.getInt("appid"));
			user.setdoctor(rs.getString("doctor"));
			user.setpatient(rs.getString("patient"));
		
			user.setappdate(rs.getString("appdate"));
			user.setapptime(rs.getString("apptime"));
			user.setdescrip(rs.getString("descrip"));
			user.setpemail(rs.getString("pemail"));
			user.setdemail(rs.getString("demail"));
			user.setstatus(rs.getString("status"));
			users.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return users;
}

public Appointment getUserById(int userId) {
	Appointment user = new Appointment();
	try {
		PreparedStatement preparedStatement = connection.
				prepareStatement("select * from appointment where appid=?");
		preparedStatement.setInt(1, userId);
		System.out.println();
		ResultSet rs = preparedStatement.executeQuery();
		
		if (rs.next()) {
			user.setappid(rs.getInt("appid"));
			user.setdoctor(rs.getString("doctor"));
			user.setpatient(rs.getString("patient"));
		
			user.setappdate(rs.getString("appdate"));
			user.setapptime(rs.getString("apptime"));
			user.setdescrip(rs.getString("descrip"));
			user.setpemail(rs.getString("pemail"));
			user.setdemail(rs.getString("demail"));
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return user;
}



public List<Appointment> getappbyemail2(String demail) {
	List<Appointment> users = new ArrayList<Appointment>();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from appointment where demail=? and status=?");
		preparedStatement.setString(1, demail);
		preparedStatement.setString(2, "CONFIRMED");
		System.out.println("in gee emal");
		ResultSet rs = preparedStatement.executeQuery();
		System.out.println("in gessfe emal");
		while (rs.next()) {
			Appointment user = new Appointment();
			user.setappid(rs.getInt("appid"));
			user.setdoctor(rs.getString("doctor"));
			user.setpatient(rs.getString("patient"));
		
			user.setappdate(rs.getString("appdate"));
			user.setapptime(rs.getString("apptime"));
			user.setdescrip(rs.getString("descrip"));
			user.setpemail(rs.getString("pemail"));
			user.setdemail(rs.getString("demail"));
			user.setstatus(rs.getString("status"));
			users.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println(users);
	return users;
}




public List<Appointment> getappbypatemail(String demail) {
	List<Appointment> users = new ArrayList<Appointment>();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from appointment where pemail=?");
		preparedStatement.setString(1, demail);
		System.out.println("in gee emal");
		ResultSet rs = preparedStatement.executeQuery();
		System.out.println("in gessfe emal");
		while (rs.next()) {
			Appointment user = new Appointment();
			user.setappid(rs.getInt("appid"));
			user.setdoctor(rs.getString("doctor"));
			user.setpatient(rs.getString("patient"));
		
			user.setappdate(rs.getString("appdate"));
			user.setapptime(rs.getString("apptime"));
			user.setdescrip(rs.getString("descrip"));
			user.setpemail(rs.getString("pemail"));
			user.setdemail(rs.getString("demail"));
			user.setstatus(rs.getString("status"));
			users.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println(users);
	return users;
}

public List<Report> getrepfrpat(String email) {
	List<Report> users = new ArrayList<Report>();
	try {
		PreparedStatement preparedStatement = connection.
				prepareStatement("select * from report where pemail=?");
		preparedStatement.setString(1, email);
		System.out.println();
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Report user = new Report();
			user.setrepid(rs.getInt("repid"));
			user.setdate(rs.getString("date"));
			user.setmonth(rs.getString("month"));
		
			user.setamount(rs.getString("amount"));
			user.setpatient(rs.getString("patient"));
			user.setpresc(rs.getString("presc"));
			user.setpemail(rs.getString("pemail"));
			user.setdemail(rs.getString("demail"));
			users.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return users;
}
public Appointment getappbyemail(String demail) {
	System.out.println("in byb emal");
	Appointment user = new Appointment();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from appointment where demail=?");
		preparedStatement.setString(1, demail);
		System.out.println("insi");
		ResultSet rs = preparedStatement.executeQuery();
		System.out.println("qqq");
		if (rs.next()) {
			user.setappid(rs.getInt("appid"));
			user.setdoctor(rs.getString("doctor"));
			user.setpatient(rs.getString("patient"));
		
			user.setappdate(rs.getString("appdate"));
			user.setapptime(rs.getString("apptime"));
			user.setdescrip(rs.getString("descrip"));
			user.setpemail(rs.getString("pemail"));
			user.setdemail(rs.getString("demail"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println(user);
	return user;
}

}