<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONNEXION</title>
    </head>
    <body>
        
        <h1><span>Hello Login!</span></h1>
        
        
        <form action='ControllerMain?section=login' method='post'>
            Utilisateur : <input type='text' name='login' value='${login}' /><br>
            <br>            
            Mot de passe : <input type='password' name='password' /><br>
            <input type='submit' name='doIt' value='Ok' />     
        </form>
            <c:url value="ControllerMain?section=newCompte" var="url08" />
           <a href="${url08}"> creer un compte </a>
        <font color='red'>${msg}</font>  

    </body>
</html>
