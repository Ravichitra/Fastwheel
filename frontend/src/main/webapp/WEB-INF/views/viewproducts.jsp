<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
	box-sizing: border-box;
}

.zoom {
	transition: transform 5s;
	margin: 0 auto;
}

.zoom:hover {
	-ms-transform: scale(2); /* IE 9 */
	-webkit-transform: scale(2); /* Safari 3-8 */
	transform: scale(2);
}

.thumbnail {
	min-height: 150px;
}

.btn {
	backgroung: #0069c0;
	color: #fff;
	font-weight: 600;
	margin-bottom: 5px;
}

.text-center.label {
	backgroung: #007b5e;
}
body{
margin-top:115px;
}


</style>
<div class="container">

	<div class="row">
		<div class=" col-md-12">
			<c:forEach items="${prodlist}" var="p">
				<div class="col-sm-3 col-md-3">
					<div class="thumbnail w3-container w3-center w3-animate-bottom">
						<h4 class="text-center">
							<span class="label label-info">${p.product_Name}</span>
						</h4>
						<img class="zoom"
							src="resources/productimages/${p.product_id}.jpg" height="100"
							width="100">
						<div class="row">
							<div class="text-center">
								<h3>Price: &#8377 ${p.price}</h3>
							</div>
						</div>
						<div class="row">
							<div class="text-center">
								<a href="oneproduct?product_Name=${p.product_Name}"
									class="btn btn-success btn-product"><span
									class="glyphicon glyphicon-shopping-cart"></span>View Details</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
</div>