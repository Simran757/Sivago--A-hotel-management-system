<%@page import="com.jsp.hotel_management_system.admin.dao.HotelDao"%>
<%@page import="com.jsp.hotel_management_system.admin.dao.HotelOwnerdao"%>
<%@page import="com.jsp.hotel_management_system.dto.Hotel"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.jsp.hotel_management_system.dto.HotelOwner"%>
<%@page import="java.util.Base64"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.jsp.hotel_management_system.dto.Hotel"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.hotel_management_system.admin.dao.HotelDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel---Display----</title>
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

	<jsp:include page="admin-navbar.jsp"></jsp:include><br>

	<%
	    List<Hotel> hotels = new HotelDao().getAllHotelDetailsDao();
	%>
	
	<form action="" method="get" style="text-align: center;">
	
	 <input type="text" placeholder="search hotel by owner name" name="">
	 <input type="submit" value="SEARCH">
	 
	</form>

	<table class="table align-middle mb-0 bg-white">
		<thead class="bg-light">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>CITY</th>
				<th>ADDRESS</th>
				<th>PRICE</th>
				<th>VerifyStatus</th>
				<th colspan="2">ACTION</th>
			</tr>
		</thead>
		<%
		for (Hotel hotel : hotels) {
			HotelOwner owner=hotel.getHotelOwner();
		%>

		<%
		byte[] image = hotel.getImage();
		String encodeImage = Base64.getEncoder().encodeToString(image);
		%>
		<tbody>
			<tr>
				<td>
					<p class="fw-normal mb-1"><%=hotel.getId()%></p>
				</td>
				<td>
					<div class="d-flex align-items-center">
						<img src="data:image/png;base64,<%=encodeImage%>"
							alt="hotel-image" style="width: 45px; height: 45px"
							class="rounded-circle" />
						<div class="ms-3">
							<p class="fw-bold mb-1"><%=hotel.getName()%></p>
						</div>
					</div>
				</td>
				<td>
					<p class="fw-normal mb-1"><%=hotel.getCity()%></p>
				</td>

				<td>
					<p class="fw-normal mb-1"><%=hotel.getAddress()%></p>
				</td>

				<td>
					<p class="fw-normal mb-1"><%=hotel.getPrice()%></p>
				</td>
				
				<%if(hotel.getVerifyStatus().equalsIgnoreCase("yes")){ %>
				
				<td><a href="#"><span
						class="badge badge-success rounded-pill d-inline"><%=hotel.getVerifyStatus()%></span></a></td>
				
				<%}else{ %>
					
					<td><a href="#"><span
						class="badge badge-danger rounded-pill d-inline"><%=hotel.getVerifyStatus()%></span></a></td>
					
				<%}%>	
				<td><a href="verifyHotelAdmin?id=<%=hotel.getId()%>"><span
						class="badge badge-success rounded-pill d-inline">Verify</span></a></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
</body>
</html>