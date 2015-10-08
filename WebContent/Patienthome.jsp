<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
    <script>
    $(function() {
    	
    	//alert(sessionStorage.getItem('userid'));
    });
    
    </script>   
    
<script language="javascript" type="text/javascript">

Profile = function() {
	var email=sessionStorage.getItem('userid');
location.href = "Patientprof?action=edit&email="+email;
}

Bill= function() {
	var email=sessionStorage.getItem('userid');

	location.href = "Patviewbill?action=edit&email="+email;
	}
	
	
Appoin= function() {
	var email=sessionStorage.getItem('userid');

	location.href = "Appointbypat?action=list&email="+email;
	}
</script> 
</head>
<body>
<div class="container">
  <div class="navigation"> 
	  <a href="Patienthome.jsp" title="Home">Home</a> 
	  <a href="javascript:Profile()" title="Doctors">Profile</a> 
	  
	   <a href="Patientdocv?action=listdoc" title="Apointments">View_Doctors</a> 
	  <a href="index.html" title="Contact">Logout</a> 
  </div>
  <div class="logo"> <b>KMC Hospital</b>  </div>
  <div class="image"></div>
  <div class="leftcontent">
    <h3 style='font-size:2.2em; font-weight:bold;'></h3>
    <br>
     <p><a href="javascript:Profile()"  style='font-size:2.2em; font-weight:bold;'>Manage Profile</a></p>
     <p><a href="Patientdocv?action=listdoc" style='font-size:2.2em; font-weight:bold;'>View all Doctors and Make Appointment</a></p>
        <p><a href="javascript:Bill()" style='font-size:2.2em; font-weight:bold;'>View Your Bill</a></p>
             <p><a href="javascript:Appoin()" style='font-size:2.2em; font-weight:bold;'>Manage your appointments</a></p>
     
<div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
 </div>
   
   
    </div>
    
  
  
  <br><center><a href="http://www.dreamtemplate.com" title="Website Templates" target="_blank">Website templates</a></center>
  
</body>
</html>