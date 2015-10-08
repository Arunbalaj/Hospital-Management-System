package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Report;
import dao.ReportDao;

public class Reportct extends HttpServlet  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String EDIT = "/reppadmin.jsp";
	    private static String INSERT = "/reppadminadd.jsp";
	    private static String LIST = "/listreppadmin.jsp";
	    private ReportDao dao;

	    public Reportct() {
	        super();
	        dao = new ReportDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            dao.deleteUser(userId);
	            forward = LIST;
	            request.setAttribute("users", dao.getAllUsers());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = EDIT;
	            int userId = Integer.parseInt(request.getParameter("userId"));
	            Report user = dao.getUserById(userId);
	            request.setAttribute("user", user);
	        } else if (action.equalsIgnoreCase("list")){
	            forward = LIST;
	            request.setAttribute("users", dao.getAllUsers());
	        }
	        else if (action.equalsIgnoreCase("listmnt")){
	            forward = LIST;
	            String month = request.getParameter("mnth");
	            request.setAttribute("users", dao.getAllreportsbymonth(month));
	        
	        }
	        else {
	            forward = INSERT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	Report user = new Report();
	        user.setdate(request.getParameter("repdte"));
	        user.setmonth(request.getParameter("rpmnth"));
	      
	        user.setamount(request.getParameter("rpamt"));

	        user.setpatient(request.getParameter("rppt"));
	        user.setpresc(request.getParameter("rppres"));
	        user.setpemail(request.getParameter("rppemail"));
	        user.setdemail(request.getParameter("rpdemail"));
	    	System.out.println("Added");
	        String userid = request.getParameter("userid");
	        if(userid == null || userid.isEmpty())
	        {
	            dao.addUser(user);
	        }
	        else
	        {
	            user.setrepid(Integer.parseInt(userid));
	            dao.updateUser(user);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LIST);
	        request.setAttribute("users", dao.getAllUsers());
	        view.forward(request, response);
	    }
	}
