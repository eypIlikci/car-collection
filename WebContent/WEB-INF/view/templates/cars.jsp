<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center">
	<s:url value="/car/add" var="url_add"/>
	<a href="${url_add}">Add Car</a>
</div>
<table id="table-1" border="1" align="center">
	<tr>
		<th>Brand</th>
		<th>Model</th>
		<th>Year</th>
	</tr>
	<c:if test="${empty cars}">
		<tr>
			<td colspan="3" align="center" style="color:red;">!!No Cars!!</td>
		</tr>
	</c:if>
	<c:forEach items="${cars}" var="car">
		<tr>
			<td> ${car.brand.name} </td>
			<td> ${car.model} </td>
			<td> ${car.year} </td>
			<td> 
				<s:url value="/car/${car.model}-${car.year}/${car.id}" var="url_detail"/>
				<a href="${url_detail}">Detail</a>
			</td>
		</tr>
	</c:forEach>
</table>