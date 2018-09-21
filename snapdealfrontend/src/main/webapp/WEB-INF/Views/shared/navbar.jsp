<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 
 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
 
<spring:url var="images" value="/resources/images"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Snapdeal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${contextRoot}/home"><img src="${images}/snapdeallogo1.png" width="40px" height="25px"></a> 
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${contextRoot}/home"><b>OnlineShoppingStore</b> </a></li>
      <li class="active"><a href="${contextRoot}/home">Home</a></li>

     <li><a href="${contextRoot}/getProduct/wall clock">Wall Clock</a></li>
      <li><a href="${contextRoot}/getProduct/wrist watch">Wrist Watches</a></li>
      <li><a href="${contextRoot}/getProduct/beauty product">Beauty Products</a></li>
      <li><a href="${contextRoot}/getProduct/clothing" >Clothing</a></li>
     
    </ul>
	
	<form class="navbar-form navbar-left" action="">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
	
    <ul class="nav navbar-nav navbar-right">
    
    <sec:authorize access="isAnonymous()">
	<li id="register">
		<a href="${contextRoot}/register">Sign Up</a>
    <li>
	<li id="login">
		<a href="${contextRoot}/login">Login</a>
	</li>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
	<li class="dropdown">
		<a href="javascript:void(0)"
			class="btn btn-default dropdown-toggle"
			id="dropdownMenu1"
			data-toggle="dropdown">
				Welcome : <c:out value="${sessionScope.userName}"/>
				<span class="caret"></span>
			</a>
		<li class="divider" role="seperator"></li>
		<li>
			<a href="${contextRoot}/addToCart/viewCart">Cart</a>
		</li>
		<li>
			<a href="${contextRoot}/perform-logout">Logout</a>
		</li>
	</sec:authorize>
	</ul>	
	
  </div>
</nav>













	
