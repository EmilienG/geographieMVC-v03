<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil Fusion !</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
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
            <a href='ControllerMain?section=deconnecter'>Déconnexion</a>
        </c:if>
        <c:if test="!${logOn}">
            <br>
            Se co
        </c:if>
    </center>
</body>
</html>