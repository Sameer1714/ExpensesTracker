<%@page import="com.entity.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnection"%>
<%@page import="com.dao.ExpenseDao"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../Compenets/allcss.jsp"%>
<title>ViewExpense</title>
<style type="text/css">
.card {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
</head>
<body>
	<%@include file="../Compenets/navbar.jsp"%>

	<c:if test="${empty User}">
		<c:redirect url="../Login.jsp"></c:redirect>
	</c:if>


	<div class="container-fliud p-5">

		<div class="row">

			<div class="col-md-10">

				<div class="card">

					<div class="card-header bg-light">

						<p class="text-center fs-3">View Expense</p>

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

						<table class="table" border="1px">
							<thead>
								<tr>
									<th scope="col">Title</th>
									<th scope="col">Date</th>
									<th scope="col">Time</th>
									<th scope="col">Description</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							<%  HttpSession s=request.getSession();
							    User u=(User)s.getAttribute("User");
							    ExpenseDao ed=new ExpenseDao(DBConnection.getSessionFactory());
							     List<Expense> list=ed.getAllExpenses(u);
							     
							     for(Expense e:list){
							    %>
							
								<tr>
									<td><%=e.getTitle() %></td>
									<td><%= e.getDate() %></td>
									<td><%=e.getTime() %></td>
									<td><%= e.getDescription() %></td>
									<td><%=e.getPrice() %></td>
									<td>
									<a href="EditExpense.jsp?Id=<%=e.getId() %>" class="text-decoration-none"><button class="btn btn-success">Edit</button></a> &nbsp &nbsp &nbsp
									<a href="../DeleteExpense?Id=<%=e.getId() %>" class="text-decoration-none"><button class="btn btn-danger">Delete</button></a>
									</td>
								</tr>
								<%} %>
							</tbody>
						</table>





					</div>
				</div>
			</div>
		</div>
	</div>


<%@include file="../Compenets/CopyWrite.jsp" %>

</body>
</html>