<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ${reqMap} </title>
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
			<div style="margin-bottom: 100px; margin-top: 150px;">
				<s:url value="/${reqMap.toLowerCase()}/add" var="url_add"/>
				<a href="${url_add}"> Add ${reqMap} </a>
				<table id="table-1" border="1" align="center">
					<tr>
						<th>${reqMap}</th>
					</tr>
					<c:if test="${empty properties}">
						<tr>
							<td colspan="3" align="center" style="color:red;">!!No ${reqMap}!!</td>
						</tr>
					</c:if>
					<c:forEach items="${properties}" var="p">
						<tr>
							<td> ${p.name} </td>
							<s:url value="/cars/${reqMap.toLowerCase()}/${p.name}/${p.id}" var="url_cars"/>
							<td> <a href="${url_cars}">Cars</a> </td>
							
							<s:url var="url_delete" value="/${reqMap.toLowerCase()}/delete">
								<s:param name="id" value="${p.id}"/>
							</s:url>
							<td> <a href="${url_delete}">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
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