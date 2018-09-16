<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Include CSS for sidebar navigation File Here -->
<link rel="stylesheet" href="css/side-bar-navigation.css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>

	<div>
		<h1 class="page-header">Hello, SuperUser : ${user.userName}</h1>
	</div>
	<div class="row">
		<div class="col-3">
			<div class="sidenav">
				<a href="${pageContext.request.contextPath}/empProfile"
					role="button">Profile</a> <a
					href="${pageContext.request.contextPath}/emplist" role="button">Employee
					List</a>
			</div>


		</div>
		
		<div class="col-8 emp-list-div" style="display: none;">
			<!-- data to be shown for superEmployee -->
		</div>
	</div>
	<%-- <ul class="list-inline">
        <li> <div>
    <a href="${pageContext.request.contextPath}/empProfile" class="btn btn-warning" role="button">Profile</a>
 </div></li>
        <li> <div>
    <a href="${pageContext.request.contextPath}/list" class="btn btn-warning" role="button">Employee List</a>
 </div></li>
      </ul> --%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>