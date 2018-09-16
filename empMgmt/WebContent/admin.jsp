<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<meta name="robots" content="noindex, nofollow">
<!-- Include CSS File Here -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- Include CSS for sidebar navigation File Here -->
<link rel="stylesheet" href="css/side-bar-navigation.css" />
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
	<h1 class="page-header">Admin Welcome ${userInfo.userName}</h1>
	<div class="row">
		<div class="col-3">
			<div class="sidenav">
				<a href="${pageContext.request.contextPath}/empProfile"
					role="button">Profile</a> <a href="#/empList" role="button"
					class="emp-list">List of Employee</a>
			</div>

			<%-- <div>
		<ul class="list-inline">
			<li>
				<div>
					<a href="${pageContext.request.contextPath}/empProfile"
						class="btn btn-success" role="button">Profile</a>
				</div>
			</li>
			<li>
				<div>
					<a href="#/empList" class="btn btn-success emp-list" role="button">List
						of Employee</a>
				</div>
			</li>
		</ul>
	</div> --%>
		</div>
		
		<div class="col-8 emp-list-div" style="display: none;">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Delete User</th>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Department</th>
						<th scope="col">Role</th>
						<th scope="col">Salary</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/emp-list.js"></script>
</body>
</html>