<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	
	<h2>**** ADD STUDENT ****</h2>
	<br>
	<form action="addStudent">
		<input type="text" name="stdId"><br>
		<input type="text" name="stdName"><br>
		<input type="submit"><br>
	</form>
	
	 <c:if test = "${not empty studentList}">
        	 <table class="table table-bordered" style="width: 24%;">
			  <tr>
			    <th>Student Id</th>
			    <th>Student Name</th>
			  </tr>
			  
			  <c:forEach items="${studentList}" var = "student">
        		 <tr>
			   	 	<td>${student.stdId}</td>
			    	<td>${student.stdName}</td>
			     </tr>
     		 </c:forEach>
			 													
			</table> 
      </c:if>

</body>
</html>