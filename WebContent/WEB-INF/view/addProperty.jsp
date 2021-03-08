<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add ${reqMap}</title>
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
				<f:form modelAttribute="property" action="${url_add}">
					
					${reqMap}: <f:input path="name" />
					<f:button>Add</f:button>
				</f:form>
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