<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../Compenets/allcss.jsp"%>
<title>AddExpense</title>
<style type="text/css">
.card {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body >
	<%@include file="../Compenets/navbar.jsp"%>

	<c:if test="${empty User}">
		<c:redirect url="../Login.jsp"></c:redirect>
	</c:if>


	<div class="container p-5">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<div class="card">

					<div class="card-header bg-light">

						<p class="text-center fs-3">Add Expense</p>

						<c:if test="${not empty Success }">
							<p class="text-center fs-2 " style="color: green;">
								<i class="fa-solid fa-circle-check"></i>${ Success }</p>
							<c:remove var="Success" />
						</c:if>

						<c:if test="${not empty Error }">
							<p class="text-center fs-5 " style="color: red;">
								<i class="fa-solid fa-triangle-exclamation"></i>${ Error }</p>
							<c:remove var="Error" />
						</c:if>


					</div>
					<div class="card-body">

						<form action="../AddExpense" method="post">
							<div class="mb-3">
								<label>Title</label> <input type="text" required name="Title"
									class="form-control">
							</div>

							<div class="mb-3">
								<label>Date</label> <input type="date" required name="Date"
									class="form-control">
							</div>

							<div class="mb-3">
								<label>Time</label> <input type="time" required name="Time"
									class="form-control">
							</div>

							<div class="mb-3">
								<label>Description</label> <input type="text" required
									name="Description" class="form-control">
							</div>

							<div class="mb-3">
								<label>Price</label> <input type="number" required name="Price"
									class="form-control">
							</div>


							<button class="btn btn-warning col-md-12">Add</button>

						</form>

					</div>

				</div>

			</div>

		</div>

	</div>
<%@include file="../Compenets/CopyWrite.jsp" %>

</body>
</html>