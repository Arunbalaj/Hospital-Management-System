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
    	var docn = getFieldFromFields("name");
    	var pemail = getFieldFromFields("email");
    	var pname = getFieldFromFields("pname");
    	var demail=sessionStorage.getItem('userid');
    	
    	
		$('#rppemail').val(pemail);
		$('#rppt').val(pname);
		$('#rpdemail').val(demail);
});
    </script>  
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
    <h3>Add Bill</h3>
    <br>
   

    <form method="POST" action='DocReport' name="frmAddUser">
   &nbsp&nbsp&nbsp&nbsp&nbspReport ID :&nbsp<input type="text" readonly="readonly" name="userid"
            value="<c:out value="${user.repid}" />" /> <br /><br /> 
       
        Report Date :&nbsp <input
            type="text" name="repdte" id="dob"  value="<c:out value="${user.date}"/>"  /> 
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Report Month : 
      
       <br /> <br />
        Patient Name:
        <input type="text" name="rppt"  id="rppt" readonly="readonly" /> 
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPatient Email:
        <input type="email" name="rppemail" id="rppemail" readonly="readonly" />  <br /> <br />
          Doctor Email:
        <input type="email" name="rpdemail" id="rpdemail" readonly="readonly"  /> 
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