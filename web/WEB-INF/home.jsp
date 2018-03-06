<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil Fusion !</title>
    </head>
    <body>
    <center>
        <h1><span>Page d'Acceuil !</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <c:if test="${logOn}">
            Welcome ${welcome}!<br>
        </c:if>
        Bienvenue dans notre super librairie en ligne,<br>dépenssez autant que vous voulez !
        <c:if test="${logOn}">
             <br>
            Vous êtes connecté
        </c:if>
        <c:if test="!${logOn}">
            <br>
           Vous êtes déconnecté
        </c:if>
    </center>
</body>
</html>