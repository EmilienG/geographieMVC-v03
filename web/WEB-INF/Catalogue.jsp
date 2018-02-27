<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
        <link href="LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <ul class="menu">
            <c:forEach var="monLivre" items="${mesLivres}">
                <li> ${monLivre.getTitreLivre()}, ${monLivre.getSousTitreLivre()} </li>
                </c:forEach>
        </ul>
    </body>
</html>
