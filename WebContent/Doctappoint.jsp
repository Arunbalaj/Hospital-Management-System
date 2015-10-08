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
	

	deletedd=function(id) {
		var r=confirm("Are you sure?");
		if(r==true)
			{
	location.href = "DoctorAppoint?action=delete&userId="+id;
			}
	}
	
</script>
 <script language="javascript" type="text/javascript">

  Profile = function() {
  	var email=sessionStorage.getItem('userid');
  location.href = "Docadcntrl?action=edit&email="+email;
  }

  Appoin= function() {
  	var email=sessionStorage.getItem('userid');

  	location.href = "DoctorAppoint?action=edit&email="+email;
  	}
  </script> 
  </head>
  <body>
  <div class="container">
    <div class="navigation"> 
  	  <a href="Docthome.jsp" title="Home">Home</a> 
  	  <a href="javascript:Profile()" title="Doctors">Profile</a> 
  	  <a href="javascript:Appoin()" title="Apointments">Appointments</a> 
	  <a href="index.html" title="Contact">Logout</a> 
  </div>
  <div class="logo"> <b>KMC Hospital</b>  </div>
  <div class="image"></div>
  <div class="leftcontent">
    <h3>Manage Appointments</h3>
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
    <table id="doctor" class="foodisplay2"  data-filter="#filterpe" >
        <thead>
            <tr>
                <th>Appointment Id</th>
                <th>Doctor Name</th>
                <th>Doctor Email</th>
                <th>Patient Name</th>
                <th>Patient Email</th>
                <th>Appointment Date</th>
                <th>Appointment Time</th>
                <th>Purpose of Visit</th>
                <th>Status</th>
                <th colspan=3>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.appid}" /></td>
                    <td><c:out value="${user.doctor}" /></td>
                    <td><c:out value="${user.demail}" /></td>
                    <td><c:out value="${user.patient}" /></td>
                    <td><c:out value="${user.pemail}" /></td>
                    <td><c:out value="${user.appdate}" /></td>
                    <td><c:out value="${user.apptime}" /></td>
                    <td><c:out value="${user.descrip}" /></td>
                     <td><c:out value="${user.status}" /></td>
                    <td><a class='btnDelete' style='font-weight:bold' href="docbilladd.jsp?name=<c:out value="${user.doctor}" />&email=<c:out value="${user.pemail}" />&pname=<c:out value="${user.patient}" />">Add Bill</a></td>
                     <td><a class='btnDelete' style='font-weight:bold' href="DoctorAppoint?action=complete&userId=<c:out value="${user.appid}"/>&email=<c:out value="${user.demail}" />">Mark as Completed</a></td>
                  <td><a class='btnDelete' style='font-weight:bold' href="javascript:deletedd(<c:out value="${user.appid}"/>)">Cancel</a></td>
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
  
   
 
  <div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
    </div>
    
  
  </div>
  <br><center><a href="http://www.dreamtemplate.com" title="Website Templates" target="_blank">Website templates</a></center>
  
</body>
</html>