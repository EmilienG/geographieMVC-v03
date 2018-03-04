<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription Fusion !</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <h1><span>Page d'inscription !</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <div id="registration">
            <h2>Creer un compte</h2>
            <form id="RegisterUserForm" action="" method="post">
                <fieldset>
                    <label for="name">Nom</label> <input class="text" id="name" type="text" name="name" value="" />
                    <br>
                    <label for="tel">Prenom</label> <input class="text" id="tel" type="tel" name="tel" value="" />
                    <br>
                    <label for="email">Email</label> <input class="text" id="email" type="email" name="email" value="" />
                    <br>
                    <label for="password">Mot de passe</label> <input class="text" id="password" type="password" name="password" />
                    <br>
                    <input id="acceptTerms" type="checkbox" name="acceptTerms" />
                    <label for="acceptTerms"> J'accepte <a>les Termes et Conditions<br></a> comme quoi je donne <a>tout à Librairie.Fusion</a> </label>
                    <br>
                    <input type="submit" value="ok"/>
                </fieldset>
            </form></div>
    </center>
</body>
</html>