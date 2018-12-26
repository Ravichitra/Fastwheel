<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=devicse-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<c:import url="navbar.jsp"></c:import>
	<div style="min-height: 800px;">
		<c:if test="${carouselpage}">
			<c:import url="carousel.jsp"></c:import>
		</c:if>
		<c:if test="${aboutuspage}">
			<c:import url="aboutus.jsp"></c:import>
		</c:if>
		<c:if test="${contactuspage}">
			<c:import url="contactus.jsp"></c:import>
		</c:if>
		<c:if test="${categorypage}">
			<c:import url="categoryform.jsp"></c:import>
		</c:if>
		<c:if test="${productpage}">
			<c:import url="product.jsp"></c:import>
		</c:if>
		<c:if test="${loginpage}">
			<c:import url="login.jsp"></c:import>
		</c:if>
		<c:if test="${registerpage}">
			<c:import url="register.jsp"></c:import>
		</c:if>
		<c:if test="${viewproductpage}">
			<c:import url="viewproducts.jsp"></c:import>
		</c:if>
		<c:if test="${oneproductpage}">
			<c:import url="oneproduct.jsp"></c:import>
		</c:if>
		<c:if test="${cartpage}">
			<c:import url="cart.jsp"></c:import>
			
		</c:if>
		<c:if test="${addresspage}">
			<c:import url="address.jsp"></c:import>
			</c:if>
			<c:if test="${orderpage}">
			<c:import url="orders.jsp"></c:import>
			</c:if>
			<c:if test="${billpage}">
			<c:import url="bill.jsp"></c:import>
			
			
			
		</c:if>
	</div>

	<c:import url="footer.jsp"></c:import>
</body>
</html>
