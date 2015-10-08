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

import model.Loginbean;
import dao.LoginmanageDao;

public class Logincntl extends HttpServlet  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	    private static String LIST = "/listlogin.jsp";
	    private LoginmanageDao dao;

	    public Logincntl() {
	        super();
	        dao = new LoginmanageDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            String name = request.getParameter("name");
	            dao.deleteUser(name);
	            forward = LIST;
	          
	            request.setAttribute("users", dao.getAllUsers());    
	        } else if (action.equalsIgnoreCase("list")){
	            forward = LIST;
	            request.setAttribute("users", dao.getAllUsers());
	        } 

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	}