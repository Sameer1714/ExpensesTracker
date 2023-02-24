<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../Compenets/allcss.jsp"%>
<title>User Dashboard</title>
</head>
<body>
<%@include file="../Compenets/navbar.jsp"%>

<c:if test="${empty User}">
<c:redirect url="../Login.jsp"></c:redirect>
</c:if>

	<div id="carouselExampleControls" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="../images/et2.jpg" class="d-block w-100" alt="..." height="585px">
			</div>
			<div class="carousel-item">
				<img src="../images/et1.jpg" class="d-block w-100" alt="..."  height="585px">
			</div>
			<div class="carousel-item">
				<img src="../images/et3.jpg" class="d-block w-100" alt="..."  height="585px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

</body>
</html>