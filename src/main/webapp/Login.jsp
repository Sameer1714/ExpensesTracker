<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="Compenets/allcss.jsp"%>
<title>Login page</title>
<style type="text/css">
.card{
 box-shadow: 0 0 6px 0 rgba(0,0,0,3);
}
</style>
</head>
<body>
	<%@include file="Compenets/navbar.jsp"%>
	<hr>

	<div class="container p-5 ">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<div class="card">

					<div class="card-header bg-light">

						<p class="text-center fs-3">Login</p>
						
						<c:if test="${not empty Success }">
						<p class="text-center fs-2 " style="color: green;"><i class="fa-solid fa-circle-check"></i>${ Success }</p>
						<c:remove var="Success"/>
						</c:if>
						
						<c:if test="${not empty Error }">
							<p class="text-center fs-5 " style="color: red;">
								<i class="fa-solid fa-triangle-exclamation"></i>${ Error }</p>
							<c:remove var="Error" />
						</c:if>

					</div>
					<div class="card-body " >

						<form action="UserLogin" method="post">

							<div class="mb-3">
								<label>Email</label> <input type="email" required name="Email"
									class="form-control">
							</div>

							<div class="mb-3">
								<label>Password</label> <input type="password" required
									name="Password" class="form-control">
							</div>
							
							<button id="sd" class="btn btn-warning  col-md-12 text-center">Login</button>
							
							<div class="text-center mt-2">
								Don't have account ? <a href="Register.jsp"
									class="text-decoration-none">Register</a>
							</div>
						</form>

					</div>

				</div>

			</div>

		</div>

	</div>
	
<%@include file="Compenets/CopyWrite.jsp" %>


</body>
</html>