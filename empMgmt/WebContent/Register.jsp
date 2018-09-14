<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin home</title>
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
function validate()
{ 
 var fullname = document.form.fullname.value;
 var addrs = document.form.addrs.value;
 var contact = document.form.contact.value;
 var password = document.form.password.value;
 var conpassword= document.form.confirmPassword.value;
 var email = document.form.email.value;
 
 if (fullname==null || fullname=="")
 { 
 alert("Full Name can't be blank"); 
 return false; 
 }
 else if (email==null || email=="")
 { 
 alert("Email can't be blank"); 
 return false; 
 }
 
 else if(password.length<6)
 { 
 alert("Password must be at least 6 characters long."); 
 return false; 
 } 
 else if (password!=conpassword)
 { 
 alert("Confirm Password should match with the Password"); 
 return false; 
 } 
 } 
</script> 
</head>
<body>

	<div class="container" style="background-color: #e3f2fd;">
		<h1>User Management system</h1>
	</div>
	<div class="container">

		<!--Navigation part starts here-->

		<nav class="navbar navbar-expand-lg navbar-light"
			style="background-color: #e3f2fd;"> <!-- <a class="navbar-brand" href="#">User management system</a> -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Home <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#">About Us</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Contact
						us</a></li>
				<!-- <li>
					<div class="dropdown">
						<a class="btn btn-secondary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"
							style="background-color: #e3f2fd; border: 0px; color: rgba(0, 0, 0, .7);">
							User options </a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<a class="dropdown-item" href="#">Add new user</a> <a
								class="dropdown-item" href="#">List all users</a> <a
								class="dropdown-item" href="#">Upload CSV file</a>
						</div>
					</div>
				</li> -->			
			</ul>
		</div>

		</nav>
		<form name="Registration Form" action="register" method="post">
		<input type="hidden" name="status" value="0" id="status">
		<div class="container">
			<h4>Registration Form</h4>
			<div class="form-group row">
				<label for="staticName" class="col-sm-2 col-form-label">Name</label>
				<div class="col-sm-10">	
						<input type="text" class="form-control" id="fullname" name="fullname"
					placeholder="abc pqr">
				</div>
			</div>
			<div class="form-group">
				<label for="inputAddress">Address</label> <input type="text"
					class="form-control" name="addrs" id="inputAddress" placeholder="1234 Main St">
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-2 col-form-label">Contact</label>
				<div class="col-sm-10">
					<input type="contact" name="contact" class="form-control" id="inputPassword"
						placeholder="9856237845">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input type="password" name="password"class="form-control" id="password"
						placeholder="Password">
				</div>
			</div>
			<div class="form-group row">
				<label for="confirmPassword" class="col-sm-2 col-form-label">Confirm
					Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
						placeholder="Password">
				</div>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputEmail" class="col-sm-2 col-form-label">Email-Id</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="email" name="email"
					placeholder="abc@gmail.com">
			</div>
		</div>
		<div>
		<input class="btn btn-primary" type="submit" value="Submit">
		</div>
		</form>
		<!--Navigation part ends here-->

		<!-- Admin main home part -->
		<!-- you can use this or other option -->
		<div class="container">

		</div>
		<!-- Admin main home part ends here-->


	</div>
	<div>
		<h1></h1>
	</div>

</body>
</html>
