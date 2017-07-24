<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<openmrs:htmlInclude file="/moduleResources/fludatatool/scripts/main.js"/>

<openmrs:htmlInclude file="/moduleResources/fludatatool/css/main.css"/>

<% 
	String email = (String)request.getAttribute("email");

	 %>
	 
	 <div><%= email %></div> 
	 <%
%>