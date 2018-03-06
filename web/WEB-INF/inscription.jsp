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
            <form id="RegisterUserForm" action="ControllerMain?section=inscription" method="post">
                <fieldset>
                    <label for="name">Nom</label> <input class="text" id="name" type="text" name="name2" value="" />
                    <br>
                    <label for="prenom">Prenom</label> <input class="text" id="prenom" type="text" name="prenom2" value="" />
                    <br>
                    <label for="pseudo">pseudo</label> <input class="text" id="pseudo" type="text" name="pseudo2" value="" />
                    <br>
                    <label for="email">Email</label> <input class="text" id="email" type="email" name="email2" value="" />
                    <br>
                    <label for="password">Mot de passe</label> <input class="text" id="password" type="password" name="password2" />
                    <br>
                    <input id="acceptTerms" type="checkbox" name="acceptTerms" />
                    <label for="acceptTerms"> J'accepte <a>les Termes et Conditions<br></a> comme quoi je donne <a>tout à Librairie.Fusion</a> </label>
                    <br>
                    <input type="submit" value="ok" name="doIt2"/>
                    <br>
                    <font color='red'>${msg}</font>  
                </fieldset>
            </form>
        </div>
    </center>
    <c:url value="ControllerMain?section=footer" var="url02" />
    <c:import url="${url02}" />
</body>
</html>