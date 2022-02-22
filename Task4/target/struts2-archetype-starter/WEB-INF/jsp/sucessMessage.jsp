<%@ page import="com.motadata.Task4.DatabaseAccess" %><%--
  Created by IntelliJ IDEA.
  User: rahil
  Date: 21/12/21
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Title</title>
</head>
<body>
    <p id="op">connection successful</p>
    <%=session.getAttribute("name")%>
    <%=session.getAttribute("surname")%>
    <%=session.getAttribute("username")%>
    <%=session.getAttribute("email")%>
    <%=session.getAttribute("password")%>
    <%=session.getAttribute("confirm_password")%>
    <%=session.getAttribute("auth")%>
    <%=session.getAttribute("status")%>
    <%=session.getAttribute("department")%>
    <%=session.getAttribute("rolegroup")%>
    <%=session.getAttribute("description")%>
    <% out.println("hello");%>
</body>
</html>
