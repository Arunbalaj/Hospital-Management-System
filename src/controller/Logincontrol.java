package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.LoginDao;



public class Logincontrol extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginDao dao;

	    public Logincontrol() {
	        super();
	        dao = new LoginDao();
	    }
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("username");
		String p=request.getParameter("userpass");
  try
  {
		if(LoginDao.validate(n, p) != null){
			System.out.println("Entered");
			String Rooo=LoginDao.validate(n,p).getRole();
			System.out.println(Rooo);
			if(Rooo.equalsIgnoreCase("ADMIN"))
			{
				
			RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
			rd.forward(request,response);
			}
			if(Rooo.equalsIgnoreCase("PATIENT"))
			{
				int id=LoginDao.validate(n,p).getlogid();
				System.out.println("Patient is"+id);
			RequestDispatcher rd=request.getRequestDispatcher("Patienthome.jsp");
			rd.forward(request,response);
			}
			if(Rooo.equalsIgnoreCase("DOCTOR"))
			{
				System.out.println("Doccc");
			RequestDispatcher rd=request.getRequestDispatcher("Docthome.jsp");
			rd.forward(request,response);
			}
			if(Rooo.equalsIgnoreCase("null")){
				
				//JOptionPane.showMessageDialog(null, "Sorry username or password error");
				
				out.print("Sorry username or password error");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request,response);
			}
			}
		else{
			
			//JOptionPane.showMessageDialog(null, "Sorry username or password error");
			
			out.print("Sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("index2.html");
			rd.include(request,response);
		}
  }
  catch(Exception e)
  {
	  RequestDispatcher rd=request.getRequestDispatcher("index2.html");
	  rd.include(request,response);
  }
		
		out.close();
	}

}
