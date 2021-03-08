<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${reqMap} Car</title>
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
			<s:url value="/car/${reqMap.toLowerCase()}" var="url"/>
				<f:form modelAttribute="car" action="${url}">
					<f:hidden path="id" />
					Model:<f:input path="model" /><br>
					Year:<f:input path="year" /><br>
					Brand:<f:select path="brandId">
						  	<f:option value="0">--SELECT--</f:option>
						  	<f:options itemLabel="name" itemValue="id" items="${brands}"/>
						  </f:select>
						  <br>
					Category<br>
					<f:checkboxes path="catsId" items="${categories}" 
											itemLabel="name"
											itemValue="id"/><br>
					<f:button>${reqMap}</f:button>
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