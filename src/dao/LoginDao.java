package dao;
import java.sql.*;

import model.Loginbean;;

public class LoginDao {



public static Loginbean validate(String name,String pass){
//boolean status=false;
Loginbean Login = new Loginbean();
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Brainiacs","admin","test");
//	System.out.println("yyyyy");
	PreparedStatement ps=con.prepareStatement("select * from login where name=? and pass=?");
	ps.setString(1,name);
	ps.setString(2,pass);
	
	ResultSet rs=ps.executeQuery();
	//status=rs.next();
	if (rs.next()) {
		
		Login.setRole(rs.getString("Role"));
		String Roleww=rs.getString("Role");
		
		if(Roleww.equalsIgnoreCase("PATIENT")){
			PreparedStatement preparedStatement = con.
					prepareStatement("select * from patient where email=?");
			preparedStatement.setString(1, name);
			System.out.println();
			ResultSet rsid = preparedStatement.executeQuery();
			
			if (rsid.next()) {
				Login.setlogid(rsid.getInt("userid"));			
			}
			
			
		}
	}
//	
	
}catch(Exception e){System.out.println(e);}

return Login;
}
}
