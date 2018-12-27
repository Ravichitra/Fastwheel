<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#myTable').DataTable({
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [ 2, 5, 10, -1 ], [ 2, 5, 10, "All" ] ],
			"ordering" : true,
		});
	});
</script>
  
  
  
  
  
  <title>product form</title>
   <style>
body{
background-color:#ffff66;
padding-top:10%;
}



</style>




<div class="container">

<c:if test="${editmode}">
<c:set var="url" value="updateproduct"></c:set>
</c:if>
<c:if test="${!editmode}">
<c:set var="url" value="CreateProduct"></c:set>
</c:if>
<c:if test="${haserror}">
<div error="alert alert-danger alert-dismissable">${error}</div>
	</c:if>
	<div class="ntry">
		<h2>PRODUCT FORM</h2>
		<form:form enctype="multipart/form-data" class="form-horizontal" modelAttribute="product"
			action="${url}" method="post">
			<c:if test="${editmode}">
				<div class="form-group">
					
					<div class="col-sm-10">
						<form:input type="text" class="form-control" 
							placeholder=""  path="product_id"
							readonly="true" />
						<form:errors path="product_id" cssStyle="color:red"></form:errors>
							
					</div>
				</div>
			</c:if>

			<div class="form-group">
				<label class="control-label col-sm-2" for="prd">PRODUCT NAME:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" 
						placeholder="product name"  path="product_Name" />
					<form:errors path="product_Name" cssStyle="color:red"></form:errors>
						
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="prd">
					DESCRIPTION:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" 
						placeholder="product description"  path="productDesc" />
										<form:errors path="productDesc" cssStyle="color:red"></form:errors>
						
				</div>
			</div>
			
			<div class="form-group">
			<label class="control-label col-sm-2" for="prd">
					CATEGORY NAME:</label>
					<div class="col-sm-10">
					<form:select class="form-control" path="category.category_id">
					<c:forEach items="${catlist}" var="c">
					<form:option value="${c.category_id}">${c.category_Name}</form:option>
					</c:forEach>
					</form:select>
					</div>
					</div>
					
					
					<div class="form-group">
      <label class="control-label col-sm-2" for="price">ENTER PRICE:</label>
      <div class="col-sm-10">          
        <form:input type="" class="form-control" id="price" placeholder="Enter price" path="price" />
       <form:errors path="price" cssStyle="color:red"></form:errors>
        
      </div>
    </div>
    <div class="form-group">        
      <label class="control-label col-sm-2" for="quantity">ENTER QUANTITY:</label>
        <div class="col-sm-10">
                  <form:input type="" class="form-control" id="quantity" placeholder="Enter quantity" path="quantity" />
       <form:errors path="quantity" cssStyle="color:red"></form:errors>

        </div>
      </div>
      
      <div class="form-group">
		<form:input type="file" name="fileToUpload" id="fileToUpload" path="pimage" class="form-control" />
		</div>
			
			<c:if test="${editmode}">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">UpdateProduct</button>
					</div>
				</div>
			</c:if>
			<c:if test="${!editmode}">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">AddProduct</button>
					</div>
				</div>
			</c:if>
		</form:form>
	
	<div class="container">
		<div class="row">
			<div>
				<div class="table-responsive">
					<table id="myTable" class="table">
						<thead>
							<tr>
							<th>IMAGE</th>
								<th>PRODUCT ID</th>
								<th>PRODUCT NAME</th>
								<th>PRODUCT DESCRIPTION</th>
								<th>CATEGORY</th>
								<th>PRICE</th>
								<th>QUANTITY</th>
								
								<th class="text-right">Edit/Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${prodlist}" var="c">
								<tr>
								<td><img src="resources/productimages/${c.product_id}.jpg" width="50" height="50"/></td>
									<td>${c.product_id}</td>
									<td>${c.product_Name}</td>
									<td>${c.productDesc}</td>
									<td>${c.category.category_Name}</td>
									<td>${c.price}</td>
									<td>${c.quantity}</td>
									<td class="td-actions text-right"><a
										href="editproduct?product_Name=${c.product_Name}" rel="tooltip"
										class="btn btn-success btn-link btn-just-icon btn-sm"
										data-original-title="" title=""> <i class="material-icons">edit</i>
									</a> <a href="deleteproduct?product_Name=${c.product_Name}"
										rel="tooltip"
										class="btn btn-danger btn-link btn-just-icon btn-sm"
										data-original-title="" title=""> <i class="material-icons">close</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

      </div>
      </div>
  