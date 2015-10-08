package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Report;
import util.DbUtil;

public class ReportDao {
	private Connection connection;

	public ReportDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(Report user) {
		try {
			
		PreparedStatement preparedStatement = connection.prepareStatement("insert into report(date,month,amount,patient,presc,pemail,demail) values (?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, user.getdate());
			preparedStatement.setString(2, user.getmonth());
			preparedStatement.setString(3, user.getamount());
			preparedStatement.setString(4, user.getpatient());
			preparedStatement.setString(5, user.getpresc());
			preparedStatement.setString(6, user.getpemail());
			preparedStatement.setString(7, user.getdemail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from report where repid=?");
			
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//address,phone,qualification,specialization

	public void updateUser(Report user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("update report set date=?, month=?, amount=?, patient=?,presc=?,pemail=?,demail=?"+
							"where repid=?");
			
			
			
			preparedStatement.setString(1, user.getdate());
			preparedStatement.setString(2, user.getmonth());
			preparedStatement.setString(3, user.getamount());
			preparedStatement.setString(4, user.getpatient());
			preparedStatement.setString(5, user.getpresc());
			preparedStatement.setString(6, user.getpemail());
			preparedStatement.setString(7, user.getdemail());
			preparedStatement.setInt(8, user.getrepid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Report> getAllUsers() {
		List<Report> users = new ArrayList<Report>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from report");
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
	
	public List<Report> getAllreportsbymonth(String month) {
		List<Report> users = new ArrayList<Report>();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from report where month=?");
			preparedStatement.setString(1, month);
			System.out.println();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Report user = new Report();
				user.setrepid(rs.getInt("repid"));
				user.setdate(rs.getString("date"));
				user.setmonth(rs.getString("month"));
			
				user.setamount(rs.getString("amount"));
				user.setpatient(rs.getString("patient"));
				user.setpemail(rs.getString("pemail"));
				user.setdemail(rs.getString("demail"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	public Report getUserById(int userId) {
		Report user = new Report();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from report where repid=?");
			preparedStatement.setInt(1, userId);
			System.out.println();
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setrepid(rs.getInt("repid"));
				user.setdate(rs.getString("date"));
				user.setmonth(rs.getString("month"));
			
				user.setamount(rs.getString("amount"));
				user.setpatient(rs.getString("patient"));
				user.setpresc(rs.getString("presc"));
				user.setpemail(rs.getString("pemail"));
				user.setdemail(rs.getString("demail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	}