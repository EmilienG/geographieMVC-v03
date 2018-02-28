
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <hr />
        <table>
           <tr> <c:forEach  var="c" items="${mesLivres}">
                 <td>${c}</td>
                    <c:forEach items="${mesLivres.get(c)}" var="p">
                        <td>
                            <a href="#">${p}</a>
                        </td>
                    </c:forEach>
               
            </c:forEach> </tr>
        </table>
    </body>
</html>
