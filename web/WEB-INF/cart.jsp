
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
        <title>Mon panier</title>
    </head>
    <body>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>

            <c:if test="${panierVide}">
                Panier vide !    
            </c:if>
            <c:if test="${!panierVide}">
                <c:forEach var="i" items="${list}">
                    ${i.ref}/${i.qty}
                    <a href='ControllerMain?section=panier&add=${i.ref}'>+</a>
                    <a href='ControllerMain?section=panier&dec=${i.ref}'>-</a>
                    <a href='ControllerMain?section=panier&del=${i.ref}'>X</a>

                    <br>        
                </c:forEach>
                <a href='ControllerMain?section=panier&clear'>Vider le panier !</a>         
            </c:if>


    </body>
</html>
