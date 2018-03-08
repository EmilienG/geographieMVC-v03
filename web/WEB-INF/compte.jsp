<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mon Compte</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <h1><span>Mon Compte</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>      
         
        <div id="conteneur">
            <div class="element"><a href="ControllerMain?section=info-perso">Informations Personelles</a></div>
            <div class="element"><a href="ControllerMain?section=order">Mes Commandes</a></div>
        </div>
        <br>
        <br>
        <h2>Ici vous pouvez visualiser et modifier les informations de votre compte personnel.
        <br>Voir vos commandes...</h2>
        <br>
        <br>
        <c:url value="ControllerMain?section=footer" var="url02" />
        <c:import url="${url02}" />
    </center>
</body>
</html>