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
	  <a href="Patienthome.jsp" title="Home">Home</a> 
	  <a href="index.html" title="Contact">Logout</a> 
  </div>
  <div class="logo"> <b>KMC Hospital</b>  </div>
  <div class="image"></div>
  <div class="leftcontent">
    <h3>Manage Your Bills</h3>
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
    <table id="doctor"  class="foodisplay2" data-limit-navigation="5" data-filter="#filter" data-page-size="10" data-page-last-text="last" >
        <thead>
            <tr>
                <th>Report Id</th>
               
                   <th>Date</th>
                    <th>Patient Name</th>
                     <th>Patient Email</th>
                      <th>Doctor Email</th>
                    <th>Prescription Details</th>
                    <th>Bill Amount</th>
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
  
   
   
   <div class="footer"> &copy; Copyright:Brainiacs CECS 575 Fall 2014 </div>
    </div>
    
  
  </div>
  <br><center><a href="http://www.dreamtemplate.com" title="Website Templates" target="_blank">Website templates</a></center>
  
</body>
</html>