<%-- 
    Document   : userList
    Created on : 04.07.2017, 21:17:06
    Author     : vasil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<sql:query var="listUsers" dataSource="java:/helpDeskDS">
    SELECT id, f_login, f_pass, f_name FROM public.t_spr_users;
</sql:query>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${list}<br>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>List of users</h2></caption>
                <tr>
                    <th>Name</th>
                    <th>Password</th>
                </tr>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.FName}</td>
                        <td>${user.FPass}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
