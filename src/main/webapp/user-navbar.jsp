<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user-navbar</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
	rel="stylesheet" />
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary">
		<!-- Container wrapper -->
		<div class="container">
			<!-- Navbar brand -->

			<!-- Toggle button -->
			<button data-mdb-collapse-init class="navbar-toggler" type="button"
				data-mdb-target="#navbarButtonsExample"
				aria-controls="navbarButtonsExample" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>

			<!-- Collapsible wrapper -->
			<div class="collapse navbar-collapse" id="navbarButtonsExample">
				<!-- Left links -->
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#">Hotel-Management-System</a>
					</li>
				</ul>
				
				<!-- Left links -->
				
				<div style="margin-right: 120px;">
						<a href="hotel-display-admin.jsp">Verify-Hotel</a>
				</div>
				
				<div style="margin-right: 180px;">
						<a href="admin-home.jsp">Verify-Owner</a>
				</div>

				<div class="d-flex align-items-center">
					<a data-mdb-ripple-init class="btn btn-dark px-3"
						href="userLogout" role="button">Logout</a>
					<a data-mdb-ripple-init class="btn btn-dark px-3"
						href="https://github.com/Mohammed-Masood-Ansari" role="button"><i
						class="fab fa-github"></i></a>
				</div>
			</div>
			<!-- Collapsible wrapper -->
		</div>
		<!-- Container wrapper -->
	</nav>
	<!-- Navbar -->
</body>
</html>