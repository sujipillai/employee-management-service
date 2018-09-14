<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<meta name="robots" content="noindex, nofollow">
<!-- Include CSS File Here -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- Include CSS File Here -->
<script src="js/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
<script> 
</script>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
 <jsp:include page="menu.jsp"></jsp:include>
  <h1 class="page-header">Employee Details</h1>
   <table border="1" cellpadding="5" cellspacing="1" class="table table-striped table-bordered table-hover table-condensed">
       <tr>
          <th>Username</th>
          <th>Department</th>
          <th>Salary</th>
          <th>Edit</th>
       </tr>
       <c:forEach items="${user}" var="user" >
          <tr>
             <td>${user.userName}</td>
             <td>${user.department}</td>
             <td>${user.salary}</td>
             <td>
                <a href="editEmployee?userName=${user.userName}" class="btn btn-info">Edit</a>
             </td>
          </tr>
       </c:forEach>
    </table>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <!-- Include all compiled plugins (below), or include individual files as needed -->
 <script src="js/bootstrap.min.js"></script>
  </body>
  </html>