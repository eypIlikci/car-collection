<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${car.model} - ${car.brand.name} </title>
</head>
<body>
<table border="1" width="80%" align="center">
	
	<tr>
		<td height="50px" width="80%">
			<%--Menu --%>
			<jsp:include page="templates/menu.jsp"/>
		</td>
	</tr>
	<tr>
		<td height="100%">
			<%--Content --%>
			<div style="margin-bottom: 100px; margin-top: 150px;" align="center">
				<h3>Brand: ${car.brand.name}</h3>
				<h3>Model: ${car.model}</h3>
				<h3>Year: ${car.year}</h3>
				<h3>Categories</h3>
				<c:forEach items="${car.categories}" var="cat">
					<h4>${cat.name}</h4>
				</c:forEach>
				<br><br>
				<s:url value="/car/edit" var="url_edit">
					<s:param name="carId" value="${car.id}"/>
				</s:url>
				<a href="${url_edit}">Edit</a><br>
				<s:url value="/car/delete" var="url_delete">
					<s:param name="carId" value="${car.id}"/>
				</s:url>
				<a href="${url_delete}">Delete</a>
			</div>
		</td>
	</tr>
	
	<tr>
		<td height="50px" valign="top" width="80%">
			<jsp:include page="templates/footer.jsp"/>
		</td>
	</tr>
	
</table>
</body>
</html>