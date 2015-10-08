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

import model.Appointment;
import dao.AppointmentDao;

public class Appointmentct extends HttpServlet  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String EDIT = "/appointadmin.jsp";
	    private static String INSERT = "/appointadminadd.jsp";
	    private static String LIST = "/listappointadmin.jsp";
	    private AppointmentDao dao;

	    public Appointmentct() {
	        super();
	        dao = new AppointmentDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            dao.deleteUser(userId);
	            forward = LIST;
	            request.setAttribute("users", dao.getAllUsers());    
	        } 
	        else if (action.equalsIgnoreCase("confirm")){
		            int userId = Integer.parseInt(request.getParameter("userId"));
		            dao.confirmapp(userId);
		            forward = LIST;
		            request.setAttribute("users", dao.getAllUsers());    
		         
	        }
	        
	        else if (action.equalsIgnoreCase("edit")){
	        
	            forward = EDIT;
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            Appointment user = dao.getUserById(userId);
	            request.setAttribute("user", user);
	        } else if (action.equalsIgnoreCase("list")){
	            forward = LIST;
	            request.setAttribute("users", dao.getAllUsers());
	        } else {
	            forward = INSERT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	Appointment user = new Appointment();
	        user.setdoctor(request.getParameter("appdoc"));
	        user.setpatient(request.getParameter("apppat"));
	      
	        user.setappdate(request.getParameter("appdate"));

	        user.setapptime(request.getParameter("aptim"));
	        user.setdescrip(request.getParameter("ades"));
	        user.setpemail(request.getParameter("pemail"));
	        user.setdemail(request.getParameter("demail"));
	    	System.out.println("Added");
	        String userid = request.getParameter("userid");
	        if(userid == null || userid.isEmpty())
	        {
	            dao.addUser(user);
	        }
	        else
	        {
	            user.setappid(Integer.parseInt(userid));
	            dao.updateUser(user);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST);
	        request.setAttribute("users", dao.getAllUsers());
	        view.forward(request, response);
	    }
	}
