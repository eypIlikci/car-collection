<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" 
		prefix="s"%>
<s:url value="/index" var="url_home"/>    
 <s:url value="/categories" var="url_categories"/> 
 <s:url value="/brands" var="url_brands"/>   
<a href="${url_home}">Home</a> |
<a href="${url_categories}">Categories</a> |
<a href="${url_brands }">Brands</a> 