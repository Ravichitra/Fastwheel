<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>


<style>
.navbar-nav {
	float: left;
	padding: 1.8%;
}

.navbar-header {
	padding: 1.1%;
}

.navbar {
	background-color: #ffff33;
}
</style>

<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="navbar-header">
		<img src="${contextRoot}/resources/images/logo.PNG" alt="fastwheel" height="80px"></img>
	</div>
	
	<c:choose>

		<c:when test="${sessionScope.userlogin==true}">
		
			<ul class="nav navbar-nav">
				<li class="nav-item "><a href="${contextRoot}/index"><font
						color="black">Home</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/aboutus"><font
						color="black">About us</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/contactus"><font
						color="black">Contact us</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/viewproducts"><font
						color="black">Viewallproduct</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/user/viewCart"><font
						color="black">cart</font></a></li>
						<li class="nav-item "><a href="${contextRoot}/user/viewOrders"><font
						color="black">Orders</font></a></li>
						
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href=""><span class="glyphicon glyphicon-user"></span>Welcome!! ${sessionScope.username}</a></li>
						<li><a href="${contextRoot}/user/viewCart"><span class="glyphicon">&#xe116;</span></a></li>
						<li><a href="${contextRoot}/user/viewOrders"><span class="glyphicon glyphicon-list-alt"></span>
								ViewOrders </a></li>

						<li><a href="${contextRoot}/logout"><span class="glyphicon glyphicon-log-out"></span>
								Logout </a></li>
					</ul>
					
		</c:when>

		<c:when test="${sessionScope.userlogin==false}">
		
			<ul class="nav navbar-nav">
				<li class="nav-item "><a href="${contextRoot}/index"><font
						color="black">Home</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/aboutus"><font
						color="black">About us</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/contactus"><font
						color="black">Contact us</font></a></li>
				<li class="nav-item "><a
					href="${contextRoot}/admin/categoryform"><font color="black">Category</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/viewproducts"><font
						color="black">Viewallproduct</font></a></li>

				<li class="nav-item "><a href="${contextRoot}/admin/product"><font
						color="black">Product</font></a></li>
					</ul>	
				<ul class="nav navbar-nav navbar-right">
				<li class="nav-item "><a href="${contextRoot}/logout"><font
						color="black">Logout</font></a></li>

					</ul>


			
		</c:when>

		<c:otherwise>
		
			<ul class="nav navbar-nav">
				<li class="nav-item "><a href="${contextRoot}/index"><font
						color="black">Home</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/aboutus"><font
						color="black">About us</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/contactus"><font
						color="black">Contact us</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/login"><font
						color="black">login</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/viewproducts"><font
						color="black">Viewallproduct</font></a></li>
				<li class="nav-item "><a href="${contextRoot}/register"><font
						color="black">Register</font></a></li>

			</ul>
		</c:otherwise>

	</c:choose>



</nav>
