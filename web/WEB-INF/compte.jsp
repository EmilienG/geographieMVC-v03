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
        Ici on modifie son compte.<br>

        ID compte = ${monClient.id}
        Membre depuis = ${monClient.dateCreation}
        <div id="registration">
            <form id="RegisterUserForm" action="" method="post">
                <u>Vos informations personelles :</u>
                <fieldset>
                    <label for="name">Nom</label> <input class="text" id="name" type="text" name="name" value="${monClient.nom}" />
                    <br>
                    <label for="name">Prenom</label> <input class="text" id="name" type="text" name="prenom" value="${monClient.prenom}" />
                    <br>
                    <label for="tel">Pseudo</label> <input class="text" id="tel" type="tel" name="tel" value="${monClient.pseudo}" />
                    <br>
                    <label for="email">Email</label> <input class="text" id="email" type="email" name="email" value="${monClient.email}" />
                    <br>
                    <label for="email">Telephone</label> <input class="text" id="email" type="email" name="email" value="${monClient.telephone}" />
                    <br>
                    <label for="password">Mot de passe</label> <input class="text" id="password" type="password" name="password" value="*****"/>
                    <br>
                    <input type="submit" value="ok"/>
                </fieldset>
            </form>
        </div>
        <c:url value="ControllerMain?section=footer" var="url02" />
        <c:import url="${url02}" />
    </center>
</body>
</html>