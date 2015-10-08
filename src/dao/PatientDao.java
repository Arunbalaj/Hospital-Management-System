package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import model.Doctor;
import util.DbUtil;

public class PatientDao {
	private Connection connection;

	public PatientDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(Patient user) {
		try {
			
			PreparedStatement ps = connection.prepareStatement("insert into login(name,pass,Role) values (?, ?,?)");

			ps.setString(1, user.getName());
			ps.setString(2,user.getPass());
			ps.setString(3,"PATIENT");
			System.out.println("Excc");
			ps.executeUpdate();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into patient(firstname,lastname,dob,email,address,phone,description,sex) values (?, ?, ?, ?,?,?,?,? )");
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getaddress());
			preparedStatement.setString(6, user.getphone());
			preparedStatement.setString(7, user.getdescription());
			preparedStatement.setString(8, user.getsex());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId,String email) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from patient where userid=?");
			PreparedStatement ps = connection
					.prepareStatement("delete from login where name=?");

			preparedStatement.setInt(1, userId);
			ps.setString(1, email);
			preparedStatement.executeUpdate();
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//address,phone,qualification,specialization
	
	public void updateUser(Patient user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("update patient set firstname=?, lastname=?, dob=?, email=?, address=?, phone=?, description=?, sex=?"+
							"where userid=?");
			
			
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getaddress());
			preparedStatement.setString(6, user.getphone());
			preparedStatement.setString(7, user.getdescription());			
		   preparedStatement.setString(8, user.getsex());
			preparedStatement.setInt(9, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Patient> getAllUsers() {
		List<Patient> users = new ArrayList<Patient>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from patient");
			while (rs.next()) {
				Patient user = new Patient();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setaddress(rs.getString("address"));
				user.setphone(rs.getString("phone"));
				user.setdescription(rs.getString("description"));
				user.setsex(rs.getString("sex"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public Patient getUserById(int userId) {
		Patient user = new Patient();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from patient where userid=?");
			preparedStatement.setInt(1, userId);
			System.out.println();
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setaddress(rs.getString("address"));
				user.setphone(rs.getString("phone"));
				user.setdescription(rs.getString("description"));
				user.setsex(rs.getString("sex"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
	public Patient getUserByemail(String email) {
		Patient user = new Patient();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from patient where email=?");
			preparedStatement.setString(1, email);
			System.out.println();
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setaddress(rs.getString("address"));
				user.setphone(rs.getString("phone"));
				user.setdescription(rs.getString("description"));
				user.setsex(rs.getString("sex"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
	
//	public User getUserByemail(String email) {
//		Patient user = new Patient();
//		try {
//			PreparedStatement preparedStatement = connection.
//					prepareStatement("select * from patient where email=?");
//			preparedStatement.setString(1, email);
//			System.out.println();
//			ResultSet rs = preparedStatement.executeQuery();
//			
//
//			if (rs.next()) {
//				user.setUserid(rs.getInt("userid"));
//				user.setFirstName(rs.getString("firstname"));
//				user.setLastName(rs.getString("lastname"));
//				user.setDob(rs.getDate("dob"));
//				user.setEmail(rs.getString("email"));
//				user.setaddress(rs.getString("address"));
//				user.setphone(rs.getString("phone"));
//				user.setdescription(rs.getString("description"));
//				user.setsex(rs.getString("sex"));
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return user;
//	}
	
}

