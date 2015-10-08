<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" />
    	 <script type="text/javascript" src="//www.google.com/jsapi"></script>
		<script type="text/javascript" src="//code.jquery.com/jquery-1.8.3.min.js"></script>
		
		 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	   <link href="//fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" />
        <script src="//code.angularjs.org/angular-1.0.1.min.js"></script>
     
     
     <link href="css/css/footable.core.css" rel="stylesheet" type="text/css"/>
<link href="css/css/footable.standalone.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
    <script>
        if (!window.jQuery) { document.write('<script src="scripts/js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
    <script src="js/js/footable.js" type="text/javascript"></script>
	<script src="js/js/footable.paginate.js" type="text/javascript"></script>
	<script src="js/js/footable.sort.js" type="text/javascript"></script>
	<script src="js/js/footable.filter.js" type="text/javascript"></script>
       
    <style>
    
</style>
       <script type="text/javascript">
	$(function () {
		var DocTable =$('#doctor').footable();
	
	 $('#clear-filterpe').click(function (e) {
         e.preventDefault();
         $('#filterpe').val('');
         DocTable.trigger('footable_clear_filter');
       });
	 
	 
	});
	
	$(document).ready(function() {
    	var userId = 7;
   
    	
    	$('#idd').val(userId);

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
    <h3>Manage Patients</h3>
    <br>
  <div style="margin-left:73%" >
<input type="text" id="filterpe" placeholder="Search" style="border: 1px solid #848484; 
    -webkit-border-radius: 30px; 
    -moz-border-radius: 30px; 
    border-radius: 30px; 
    outline:0; 
    padding:5px;
    padding-left: 25px;
    background: #F7F778;" />
    <input type="button" value="Clear" id="clear-filterpe" />
</div>
<br>
    <table id="doctor" class="foodisplay2" data-filter="#filterpe" >
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Email</th>
                 <th>Address</th>
                  <th>Phone</th>
                   <th>Description</th>
                    <th>Sex</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.address}" /></td>
                    <td><c:out value="${user.phone}" /></td>
                    <td><c:out value="${user.description}" /></td>
                    <td><c:out value="${user.sex}" /></td>
                    <td><a class='btnDelete' style='font-weight:bold' href="Patientcntrl?action=edit&userId=<c:out value="${user.userid}" />">Update</a></td>
                    <td><a class='btnDelete' style='font-weight:bold' href="Patientcntrl?action=delete&userId=<c:out value="${user.userid}"/>&email=<c:out value="${user.email}" /> ">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
            </tbody>
            <tfoot >
           <tr>
        <td colspan='14'>
        <div align='center' class='pagination'></div>
        </td>
        </tr>
        </tfoot>
        </table>
  
    <p><a href="Patientcntrl?action=insert" style='font-size:2.0em; font-weight:bold;'>Add New Patient Details</a></p>
    
<input type="hidden" id="idd"/>


  


  <div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
    </div>
    
  
  </div>
  <br><center><a href="http://www.dreamtemplate.com" title="Website Templates" target="_blank">Website templates</a></center>
  
</body>
</html>