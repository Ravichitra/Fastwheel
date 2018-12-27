



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mytry{
margin-top:11%;
}
</style>
<div class="container">

<div class="mytry">
	<div class="row">
		<div class="col-sm-5 ">
			<div>
				<img src="resources/productimages/${product.product_id}.jpg"
					width="300px" height="300px">
			</div>
		</div>
		<div class="col-sm-7">
			<div class="card-body p-5">
				<h3 class="title mb-3">${product.product_Name}</h3>

				<p class="price-detail-wrap">
					<span class="price h3 text-warning"> <span class="currency">&#8377</span><span
						class="num">${product.price}</span>
					</span>
				</p>
				<!-- price-detail-wrap .// -->
				<dl class="item-property">
					<dt>Description</dt>
					<dd>
						<p>${product.productDesc}</p>
					</dd>
				</dl>
				<dl class="param param-feature">
					<dt>Delivery</dt>
					<dd>Free Shipping And COD For COIMBATORE,CHENNAI AND BANGALORE</dd>
				</dl>
				
				<p id="demo"></p>
				<br>
				<c:if test="${msg}">
					<span class="alert alert-danger">Requested quantity not
						available</span>
				</c:if>
				<br>
				<hr>
				
		
				<a href="viewproducts" class="btn btn-success btn-product"><span
					class="glyphicon glyphicon-shopping-cart"></span>BACK</a>
				<c:if test="${product.quantity != 0 }">
					
					<a name="refreshcart" id="refreshcart"
						href="addToCart?product_Name=${product.product_Name}" 
						class="btn btn-success btn-product">
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
					</a>
				</c:if>
				
			</div>
		</div>
	</div>
</div>
