package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import model.Doctor;
import util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(Doctor user) {
		try {
			PreparedStatement ps = connection.prepareStatement("insert into login(name,pass,Role) values (?, ?,?)");
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into doctor(firstname,lastname,dob,email,address,phone,qualification,specialization) values (?, ?, ?, ?,?,?,?,? )");
			ps.setString(1, user.getName());
			ps.setString(2,user.getPass());
			ps.setString(3,"DOCTOR");
			System.out.println("Excc");
			ps.executeUpdate();
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getaddress());
			preparedStatement.setString(6, user.getphone());
			preparedStatement.setString(7, user.getqualification());
			preparedStatement.setString(8, user.getspecialization());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId,String email) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from doctor where userid=?");
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
	
	public void updateUser(Doctor user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update doctor set firstname=?, lastname=?, dob=?, email=?, address=?, phone=?, qualification=?, specialization=?"+
							"where userid=?");
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getaddress());
			preparedStatement.setString(6, user.getphone());
			preparedStatement.setString(7, user.getqualification());			
		   preparedStatement.setString(8, user.getspecialization());
			preparedStatement.setInt(9, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Doctor> getAllUsers() {
		List<Doctor> users = new ArrayList<Doctor>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from doctor");
			while (rs.next()) {
				Doctor user = new Doctor();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setaddress(rs.getString("address"));
				user.setphone(rs.getString("phone"));
				user.setqualification(rs.getString("qualification"));
				user.setspecialization(rs.getString("specialization"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public Doctor getUserById(int userId) {
		Doctor user = new Doctor();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from doctor where userid=?");
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
				user.setqualification(rs.getString("qualification"));
				user.setspecialization(rs.getString("specialization"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public Doctor getUserByemail(String email) {
		Doctor user = new Doctor();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from doctor where email=?");
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
				user.setqualification(rs.getString("qualification"));
				user.setspecialization(rs.getString("specialization"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
}
