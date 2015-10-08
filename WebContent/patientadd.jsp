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

     <script>
        $(function() {
        	
        	$('#dob').datepicker({
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
    <h3>Add new Patient Details</h3>
    <br>
   

    <form method="POST" action='Patientcntrl'  name="frmAddUser">
   &nbsp&nbsp&nbsp&nbsp&nbsp&nbspUser ID :<input type="text" readonly="readonly" name="userid"
            value="<c:out value="${user.userid}" />" /> <br /><br /> 
        First Name : <input
            type="text" name="firstName"
            value="<c:out value="${user.firstName}" />" /> &nbsp&nbsp&nbsp
       &nbsp&nbsp&nbspLast Name : <input
            type="text" name="lastName"
            value="<c:out value="${user.lastName}" />" /> <br /> <br />
        DOB :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input
            type="text" name="dob" id="dob"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> 
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEmail : <input type="email" name="email"
            value="<c:out value="${user.email}" />" /> <br /> <br />
        &nbsp&nbsp&nbsp&nbsp&nbspAddress:
        <input type="text" name="uadd"  value="<c:out value="${user.address}"/>" /> &nbsp&nbsp&nbsp
         &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPhone:&nbsp<input
            type="text" name="uphone"  value="<c:out value="${user.phone}"/>" /> <br /> <br />
        Description:<input
            type="text" name="pdes" value="<c:out value="${user.description}"/>" />&nbsp&nbsp&nbsp
        
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Sex:&nbsp <select name="psex" id="psex" style="width:130px;"  >
			
	<option value="MALE">Male</option>
	<option value="FEMALE">Female</option>
	<option value="N/A">I wish not to Disclose</option>

	</select>
	<hr>
	<br /> <br />
             <span style="font-weight:bold;">Choose your Password for Login:</span><br><br>
          Email will be your Username<br>
        Password :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input
            type="text" name="pass" /> <br /> <br />
            <input type="submit" value="Submit" />
    </form>
    <div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
    
    </div>
    </div>
</body>
</html>