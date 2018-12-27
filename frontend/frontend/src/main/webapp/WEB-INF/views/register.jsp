<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>registrationform</title>
<style>
body{
background-color:#ffff66;
padding-top:10%;
}
</style>

<div class="container">
  <h2>Register Form</h2>
  <form:form modelAttribute="myuser" class="form-horizontal" action="adduser" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">USERNAME:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="name" placeholder="Enter username" path="user_Name" />
        <form:errors path="user_Name" cssStyle="color:red"></form:errors>
        
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >MOBILE NUMBER:</label>
      <div class="col-sm-10">          
        <form:input type="number" class="form-control" id="mobno" placeholder="Enter mobile number" path="phno" />
              <form:errors path="phno" cssStyle="color:red"></form:errors>
      
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">EMAIL ID:</label>
      <div class="col-sm-10">          
        <form:input type="email" class="form-control" id="email" placeholder="Enter email"  path="emailId"  />
        <form:errors path="emailId" cssStyle="color:red"></form:errors>
        
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">PASSWORD:</label>
      <div class="col-sm-10">          
        <form:input type="password" class="form-control" id="email" placeholder="Enter password"  path="user_Password"  />
        <form:errors path="user_Password" cssStyle="color:red"></form:errors>
        
      </div>
    </div>
    
		
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">create</button>
      </div>
    </div>
	
  </form:form>
</div>


