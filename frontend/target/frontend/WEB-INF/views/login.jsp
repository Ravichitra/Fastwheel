<!DOCTYPE html>
<html lang="en">
<head>
  <title>loginform</title>
  
  <style>
body{
background-color:#ffff66;
padding-top:110px;

}
</style>

</head>
<body>


<div class="container">
  <h2>login form</h2>
  <form class="form-horizontal" action="performlogin" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control"  placeholder="Enter email" name="user_name" id="user_name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="user_password" placeholder="Enter password" name="user_password">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>
