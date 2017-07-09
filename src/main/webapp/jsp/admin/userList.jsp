<%-- 
    Document   : userList
    Created on : 04.07.2017, 21:17:06
    Author     : vasil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <table cellpadding="5">
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

            <table>
                <c:forEach var="Item" items="${incidentList}">
                    <tr>
                        <td>${Item.id}</td>
                        <td>${Item.FDate}</td>
                        <td>${Item.FComment}</td>
                        <td>
                            <table>
                                <c:forEach var="commentItem" items="${Item.TIncidentComments}">
                                    <tr>
                                        <td>
                                            ${commentItem.id}<br>
                                        </td>
                                        <td>
                                            ${commentItem.FComment}<br>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
