package controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patient;
import dao.PatientDao;

public class Patientregs extends HttpServlet  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String EDIT = "/patientregis.jsp";
	    private static String INSERT = "/patientregis.jsp";
	    private static String LIST_USER = "/index.html";
	    private PatientDao dao;

	    public Patientregs() {
	        super();
	        dao = new PatientDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            dao.deleteUser(userId,"");
	            forward = LIST_USER;
	            request.setAttribute("users", dao.getAllUsers());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = EDIT;
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            Patient user = dao.getUserById(userId);
	            request.setAttribute("user", user);
	        } else if (action.equalsIgnoreCase("listUser")){
	            forward = LIST_USER;
	            request.setAttribute("users", dao.getAllUsers());
	        } else {
	            forward = INSERT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	Patient user = new Patient();
	        user.setFirstName(request.getParameter("firstName"));
	        user.setLastName(request.getParameter("lastName"));
	        try {
	            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
	            user.setDob(dob);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        user.setEmail(request.getParameter("email"));

	        user.setName(request.getParameter("email"));
	        user.setPass(request.getParameter("pass"));
	        
	        user.setaddress(request.getParameter("uadd"));
	        user.setphone(request.getParameter("uphone"));
	        user.setdescription(request.getParameter("pdes"));
	        user.setsex(request.getParameter("psex"));
	       
	    	System.out.println("Added");
	        String userid = request.getParameter("userid");
	        if(userid == null || userid.isEmpty())
	        {
	            dao.addUser(user);
	        }
	        else
	        {
	            user.setUserid(Integer.parseInt(userid));
	            dao.updateUser(user);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
	        request.setAttribute("users", dao.getAllUsers());
	        view.forward(request, response);
	    }
	}