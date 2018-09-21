<jsp:include page="./shared/navbar.jsp"></jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
 
<spring:url var="images" value="/resources/images"/>

 

<div class="container">

<div style="color:red">${msg}</div>

<div class="rows">
<div class="col-md-6">
<div class="thumbnail" align="center">
<div><a href="addProductForm"><h5>Add Product</h5></a></div>
</div>
</div>
</div>


<div class="col-md-6">
<div class="thumbnail" align="center">
<div><a href="${contextRoot}/viewAllProducts"><h5>View All Products</h5></a></div>
</div>

</div>



<!-- <div class="col-md-4">
<div class="thumbnail" align="center">
<div><a herf="#"><h5>SUPPLIER</h5></div>
</div>
</div>
 --></div>

</div>
</div>

<div style="margin-top:100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>

