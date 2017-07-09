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
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
        <link rel="stylesheet" type="text/css" href="css/jquery-ui/jquery-ui.css"/>
        <script src="js/jquery-3.2.1.js"></script>
        <script src="js/jquery-ui/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#idAccording").accordion();
            });
        </script>
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

            

            <div id="idAccording">
                <c:forEach var="Item" items="${incidentList}">
                    <h3>
                        <div class="classIncidentHeader">
                            ${Item.id}
                            ${Item.FDate}
                            ${Item.FComment}
                        </div>
                    </h3>
                    <div>
                        <table>
                            <c:forEach var="commentItem" items="${Item.TIncidentComments}">
                                <tr class="classSecondTable">
                                    <td>
                                        ${commentItem.id}<br>
                                    </td>
                                    <td>
                                        ${commentItem.FComment}<br>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                </c:forEach>

            </div>

        </div>
    </body>
</html>
