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
        * : Petites précisions <div id="cgu">
            - Pour nous faire gagner du temps à vous comme à nous, vous pouvez faire directement <b>un don</b>.
            <br>
            On a déjà prérempli le montant et les information et vous avez déjà validé
            <br>
            en acceptant les CGU lors de votre <strike>piratage</strike> inscription.
            <br>
            Donc regardez dans votre boite <strike>à lettre</strike> email (moins cher) pour votre
            <br>
            facture <strike>détaillée</strike> si notre java/jsp/html/css/etc fonctionne.
            <br>
            Merci. Au revoir.
            <br>
            Bisou ♥
        </div>
        <br>
        <img src="/LibrairieFusion-v1.0/img/lib.png"/>
        <c:url value="ControllerMain?section=footer" var="url02" />
        <c:import url="${url02}" />
    </center>
</body>
</html>