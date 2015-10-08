package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appointment;
import dao.AppointmentDao;

public class DoctorAppoint  extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String EDIT = "/Doctappoint.jsp";
	private static String LIST = "/listappointadmin.jsp";
	    private static String HOME= "/Docthome.jsp";
	    private AppointmentDao dao;

	    public DoctorAppoint() {
	        super();
	        dao = new AppointmentDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");
	        if (action.equalsIgnoreCase("delete")){
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            dao.deleteUser(userId);
	            forward = HOME;
	            
	        } 
	        else if (action.equalsIgnoreCase("complete")){
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            String email = request.getParameter("email");
	            dao.completapp(userId);
	            forward = HOME; 
	            forward = EDIT;
	            request.setAttribute("users", dao.getappbyemail2(email));
	         
        }
	        else if (action.equalsIgnoreCase("edit")){
	            String email = request.getParameter("email");
	            forward = EDIT;
	            request.setAttribute("users", dao.getappbyemail2(email));
	        }
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	}