<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-warning">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><i
			class="fa-solid fa-sack-dollar"></i>Expense Tracker</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">


			<ul class="navbar-nav me-auto mb-2 mb-lg-0">


				<c:if test="${empty User }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp"><i
							class="fa-solid fa-house"></i>Home</a></li>
				</c:if>
				<c:if test="${ not empty User }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="UserDashboard.jsp"><i
							class="fa-solid fa-house"></i>Home</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="AddExpense.jsp"> <i
							class="fa-solid fa-circle-plus"></i>Add Expense
					</a></li>


					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="ViewExpense.jsp"> <i
							class="fa-solid fa-list-ul"></i>View Expense
					</a></li>


				</c:if>

			</ul>
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

				<c:if test="${not empty User }">

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#"><botton class=" btn btn-light">
							<i class="fa-solid fa-circle-user"></i> ${User.getName() }</botton> </a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="../UserLogout"> <i
							class="fa-solid fa-right-from-bracket"></i>Logout
					</a></li>

				</c:if>


				<c:if test="${ empty User }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="Login.jsp"><i
							class="fa-solid fa-right-to-bracket"></i>Login</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="Register.jsp"><i
							class="fa-solid fa-user-plus"></i>Register</a></li>
				</c:if>
			</ul>

		</div>
	</div>
</nav>