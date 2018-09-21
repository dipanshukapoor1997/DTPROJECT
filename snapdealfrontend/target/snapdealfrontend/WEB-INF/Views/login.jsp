<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<spring:url var="images" value="/resources/images"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${contextRoot}/home"><img src="${images}/logomyntra.png" width="40px" height="25px"></a> 
    </div>
    </div>
</nav>
			
   <div class="container">
   
   
   <c:if test="${not empty message}"> 
   	 <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
   		<div class="alert alert-danger">
   			${message}
   		</div>
   	</div>
   	</div>
    </c:if> 
    <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Login</h4>
       </div>
       
       
       <div class="panel-body">
       
        <form action="login" method="POST" class="form-horizontal" id="loginForm">
        
        
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">  
           <input type="text" name="username" id="username" class="form-control" required="required"/>
          </div>
          </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control" required="required"/>
          </div>
         </div>
          <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
      	   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
          <input type="submit" value="Login" class="btn btn-primary"/>
          </div>
          </div>-
        </form>
       
       </div>
       
      </div> 
    
 	     </div>
     
    </div>    
   
   </div>

			
		</div>

	<%@include file="./shared/footer.jsp" %>
		
	</div>

</body>

</html>