<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" />
    	 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.3.min.js"></script>
		
		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	   <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" />
        <script src="http://code.angularjs.org/angular-1.0.1.min.js"></script>
       
    <style>
    
</style>
 <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

     <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
 
<script>
  $(function() {
	  $('#rpmnth').val("<c:out value="${user.month}"/>");
  	 $( "#dob" ).datepicker({
      changeMonth: true,
      changeYear: true,
      showButtonPanel: true,
      showOn: 'both'
    });
   
  });
  </script>

</head>
<body>
<div class="container">
  <div class="navigation"> 
	   <a href="Admin.jsp" title="Home">Home</a> 
	  <a href="UserController?action=listUser" title="Doctors">Doctors</a> 
	  <a href="Patientcntrl?action=listUser"  title="Patients">Patients</a> 
	  <a href="Appointmentct?action=list" title="Apointments">Appointments</a> 
	  <a href="Reportct?action=list"title="Contact">Report</a> 
	    <a href="Logincntl?action=list" title="Contact">Manage_Logins</a> 
	  <a href="index.html" title="Contact">Logout</a> 
  </div>
  <div class="logo"> <b>KMC Hospital</b>  </div>
  <div class="image"></div>
  <div class="leftcontent">
    <h3>Edit Bill Details</h3>
    <br>
   

    <form method="POST" action='Reportct' name="frmAddUser">
   &nbsp&nbsp&nbsp&nbsp&nbspReport ID :&nbsp<input type="text" readonly="readonly" name="userid"
            value="<c:out value="${user.repid}" />" /> <br /><br /> 
       
        Report Date :&nbsp <input
            type="text" name="repdte" id="dob"  value="<c:out value="${user.date}"/>"  /> 
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Report Month : 
      
       <select name="rpmnth" id="rpmnth">
    <option value="January">January</option>
    <option value="February">February</option>
    <option value="March">March</option>
    <option value="April">April</option>
    <option value="May">May</option>
    <option value="June">June</option>
    <option value="July">July</option>
    <option value="August">August</option>
    <option value="September">September</option>
    <option value="October">October</option>
    <option value="November">November</option>
    <option value="December">December</option>
</select> <br /> <br />
        Patient Name:
        <input type="text" name="rppt"  value="<c:out value="${user.patient}"/>" /> 
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPatient Email:
        <input type="email" name="rppemail"  value="<c:out value="${user.pemail}"/>" />  <br /> <br />
          Doctor Email:
        <input type="email" name="rpdemail"  value="<c:out value="${user.demail}"/>" /> 
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
          Total Bill:&nbsp<input
            type="text" name="rpamt"  value="<c:out value="${user.amount}"/>" />  <br /> <br />
        
           &nbsp&nbspPrescription:<textarea rows="2"  cols="22" name="rppres"  ><c:out value="${user.presc}"/></textarea>
         &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        
            <input type="submit" value="Submit" />
    </form>
    <div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
    
    </div>
    </div>
</body>
</html>