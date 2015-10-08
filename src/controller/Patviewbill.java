package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Report;
import dao.ReportDao;

public class Patviewbill extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String EDIT = "/PatientBillView.jsp";
	    private static String INSERT = "/Patienthome.jsp";
	    private static String LIST = "/PatientBillView.jsp";
	    private ReportDao dao;

	    public Patviewbill() {
	        super();
	        dao = new ReportDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	       if (action.equalsIgnoreCase("edit")){
	    
	            String email = request.getParameter("email");
	            forward = LIST;
	            request.setAttribute("users", dao.getrepfrpat(email));
	           } else if (action.equalsIgnoreCase("list")){
	            forward = LIST;
	            request.setAttribute("users", dao.getAllUsers());
	        }
	      
	        else {
	            forward = INSERT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	}