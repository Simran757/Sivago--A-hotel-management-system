<%@page import="com.jsp.hotel_management_system.dto.HotelOwner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel Owner Home Page</title>
</head>
<body>
	<jsp:include page="hotel-owner-navbar.jsp" />
	<h1>Welcome Hotel Owner</h1>
	<jsp:include page="hotel-display-owner.jsp"></jsp:include>

</body>
</html>