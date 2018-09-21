<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="images" value="/resources/images"/>

 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<div class="container">

<br/>



<h1 style="color:green">${msg}</h1>
<h1>List Of  Product</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>Product Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Category</th>
        <th>Supplier</th>
        <th>Actions</th>
       <!--  <th>Image</th> -->
      </tr>
    </thead>
   <tbody>
 <c:forEach items="${productList}" var="productObj">
 		
  		<tr>
  			<td>${productObj.productName}</td>
  			<td>${productObj.price}</td>
  			<td>${productObj.description}</td>
  			<td>${productObj.quantity}</td>
  			<td>${productObj.category.categoryName}</td>
  			<td>${productObj.supplier.supplierName}</td>
  			<td>${images}/${productObj.imgname}</td>
  			<td><a href="deleteProduct/${productObj.productId}">Delete</a></td>
  			<td><img src="${images}/${productObj.imgname}"/></td> 
  		</tr>
  </c:forEach>
  </tbody>
</table>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
