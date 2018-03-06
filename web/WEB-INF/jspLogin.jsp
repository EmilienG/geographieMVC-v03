<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Se connecter</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center> 
        <h1><span>Hello Login!</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <table id="tableau">
            <tr>
                <td><h2>Veuillez entrer votre pseudo<br>et votre mot de passe :</h2>
                    <form action='ControllerMain?section=login' method='post'>
                        Utilisateur : <input type='text' name='login' value='${login}' />
                        <br>            
                        Mot de passe : <input type='password' name='password' />
                        <br>
                        <br>
                        <input type='submit' name='doIt' value='Ok' />     
                        <input type="hidden" value="${getIDCompte}" name="IDCompte"/>
                    </form>
                    <c:url value="ControllerMain?section=inscription" var="url08" />
                    <a href="${url08}">Creer un compte</a>
                    <br>
                    <font color='red'>${msg}</font>  
                </td>
            </tr>
        </table>
    </center>
</body>
</html>
