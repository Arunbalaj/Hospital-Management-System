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
       
       
       
       	<script src="jspdf/jspdf.js" type="text/javascript"></script>
	<script src="jspdf/libs/base64.js" type="text/javascript"></script>
	<script src="jspdf/libs/sprintf.js" type="text/javascript"></script>
    <style>
    
</style>
	
	
	<script>
	
	var doc = new jsPDF();
	var specialElementHandlers = {
		    '#editor': function (element, renderer) {
		        return true;
		    }
		};

	 function download() {
			alert("dd");
		    doc.fromHTML($('#bill').html(), 15, 15, {
		        'width': 170,
		            'elementHandlers': specialElementHandlers
		    });
		    doc.save('sample-file.pdf');
		}
		
		
		</script>
       <script type="text/javascript">
	$(function () {
		var DocTable =$('#doctor').footable();
		 $('.filter-status').change(function (e) {
		        $('table.foodisplay2').trigger('footable_filter', {filter: $('#filter').val()});
		    });
	 $('#clear-filterpe').click(function (e) {
         e.preventDefault();
         $('#filter').val('');
         DocTable.trigger('footable_clear_filter');
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
    <h3>Manage Report</h3>
    <br>
    
    


    
  <div style="margin-left:73%" >
<input type="text" id="filter" placeholder="Search" style="border: 1px solid #848484; 
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
<div id="bill">
    <table id="doctor"  class="foodisplay" data-limit-navigation="5" data-filter="#filter" data-page-size="10" data-page-last-text="last" >
        <thead>
            <tr>
                <th>Report Id</th>
               
                   <th>Date</th>
                     <th>Patient Name</th>
                     <th>Patient Email</th>
                      <th>Doctor Email</th>
                    <th>Prescription Details</th>
                    <th>Bill Amount</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.repid}" /></td>
                    <td><c:out value="${user.date}" /></td>
                     <td><c:out value="${user.patient}" /></td>
                    <td><c:out value="${user.pemail}" /></td>
                    <td><c:out value="${user.demail}" /></td>
                      <td><c:out value="${user.presc}" /></td>
                    <td><c:out value="${user.amount}" /></td>
                   <td><a class='btnDelete' style='font-weight:bold' href="Reportct?action=edit&userId=<c:out value="${user.repid}" />">Update</a></td>
                    <td><a class='btnDelete' style='font-weight:bold' href="Reportct?action=delete&userId=<c:out value="${user.repid}"/>">Delete</a></td>
                 </tr>
            </c:forEach>
            </tbody>
            </tbody>
            <tfoot >
           <tr>
        <td colspan='10'>
        <div align='center' class='pagination'></div>
        </td>
        </tr>
        </tfoot>
        </table>
  </div>
  
  <div id="editor"></div>
  
     <p><a href="Reportct?action=insert" style='font-size:2.0em; font-weight:bold;'>Add New Bill Details</a></p>
   
   <div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
    </div>
    
  
  </div>
  <br><center><a href="http://www.dreamtemplate.com" title="Website Templates" target="_blank">Website templates</a></center>
  
</body>
</html>