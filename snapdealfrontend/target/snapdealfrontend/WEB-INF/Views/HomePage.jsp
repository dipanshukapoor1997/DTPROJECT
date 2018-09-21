<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<spring:url var="images" value="/resources/images"/>
 

<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>

 
	<sec:authorize access="hasAuthority('ADMIN')">
		<jsp:forward page="/admin"/>
	</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${images}/banner1.png" alt="banner" style="width:100%;">
      </div>

      <div class="item">
        <img src="${images}/banner4.jpg" alt="banner" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="${images}/banner3.jpg" alt="banner" style="width:100%;">
      </div>
       <div class="item">
        <img src="${images}/banner5.jpg" alt="banner" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>


<div class="container" style="margin-top: 20px">
<div class="rows">
<div class="col-md-12">

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/kids.jpg" style="height:300px;width:250px">
<h5>Kurta Pyjama</h5>
<p align="left">Rs.1500 (50%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/beauty.jpg" style="height:300px;width:250px">
<h5>Nail paint</h5>
<p align="left">Rs.400 (10%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/mens2.jpg" style="height:300px;width:250px">
<h5>Green Blazzer</h5>
<p align="left">Rs.2200 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/women.jpg" style="height:300px;width:250px">
<h5>Black  dress</h5>
<p align="left">Rs.999 (50%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
 </br>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/w1.jpg" style="height:300px;width:250px">
<h5>Wrist Watch</h5>
<p align="left">Rs.600 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/wall6.jpg" style="height:300px;width:250px">
<h5>Wall Clock</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>


<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/women2.jpg" style="height:300px;width:250px">
<h5>Suit</h5>
<p align="left">Rs.3000 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/c6.jpg" style="height:300px;width:250px">
<h5>Foundation</h5>
<p align="left">Rs.799 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
</br>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/w5.jpg" style="height:300px;width:250px">
<h5> Womens Wrist Watches</h5>
<p align="left">Rs.1500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>




<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/wall4.jpg" style="height:300px;width:250px">
<h5>Cute Wall Clock</h5>
<p align="left">Rs.800 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
</div>
</div>
</div>

<jsp:include page="./shared/footer.jsp"></jsp:include>

