<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <title>Category Menu Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
        
         <ul class="nav navbar-nav">
     <li><a href="#">CATEGORIES  <span class="glyphicon glyphicon-hand-right"></span></a></li>
        </ul>
 
 	<ul class="nav navbar-nav" role="tablist">
 	<c:forEach items="${categoryList}" var="category">
 	<li class="dropdown"><a class="dropdown-toggle"  href="navproducts/${category.id}">${category.name}</a>
 	
 	</li>
 	</c:forEach>
 	</ul>
 	
 	 <ul class="nav navbar-nav navbar-right">
 	<sec:authorize access="isAuthenticated()">
     <a class="navbar-brand" style="font-size:15px;"><span class="glyphicon glyphicon-user"></span> WELCOME 
     <sec:authentication property="principal.username"/></a>
     </sec:authorize>
     </ul>
    
    </div>
    
</nav>
</body>
</html>
