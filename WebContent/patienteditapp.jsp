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
 function getFieldFromFields(fieldName) 
 {
 	var p = location.href;
 	var indexStart = p.indexOf(fieldName + '=');
 	var indexEnd = p.indexOf('&', indexStart);
 	var result = null;
 	if(indexStart != -1){
 		if (indexEnd != -1) result = p.substring(indexStart + fieldName.length + 1, indexEnd);
 		else result = p.substring(indexStart + fieldName.length + 1);	
 	}	
 	return result;
 }
    $(document).ready(function() {
    	var docname = getFieldFromFields("name");
    	var email = getFieldFromFields("email");
    	var pemail=sessionStorage.getItem('userid');
    	
		$('#pemail').val(pemail);
});
    </script>  
     <script>
     function populate(selector) {
    	    var select = $(selector);
    	    var hours, minutes, ampm;
    	    for(var i = 420; i <= 1320; i += 15){
    	        hours = Math.floor(i / 60);
    	        minutes = i % 60;
    	        if (minutes < 10){
    	            minutes = '0' + minutes; // adding leading zero
    	        }
    	        ampm = hours % 24 < 12 ? 'AM' : 'PM';
    	        hours = hours % 12;
    	        if (hours === 0){
    	            hours = 12;
    	        }
    	        select.append($('<option></option>')
    	            .attr('value', i)
    	            .text(hours + ':' + minutes + ' ' + ampm)); 
    	    }
    	}

     populate('#psex');
     
     
     $(function() {
    	 $('#aptim').val("<c:out value="${user.apptime}" />");
     	
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
	  <a href="Patienthome.jsp" title="Home">Home</a> 
	  <a href="index.html" title="Contact">Logout</a> 
  </div>
  <div class="logo"> <b>KMC Hospital</b>  </div>
  <div class="image"></div>
  <div class="leftcontent">
    <h3>Create New Appointment</h3>
    <br>
   

    <form method="POST" action='Appointbypat' name="frmAddUser">
  &nbsp&nbspAppointment ID : &nbsp&nbsp<input type="text" readonly="readonly" name="userid"
            value="<c:out value="${user.appid}" />" /> <br /><br /> 
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDoctor Name :  <input type="text" name="appdoc" id="appdoc"  value="<c:out value="${user.doctor}" />" /> &nbsp&nbsp&nbsp
     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
      &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp
     Doctor Email:
        <input type="email" name="demail" id="demail"  value="<c:out value="${user.demail}"/>" /> </br></br>
         Appointment Date : <input
            type="text" name="appdate" id="dob"
            value="<c:out value="${user.appdate}" />"  /> 
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Appointment Time : 
            
            <select name="aptim" id="aptim" style="width:130px;" value="<c:out value="${user.apptime}" />" >
			
	<option value="9.00AM">9.00AM</option>
	<option value="9.30AM">9.30AM</option>
	<option value="10.00AM">10.00AM</option>
	<option value="10.30AM">10.30AM</option>
	<option value="11.00AM">11.00AM</option>
	<option value="11.30AM">11.30AM</option>
	<option value="12.00PM">12.00PM</option>
	<option value="12.30PM">12.30PM</option>
	<option value="1.00PM">1.00PM</option>
	<option value="1.30PM">1.30PM</option>
	<option value="2.00PM">2.00PM</option>
	<option value="2.30PM">2.30PM</option>
	<option value="3.00PM">3.00PM</option>
	<option value="3.30PM">3.30PM</option>
	<option value="4.00PM">4.00PM</option>
	<option value="4.30PM">4.30PM</option>
	<option value="5.00PM">5.00PM</option>
	</select><br /> <br />
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Patient Name : <input
            type="text" name="apppat"
            value="<c:out value="${user.patient}" />" />
     
        &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp
         &nbsp&nbsp&nbsp&nbsp&nbsp&nbspPatient Email:
        <input type="email" name="pemail" id="pemail" value="<c:out value="${user.pemail}"/>" /> <br><br>
       &nbsp&nbsp&nbsp Purpose of Visit:
        <input type="text" name="ades"  value="<c:out value="${user.descrip}"/>" /> 
            <br><br><input type="submit" value="Submit" />
    </form>
    <div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
    
    </div>
    </div>
</body>
</html>